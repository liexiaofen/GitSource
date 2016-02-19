package com.lw.oa.common.command;

import java.io.Serializable;

/**
 * *@author yuliang
 */
public class SessionEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 登录画面组织机构
	private String orgcdid;
	// 员工id
	private String empid;
	// 员工姓名
	private String empname;

	public String getOrgcdid() {
		return orgcdid;
	}

	public void setOrgcdid(String orgcdid) {
		this.orgcdid = orgcdid;
	}

	public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}
}
