/**
 * 
 */
package com.hanbolin.entity;

/**
 * @作者:hbl
 * @时间:2019年8月6日
 */
public class Zhiwu {
	
	private int zid;
	private String zname;
	private String introduction;
	private Type type;
	
	public int getZid() {
		return zid;
	}
	public void setZid(int zid) {
		this.zid = zid;
	}
	public String getZname() {
		return zname;
	}
	public void setZname(String zname) {
		this.zname = zname;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public Zhiwu() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Zhiwu [zid=" + zid + ", zname=" + zname + ", introduction=" + introduction + ", type=" + type + "]";
	}
}
