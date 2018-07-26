package com.cw.portal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cw.common.domain.exam.ExamPaper;
import com.cw.portal.persistence.ExamPaperMapper;

@Service("examPaperService")
public class ExamPaperServiceImpl implements ExamPaperService {

	@Autowired
	private ExamPaperMapper examPaperMapper;
	
	@Override
	public ExamPaper getExamPaperById(int examPaperId) {
		// TODO Auto-generated method stub
		return examPaperMapper.getExamPaperById(examPaperId);
	}
	
	//查找答案
	@Override
	public String queryAnswerSheet(int id){
		// TODO Auto-generated method stub
		return examPaperMapper.queryAnswerSheet(id);
	}
}
