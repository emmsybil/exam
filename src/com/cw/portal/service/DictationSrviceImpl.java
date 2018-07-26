package com.cw.portal.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cw.common.domain.dictation.Dictation;
import com.cw.common.domain.dictation.DictationCase;
import com.cw.common.util.Page;
import com.cw.portal.persistence.DictationMapper;

@Service("doctatopmServoce")
public class DictationSrviceImpl implements DictationService {

	@Autowired
	private DictationMapper dictationMapper;

	@Override
	public List<DictationCase> getallDictationCase() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dictation getDictationByStudentId(int studentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DictationCase> getDictationByDate(Page<DictationCase> page, String startTime, String endTime,
			int userId) {
		return dictationMapper.getDictationByDate(page, startTime, endTime, userId);
	}

	/**
	 * 获取所有单词表信息
	 * 
	 * @return
	 */
	public List<Dictation> getDictationAll(@Param("page") Page<Dictation> page) {
		return dictationMapper.getDictationAll(page);
	}

}