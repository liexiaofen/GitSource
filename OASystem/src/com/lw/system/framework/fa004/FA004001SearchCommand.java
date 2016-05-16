package com.lw.system.framework.fa004;

import java.io.Serializable;

import com.lw.oa.common.model.BusiDictType;
import com.lw.oa.mybatis.interceptor.Pager;

/**
 * *@author yuliang
 */
public class FA004001SearchCommand extends Pager<FA004001ResultCommand>
		implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BusiDictType[] busidicttype;
	// 业务字典类型id
	private String busidicttypeid;
	// 业务字典类型名称
	private String busidicttypename;
	// 业务字典id
	private String busidictid;
	// 业务字典名称
	private String busidictname;	
	// 编辑画面业务字典类型id
	private String id;
	// 编辑画面业务字典类型名称
	private String name;
	public BusiDictType[] getBusidicttype() {
		return busidicttype;
	}

	public void setBusidicttype(BusiDictType[] busidicttype) {
		this.busidicttype = busidicttype;
	}

	public String getBusidicttypeid() {
		return busidicttypeid;
	}

	public void setBusidicttypeid(String busidicttypeid) {
		this.busidicttypeid = busidicttypeid;
	}

	public String getBusidicttypename() {
		return busidicttypename;
	}

	public void setBusidicttypename(String busidicttypename) {
		this.busidicttypename = busidicttypename;
	}

	public String getBusidictid() {
		return busidictid;
	}

	public void setBusidictid(String busidictid) {
		this.busidictid = busidictid;
	}

	public String getBusidictname() {
		return busidictname;
	}

	public void setBusidictname(String busidictname) {
		this.busidictname = busidictname;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
