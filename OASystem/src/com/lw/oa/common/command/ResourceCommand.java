package com.lw.oa.common.command;

import java.io.Serializable;
import java.util.List;
public class ResourceCommand implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<ResourceCommand> list = null;
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
	// 备注1
	private String remark1;

	public List<ResourceCommand> getList() {
		return list;
	}

	public void setList(List<ResourceCommand> list) {
		this.list = list;
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

	public String getRemark1() {
		return remark1;
	}

	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}
	
}
