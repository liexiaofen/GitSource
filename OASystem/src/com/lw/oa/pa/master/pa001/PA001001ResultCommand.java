package com.lw.oa.pa.master.pa001;

import java.io.Serializable;
import java.util.List;

import com.lw.oa.common.command.ResultCommand;

public class PA001001ResultCommand implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<ResultCommand> listOrg;
	// 更新日
	private String updatetime;
	// 更新人
	private String updator;
	// 员工id
	private String empid;
	// 排他标识
	private String exclusivefg;
	// 角色id
	private String roleid;
	// 角色id业务字典
	private String roleiddict;	
	// 员工姓名
	private String empname;
	// 员工号
	private String empno;	
	// 职称名称
	private String posname;
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
	// 离职时间
	private String offtime;
	// 性别
	private String sex;
	// 性别业务字典
	private String sexdict;
	// 状态
	private String status;
	// 状态业务字典
	private String statusdict;
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

	public List<ResultCommand> getListOrg() {
		return listOrg;
	}

	public void setListOrg(List<ResultCommand> listOrg) {
		this.listOrg = listOrg;
	}

	public String getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}

	public String getUpdator() {
		return updator;
	}

	public void setUpdator(String updator) {
		this.updator = updator;
	}

	public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}

	public String getExclusivefg() {
		return exclusivefg;
	}

	public void setExclusivefg(String exclusivefg) {
		this.exclusivefg = exclusivefg;
	}

	public String getRoleid() {
		return roleid;
	}

	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}
	
	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public String getEmpno() {
		return empno;
	}

	public void setEmpno(String empno) {
		this.empno = empno;
	}

	public String getPosname() {
		return posname;
	}

	public void setPosname(String posname) {
		this.posname = posname;
	}


	public String getEmail() {
		return email;
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
		return cardno;
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

	public String getOfftime() {
		return offtime;
	}

	public void setOfftime(String offtime) {
		this.offtime = offtime;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getStatus() {
		return status;
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

	public String getRoleiddict() {
		return roleiddict;
	}

	public void setRoleiddict(String roleiddict) {
		this.roleiddict = roleiddict;
	}

	public String getStatusdict() {
		return statusdict;
	}

	public void setStatusdict(String statusdict) {
		this.statusdict = statusdict;
	}

	public String getSexdict() {
		return sexdict;
	}

	public void setSexdict(String sexdict) {
		this.sexdict = sexdict;
	}

}
