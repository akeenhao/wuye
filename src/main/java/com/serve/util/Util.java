package com.serve.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {
	
	public static final String DAY = "yyyy-MM-dd";
	public static final String TIME = "yyyy-MM-dd HH:mm:ss";
	public static final String TIME_1 = "yyyyMMddHHmmss";
	public static SimpleDateFormat formatDay = new SimpleDateFormat(DAY);
	public static SimpleDateFormat formatTime = new SimpleDateFormat(TIME);
	public static SimpleDateFormat formatTime1 = new SimpleDateFormat(TIME_1);
	
	/**
	 * 获取当前日期
	 * @return
	 */
	public static String getCurrentDate() {
		return formatDay.format(new Date());
	}
	
	/**
	 * 获取当前时间
	 * @return
	 */
	public static String getCurrentTime() {
		return formatTime.format(new Date());
	}
	
	/**
	 * 获取当前时间
	 * @return
	 */
	public static String getCurrentTime1() {
		return formatTime1.format(new Date());
	}

	/**
	 * 判断字符串为空
	 * @param str
	 * @return
	 */
	public static boolean isEmptyString(String str) {
		return str == null || "".equals(str);
	}
}
