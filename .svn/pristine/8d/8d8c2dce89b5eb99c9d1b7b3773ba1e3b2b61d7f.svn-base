package com.cw.portal.controller.action;

import java.util.Date;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cw.common.domain.exam.Message;
import com.cw.common.domain.user.User;
import com.cw.common.util.IdentityUtil;
import com.cw.common.util.StandardPasswordEncoderForSha1;
import com.cw.portal.security.UserInfo;
import com.cw.portal.service.DictationService;
import com.cw.portal.service.UserService;


@Controller
public class UserAction {
	@Autowired
	private UserService userService;
	@Autowired
	private DictationService dictationService;

	/**
	 * 判断用户是否存在
	 * 
	 * @param userName
	 * @return
	 */
	@RequestMapping(value = "/judgeUser", method = RequestMethod.POST)
	public @ResponseBody Message judgeUser(@Param("userName") String userName, @Param("trueName") String trueName) {

		Message me = new Message();

		// 创建用户类
		User user = new User();
		user.setUserName(userName);
		user.setTrueName(trueName);

		// 获取查询的值
		String name = userService.judgeUser(user);

		if (name == null || name.length() == 0) {
			me.setResult("success");
		} else {
			me.setResult("error");
		}

		return me;
	}

	/**
	 * 添加用户
	 * 
	 * @param user
	 * @param groupId
	 *            如果添加的用户为学员，必须指定groupId（分组）。如果添加的用户为教师，则groupId为任意数字
	 * @return
	 */
	@RequestMapping(value = { "/add-user" }, method = RequestMethod.POST)
	public @ResponseBody Message addUser(@RequestBody User user) {
		
		// 获取年龄
		int ago = IdentityUtil.id(user.getNationalId());
		user.setAgo(ago);
		user.setCreateTime(new Date());
		String password = user.getPassword() + "{" + user.getUserName().toLowerCase() + "}";
		PasswordEncoder passwordEncoder = new StandardPasswordEncoderForSha1();
		String resultPassword = passwordEncoder.encode(password);
		user.setPassword(resultPassword);
		user.setEnabled(true);
		user.setCreateBy(-1);
		user.setUserName(user.getUserName().toLowerCase());
		
		//获取班级
		int groupId = user.getDepId();
		System.err.println("获取的班级------------------》》》》》"+groupId);

		// 设置班级
		//user.setDepartment(userService.getClassById(user.getDepId()));
		Message message = new Message();
		try {
			userService.addUser(user, "ROLE_STUDENT", groupId, userService.getRoleMap());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			if (e.getMessage().contains(user.getUserName())) {
				message.setResult("duplicate-username");
				message.setMessageInfo("重复的用户名");
			} else if (e.getMessage().contains(user.getNationalId())) {
				message.setResult("duplicate-national-id");
				message.setMessageInfo("重复的身份证");
			} else if (e.getMessage().contains(user.getEmail())) {
				message.setResult("duplicate-email");
				message.setMessageInfo("重复的邮箱");
			} else if (e.getMessage().contains(user.getPhoneNum())) {
				message.setResult("duplicate-phone");
				message.setMessageInfo("重复的电话");
			} else {
				// message.setResult(e.getMessage());
				message.setResult(e.getCause().getMessage());
				e.printStackTrace();
			}
		}
		return message;
	}

	/**
	 * 修改用户
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = { "/student/update-user" }, method = RequestMethod.POST)
	public @ResponseBody Message updateUser(@RequestBody User user) {

		UserInfo userInfo = (UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		String password = user.getPassword() + "{" + user.getUserName() + "}";
		PasswordEncoder passwordEncoder = new StandardPasswordEncoderForSha1();
		String resultPassword = "";
		if (user.getPassword() != null)
			resultPassword = "".equals(user.getPassword().trim()) ? "" : passwordEncoder.encode(password);
		user.setPassword(resultPassword);
		user.setEnabled(true);
		Message message = new Message();
		try {
			userService.updateUser(user, null);
			userInfo.setTrueName(user.getTrueName());
			userInfo.setEmail(user.getEmail());
			userInfo.setNationalId(user.getNationalId());
			userInfo.setPhoneNum(user.getPhoneNum());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			if (e.getMessage().contains(user.getUserName())) {
				message.setResult("duplicate-username");
				message.setMessageInfo("重复的用户名");
			} else if (e.getMessage().contains(user.getNationalId())) {
				message.setResult("duplicate-national-id");
				message.setMessageInfo("重复的身份证");
			} else if (e.getMessage().contains(user.getEmail())) {
				message.setResult("duplicate-email");
				message.setMessageInfo("重复的邮箱");
			} else if (e.getMessage().contains(user.getPhoneNum())) {
				message.setResult("duplicate-phone");
				message.setMessageInfo("重复的电话");
			} else {
				message.setResult(e.getCause().getMessage());
				e.printStackTrace();
			}

		}
		return message;
	}

	@RequestMapping(value = { "/student/change-pwd" }, method = RequestMethod.POST)
	public @ResponseBody Message changePassword(@RequestBody User user) {
		Message message = new Message();
		UserInfo userInfo = (UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		try {
			String password = user.getPassword() + "{" + userInfo.getUsername() + "}";
			PasswordEncoder passwordEncoder = new StandardPasswordEncoderForSha1();
			String resultPassword = passwordEncoder.encode(password);
			user.setPassword(resultPassword);
			user.setUserName(userInfo.getUsername());
			userService.updateUserPwd(user, null);
		} catch (Exception e) {
			e.printStackTrace();
			message.setResult(e.getClass().getName());
		}

		return message;
	}

}
