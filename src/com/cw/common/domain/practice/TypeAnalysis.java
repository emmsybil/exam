package com.cw.common.domain.practice;

/**
 * 类型分析实体类
 * @author yuanguangjie
 *
 */
public class TypeAnalysis {
	private int questionTypeId; //试题类型编号
	private String questionTypeName; //试题类型名称
	private int restAmount; //剩余数量
	private int rightAmount; //正确数量
	private int wrongAmount; //错误数量

	public int getQuestionTypeId() {
		return questionTypeId;
	}

	public void setQuestionTypeId(int questionTypeId) {
		this.questionTypeId = questionTypeId;
	}

	public String getQuestionTypeName() {
		return questionTypeName;
	}

	public void setQuestionTypeName(String questionTypeName) {
		this.questionTypeName = questionTypeName;
	}

	public int getRestAmount() {
		return restAmount;
	}

	public void setRestAmount(int restAmount) {
		this.restAmount = restAmount;
	}

	public int getRightAmount() {
		return rightAmount;
	}

	public void setRightAmount(int rightAmount) {
		this.rightAmount = rightAmount;
	}

	public int getWrongAmount() {
		return wrongAmount;
	}

	public void setWrongAmount(int wrongAmount) {
		this.wrongAmount = wrongAmount;
	}
}
