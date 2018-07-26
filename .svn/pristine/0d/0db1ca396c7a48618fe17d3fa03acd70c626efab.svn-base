package com.cw.common.domain.question;

import java.util.Date;

/**
 * 
 * @author yuanguangjie
 *
 */
public class QuestionHistory implements Comparable<QuestionHistory> {

	/**
	 * 记录试卷id：-1找不到试卷；0练习题
	 */
	private int examPaperId;
	private int questionId; //试题编号
	private Date time; //时间
	private String answer; //答案
	private String myAnswer; //答题卡
	private boolean isRight; //是否正确
	private int questionTypeId; //试题类型编号
	private int pointId; //知识点编号
	/**
	 * 来源，强化练习则设置成1
	 */
	private int from;
	public int getFrom() {
		return from;
	}
	public void setFrom(int from) {
		this.from = from;
	}
	public int getPointId() {
		return pointId;
	}
	public void setPointId(int pointId) {
		this.pointId = pointId;
	}
	public int getQuestionTypeId() {
		return questionTypeId;
	}
	public void setQuestionTypeId(int questionTypeId) {
		this.questionTypeId = questionTypeId;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public int getExamPaperId() {
		return examPaperId;
	}
	public void setExamPaperId(int examPaperId) {
		this.examPaperId = examPaperId;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getMyAnswer() {
		return myAnswer;
	}
	public void setMyAnswer(String myAnswer) {
		this.myAnswer = myAnswer;
	}
	public boolean isRight() {
		return isRight;
	}
	public void setRight(boolean isRight) {
		this.isRight = isRight;
	}
	@Override
	public int compareTo(QuestionHistory o) {
		// TODO Auto-generated method stub
		if(this.time.getTime() > o.getTime().getTime())
			return 1;
		else if(this.time.getTime() < o.getTime().getTime())
			return -1;
		else return 0;
	}
}
