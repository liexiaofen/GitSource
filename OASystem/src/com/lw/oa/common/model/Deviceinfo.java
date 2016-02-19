package com.lw.oa.common.model;

/**
 * *@author yuliang
 */
public class Deviceinfo extends CommonBean {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//日程设备id
	private String dailydeviceid;
	//机构id
	private String orgcdid;
	//日程设备名称
	private String dailydevicename;
	//内容
	private String comment;
	//备注1
	private String remark1;
	//备注2
	private String remark2;
	//备注3
	private String remark3;

	public String getDailydeviceid() {
		return this.dailydeviceid;
	}

	public void setDailydeviceid(String dailydeviceid) {
		this.dailydeviceid = dailydeviceid;
	}

	public String getOrgcdid() {
		return orgcdid;
	}

	public void setOrgcdid(String orgcdid) {
		this.orgcdid = orgcdid;
	}

	public String getDailydevicename() {
		return this.dailydevicename;
	}

	public void setDailydevicename(String dailydevicename) {
		this.dailydevicename = dailydevicename;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getRemark1() {
		return this.remark1;
	}

	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}

	public String getRemark2() {
		return this.remark2;
	}

	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}

	public String getRemark3() {
		return this.remark3;
	}

	public void setRemark3(String remark3) {
		this.remark3 = remark3;
	}

}