package com.lw.oa.common.model;

/**
 * *@author yuliang
 */
public class AnnualVctn extends CommonBean {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 员工id
	private String empid;
	// 年份
	private String year;
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
	// 备注1
	private String remark1;
	// 备注2
	private String remark2;
	// 备注3
	private String remark3;

	public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
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