package com.cw.common.domain.question;

import java.io.Serializable;
import java.util.Date;

/**
 * 试题标签实体类
 * @author yuanguangjie
 *
 */
public class QuestionTag implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3291344057024079156L;
	private int questionTagId; //试题标签编号
	private int questionId; //试题编号
	private int tagId; //标签编号
	private String tagName; //标签名称
	private int creator; //创建者
	private boolean privatee; //是否私有的
	private Date createtime; //创建时间
	public int getQuestionTagId() {
		return questionTagId;
	}
	public void setQuestionTagId(int questionTagId) {
		this.questionTagId = questionTagId;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public int getTagId() {
		return tagId;
	}
	public void setTagId(int tagId) {
		this.tagId = tagId;
	}
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	public int getCreator() {
		return creator;
	}
	public void setCreator(int creator) {
		this.creator = creator;
	}
	public boolean isPrivatee() {
		return privatee;
	}
	public void setPrivatee(boolean privatee) {
		this.privatee = privatee;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
}
