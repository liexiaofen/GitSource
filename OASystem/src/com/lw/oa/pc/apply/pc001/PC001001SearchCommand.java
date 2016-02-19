package com.lw.oa.pc.apply.pc001;

import java.io.Serializable;
/**
 * *@author yuliang
 */
public class PC001001SearchCommand implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// 申请类型
	private String applytype;
	// 员工id
	private String empid;
	// 员工姓名
	private String empname;	

	public String getApplytype() {
		return applytype;
	}

	public void setApplytype(String applytype) {
		this.applytype = applytype;
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
