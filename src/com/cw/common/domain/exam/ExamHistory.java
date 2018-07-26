package com.cw.common.domain.exam;

import java.util.Date;

/**
 * 用户考试历史记录实体类
 * 
 * @author yuanguangjie
 *
 */
public class ExamHistory {

	private int histId; // 考试历史记录编号
	private int userId; // 用户编号
	private String userName; //用户名称
	private String trueName;//真实姓名
	private Date startTime; //开始时间
	private int examId;		//考试编号
	private String examName; //考试名称
	private int examType;   //考试类型
	private boolean enabled; //启用状态
	private int examPaperId; // 考试试卷编号
	private float point;   //分数
	private String seriNo; // 准考证号
	private String content; // 考试试卷内容
	private Date createTime;  // 创建时间
	private String answerSheet; //用户答题卡
	private int duration; // 持续时长
	private float pointGet; //考试得分
	private Date submitTime; //提交时间
	// 0 未审核 1 通过 2 未通过
	private int approved;
	private Date verifyTime; //核实时间
	private float passPoint; //及格分数
	private String nationalId; //身份证编号
	private String depName; //班级名称

	public String getNationalId() {
		return nationalId;
	}

	public void setNationalId(String nationalId) {
		this.nationalId = nationalId;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	public float getPassPoint() {
		return passPoint;
	}

	public void setPassPoint(float passPoint) {
		this.passPoint = passPoint;
	}

	public String getExamName() {
		return examName;
	}

	public void setExamName(String examName) {
		this.examName = examName;
	}

	public int getExamType() {
		return examType;
	}

	public void setExamType(int examType) {
		this.examType = examType;
	}

	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getHistId() {
		return histId;
	}

	public void setHistId(int histId) {
		this.histId = histId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public int getExamId() {
		return examId;
	}

	public void setExamId(int examId) {
		this.examId = examId;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public int getExamPaperId() {
		return examPaperId;
	}

	public void setExamPaperId(int examPaperId) {
		this.examPaperId = examPaperId;
	}

	public float getPoint() {
		return point;
	}

	public void setPoint(float point) {
		this.point = point;
	}

	public String getSeriNo() {
		return seriNo;
	}

	public void setSeriNo(String seriNo) {
		this.seriNo = seriNo;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getAnswerSheet() {
		return answerSheet;
	}

	public void setAnswerSheet(String answerSheet) {
		this.answerSheet = answerSheet;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public float getPointGet() {
		return pointGet;
	}

	public void setPointGet(float pointGet) {
		this.pointGet = pointGet;
	}

	public Date getSubmitTime() {
		return submitTime;
	}

	public void setSubmitTime(Date submitTime) {
		this.submitTime = submitTime;
	}

	public int getApproved() {
		return approved;
	}

	public void setApproved(int approved) {
		this.approved = approved;
	}

	public Date getVerifyTime() {
		return verifyTime;
	}

	public void setVerifyTime(Date verifyTime) {
		this.verifyTime = verifyTime;
	}

}
