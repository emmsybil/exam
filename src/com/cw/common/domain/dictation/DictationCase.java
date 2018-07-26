package com.cw.common.domain.dictation;

public class DictationCase {
	// 表ID
	private int dictationCaseId;
	// 学员组ID
	private int studentGroupId;
	// 学生ID
	private int studentId;
	// 单词表ID
	private int dictationId;
	// 听写状态 是否通过 默认不通过 0,1表示通过
	private int cases;
	// 学生姓名，表中不存在此字段，为方便显示信息加上该属性
	private String studnetName;
	// 审阅人ID
	private int approverId;
	// 审阅人姓名
	private String approverName;
	// 审阅时间
	private String approverDate;
	// 罚抄情况
	private int copyingType;

	public int getApproverId() {
		return approverId;
	}

	public void setApproverId(int approverId) {
		this.approverId = approverId;
	}

	public String getApproverName() {
		return approverName;
	}

	public void setApproverName(String approverName) {
		this.approverName = approverName;
	}

	public String getApproverDate() {
		return approverDate;
	}

	public void setApproverDate(String approverDate) {
		this.approverDate = approverDate;
	}

	public int getDictationCaseId() {
		return dictationCaseId;
	}

	public void setDictationCaseId(int dictationCaseId) {
		this.dictationCaseId = dictationCaseId;
	}

	public int getStudentGroupId() {
		return studentGroupId;
	}

	public void setStudentGroupId(int studentGroupId) {
		this.studentGroupId = studentGroupId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudnetName() {
		return studnetName;
	}

	public void setStudnetName(String studnetName) {
		this.studnetName = studnetName;
	}

	public int getAppoverId() {
		return approverId;
	}

	public void setAppoverId(int approverId) {
		this.approverId = approverId;
	}

	public String getAppoverDate() {
		return approverDate;
	}

	public void setAppoverDate(String approverDate) {
		this.approverDate = approverDate;
	}

	public int getCases() {
		return cases;
	}

	public void setCases(int cases) {
		this.cases = cases;
	}

	public int getCopyingType() {
		return copyingType;
	}

	public void setCopyingType(int copyingType) {
		this.copyingType = copyingType;
	}

	public int getDictationId() {
		return dictationId;
	}

	public void setDictationId(int dictationId) {
		this.dictationId = dictationId;
	}

}
