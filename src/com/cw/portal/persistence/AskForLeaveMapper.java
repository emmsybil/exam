package com.cw.portal.persistence;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.cw.common.util.Page;
import com.cw.common.domain.askForLeave.AskForLeave;

/**
*
*@author XieRong
*请假
*/
public interface AskForLeaveMapper {
	
	/**
	 * 查询总数
	 * @param userId
	 * @return
	 */
	public int getCount(@Param("askForLeave") AskForLeave askForLeave,@Param("start") String start,@Param("end") String end);
	
	/**
	 * 查询用户请假历史（分页查询/条件查询）
	 * @param askForLeave
	 * @param start
	 * @param end
	 * @param id
	 * @param page
	 * @return
	 */
	public List<AskForLeave> queryHistoryByCondition(@Param("askForLeave") AskForLeave askForLeave,@Param("start") String start,@Param("end") String end, @Param("page") Page<AskForLeave> page);
	
	/**
	 * 提交请假申请
	 * @param askForleave
	 */
	public void addApplication(AskForLeave askForleave);
	
	/**
	 * 根据用户id查询请假历史
	 * @param userId
	 * @return
	 */
	public AskForLeave queryById(@Param("id") String id, @Param("userId") int userId);
	
}