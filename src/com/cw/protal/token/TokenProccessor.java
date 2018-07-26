package com.cw.protal.token;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import com.thoughtworks.xstream.core.util.Base64Encoder;

/**
 *
 * @author XieRong 产生随机令牌类 单例设计模式（保证类的对象在内存中只有一个） 1. 类的构造函数私有 2. 创建类的对象 3.
 *         对外提供一个公共的方法，返回类的对象
 */
public class TokenProccessor {

	private TokenProccessor() {
	};

	private static final TokenProccessor instance = new TokenProccessor();

	public static TokenProccessor getIntance() {
		return instance;
	}

	public String makeToken() {

		String token = (System.currentTimeMillis() + new Random().nextInt(999999999)) + "";

		try {
			// MD5数据摘要也称数据指纹 其长度是128位长 ，也就是16个字节
			MessageDigest md = MessageDigest.getInstance("md5");
			byte md5[] = md.digest(token.getBytes());

			// md5[]得到的是任意的二进制数据，若直接转成字符输出会产生乱码
			// base64编码 是将三字节转成四字节，每个字节范围为0-63，并对应相应的字符，
			Base64Encoder encoder = new Base64Encoder();
			return encoder.encode(md5);

		} catch (NoSuchAlgorithmException e) {

			throw new RuntimeException(e);
		}

	}

	public boolean isRepeatSubmit(HttpServletRequest request) {

		// 客户端提交的token
		String client_token = request.getParameter("token") == null ? "" : request.getParameter("token");

		// 客户端提交的token为空，则重复提交
		if ("".equals(client_token)) {
			return true;
		}

		// 获取存在session中的token
		String server_token = (String) request.getSession().getAttribute("token") == null ? ""
				: (String) request.getSession().getAttribute("token");

		// 当前用户的session中不存在token，则重复提交
		if ("".equals(server_token)) {
			return true;
		}
		
		//如果客户端提交的token和服务端session中的token不一致，则重复提交
		if(!server_token.equals(client_token)){
			return true;
		}

		return false;
	}

}
