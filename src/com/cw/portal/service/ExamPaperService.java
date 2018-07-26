package com.cw.portal.service;


import com.cw.common.domain.exam.ExamPaper;

public interface ExamPaperService {
	
	/**
	 * 获取一张试卷
	 * @param examPaperId
	 * @return
	 */
	public ExamPaper getExamPaperById(int examPaperId);
	
	//查找答案
	public String queryAnswerSheet(int id);
}
