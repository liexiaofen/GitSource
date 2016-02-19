package com.lw.oa.pa.master.pa005;

import java.io.Serializable;

/**
 * *@author yuliang
 */
public class PA005Command implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PA005001SearchCommand pa005001searchcommand;
	// 排他标识
	private String exclusivefg;
	// 员工姓名
	private String empname;
	// 年度
	private String year;
	// 员工id
	private String empid;
	// 法定休假
	private String legalvctn;
	// 福利休假
	private String wealvctn;
	// 加班调休
	private String extraworkvctn;
	// 已休法定休假
	private String haslegalvctn;
	// 已休福利休假
	private String haswealvctn;
	// 已休加班调休
	private String hasextraworkvctn;
	// 未休法定休假
	private String unlegalvctn;
	// 未休福利休假
	private String unwealvctn;
	// 未休加班调休
	private String unextraworkvctn;
	
	public PA005001SearchCommand getPa005001searchcommand() {
		return pa005001searchcommand;
	}

	public void setPa005001searchcommand(
			PA005001SearchCommand pa005001searchcommand) {
		this.pa005001searchcommand = pa005001searchcommand;
	}

	public String getExclusivefg() {
		return exclusivefg;
	}

	public void setExclusivefg(String exclusivefg) {
		this.exclusivefg = exclusivefg;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}

	public String getLegalvctn() {
		return legalvctn;
	}

	public void setLegalvctn(String legalvctn) {
		this.legalvctn = legalvctn;
	}

	public String getWealvctn() {
		return wealvctn;
	}

	public void setWealvctn(String wealvctn) {
		this.wealvctn = wealvctn;
	}

	public String getExtraworkvctn() {
		return extraworkvctn;
	}

	public void setExtraworkvctn(String extraworkvctn) {
		this.extraworkvctn = extraworkvctn;
	}

	public String getHaslegalvctn() {
		return haslegalvctn;
	}

	public void setHaslegalvctn(String haslegalvctn) {
		this.haslegalvctn = haslegalvctn;
	}

	public String getHaswealvctn() {
		return haswealvctn;
	}

	public void setHaswealvctn(String haswealvctn) {
		this.haswealvctn = haswealvctn;
	}

	public String getHasextraworkvctn() {
		return hasextraworkvctn;
	}

	public void setHasextraworkvctn(String hasextraworkvctn) {
		this.hasextraworkvctn = hasextraworkvctn;
	}

	public String getUnlegalvctn() {
		return unlegalvctn;
	}

	public void setUnlegalvctn(String unlegalvctn) {
		this.unlegalvctn = unlegalvctn;
	}

	public String getUnwealvctn() {
		return unwealvctn;
	}

	public void setUnwealvctn(String unwealvctn) {
		this.unwealvctn = unwealvctn;
	}

	public String getUnextraworkvctn() {
		return unextraworkvctn;
	}

	public void setUnextraworkvctn(String unextraworkvctn) {
		this.unextraworkvctn = unextraworkvctn;
	}

}
