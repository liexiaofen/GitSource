package com.lw.system.framework.fa004;

import java.io.Serializable;
import java.util.List;

import com.lw.oa.common.model.BusiDict;
public class FA004Command implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FA004001SearchCommand searchCommand;
	// 业务字典类型id
	private String busidicttypeid;
	// 业务字典类型名称
	private String busidicttypename;

	private BusiDict[] busidict;
	
	private List<BusiDict> list;
	

	public FA004001SearchCommand getSearchCommand() {
		return searchCommand;
	}

	public void setSearchCommand(FA004001SearchCommand searchCommand) {
		this.searchCommand = searchCommand;
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

	public List<BusiDict> getList() {
		return list;
	}

	public void setList(List<BusiDict> list) {
		this.list = list;
	}

}
