package com.lw.system.framework.fa002;

import java.io.Serializable;
public class FA002Command implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FA002001SearchCommand searchCommand;
	// 角色名称
	private String rolename;
	// 角色代码
	private String rolecode;
	// 角色级别
	private String roletype;
	// 角色id
	private String roleid;
	
	public FA002001SearchCommand getSearchCommand() {
		return searchCommand;
	}

	public void setSearchCommand(FA002001SearchCommand searchCommand) {
		this.searchCommand = searchCommand;
	}

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

}
