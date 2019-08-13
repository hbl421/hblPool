/**
 * 
 */
package com.bw.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @作者:hbl
 * @时间:2019年8月10日
 */
public class DateUtil {
	
	//把字符串类型转换为日期类型
	public static Date StringToDate(String src,String pattern){
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		try {
			return sdf.parse(src);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
