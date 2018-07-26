package com.cw.portal.service;

import java.util.List;

import com.cw.common.util.Page;

import com.cw.common.domain.askForLeave.AskForLeave;

//请假
public interface AskForLeaveService {

	public AskForLeave queryById(String id, int userId);
	
	public void addApplication(AskForLeave askForLeave);
	
	public int getCount(AskForLeave askForLeave, String start, String end);
	
	public List<AskForLeave> getAskForLeaveHistory(AskForLeave askForLeave, Page<AskForLeave> page, String start, String end);
}
