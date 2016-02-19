package com.lw.oa.common.model;

/**
 * *@author yuliang
 */
public class Emporg extends CommonBean {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 员工id
	private String empid;
	// 组织id
	private String orgcdid;
	// depid
	private String depid;
	// posid
	private String posid;

	public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}

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

	public String getPosid() {
		return posid;
	}

	public void setPosid(String posid) {
		this.posid = posid;
	}

}