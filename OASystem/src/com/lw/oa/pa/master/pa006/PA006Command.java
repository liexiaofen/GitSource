package com.lw.oa.pa.master.pa006;

import java.io.Serializable;

/**
 * *@author yuliang
 */
public class PA006Command implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 员工id
	private String empid;
	// 排他标识
	private String exclusivefg;
	// 用户名
	private String username;
	// 密码
	private String password;
	// 新密码
	private String newpassword;
	
	public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}

	public String getExclusivefg() {
		return exclusivefg;
	}

	public void setExclusivefg(String exclusivefg) {
		this.exclusivefg = exclusivefg;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

}
