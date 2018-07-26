package com.cw.portal.controller.action;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.codehaus.jackson.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cw.common.Constants;
import com.cw.common.domain.exam.AnswerSheet;
import com.cw.common.domain.exam.Exam;
import com.cw.common.domain.exam.ExamHistory;
import com.cw.common.domain.exam.Message;
import com.cw.common.util.DataUtils;
import com.cw.portal.security.UserInfo;
import com.cw.portal.service.ExamPaperService;
import com.cw.portal.service.ExamService;
import com.cw.portal.service.QuestionHistoryService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;

@Controller
public class ExamAction {

	@Autowired
	private ExamService examService;

	@Autowired
	private org.springframework.amqp.core.AmqpTemplate qmqpTemplate;
	// private JSONArray jsonarray;
	@Autowired
	private ExamPaperService examPaperService;
	@Autowired
	private QuestionHistoryService histService;

	/**
	 * 获取答题卡
	 * 
	 * @param histId
	 * @return
	 */
	@RequestMapping(value = "student/get-answersheet/{histId}", method = RequestMethod.GET)
	public @ResponseBody AnswerSheet getAnswerSheet(@PathVariable("histId") int histId) {
		ExamHistory history = examService.getUserExamHistListByHistId(histId);
		Gson gson = new Gson();
		AnswerSheet answerSheet = gson.fromJson(history.getAnswerSheet(), AnswerSheet.class);
		
 		
		return answerSheet;
	}

	/**
	 * 用户申请考试
	 * 
	 * @param examId
	 * @return
	 */
	@RequestMapping(value = "student/exam/send-apply/{examId}", method = RequestMethod.GET)
	public @ResponseBody Message sendApply(@PathVariable("examId") int examId) {
		Message msg = new Message();
		UserInfo userInfo = (UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		try {
			Exam exam = this.checkExam(examId);
			// 申请考试默认未审核
			examService.addUserExamHist(userInfo.getUserid(), examId, exam.getExamPaperId(), 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			msg.setResult(e.getMessage());
			e.printStackTrace();
		}
		return msg;
	}

	/**
	 * 检查用户是否可以申请该考试
	 * 
	 * @param examId
	 * @return
	 * @throws Exception
	 */
	public Exam checkExam(int examId) throws Exception {
		Exam exam = examService.getExamById(examId);
		if (exam == null) {
			throw new Exception("考试不存在！或已经申请过一次！");
		}
		/*
		 * if(exam.getEffTime().before(new Date())) throw new
		 * Exception("不能在考试开始后申请！");
		 */
		if (exam.getApproved() != 1) {
			throw new Exception("不能申请一个未审核通过的考试！");
		}

		return exam;
	}

	/**
	 * 完成考试
	 * 
	 * @param answerSheet
	 *            答卷
	 * @return
	 */
	@RequestMapping(value = "/student/exam-submit/{time}", method = RequestMethod.POST)
	public @ResponseBody Message finishExam(@RequestBody AnswerSheet answerSheet,
			@PathVariable("time") String startTime) {
		System.err.println("时间获取" + startTime);
		Message message = new Message();
		// 获取试卷答案
		String answer_sheet = examPaperService.queryAnswerSheet(answerSheet.getExamId());
		// System.err.println("试卷答案是：" + answer_sheet);
		// 答案
		Float points = 0.0f;// 得分
		Float totalPoint = 0.0f;// 总分
		List<Float> score = new ArrayList<Float>();// 分数集合
		List<String> answers = new ArrayList<String>();// 答案集合

		// 学员提交的试卷答题卡答案
		Map<String, String> map = new HashMap<String, String>();
		Map<String, Float> pointMap = new HashMap<String, Float>();

		ExamHistory examHistory = new ExamHistory();
		JSONObject json = JSONObject.fromObject(answer_sheet);
		Iterator<String> sIterator = json.keys();
		while (sIterator.hasNext()) {
			// 获得key
			String key = sIterator.next();
			// 根据key获得value, value也可以是JSONObject,JSONArray,使用对应的参数接收即可
			if (key.equals("answerSheetItems")) {
				String value = json.getString(key);
				JSONArray jsonArray = JSONArray.fromObject(value);
				if (jsonArray.size() > 0) {
					for (int i = 0; i < jsonArray.size(); i++) {
						// 遍历jsonarray数组，把每一个对象转成json对象
						JSONObject job = jsonArray.getJSONObject(i);
						// 得到答案
						String answer = job.get("answer") + "";
						Float point1 = (float) job.getDouble("point");
						answers.add(i, answer);
						score.add(i, point1);
						pointMap.put(i + "", point1);
					}
				}
			}
		}
		// 学员提交的答题卡
		for (int i = 0; i < answerSheet.getAnswerSheetItems().size(); i++) {
			map.put(i + "", answerSheet.getAnswerSheetItems().get(i).getAnswer());
		}

		// 计算得分、试卷总分
		for (int i = 0; i < map.size(); i++) {
			String daan = "";
			String userDaan = "";
			daan = answers.get(i);
			userDaan = map.get(i + "");
			totalPoint += pointMap.get(i + "");
			if (daan.equals(userDaan)) {
				points += pointMap.get(i + "");
			}
		}

		System.err.println(totalPoint + "显示分数：" + points);

		// 获得交卷时间
		Date time = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		// 获得考试时长
		int duration = histService.queryDurationById(answerSheet.getExamHistroyId());
		// 设置开始时间
		// String startTime = getTimeByMinute(-duration);
		System.err.println("考试时长：" + duration + ",开始时间：" + startTime);

		// 设置总分
		examHistory.setPoint(totalPoint);
		// 设置得分
		examHistory.setPointGet(points);

		// 设置开始时间
		try {
			examHistory.setSubmitTime(df.parse(df.format(time)));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		// 更新条件（id设置）
		examHistory.setHistId(answerSheet.getExamHistroyId());
		// 设置为已交卷
		examHistory.setApproved(2);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		// 设置开始时间
		try {
			examHistory.setStartTime(sdf.parse(startTime));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// 获取学员的答题卡
		examHistory.setAnswerSheet(DataUtils.getBeanData(JSONArray.fromObject(answerSheet).toString()));

		try {
			histService.updateExamHistory(examHistory);
		} catch (Exception e) {
			e.printStackTrace();
			message.setResult(e.getMessage());
		}
		return message;
	}

	@RequestMapping(value = "addAnswerSheet4Test", method = RequestMethod.GET)
	public @ResponseBody Message addAnswerSheet4Test(Model model) throws JsonProcessingException, IOException {
		Message msg = new Message();
		AnswerSheet as = new AnswerSheet();
		as.setExamPaperId(2);
		ObjectMapper om = new ObjectMapper();
		qmqpTemplate.convertAndSend(Constants.ANSWERSHEET_DATA_QUEUE, om.writeValueAsBytes(as));
		return msg;
	}

	// 获取当前系统时间的前一段或后一段时间
	public static String getTimeByMinute(int minute) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MINUTE, minute);
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime());
	}
}
