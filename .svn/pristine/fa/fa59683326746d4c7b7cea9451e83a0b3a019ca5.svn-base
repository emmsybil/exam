package com.cw.common.util;

/**
 * 自定义异常类，用于接收异常信息
 * 
 * @author 文浩
 *
 */
public class ExceptionUtil extends Exception {

	// 提示错误编码
	private String code;
	// 错误信息
	private String errorMsg;

	// 抛出异常
	public ExceptionUtil(String code, String errorMsg) {
		this.code = code;
		this.errorMsg = errorMsg;
	}

	public ExceptionUtil(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

}
