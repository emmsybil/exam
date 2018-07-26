package com.cw.portal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cw.common.util.Page;
import com.cw.portal.persistence.AskForLeaveMapper;

import com.cw.common.domain.askForLeave.AskForLeave;

/**
*
*@author XieRong
*
*/

@Service
public class AskForleaveServiceImpl implements AskForLeaveService {

	//自动装配，自动在上下文找到和其匹配的Bean
	@Autowired
	private AskForLeaveMapper askForLeaveMapper;

	//提交请假申请
	@Override
	public void addApplication(AskForLeave askForLeave) {

		askForLeaveMapper.addApplication(askForLeave);
	}

	//获取总数
	@Override
	public int getCount(AskForLeave askForLeave, String start, String end) {
		
		return askForLeaveMapper.getCount(askForLeave, start, end);
	}

	//分页查询、条件查询
	@Override
	public List<AskForLeave> getAskForLeaveHistory(AskForLeave askForLeave, Page<AskForLeave> page, String start, String end) {
		
		return askForLeaveMapper.queryHistoryByCondition(askForLeave, start, end, page);
	}

	@Override
	public AskForLeave queryById(String id, int userId) {
		
		return askForLeaveMapper.queryById(id, userId);
	}

}
