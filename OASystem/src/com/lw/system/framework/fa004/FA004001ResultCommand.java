package com.lw.system.framework.fa004;

import java.io.Serializable;

public class FA004001ResultCommand implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 业务字典类型id
	private String busidicttypeid;
	// 业务字典类型名称
	private String busidicttypename;
	// 业务字典id
	private String busidictid;
	// 业务字典名称
	private String busidictname;
	
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
	
}
