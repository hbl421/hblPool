/**
 * 
 */
package com.hanbolin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hanbolin.entity.Type;
import com.hanbolin.entity.Zhiwu;
import com.hanbolin.entity.ZhiwuVo;
import com.hanbolin.mapper.ZhiwuMapper;

/**
 * @作者:hbl
 * @时间:2019年8月6日
 */
@Service//业务层
@Transactional
public class ZhiwuServiceImp implements ZhiwuService{

	@Autowired
	private ZhiwuMapper zm;

	//实现列表展示方法
	public List<Zhiwu> getList(ZhiwuVo zv) {
		return zm.getList(zv);
	}

	//实现下拉框回显方法
	@Override
	public List<Type> getType() {
		return zm.getType();
	}

	//实现添加方法
	@Override
	public int addZhiwu(Zhiwu zw) {
		return zm.addZhiwu(zw);
	}

	//实现删除方法
	@Override
	public int dele(ZhiwuVo zv) {
		return zm.dele(zv);
	}

	//实现修改方法
	@Override
	public Zhiwu updateById(int zid) {
		return zm.updateById(zid);
	}

	//实现修改方法
	@Override
	public int update(Zhiwu zw) {
		return zm.update(zw);
	}

	//实现查看方法
	@Override
	public Zhiwu chakanById(int zid) {
		return zm.chakanById(zid);
	}

	//实现查看类别方法
	@Override
	public List<Zhiwu> chakanType(Type tp) {
		return zm.chakanType(tp);
	}
}
