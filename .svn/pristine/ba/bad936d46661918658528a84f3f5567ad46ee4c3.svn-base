package com.cw.common.util;

import java.util.ArrayList;
import java.util.List;


/**
 * 生成随机数，返回新的List集合
 * 
 * @author 文浩
 *
 */
public class RandomListUtil {

	/**
	 * 根据集合长度，生成随机数，打乱集合排序.生成新的集合
	 * 
	 * @param list
	 *            需要重新生成的集合
	 * @param i
	 *            生成新集合的长度
	 * @param nullPointerMessage
	 *            需要抛出的异常信息
	 * @param indexOutOfBoundsMessage
	 *            需要抛出的异常信息
	 * @return 新的集合
	 * @throws NullPointerException
	 * @throws IndexOutOfBoundsException
	 * @throws ExceptionUtil
	 */
	public static <T> List<T> getList(List<T> list, int i, String nullPointerMessage, String indexOutOfBoundsMessage)
			throws ExceptionUtil {
		// Collections.shuffle(list);

		// 判断是否为空
		if (list == null || list.size() == 0) 
			throw new ExceptionUtil(nullPointerMessage);
		

		// 判断数量是否大于集合
		if (i > list.size()) 
			throw new ExceptionUtil(indexOutOfBoundsMessage);
		
		// 创建一个新的集合
		List<T> newList = new ArrayList<T>();

		while (i != 0) {
			// 循环生成随机数，
			int x = (int) (Math.random() * list.size() - 1) + 1;
			// 判断新集合是否包含已经添加过的对象，如果包含则跳过该次循环
			if (newList.contains(list.get(x))) {
				continue;
			}
			newList.add(list.get(x));
			i--;
		}
		return newList;
	}
}
