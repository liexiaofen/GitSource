package com.lw.oa.pb.daily.pb002;

import com.lw.oa.mybatis.interceptor.Pager;

/**
 * *@author yuliang
 */
public class PB002001SearchCommand extends Pager<PB002001ResultCommand> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 机构id
	private String orgcdid;
	// 机构ids
	private String[] orgcdids;
	// 月预定日程设备id
	private String monthdailydeviceid;
	// 日程设备名称
	private String dailydevicename;
	// 显示日历
	private String displaydate;
	// 当前日期
	private String currentdate;

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

	public String getMonthdailydeviceid() {
		return monthdailydeviceid;
	}

	public void setMonthdailydeviceid(String monthdailydeviceid) {
		this.monthdailydeviceid = monthdailydeviceid;
	}

	public String getDailydevicename() {
		return dailydevicename;
	}

	public void setDailydevicename(String dailydevicename) {
		this.dailydevicename = dailydevicename;
	}

	public String getDisplaydate() {
		return displaydate;
	}

	public void setDisplaydate(String displaydate) {
		this.displaydate = displaydate;
	}

	public String getCurrentdate() {
		return currentdate;
	}

	public void setCurrentdate(String currentdate) {
		this.currentdate = currentdate;
	}

}
