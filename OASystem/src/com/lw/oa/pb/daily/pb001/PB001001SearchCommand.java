package com.lw.oa.pb.daily.pb001;

import com.lw.oa.mybatis.interceptor.Pager;

/**
 * *@author yuliang
 */
public class PB001001SearchCommand extends Pager<PB001001ResultCommand> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 机构id
	private String orgcdid;
	// 部门id
	private String depid;
	// 员工id
	private String empid;
	// 月预定员工id
	private String monthempid;
	//日程id
	private String dailyid;
	// 员工姓名
	private String empname;
	// 显示日历
	private String displaydate;
	// 显示周期
	private String displaycycle;
	// 当前日期
	private String currentdate;

	public String getOrgcdid() {
		return orgcdid;
	}

	public void setOrgcdid(String orgcdid) {
		this.orgcdid = orgcdid;
	}

	public String getDepid() {
		return depid;
	}

	public void setDepid(String depid) {
		this.depid = depid;
	}

	public String getMonthempid() {
		return monthempid;
	}

	public void setMonthempid(String monthempid) {
		this.monthempid = monthempid;
	}

	public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}

	public String getDailyid() {
		return dailyid;
	}

	public void setDailyid(String dailyid) {
		this.dailyid = dailyid;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public String getDisplaydate() {
		return displaydate;
	}

	public void setDisplaydate(String displaydate) {
		this.displaydate = displaydate;
	}

	public String getDisplaycycle() {
		return displaycycle;
	}

	public void setDisplaycycle(String displaycycle) {
		this.displaycycle = displaycycle;
	}

	public String getCurrentdate() {
		return currentdate;
	}

	public void setCurrentdate(String currentdate) {
		this.currentdate = currentdate;
	}

}
