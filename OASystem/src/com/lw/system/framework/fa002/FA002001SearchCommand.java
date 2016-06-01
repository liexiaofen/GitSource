package com.lw.system.framework.fa002;

import java.io.Serializable;

import com.lw.oa.common.model.Role;
import com.lw.oa.common.model.RoleResource;
import com.lw.oa.mybatis.interceptor.Pager;

/**
 * *@author yuliang
 */
public class FA002001SearchCommand extends Pager<FA002001ResultCommand>
		implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Role[] role;
	private RoleResource[] roleresource;
	// 角色名称
	private String rolename;
	// 角色代码
	private String rolecode;
	// 角色级别
	private String roletype;
	// 角色id
	private String roleid;

	public Role[] getRole() {
		return role;
	}

	public void setRole(Role[] role) {
		this.role = role;
	}

	public RoleResource[] getRoleresource() {
		return roleresource;
	}

	public void setRoleresource(RoleResource[] roleresource) {
		this.roleresource = roleresource;
	}

	public String getRolecode() {
		return rolecode;
	}

	public void setRolecode(String rolecode) {
		this.rolecode = rolecode;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
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
