package com.shop.my.util;


import com.shop.my.pojo.User;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyUtil {
	/**
	 * 获得时间字符串
	 */
	public static String getStringID(){
		String id=null;
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmssSSS"); 
		id=sdf.format(date);
		return id;
	}
	/**
	 * 获得用户ID
	 */
	public static Integer getUserId(HttpSession session) {
		User user = (User)session.getAttribute("userOnline");
		return user.getId();
	}
}
