package com.lw.oa.common.model;

/**
 * *@author yuliang
 */
public class Emprole extends CommonBean {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 员工id
	private String empid;
	// 角色id
	private String roleid;
	
	public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}

	public String getRoleid() {
		return roleid;
	}

	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}


}