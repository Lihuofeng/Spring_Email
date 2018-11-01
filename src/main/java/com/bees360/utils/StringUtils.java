package com.bees360.utils;

public class StringUtils {

	// 字符串的一些工具类方法

	/**
	 * 
	 * @param str
	 *            文件地址
	 * @return
	 */
	public static String getFileName(String str) {
		//获取"/"字符最后一次出现的位置
		int beginIndex = str.lastIndexOf("/") + 1;
		int endIndex = str.length();
		//截取字符串
		String location2 = str.substring(beginIndex, endIndex);
		return location2;
	}

}
