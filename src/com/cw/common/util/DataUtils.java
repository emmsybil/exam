package com.cw.common.util;

/**
 * 数据帮助类
 * 
 * @author yuanguangjie
 *
 */
public class DataUtils {

	/**
	 * 将封装的json格式转为单个对象的数据格式
	 * 
	 * @param ja
	 * @return
	 */
	public static String getBeanData(String str) {

		if (str == null || str.length() == 0) {
			return "";
		}
		String data = str.substring(1, str.length() - 1);

		System.err.println("查看格式是否正确：" + data);

		return data;
	}

}
