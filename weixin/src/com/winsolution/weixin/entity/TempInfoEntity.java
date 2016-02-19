package com.winsolution.weixin.entity;

import java.io.Serializable;
import java.sql.Date;

public class TempInfoEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//用户ID
	private String uid;
	//微信号
	private String wxid;
	//用户名
	private String usrname;
	//绑定邮件
	private String email;
	//绑定手机号
	private String mobile;
	//性别
	private String sex;
	//入职日期
	private Date entrydate;

	public TempInfoEntity() {
		super();
	}

	public TempInfoEntity(String uid, String wxid, String usrname,
			String email, String mobile, String sex, Date entrydate) {
		super();
		this.uid = uid;
		this.wxid = wxid;
		this.usrname = usrname;
		this.email = email;
		this.mobile = mobile;
		this.sex = sex;
		this.entrydate = entrydate;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getWxid() {
		return wxid;
	}

	public void setWxid(String wxid) {
		this.wxid = wxid;
	}

	public String getUsrname() {
		return usrname;
	}

	public void setUsrname(String usrname) {
		this.usrname = usrname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getEntrydate() {
		return entrydate;
	}

	public void setEntrydate(Date entrydate) {
		this.entrydate = entrydate;
	}
	
	
	
}
