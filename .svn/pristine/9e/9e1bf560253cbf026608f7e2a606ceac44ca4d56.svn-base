package com.cw.portal.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cw.common.domain.exam.ExamPaper;
import com.cw.common.util.Page;

public interface ExamPaperMapper {

	public List<ExamPaper> getExamPaperList(@Param("searchStr") String searchStr, @Param("page") Page<ExamPaper> page);
	
	//查找答案
	public String queryAnswerSheet(int id);
	
	public void insertExamPaper(ExamPaper examPaper);
	
	public ExamPaper getExamPaperById(int examPaperId);
	
	public void updateExamPaper(ExamPaper examPaper);
	
	public void deleteExamPaper(int id);
	
	public List<ExamPaper> getEnabledExamPaperList(@Param("userName") String userName,@Param("page") Page<ExamPaper> page);
}
