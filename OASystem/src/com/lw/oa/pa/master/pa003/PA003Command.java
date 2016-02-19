package com.lw.oa.pa.master.pa003;

import java.io.Serializable;

/**
 * *@author yuliang
 */
public class PA003Command implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PA003001SearchCommand pa003001searchcommand;
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
	// 每月天数
	private String dayofmonth;
	// 工作日状态
	private String status;

	public PA003001SearchCommand getPa003001searchcommand() {
		return pa003001searchcommand;
	}

	public void setPa003001searchcommand(
			PA003001SearchCommand pa003001searchcommand) {
		this.pa003001searchcommand = pa003001searchcommand;
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

	public String getDayofmonth() {
		return dayofmonth;
	}

	public void setDayofmonth(String dayofmonth) {
		this.dayofmonth = dayofmonth;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
