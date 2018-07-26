package com.cw.common.domain.question;

/**
 * 试题统计实体类
 * @author yuanguangjie
 *
 */
public class QuestionStatistic {

	private int fieldId; //题库编号
	private String fieldName; //题库名称
	private int pointId; //知识点编号
	private String pointName; //知识点名称
	private int questionTypeId; //试题类型编号
	private String questionTypeName; //试题类型名称
	private int amount; //总计分数
	private int rightAmount; //正确分数
	private int wrongAmount; //错误分数
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
	public int getFieldId() {
		return fieldId;
	}
	public void setFieldId(int fieldId) {
		this.fieldId = fieldId;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public int getPointId() {
		return pointId;
	}
	public void setPointId(int pointId) {
		this.pointId = pointId;
	}
	public String getPointName() {
		return pointName;
	}
	public void setPointName(String pointName) {
		this.pointName = pointName;
	}
	
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
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
