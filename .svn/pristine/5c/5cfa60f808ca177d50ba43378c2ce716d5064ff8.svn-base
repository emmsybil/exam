package com.cw.common.util;

/**
 * 字符串帮助类
 * 
 * @author yuanguangjie
 *
 */
public class StringUtil {

	public static String format(String str, int length) {
		while (str.length() > length)
			length++;
		while (str.length() < length) {
			str = "0" + str;
		}
		return str;
	}

	public static String format(int num, int length) {
		String str = Integer.toHexString(num);
		return format(str, length);
	}

	/**
	 * 字符串替换方法
	 * 
	 * @param str
	 * @param find
	 * @param newStr
	 * @return
	 */
	public static String trope(String str) {
		if (str == null)
			return "";

		String stu = str.replaceAll("<", "&lt;");
		stu = stu.replaceAll(">", "&gt;");
		return stu;
	}

}
