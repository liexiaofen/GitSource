package com.lw.system.framework.fa002;

import java.io.Serializable;

public class FA002001ResultCommand implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 角色名称
	private String rolename;
	// 角色代码
	private String rolecode;
	// 角色级别
	private String roletype;
	// 角色id
	private String roleid;
	// 备注1
	private String remark1;
	// 备注2
	private String remark2;
	// 备注3
	private String remark3;

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getRolecode() {
		return rolecode;
	}

	public void setRolecode(String rolecode) {
		this.rolecode = rolecode;
	}

	public String getRoletype() {
		return roletype;
	}

	public void setRoletype(String roletype) {
		this.roletype = roletype;
	}

	public String getRoleid() {
		return roleid;
	}

	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}

	public String getRemark1() {
		return remark1;
	}

	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}

	public String getRemark2() {
		return remark2;
	}

	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}

	public String getRemark3() {
		return remark3;
	}

	public void setRemark3(String remark3) {
		this.remark3 = remark3;
	}

}
