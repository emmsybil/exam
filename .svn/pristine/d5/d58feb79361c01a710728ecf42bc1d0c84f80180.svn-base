package com.cw.common.util.file;

import java.io.File;

/**
 * 删除文件帮助类
 * 
 * @author yuanguangjie
 *
 */
public class DeleteFileUtil {

	/**
	 * 删除文件，可以是单个文件或文件夹
	 * 
	 * @param fileName
	 * @return
	 */
	public static boolean delete(String fileName) {

		File file = new File(fileName);
		if (!file.exists()) {
			System.out.println("删除文件失败：" + fileName + "文件不存在");
			return false;
		} else {
			if (file.isFile()) {
				return deleteFile(fileName);
			} else {
				return deleteDirectory(fileName);
			}
		}

	}

	/**
	 * 删除单个文件
	 * 
	 * @param fileName
	 *            文件名
	 * @return
	 */
	public static boolean deleteFile(String fileName) {

		File file = new File(fileName);
		if (file.isFile() && file.exists()) {
			file.delete();
			System.out.println("删除单个文件" + fileName + "成功");
			return true;
		} else {
			System.out.println("删除单个文件" + fileName + "失败");
			return false;
		}

	}

	/**
	 * 删除目录（文件夹）以及目录下的文件
	 * 
	 * @param dir
	 * @return
	 */
	public static boolean deleteDirectory(String dir) {

		// 如果dir不以文件分隔符结尾，自动添加文件分隔符
		if (!dir.endsWith(File.separator)) {
			dir = dir + File.separator;
		}

		File dirFile = new File(dir);

		// 如果dir对应的文件不存在，或者不是一个目录，则退出
		if (!dirFile.exists() || !dirFile.isDirectory()) {
			System.out.println("删除目录失败" + dir + "目录不存在！");
			return false;
		}
		boolean flag = true;
		// 删除文件夹下的所有文件（包括子目录）
		File[] file = dirFile.listFiles();
		for (int i = 0; i < file.length; i++) {

			// 删除子文件
			if (file[i].isFile()) {
				flag = deleteFile(file[i].getAbsolutePath());
				if (!flag) {
					break;
				}
			} else {
				flag = deleteDirectory(file[i].getAbsolutePath());
				if (!flag) {
					break;
				}
			}

		}

		if (!flag) {
			System.out.println("删除目录失败");
			return false;
		}

		// 删除当前目录
		if (dirFile.delete()) {
			System.out.println("删除目录" + dir + "成功！");
			return true;
		} else {
			System.out.println("删除目录" + dir + "失败！");
			return false;
		}

	}

	/**
	 * 批量删除多个文件
	 * 
	 * @param fileName
	 */
	public static boolean deleteFile(String[] fileName) {

		boolean flag = false;

		if (fileName == null) {
			System.out.println("文件名称为空，删除失败");
			return flag;
		}

		for (String s : fileName) {
			flag = delete(s);
		}
		return flag;
	}

}
