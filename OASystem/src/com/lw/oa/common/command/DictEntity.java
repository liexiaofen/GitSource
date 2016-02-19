package com.lw.oa.common.command;

import java.io.Serializable;

/**
 * *@author yuliang
 */
public class DictEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 业务字典id
	private String busidictid;
	// 业务字典名称
	private String busidictname;

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
