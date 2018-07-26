package com.cw.portal.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cw.common.domain.dictation.Dictation;
import com.cw.common.domain.dictation.DictationCase;
import com.cw.common.util.Page;

public interface DictationMapper {
	/**
	 * 获得所有信息
	 * 
	 * @return
	 */
	public List<DictationCase> getallDictationCase();

	/**
	 * 根据学生ID查询信息
	 * 
	 * @param studentId
	 * @return
	 */
	public Dictation getDictationByStudentId(@Param("studentId") int studentId);

	/**
	 * 根据时间段查询信息
	 * 
	 * @param studentId
	 * @return
	 */
	public List<DictationCase> getDictationByDate(@Param("page") Page<DictationCase> page,
			@Param("startTime") String startTime, @Param("endTime") String endTime, @Param("userId") int userId);

	/**
	 * 获取所有单词表信息
	 * 
	 * @return
	 */
	public List<Dictation> getDictationAll(@Param("page") Page<Dictation> page);
}
