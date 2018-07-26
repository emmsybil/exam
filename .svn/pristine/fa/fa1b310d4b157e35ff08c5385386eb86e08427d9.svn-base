package com.cw.portal.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cw.common.domain.exam.ExamHistory;
import com.cw.common.domain.exam.UserQuestionHistory;
import com.cw.common.domain.question.QuestionStatistic;

public interface QuestionHistoryMapper {

	/**
	 * 插入试题历史
	 * @param historyList
	 */
	public void addUserQuestionHist(@Param("array") List<UserQuestionHistory> historyList);
	
	//获取考试时长
	public int queryDurationById(int id);
	
	/**
	 * 完成考试，更新考试历史
	 * @param examHistory 考试历史
	 */
	public void updateExamHistory(ExamHistory examHistory);
	
	/**
	 * 获取用户的试题练习历史
	 * @param userId
	 * @param fieldId
	 * @return
	 */
	public List<UserQuestionHistory> getUserQuestionHist(@Param("userId") int userId,@Param("fieldId") int fieldId);
	
	/**
	 * 根据fieldId,pointId分组统计练习历史试题数量
	 * @param fieldId
	 * @param userId
	 * @return
	 */
	public List<QuestionStatistic> getQuestionHistStaticByFieldId(@Param("fieldId") int fieldId,@Param("userId") int userId);
	
	/**
	 * 根据fieldId,pointId,typeId分组统计练习历史试题数量
	 * @param fieldId
	 * @param userId
	 * @return
	 */
	public List<QuestionStatistic> getTypeQuestionHistStaticByFieldId(@Param("fieldId") int fieldId,@Param("userId") int userId);
}
