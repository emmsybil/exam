package com.cw.common.domain.user;

/**
 * 部门/班级类
 * @author yuanguangjie
 *
 */
public class Department {

	private int depId; 
	private String depName; //名称
	private String memo; //描述
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public int getDepId() {
		return depId;
	}
	public void setDepId(int depId) {
		this.depId = depId;
	}
	public String getDepName() {
		return depName;
	}
	public void setDepName(String depName) {
		this.depName = depName;
	}
}
