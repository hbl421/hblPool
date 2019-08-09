/**
 * 
 */
package com.hanbolin.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * @作者:hbl
 * @时间:2019年8月6日
 */
public class Type {

	private int tid;
	private String tname;
	private Set<Zhiwu> zhiwus = new HashSet<Zhiwu>();
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public Set<Zhiwu> getZhiwus() {
		return zhiwus;
	}
	public void setZhiwus(Set<Zhiwu> zhiwus) {
		this.zhiwus = zhiwus;
	}
	public Type() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Type [tid=" + tid + ", tname=" + tname + ", zhiwus=" + zhiwus + "]";
	}
}
