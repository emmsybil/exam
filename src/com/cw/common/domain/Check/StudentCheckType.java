package com.cw.common.domain.Check;

public class StudentCheckType {
	// 表id
	private int id;
	// 学生id
	private int studnetId;
	// 学生姓名
	private String studnetName;
	// 上午打卡时间
	private String AMDate;
	// 下午打卡时间
	private String PMDate;
	// 晚上打卡时间
	private String eveningDate;
	// 迟到情况 默认为0：未迟到
	private int beLate;
	// 考勤日期
	private String checkDate;
	// 迟到时长
	private int beLateduration;
	// 是否旷课 默认为0：未旷课
	private int absenteeismType;
	// 迟到次数
	private int beLateNum;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStudnetId() {
		return studnetId;
	}

	public void setStudnetId(int studnetId) {
		this.studnetId = studnetId;
	}

	public String getStudnetName() {
		return studnetName;
	}

	public void setStudnetName(String studnetName) {
		this.studnetName = studnetName;
	}

	public String getAMDate() {
		return AMDate;
	}

	public void setAMDate(String aMDate) {
		AMDate = aMDate;
	}

	public String getPMDate() {
		return PMDate;
	}

	public void setPMDate(String pMDate) {
		PMDate = pMDate;
	}

	public String getEveningDate() {
		return eveningDate;
	}

	public void setEveningDate(String eveningDate) {
		this.eveningDate = eveningDate;
	}

	public int getBeLate() {
		return beLate;
	}

	public void setBeLate(int beLate) {
		this.beLate = beLate;
	}

	public int getBeLateduration() {
		return beLateduration;
	}

	public void setBeLateduration(int beLateduration) {
		this.beLateduration = beLateduration;
	}

	public int getAbsenteeismType() {
		return absenteeismType;
	}

	public void setAbsenteeismType(int absenteeismType) {
		this.absenteeismType = absenteeismType;
	}

	public int getBeLateNum() {
		return beLateNum;
	}

	public void setBeLateNum(int beLateNum) {
		this.beLateNum = beLateNum;
	}

	public String getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(String checkDate) {
		this.checkDate = checkDate;
	}
}
