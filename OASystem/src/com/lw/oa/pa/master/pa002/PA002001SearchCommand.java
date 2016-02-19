package com.lw.oa.pa.master.pa002;

import com.lw.oa.mybatis.interceptor.Pager;

/**
 * *@author yuliang
 */
public class PA002001SearchCommand extends Pager<PA002001ResultCommand> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 日程设备id
	private String dailydeviceid;
	// 机构id
	private String orgcdid;
	// 日程设备名称
	private String dailydevicename;

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

}
