package com.cw.portal.controller.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cw.common.util.Page;
import com.cw.common.util.PagingUtil;
import com.cw.portal.security.UserInfo;
import com.cw.portal.service.ScoreHistoryService;
import com.cw.common.domain.score.Score;

/**
 *
 * @author XieRong 成绩
 */
@Controller
public class ScoreAction {

	@Autowired
	private ScoreHistoryService scoreHistoryService;

	@RequestMapping(value = "/student/score", method = RequestMethod.GET)
	public String scoreListPage() {

		return "redirect:score/filter-1-0.html";
	}

	/**
	 * 分页、条件查询出学生成绩
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/student/score/filter-{page}-{pass}", method = RequestMethod.GET)
	public String queryScoreByCondition(Model model, @PathVariable("page") int pageNo,
			@PathVariable("pass") String pass, HttpServletRequest request) {

		// 获取当前登录的用户信息
		UserInfo userInfo = (UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		// 获取用户的id
		int stuNo = userInfo.getUserid();
		
		String examType = request.getParameter("examType");
		String fieldName = request.getParameter("fieldName");
		
		if (examType == null || ("0").equals(examType))
			examType = "";
		if (fieldName == null || ("请选择").equals(fieldName))
			fieldName = "";
		if (pass.equals("0"))
			pass = null;

		int count = scoreHistoryService.getCount(examType.equals("") ? null : examType,
				fieldName.equals("") ? null : fieldName, pass, stuNo);
		Page<Score> page = new Page<Score>();
		page.setPageNo(pageNo);
		page.setPageSize(10);
		page.setTotalRecord(count);
		// 分页按钮
		String str = PagingUtil.getPageBtnlink(pageNo, page.getTotalPage());
		//获取成绩
		List<Score> scoreList = scoreHistoryService.getScoreByCondition(page, examType.equals("") ? null : examType,
				fieldName.equals("") ? null : fieldName, pass, stuNo);
		
		//获取知识点
		List<Score> fieldList = scoreHistoryService.getField(stuNo);

		model.addAttribute("fieldList", fieldList);
		model.addAttribute("scoreList", scoreList);
		model.addAttribute("count", count);
		model.addAttribute("pageStr", str);
		model.addAttribute("pass", pass);
		model.addAttribute("fieldName", fieldName);
		model.addAttribute("examType", examType);
		
		return "score";
	};

}
