package com.sp.xmgl.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonDate {
	public static Date parseDate(String date,String pattern){
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Date d = null;
		try {
			if(date!=null&&!"".equals(date))
				d = sdf.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return d;
	}
	public static String format(Date date,String pattern){
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		if(date!=null)
			return sdf.format(date);
		return "";
	}
	public static String format(Date date){
		return format(date,"yyyy-MM-dd");
	}
}
