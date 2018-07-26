package com.cw.common.domain.training;

/**
 * 用户培训类
 * @author yuanguangjie
 *
 */
public class UserTraining extends Training {

	private int userId; //用户编号
	private String userName; //用户名称
	private String trueName; //真实名称
	private String depName; //班级名称
	
	public String getDepName() {
		return depName;
	}
	public void setDepName(String depName) {
		this.depName = depName;
	}
	public String getTrueName() {
		return trueName;
	}
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
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
	
}
