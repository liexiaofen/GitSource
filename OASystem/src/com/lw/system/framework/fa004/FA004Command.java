package com.lw.system.framework.fa004;

import java.io.Serializable;
import com.lw.oa.common.model.BusiDict;
public class FA004Command implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FA004001SearchCommand searchcommand;
	// 业务字典类型id
	private String busidicttypeid;
	// 业务字典类型名称
	private String busidicttypename;

	private BusiDict[] busidict;

	public FA004001SearchCommand getSearchcommand() {
		return searchcommand;
	}

	public void setSearchcommand(FA004001SearchCommand searchcommand) {
		this.searchcommand = searchcommand;
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

	public BusiDict[] getBusidict() {
		return busidict;
	}

	public void setBusidict(BusiDict[] busidict) {
		this.busidict = busidict;
	}

}
