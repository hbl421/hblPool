/**
 * 
 */
package com.hanbolin.entity;

import java.util.Arrays;

/**
 * @作者:hbl
 * @时间:2019年8月6日
 */
public class ZhiwuVo {

	private String zname;
	private Integer[] zid;
	public String getZname() {
		return zname;
	}
	public void setZname(String zname) {
		this.zname = zname;
	}
	public Integer[] getZid() {
		return zid;
	}
	public void setZid(Integer[] zid) {
		this.zid = zid;
	}
	public ZhiwuVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ZhiwuVo [zname=" + zname + ", zid=" + Arrays.toString(zid) + "]";
	}
}
