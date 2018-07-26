package com.cw.common.domain.applet;

/**
 * 学员考勤实体类
 * 
 * @author yuanguangjie
 *
 */
public class CheckIn {
	private int id;// 编号
	private int stuNo;// 学生编号
	private int late; // 迟到次数
	private int vacate;// 请假次数
	private int truant;// 旷课次数
	private int violate;// 违纪次数
	private String mark;// 描述
	private String startTime;// 开始时间
	private String endTime;// 结束时间
	private String studentName;// 学员姓名

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStuNo() {
		return stuNo;
	}

	public void setStuNo(int stuNo) {
		this.stuNo = stuNo;
	}

	public int getLate() {
		return late;
	}

	public void setLate(int late) {
		this.late = late;
	}

	public int getVacate() {
		return vacate;
	}

	public void setVacate(int vacate) {
		this.vacate = vacate;
	}

	public int getTruant() {
		return truant;
	}

	public void setTruant(int truant) {
		this.truant = truant;
	}

	public int getViolate() {
		return violate;
	}

	public void setViolate(int violate) {
		this.violate = violate;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
}
