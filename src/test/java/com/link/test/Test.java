/**
 * 
 */
package com.link.test;

import static org.junit.Assert.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bw.entity.NewsLink;
import com.bw.mapper.NewsLinkMapper;
import com.bw.util.CommonUtil;
import com.bw.util.DateUtil;

/**
 * @作者:hbl
 * @时间:2019年8月10日
 */
public class Test {

	@org.junit.Test
	public void add() {
		String url = "http://news.cnstock.com/news,yw-2019/08/10-4413224.htm";
		String[] result = url.split("-");
		String time = result[1];
		int score = CommonUtil.getPlaceHolder(result[2], "[^0-9]");
		
		//用于连接到数据库
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//创建与mapper接口的连接
		NewsLinkMapper bean = context.getBean(NewsLinkMapper.class);
		
		NewsLink newsLink = new NewsLink();
		
		//把上面截取的值，存到对象属性中，
		newsLink.setScore(score);
		newsLink.setCreated(DateUtil.StringToDate(time,"yyyy/MM/dd"));
		//调用mapper接口中的方法
		bean.add(newsLink);
	}

}
