package com.cw.portal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cw.common.util.Page;
import com.cw.common.domain.score.Score;
import com.cw.portal.persistence.ScoreHistoryMapper;

/**
*
*@author XieRong
*
*/
@Service("scoreHistoryService")
public class ScoreHistoryServiceImpl  implements ScoreHistoryService{
	
	@Autowired
	private ScoreHistoryMapper scoreHistoryMapper;

	@Override
	public List<Score> getScoreByCondition(Page<Score> page, String examType, String fieldName, String pass, int stuNo) {

		return scoreHistoryMapper.getScoreByCondition(page, examType, fieldName, pass, stuNo);
	}

	@Override
	public int getCount(String examType, String field_name, String pass,int stuNo) {

		return scoreHistoryMapper.getCount(examType, field_name, pass, stuNo);
	}

	@Override
	public List<Score> getField(int stuNo) {

		return scoreHistoryMapper.getField(stuNo);
	}

}
