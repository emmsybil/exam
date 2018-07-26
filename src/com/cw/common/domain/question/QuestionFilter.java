package com.cw.common.domain.question;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 试题过滤实体类
 * @author Ocelot
 * @date 2014年6月8日 下午10:15:55
 */
@XmlRootElement
public class QuestionFilter implements Serializable {

	private static final long serialVersionUID = -8784942836284858739L;

	private int fieldId;//题库编号
 
	private int knowledge; //知识点

	private int questionType; // 试题类型

	private int tag; //标签

	private String searchParam;//搜索参数

	public int getFieldId() {
		return fieldId;
	}

	public void setFieldId(int fieldId) {
		this.fieldId = fieldId;
	}

	public int getKnowledge() {
		return knowledge;
	}

	public void setKnowledge(int knowledge) {
		this.knowledge = knowledge;
	}

	public int getQuestionType() {
		return questionType;
	}

	public void setQuestionType(int questionType) {
		this.questionType = questionType;
	}

	public String getSearchParam() {
		return searchParam;
	}

	public void setSearchParam(String searchParam) {
		this.searchParam = searchParam;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getTag() {
		return tag;
	}

	public void setTag(int tag) {
		this.tag = tag;
	}
}
