package com.cw.common.domain.question;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 题库实体类
 * @author yuanguangjie
 *
 */
@XmlRootElement
public class Field {

	private int fieldId; //题库编号
	private String fieldName; //题库名称
	private String memo; //备注
	private boolean state; //状态
	private boolean removeable; //是否可移动
	public boolean isRemoveable() {
		return removeable;
	}
	public void setRemoveable(boolean removeable) {
		this.removeable = removeable;
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
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
}
