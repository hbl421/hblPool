/**
 * 
 */
package com.bw.mapper;

import java.util.List;

import com.bw.entity.NewsLink;

/**
 * @作者:hbl
 * @时间:2019年8月10日
 */
public interface NewsLinkMapper {
	
	//实现添加方法
	void add(NewsLink nl);
	
	//实现展示列表方法
	List<NewsLink> getList();
}
