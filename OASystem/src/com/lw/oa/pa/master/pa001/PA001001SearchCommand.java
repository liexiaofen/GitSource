package com.lw.oa.pa.master.pa001;

import com.lw.oa.mybatis.interceptor.Pager;

/**
 * *@author yuliang
 */
public class PA001001SearchCommand extends Pager<PA001001ResultCommand> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 员工id
	private String empid;
	// 机构id
	private String orgcdid;
	// 角色id
	private String roleid;
	// 部门id
	private String depid;
	// 职称id
	private String posid;
	// 员工姓名
	private String empname;
	// 员工号
	private String empno;
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
	private String entrytime;
	// 入职时间start
	private String entrytimestart;
	// 入职时间end
	private String entrytimeend;
	// 离职时间
	private String offtime;
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

	public String getOrgcdid() {
		return orgcdid;
	}

	public void setOrgcdid(String orgcdid) {
		this.orgcdid = orgcdid;
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

	public String getEntrytime() {
		return entrytime;
	}

	public void setEntrytime(String entrytime) {
		this.entrytime = entrytime;
	}

	public String getEntrytimestart() {
		return entrytimestart;
	}

	public void setEntrytimestart(String entrytimestart) {
		this.entrytimestart = entrytimestart;
	}

	public String getEntrytimeend() {
		return entrytimeend;
	}

	public void setEntrytimeend(String entrytimeend) {
		this.entrytimeend = entrytimeend;
	}

	public String getOfftime() {
		return this.offtime;
	}

	public void setOfftime(String offtime) {
		this.offtime = offtime;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getDepid() {
		return this.depid;
	}

	public void setDepid(String depid) {
		this.depid = depid;
	}

	public String getPosid() {
		return this.posid;
	}

	public void setPosid(String posid) {
		this.posid = posid;
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
