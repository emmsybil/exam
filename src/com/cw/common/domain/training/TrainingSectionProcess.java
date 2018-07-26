package com.cw.common.domain.training;

/**
 * 培训流程类
 * @author yuanguangjie
 *
 */
public class TrainingSectionProcess extends TrainingSection {

	private String trainingName; //培训名称
	private int userId; //用户编号
	private String userName; //用户名称
	private float process; //流程

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTrainingName() {
		return trainingName;
	}

	public void setTrainingName(String trainingName) {
		this.trainingName = trainingName;
	}

	public float getProcess() {
		return process;
	}

	public void setProcess(float process) {
		this.process = process;
	}
	
}
