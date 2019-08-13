/**
 * 
 */
package com.bw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bw.entity.NewsLink;
import com.bw.service.NewsLinkService;

/**
 * @作者:hbl
 * @时间:2019年8月11日
 */
@Controller//控制层
public class NewsLinkController {

	@Autowired
	private NewsLinkService service;
	
	//实现展示列表方法
	@RequestMapping("list")
	public String getList(Model m){
		
		List<NewsLink> list = service.getList();
		
		m.addAttribute("news",list);
		
		return "list";
	}
}
