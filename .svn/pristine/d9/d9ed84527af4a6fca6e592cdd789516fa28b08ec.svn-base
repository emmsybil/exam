package com.cw.portal.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cw.common.util.Page;
import com.cw.common.domain.score.Score;
/**
 *
 * @author XieRong
 *
 */

public interface ScoreHistoryService {

	// 条件分页查询出所有学生成绩
	public List<Score> getScoreByCondition(@Param("page") Page<Score> page, @Param("examType") String examType, 
			@Param("fieldName") String fieldName, @Param("pass") String pass, @Param("stuNo") int stuNo);

	// 获取总数
	public int getCount(@Param("examType") String examType, @Param("field_name") String field_name, @Param("pass") String pass, @Param("stuNo") int stuNo);

	// 查询出科目
	public List<Score> getField(@Param("stuNo") int stuNo);
	
}
