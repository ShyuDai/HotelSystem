package com.hs.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DateFormatDefinition{
	
	/**
	 * 自定义日期格式
	 * @return
	 */
	public static String SimpleDateFormatwg() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		Date date=new Date();// new Date()为获取当前系统时间
		String time=df.format(date);//顾客预定时的系统时间
		return time;
	}
	
	public static String getDate() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		Date date=new Date();// new Date()为获取当前系统时间
		String time=df.format(date);//顾客预定时的系统时间
		return time;
	}
	
	
	public static int getYearByDays(int days) {
		int year=0;
		if(days%365==0) {
			year=days/365;
		}else {
			year=days/365+1;
		}
		return year;
	}
	
	
	/**
	 * 计算两个时间之间
	 * 返回相差天数
	 */
	public static int statydays(String checkintime,String checkouttime){
		long days=0;
		int statydays=0;
        try {
        	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        	//跨年不会出现问题
        	//如果时间为：差值为 0，则默认加1
        	Date fDate=sdf.parse(checkintime);
        	Date oDate=sdf.parse(checkouttime);
        	days=(oDate.getTime()-fDate.getTime())/(1000*3600*24);
        	String statydaysStr=days+"";
        	statydays=Integer.parseInt(statydaysStr);
        	if(days>0) {
        		return statydays;
        	}else {
        		days=days+1;
        		return statydays;
        	}
		} catch (Exception e) {
			e.printStackTrace();
		}
        return statydays;
    }
	
	/**
	 * 获取数据库当前时间
	 * 返回数据库时间String类型
	 */
	public static String MySQLSystemDateTimeStr() {
		String datetime="";
		String sql="SELECT SYSDATE()";
//		String sql="SELECT NOW()";
		try {
			ResultSet rs=new BaseDaoImplwg().executeQuerywg(sql);
			while(rs.next()) {
//				String sysdate=rs.getString("NOW()");
				String sysdate=rs.getString("SYSDATE()");
//				System.out.println(sysdate);
				String[] part=sysdate.split("\\.");
				datetime=part[0];
//				System.out.println(part[0]);
//				for (String string : part) {
//					System.out.println(string);
//				}
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return datetime;
	}
	
	

}
