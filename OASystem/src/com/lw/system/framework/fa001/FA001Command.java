package com.lw.system.framework.fa001;

import java.io.Serializable;
public class FA001Command implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FA001001SearchCommand searchCommand;
	// 资源id
	private String resourceid;
	// 资源名称
	private String resourcename;
	// 资源代码
	private String resourcecode;
	// 是否叶子资源
	private String isleaf;
	// 等级
	private String resourcelevel;
	// 资源入口
	private String resourceaction;
	// 父类id
	private String parentid;
	// 资源类型
	private String resourcetype;
	// 排序no
	private String sortno;
	// 父类名称
	private String parentname;
	
	public FA001001SearchCommand getSearchCommand() {
		return searchCommand;
	}

	public void setSearchCommand(FA001001SearchCommand searchCommand) {
		this.searchCommand = searchCommand;
	}

	public String getResourceid() {
		return resourceid;
	}

	public void setResourceid(String resourceid) {
		this.resourceid = resourceid;
	}

	public String getResourcename() {
		return resourcename;
	}

	public void setResourcename(String resourcename) {
		this.resourcename = resourcename;
	}

	public String getResourcecode() {
		return resourcecode;
	}

	public void setResourcecode(String resourcecode) {
		this.resourcecode = resourcecode;
	}

	public String getIsleaf() {
		return isleaf;
	}

	public void setIsleaf(String isleaf) {
		this.isleaf = isleaf;
	}

	public String getResourcelevel() {
		return resourcelevel;
	}

	public void setResourcelevel(String resourcelevel) {
		this.resourcelevel = resourcelevel;
	}

	public String getResourceaction() {
		return resourceaction;
	}

	public void setResourceaction(String resourceaction) {
		this.resourceaction = resourceaction;
	}

	public String getParentid() {
		return parentid;
	}

	public void setParentid(String parentid) {
		this.parentid = parentid;
	}

	public String getResourcetype() {
		return resourcetype;
	}

	public void setResourcetype(String resourcetype) {
		this.resourcetype = resourcetype;
	}

	public String getSortno() {
		return sortno;
	}

	public void setSortno(String sortno) {
		this.sortno = sortno;
	}

	public String getParentname() {
		return parentname;
	}

	public void setParentname(String parentname) {
		this.parentname = parentname;
	}
}
