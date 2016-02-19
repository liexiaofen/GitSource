package com.lw.oa.pa.master.pa003;

import com.lw.oa.mybatis.interceptor.Pager;

/**
 * *@author yuliang
 */
public class PA003001SearchCommand extends Pager<PA003001ResultCommand> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 法定id
	private String legalid;
	// 法定日期
	private String legaldate;
	// 法定年
	private String legalyear;
	// 法定月
	private String legalmonth;

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

}
