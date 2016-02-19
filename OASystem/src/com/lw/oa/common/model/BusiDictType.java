package com.lw.oa.common.model;

import java.io.Serializable;

/**
 * *@author yuliang
 */
public class BusiDictType implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4250251212838000187L;
	// 业务字典类型id
	private String busidicttypeid;
	// 业务字典类型名称
	private String busidicttypename;
	// 等级
	private String rank;
	// 父类id
	private String parentid;
	// 序列号
	private String seqno;

	public String getBusidicttypeid() {
		return busidicttypeid;
	}

	public void setBusidicttypeid(String busidicttypeid) {
		this.busidicttypeid = busidicttypeid;
	}

	public String getBusidicttypename() {
		return busidicttypename;
	}

	public void setBusidicttypename(String busidicttypename) {
		this.busidicttypename = busidicttypename;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getParentid() {
		return parentid;
	}

	public void setParentid(String parentid) {
		this.parentid = parentid;
	}

	public String getSeqno() {
		return seqno;
	}

	public void setSeqno(String seqno) {
		this.seqno = seqno;
	}

}