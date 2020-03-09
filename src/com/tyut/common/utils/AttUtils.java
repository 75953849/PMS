package com.tyut.common.utils;

import java.util.Calendar;
import java.util.Date;


public class AttUtils {

	//获取当天整点时间戳
	public static Calendar getIntegeratedTime(Calendar calendar , int hour) {
		
		calendar.set(Calendar.HOUR_OF_DAY, hour);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar;
	}
	public static Calendar getSameDayTimeByHms(Calendar calendar,int hour,int min,int sec) {
		calendar.set(Calendar.HOUR_OF_DAY, hour);
		calendar.set(Calendar.MINUTE, min);
		calendar.set(Calendar.SECOND, sec);
		return calendar;
	}
	
	public static Date getSameDayDateByHms(Calendar calendar,int hour,int min,int sec) {
		calendar.set(Calendar.HOUR_OF_DAY, hour);
		calendar.set(Calendar.MINUTE, min);
		calendar.set(Calendar.SECOND, sec);
		return calendar.getTime();
	}
}
