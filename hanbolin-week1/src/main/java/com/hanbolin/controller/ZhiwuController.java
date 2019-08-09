/**
 * 
 */
package com.hanbolin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hanbolin.entity.Type;
import com.hanbolin.entity.Zhiwu;
import com.hanbolin.entity.ZhiwuVo;
import com.hanbolin.service.ZhiwuService;
import com.hanbolin.util.PageHelpUtil;

/**
 * @作者:hbl
 * @时间:2019年8月6日
 */
@Controller//控制层
public class ZhiwuController {

	@Autowired
	private ZhiwuService service;
	

	//实例化分页工具
	private int pageSize = 2;
	
	//实现列表展示方法
	@RequestMapping("listZhi.do")
	public String getList(Model m,@RequestParam(defaultValue="1")int page,ZhiwuVo zv){
		
		
		PageHelper.startPage(page, pageSize);
		
		//调用列表方法
		List<Zhiwu> list = service.getList(zv);
		PageInfo<Zhiwu> plist = new PageInfo<>(list);
		
		//分页信息,三个参数
		/*
		 * 第一个:每次在页面中点过来，需要进入的方法
		 * 第二个:使用分页插件包装过的list
		 * 第三个:带条件分页的参数
		 * */
		String pinfo = PageHelpUtil.page("listZhi.do",plist,null);
		
		m.addAttribute("zhiwu",list);
		m.addAttribute("pinfo",pinfo);
		m.addAttribute("zv",zv);
		
		//页面分发
		return "list";
	}
	
	//实现进入添加页面方法
	@RequestMapping("getAdd.do")
	public String getAdd(){
		
		return "add";
	}
	
	//实现下拉框回显方法
	@RequestMapping("getType.do")
	@ResponseBody
	public Object getType(){
		
		List<Type> type = service.getType();
		
		return type;
	}
	
	//实现进入添加页面方法
	@RequestMapping("add.do")
	public String add(Zhiwu zw){
		
		int num = service.addZhiwu(zw);
		
		if(num > 0){
			return "redirect:listZhi.do";			
		}else{
			return "add";
		}
		
	}
	
	//实现删除方法
	@RequestMapping("dele.do")
	@ResponseBody
	public Object dele(ZhiwuVo zv){
		
		int num = service.dele(zv);
		
		if(num > 0){			
			return true;
		}else{
			return false;
		}
	}
	
	//实现修改跳转方法
	@RequestMapping("getUpdate.do")
	public String getUpdate(int zid,Model m){
		
		m.addAttribute("zid",zid);
		
		return "update";
	}
	
	//实现修改回显方法
	@RequestMapping("updateById.do")
	@ResponseBody
	public Object updateById(int zid){
		
		Zhiwu zhiwu = service.updateById(zid);
		
		return zhiwu;
	}
	
	//实现修改方法
	@RequestMapping("update.do")
	public String update(Zhiwu zw){
		System.out.println(zw);
		int num = service.update(zw);
		
		if(num > 0){
			//如果不带东西，记性跳转，使用重定向就可以
			return "redirect:listZhi.do";		
		}else{
			return "update";
		}
	}
	
	//实现查看功能
	@RequestMapping("chakan.do")
	public String chakan(int zid,Model m){
		
		//通过植物id查出植物类别id
		Zhiwu zhiwu = service.chakanById(zid);
		
		//获取查询过来的tid
		Type type = zhiwu.getType();
		
		//创建类别对象
		Type tp = new Type();
		//把tid传进对象
		tp.setTid(type.getTid());
		
		List<Zhiwu> chakanType = service.chakanType(tp);
		
		String tname = "";
		
		for (Zhiwu zw : chakanType) {
			Type te = zw.getType();
			tname = te.getTname();
			m.addAttribute("tname", tname);
		}
		
		
		//传进model作用域
		m.addAttribute("type", chakanType);
		
		//页面分发
		return "chakan";
	}
	
	//实现分页模糊查询
	@RequestMapping("queryByDname.do")
	public String queryByDname(Model m,ZhiwuVo zv,@RequestParam(defaultValue="1")int page){
		
		PageHelper.startPage(page, pageSize);
		
		//再次调用列表方法,直接使用列表的sql语句就可以直接查询
		List<Zhiwu> list = service.getList(zv);
		PageInfo<Zhiwu> pageInfo = new PageInfo<>(list);
		
		//模糊查询，如果使用的是加强类，需要直接get出zname的值
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("zname",zv.getZname());
		
		//分页信息
		String pinfo = PageHelpUtil.page("queryByDname.do", pageInfo,params);
		
		//传进model作用域的里面
		m.addAttribute("pinfo", pinfo);
		m.addAttribute("zv", zv);
		m.addAttribute("zhiwu",pageInfo.getList());
		
		return "list";
	}
}
