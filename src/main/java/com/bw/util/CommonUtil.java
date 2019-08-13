/**
 * 
 */
package com.bw.util;

import java.util.regex.Pattern;

/**
 * @作者:hbl
 * @时间:2019年8月10日
 */
public class CommonUtil {
	
	//判断字符串是否为数字
	public static boolean isNumber(String src){
		//pattern用于比较，compile里面传入正则表达式，matcher传入比较的字符串
		return Pattern.compile("//d+").matcher(src).matches();
	}
	
	//判断源字符串是否存值，空引号(空白字符串)和空格
	public static boolean hasText(String src){
		if(!src.equals(" ") || src != null || !src.equals("")){
			return true;
		}
		return false;
	}
	
	//根据url地址取出地址中的数字:"[^0-9]"
	public static int getPlaceHolder(String url,String regx){
		//第一种情况:
//		String result = url.substring(url.lastIndexOf("-")+1);
		
		//第二种情况
		String result = Pattern.compile(regx).matcher(url).replaceAll("");
		
		//调用第二个判断字符串是否有值，使用三目运算符，判断。
		return hasText(result) ? Integer.parseInt(result) : 0;
	}
}
