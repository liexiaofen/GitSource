package com.lw.oa.common.model;

/**
 * *@author yuliang
 */
public class TicketDetail extends CommonBean {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 订票明细id
	private String ticketdetailid;
	// 申请id
	private String applyid;
	// 预订日期
	private String orderdate;
	// 航班
	private String flight;
	// 出发
	private String start;
	// 到达
	private String reach;
	// 是否折扣
	private String discountflag;
	// 是否出票
	private String ticketflag;
	// 排序no
	private String sortno;
	// 备注1
	private String remark1;
	// 备注2
	private String remark2;
	// 备注3
	private String remark3;

	public String getTicketdetailid() {
		return ticketdetailid;
	}

	public void setTicketdetailid(String ticketdetailid) {
		this.ticketdetailid = ticketdetailid;
	}

	public String getApplyid() {
		return applyid;
	}

	public void setApplyid(String applyid) {
		this.applyid = applyid;
	}

	public String getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}

	public String getFlight() {
		return flight;
	}

	public void setFlight(String flight) {
		this.flight = flight;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getReach() {
		return reach;
	}

	public void setReach(String reach) {
		this.reach = reach;
	}

	public String getDiscountflag() {
		return discountflag;
	}

	public void setDiscountflag(String discountflag) {
		this.discountflag = discountflag;
	}

	public String getTicketflag() {
		return ticketflag;
	}

	public void setTicketflag(String ticketflag) {
		this.ticketflag = ticketflag;
	}

	public String getSortno() {
		return sortno;
	}

	public void setSortno(String sortno) {
		this.sortno = sortno;
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