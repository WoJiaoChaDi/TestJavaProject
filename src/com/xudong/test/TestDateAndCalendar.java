package com.xudong.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestDateAndCalendar {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Date date = new Date();//当前时间
		Date date1 = new Date(1000000);//从1970年1月1日起的毫秒数
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(sdf.format(date));
		System.out.println(sdf.format(date1));
		date1.setTime(date.getTime());
		
		int compareRslt = date.compareTo(date1);
		if(compareRslt > 0){
			System.out.println("大于");
		}else if(compareRslt < 0){
			System.out.println("小于");
		}else{
			System.out.println("等于");
		}
		
		//解析字符串为时间
		try {
			Date parseDate = sdf.parse("2017-12-20 23:23:23");
			System.out.println(parseDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//测量程序运行时间
		try {
			long start = System.currentTimeMillis();
			System.out.println(sdf.format(new Date()));
			
			Thread.sleep(1*1000);
			
			System.out.println(sdf.format(new Date()));
			long end = System.currentTimeMillis();
			
			long diff = end - start;
			System.out.println("diffTime:" + diff);
		} catch (Exception e) {
		}
		
		
		//Calendar类（日历类）
		Calendar c = Calendar.getInstance();//默认是当前日期
		c.set(2009, 1-1, 1, 23, 23, 23);//设置年月日十分年
		System.out.println(sdf.format(c.getTime()));
		c.set(Calendar.DAY_OF_MONTH, 3);//设置日
		System.out.println(sdf.format(c.getTime()));
		c.add(Calendar.DAY_OF_MONTH, 3);//添加日
		System.out.println(sdf.format(c.getTime()));
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		int day = c.get(Calendar.DAY_OF_MONTH);
		System.out.println(year + "_" + (month+1) + "_" + day);
		
		
		
		
	}
}
