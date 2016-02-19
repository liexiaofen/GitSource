package com.lw.oa.pa.master.pa003;

import java.io.Serializable;

public class PA003001ResultCommand implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 更新日
	private String updatetime;
	// 排他标识
	private String exclusivefg;
	// 法定id
	private String legalid;
	// 法定日期
	private String legaldate;
	// 法定年
	private String legalyear;
	// 法定月
	private String legalmonth;
	// 法定日
	private String legalday;
	// 星期
	private String dayofweek;
	// 周数
	private String weekofyear;
	// 天数
	private String dayofyear;
	// 工作日状态
	private String status;
	// 备注1
	private String remark1;
	// 备注2
	private String remark2;
	// 备注3
	private String remark3;

	public String getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}

	public String getExclusivefg() {
		return exclusivefg;
	}

	public void setExclusivefg(String exclusivefg) {
		this.exclusivefg = exclusivefg;
	}

	public String getLegalid() {
		return legalid;
	}

	public void setLegalid(String legalid) {
		this.legalid = legalid;
	}

	public String getLegaldate() {
		return legaldate;
	}

	public void setLegaldate(String legaldate) {
		this.legaldate = legaldate;
	}

	public String getLegalyear() {
		return legalyear;
	}

	public void setLegalyear(String legalyear) {
		this.legalyear = legalyear;
	}

	public String getLegalmonth() {
		return legalmonth;
	}

	public void setLegalmonth(String legalmonth) {
		this.legalmonth = legalmonth;
	}

	public String getLegalday() {
		return legalday;
	}

	public void setLegalday(String legalday) {
		this.legalday = legalday;
	}

	public String getDayofweek() {
		return dayofweek;
	}

	public void setDayofweek(String dayofweek) {
		this.dayofweek = dayofweek;
	}

	public String getWeekofyear() {
		return weekofyear;
	}

	public void setWeekofyear(String weekofyear) {
		this.weekofyear = weekofyear;
	}

	public String getDayofyear() {
		return dayofyear;
	}

	public void setDayofyear(String dayofyear) {
		this.dayofyear = dayofyear;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemark1() {
		return remark1;
	}

	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}

	public String getRemark2() {
		return remark2;
	}

	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}

	public String getRemark3() {
		return remark3;
	}

	public void setRemark3(String remark3) {
		this.remark3 = remark3;
	}
}
