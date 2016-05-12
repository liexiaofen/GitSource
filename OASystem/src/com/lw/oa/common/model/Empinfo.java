package com.lw.oa.common.model;

import java.util.Date;

/**
 * *@author yuliang
 */
public class Empinfo extends CommonBean {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1727701528826002704L;
	// 员工id
	private String empid;
	// 角色id
	private String roleid;	
	// 职称名称
	private String posname;	
	// 员工姓名
	private String empname;
	// 员工英文名
	private String empenname;
	// 员工号
	private String empno;
	// 工龄
	private String workage;
	// 邮件
	private String email;
	// 国内电话
	private String domestictel;
	// 国际电话
	private String internttel;
	// 分机
	private String extension;
	// 直线
	private String straightline;
	// SKYPE號
	private String skypenum;
	// 身份证号码
	private String cardno;
	// 入职时间
	private Date entrytime;
	// 离职时间
	private Date offtime;
	// 性别
	private String sex;
	// 状态
	private String status;
	// 用户名
	private String username;
	// 密码
	private String password;
	// 备注1
	private String remark1;
	// 备注2
	private String remark2;
	// 备注3
	private String remark3;

	public String getEmpid() {
		return this.empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}
	
	public String getEmpenname() {
		return empenname;
	}

	public void setEmpenname(String empenname) {
		this.empenname = empenname;
	}

	public String getPosname() {
		return posname;
	}

	public void setPosname(String posname) {
		this.posname = posname;
	}

	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}

	public String getRoleid() {
		return roleid;
	}

	public String getEmpname() {
		return this.empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public String getEmpno() {
		return this.empno;
	}

	public void setEmpno(String empno) {
		this.empno = empno;
	}

	public String getWorkage() {
		return workage;
	}

	public void setWorkage(String workage) {
		this.workage = workage;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDomestictel() {
		return domestictel;
	}

	public void setDomestictel(String domestictel) {
		this.domestictel = domestictel;
	}

	public String getInternttel() {
		return internttel;
	}

	public void setInternttel(String internttel) {
		this.internttel = internttel;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getStraightline() {
		return straightline;
	}

	public void setStraightline(String straightline) {
		this.straightline = straightline;
	}

	public String getSkypenum() {
		return skypenum;
	}

	public void setSkypenum(String skypenum) {
		this.skypenum = skypenum;
	}

	public String getCardno() {
		return this.cardno;
	}

	public void setCardno(String cardno) {
		this.cardno = cardno;
	}

	public Date getEntrytime() {
		return this.entrytime;
	}

	public void setEntrytime(Date entrytime) {
		this.entrytime = entrytime;
	}

	public Date getOfftime() {
		return this.offtime;
	}

	public void setOfftime(Date offtime) {
		this.offtime = offtime;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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