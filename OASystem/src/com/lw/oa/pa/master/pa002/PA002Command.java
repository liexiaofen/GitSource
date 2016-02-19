package com.lw.oa.pa.master.pa002;

import java.io.Serializable;

/**
 * *@author yuliang
 */
public class PA002Command implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PA002001SearchCommand pa002001searchcommand;
	// 排他标识
	private String exclusivefg;
	// 日程设备id
	private String dailydeviceid;
	// 机构id
	private String orgcdid;
	// 日程设备名称
	private String dailydevicename;
	// 内容
	private String comment;

	public PA002001SearchCommand getPa002001searchcommand() {
		return pa002001searchcommand;
	}

	public void setPa002001searchcommand(
			PA002001SearchCommand pa002001searchcommand) {
		this.pa002001searchcommand = pa002001searchcommand;
	}

	public String getExclusivefg() {
		return exclusivefg;
	}

	public void setExclusivefg(String exclusivefg) {
		this.exclusivefg = exclusivefg;
	}

	public String getDailydeviceid() {
		return dailydeviceid;
	}

	public void setDailydeviceid(String dailydeviceid) {
		this.dailydeviceid = dailydeviceid;
	}

	public String getOrgcdid() {
		return orgcdid;
	}

	public void setOrgcdid(String orgcdid) {
		this.orgcdid = orgcdid;
	}

	public String getDailydevicename() {
		return dailydevicename;
	}

	public void setDailydevicename(String dailydevicename) {
		this.dailydevicename = dailydevicename;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
