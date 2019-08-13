/**
 * 
 */
package com.bw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bw.entity.NewsLink;
import com.bw.mapper.NewsLinkMapper;

/**
 * @作者:hbl
 * @时间:2019年8月11日
 */
@Service//业务层
public class NewsLinkServiceImp implements NewsLinkService{

	@Autowired
	private NewsLinkMapper nm;
	
	//实现展示列表方法
	@Override
	public List<NewsLink> getList() {
		return nm.getList();
	}

}
