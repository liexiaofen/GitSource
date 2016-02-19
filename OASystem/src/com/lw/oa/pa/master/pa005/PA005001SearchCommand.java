package com.lw.oa.pa.master.pa005;

import com.lw.oa.mybatis.interceptor.Pager;

/**
 * *@author yuliang
 */
public class PA005001SearchCommand extends Pager<PA005001ResultCommand> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 员工姓名
	private String empname;
	// 年度
	private String year;
	// 员工id
	private String empid;
	// 年度
	private String detailyear;
	// 排他标识
	private String exclusivefg;

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}

	public String getDetailyear() {
		return detailyear;
	}

	public void setDetailyear(String detailyear) {
		this.detailyear = detailyear;
	}

	public String getExclusivefg() {
		return exclusivefg;
	}

	public void setExclusivefg(String exclusivefg) {
		this.exclusivefg = exclusivefg;
	}

}
