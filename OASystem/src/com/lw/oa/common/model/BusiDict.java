package com.lw.oa.common.model;

import java.io.Serializable;

/**
 * *@author yuliang
 */
public class BusiDict implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4250251212838000187L;
	// 业务字典类型id
	private String busidicttypeid;
	// 业务字典id
	private String busidictid;
	// 业务字典名称
	private String busidictname;
	// 状态
	private String status;
	// 排序no
	private int sortno;
	// 等级
	private String rank;
	// 父类id
	private String parentid;
	// 序列号
	private String seqno;
	// 过滤值1
	private String filter1;
	// 过滤值2
	private String filter2;

	public String getBusidicttypeid() {
		return busidicttypeid;
	}

	public void setBusidicttypeid(String busidicttypeid) {
		this.busidicttypeid = busidicttypeid;
	}

	public String getBusidictid() {
		return busidictid;
	}

	public void setBusidictid(String busidictid) {
		this.busidictid = busidictid;
	}

	public String getBusidictname() {
		return busidictname;
	}

	public void setBusidictname(String busidictname) {
		this.busidictname = busidictname;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getSortno() {
		return sortno;
	}

	public void setSortno(int sortno) {
		this.sortno = sortno;
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

	public String getFilter1() {
		return filter1;
	}

	public void setFilter1(String filter1) {
		this.filter1 = filter1;
	}

	public String getFilter2() {
		return filter2;
	}

	public void setFilter2(String filter2) {
		this.filter2 = filter2;
	}

}