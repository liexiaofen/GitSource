package com.lw.oa.common.command;

import com.lw.oa.mybatis.interceptor.Pager;

/**
 * *@author yuliang
 */
public class DeviceOrderSearchCommand extends Pager<ResultCommand> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 机构id
	private String orgcdid;
	// 机构ids
	private String[] orgcdids;
	// 显示日历
	private String displaydate;
	// 设备名称
	private String devicename;

	public String getOrgcdid() {
		return orgcdid;
	}

	public void setOrgcdid(String orgcdid) {
		this.orgcdid = orgcdid;
	}

	public String[] getOrgcdids() {
		return orgcdids;
	}

	public void setOrgcdids(String[] orgcdids) {
		this.orgcdids = orgcdids;
	}

	public String getDisplaydate() {
		return displaydate;
	}

	public void setDisplaydate(String displaydate) {
		this.displaydate = displaydate;
	}

	public String getDevicename() {
		return devicename;
	}

	public void setDevicename(String devicename) {
		this.devicename = devicename;
	}

}
