package com.cw.common.domain.training;

import java.util.Date;

/**
 * 培训类
 * @author yuanguangjie
 *
 */
public class Training {

	private int trainingId; // 培训编号
	private String trainingName; //培训名称
	private String trainingDesc; //培训说明
	private Date createTime; //创建时间
	private int status;  //状态
	private int creatorId; //创建者编号
	private int fieldId; //题库编号
	private String creatorName; //创建者名称
	private Date stateTime; //开始时间
	private Date expTime; //结束时间
	private boolean privatee; //私有的
	public boolean isPrivatee() {
		return privatee;
	}
	public void setPrivatee(boolean privatee) {
		this.privatee = privatee;
	}
	public int getFieldId() {
		return fieldId;
	}
	public void setFieldId(int fieldId) {
		this.fieldId = fieldId;
	}
	public int getTrainingId() {
		return trainingId;
	}
	public void setTrainingId(int trainingId) {
		this.trainingId = trainingId;
	}
	public String getTrainingName() {
		return trainingName;
	}
	public void setTrainingName(String trainingName) {
		this.trainingName = trainingName;
	}
	public String getTrainingDesc() {
		return trainingDesc;
	}
	public void setTrainingDesc(String trainingDesc) {
		this.trainingDesc = trainingDesc;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getCreatorId() {
		return creatorId;
	}
	public void setCreatorId(int creatorId) {
		this.creatorId = creatorId;
	}
	public String getCreatorName() {
		return creatorName;
	}
	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}
	public Date getStateTime() {
		return stateTime;
	}
	public void setStateTime(Date stateTime) {
		this.stateTime = stateTime;
	}
	public Date getExpTime() {
		return expTime;
	}
	public void setExpTime(Date expTime) {
		this.expTime = expTime;
	}
	
}
