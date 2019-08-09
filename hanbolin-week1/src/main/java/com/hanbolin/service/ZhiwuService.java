/**
 * 
 */
package com.hanbolin.service;

import java.util.List;

import com.hanbolin.entity.Type;
import com.hanbolin.entity.Zhiwu;
import com.hanbolin.entity.ZhiwuVo;

/**
 * @作者:hbl
 * @时间:2019年8月6日
 */
public interface ZhiwuService {
	
	//实现列表展示方法
	List<Zhiwu> getList(ZhiwuVo zv);
	
	//实现下拉框回显方法
	List<Type> getType();
	
	//实现添加方法
	int addZhiwu(Zhiwu zw);
	
	//实现删除方法
	int dele(ZhiwuVo zv);
	
	//实现修改方法
	Zhiwu updateById(int zid);
	
	//实现修改方法
	int update(Zhiwu zw);
	
	//实现查看方法
	Zhiwu chakanById(int zid);
	
	//实现查看类别方法
	List<Zhiwu> chakanType(Type tp);
}
