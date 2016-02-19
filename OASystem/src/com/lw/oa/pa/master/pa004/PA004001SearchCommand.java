package com.lw.oa.pa.master.pa004;

import com.lw.oa.mybatis.interceptor.Pager;

/**
 * *@author yuliang
 */
public class PA004001SearchCommand extends Pager<PA004001ResultCommand> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 区域id
	private String regionid;
	// 机构id
	private String orgcdid;
	// 机构全称
	private String orgname;
	// 机构简称
	private String orgshortname;

	public String getRegionid() {
		return regionid;
	}

	public void setRegionid(String regionid) {
		this.regionid = regionid;
	}

	public String getOrgcdid() {
		return orgcdid;
	}

	public void setOrgcdid(String orgcdid) {
		this.orgcdid = orgcdid;
	}

	public String getOrgname() {
		return orgname;
	}

	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	public String getOrgshortname() {
		return orgshortname;
	}

	public void setOrgshortname(String orgshortname) {
		this.orgshortname = orgshortname;
	}

}
