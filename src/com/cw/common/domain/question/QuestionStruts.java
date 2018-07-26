package com.cw.common.domain.question;

/**
 * 试题架构实体类
 * @author yuanguangjie
 *
 */
public class QuestionStruts {

	private int questionId; //试题编号
	private int questionTypeId; //试题类型编号
	private double exposeTimes; //显示时间
	private double rightTimes; //正确时长
	private double wrongTimes; //错误时长
	private float difficulty; //困难点
	private int pointId; //知识点编号
	private int referenceId; //参考编号
	private float point; //分数
	private String keyword; //关键字
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public float getPoint() {
		return point;
	}
	public void setPoint(float point) {
		this.point = point;
	}
	public int getPointId() {
		return pointId;
	}
	public void setPointId(int pointId) {
		this.pointId = pointId;
	}
	public int getReferenceId() {
		return referenceId;
	}
	public void setReferenceId(int referenceId) {
		this.referenceId = referenceId;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public int getQuestionTypeId() {
		return questionTypeId;
	}
	public void setQuestionTypeId(int questionTypeId) {
		this.questionTypeId = questionTypeId;
	}
	public double getExposeTimes() {
		return exposeTimes;
	}
	public void setExposeTimes(double exposeTimes) {
		this.exposeTimes = exposeTimes;
	}
	public double getRightTimes() {
		return rightTimes;
	}
	public void setRightTimes(double rightTimes) {
		this.rightTimes = rightTimes;
	}
	public double getWrongTimes() {
		return wrongTimes;
	}
	public void setWrongTimes(double wrongTimes) {
		this.wrongTimes = wrongTimes;
	}
	public float getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(float difficulty) {
		this.difficulty = difficulty;
	}
	
}
