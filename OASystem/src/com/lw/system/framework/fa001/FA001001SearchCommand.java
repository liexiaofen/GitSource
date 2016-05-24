package com.lw.system.framework.fa001;

import java.io.Serializable;

import com.lw.oa.common.model.Resource;
import com.lw.oa.mybatis.interceptor.Pager;

/**
 * *@author yuliang
 */
public class FA001001SearchCommand extends Pager<FA001001ResultCommand>
		implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Resource[] resource;
	// 菜单编号
	private String resourcecode;
	// 菜单层次
	private String resourcelevel;
	// 菜单名称
	private String resourcename;
	// 菜单id
	private String resourceid;

	public Resource[] getResource() {
		return resource;
	}

	public void setResource(Resource[] resource) {
		this.resource = resource;
	}

	public String getResourceid() {
		return resourceid;
	}

	public void setResourceid(String resourceid) {
		this.resourceid = resourceid;
	}

	public String getResourcecode() {
		return resourcecode;
	}

	public void setResourcecode(String resourcecode) {
		this.resourcecode = resourcecode;
	}

	public String getResourcelevel() {
		return resourcelevel;
	}

	public void setResourcelevel(String resourcelevel) {
		this.resourcelevel = resourcelevel;
	}

	public String getResourcename() {
		return resourcename;
	}

	public void setResourcename(String resourcename) {
		this.resourcename = resourcename;
	}

}
