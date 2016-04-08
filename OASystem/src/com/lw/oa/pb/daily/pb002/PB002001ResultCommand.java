package com.lw.oa.pb.daily.pb002;

import java.io.Serializable;
import java.util.List;

/**
 * *@author yuliang
 */
public class PB002001ResultCommand implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 日程设备id
	private String dailydeviceid;
	// 日程设备名称
	private String dailydevicename;
	// 机构id
	private String orgcdid;	
	// 第一天
	private List<PB002Command> one;
	// 第二天
	private List<PB002Command> two;
	// 第三天
	private List<PB002Command> three;
	// 第四天
	private List<PB002Command> four;
	// 第五天
	private List<PB002Command> five;
	// 第六天
	private List<PB002Command> six;
	// 第七天
	private List<PB002Command> seven;

	public String getDailydeviceid() {
		return dailydeviceid;
	}

	public void setDailydeviceid(String dailydeviceid) {
		this.dailydeviceid = dailydeviceid;
	}

	public String getDailydevicename() {
		return dailydevicename;
	}

	public void setDailydevicename(String dailydevicename) {
		this.dailydevicename = dailydevicename;
	}

	public String getOrgcdid() {
		return orgcdid;
	}

	public void setOrgcdid(String orgcdid) {
		this.orgcdid = orgcdid;
	}

	public List<PB002Command> getOne() {
		return one;
	}

	public void setOne(List<PB002Command> one) {
		this.one = one;
	}

	public List<PB002Command> getTwo() {
		return two;
	}

	public void setTwo(List<PB002Command> two) {
		this.two = two;
	}

	public List<PB002Command> getThree() {
		return three;
	}

	public void setThree(List<PB002Command> three) {
		this.three = three;
	}

	public List<PB002Command> getFour() {
		return four;
	}

	public void setFour(List<PB002Command> four) {
		this.four = four;
	}

	public List<PB002Command> getFive() {
		return five;
	}

	public void setFive(List<PB002Command> five) {
		this.five = five;
	}

	public List<PB002Command> getSix() {
		return six;
	}

	public void setSix(List<PB002Command> six) {
		this.six = six;
	}

	public List<PB002Command> getSeven() {
		return seven;
	}

	public void setSeven(List<PB002Command> seven) {
		this.seven = seven;
	}


}
