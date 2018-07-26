package com.cw.common.domain.practice;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 提交参数实体类
 * @author Ocelot
 * @date 2014年8月3日 下午7:56:19
 */
@XmlRootElement	
public class SubmitParam {
	private int questionId; //试题编号
	private String answer; //答案
	private String userId; //用户编号
	private Date submitDate; //提交时间
	
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getSubmitDate() {
		return submitDate;
	}
	public void setSubmitDate(Date submitDate) {
		this.submitDate = submitDate;
	}
	
	
	
}
