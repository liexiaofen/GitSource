package com.winsolution.weixin.entity;

import java.io.Serializable;

public class PageEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int pageSize; // 每页显示多少条数据
	private int totalPage; // 总页数
	private int totalRecords; // 总记录数
	private int curPage; // 当前页数
	private int curRecord; // 当前记录, 在mysql limit 中就是第一个参数.
	private String sortField; // 排序字段列表
	private String orderBy; // 排序含order by语句

	public int getPageSize() {
		if (pageSize <= 0 || pageSize > 1000) {
			pageSize = 10;
		}
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPage() {
		totalPage = (int) Math.ceil((this.getTotalRecords() + 0.0)/ this.getPageSize());
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalRecords() {
		if (totalRecords < 0) {
			totalRecords = 0;
		}
		return totalRecords;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

	public int getCurPage() {
		int _totalPage = this.getTotalPage();
		if (curPage <= 0) {
			curPage = 1;
		} else if (curPage > _totalPage) {
			curPage = _totalPage;
		}
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
		int _curRecord = (curPage - 1) * this.getPageSize();
		setCurRecord(_curRecord);
	}

	public int getCurRecord() {
		int _totalRecords = this.getTotalRecords();
		int _curPage = this.getCurPage();
		if (curRecord <= 0 || curRecord > _totalRecords) {
			curRecord = 0;
		} else {
			curRecord = (_curPage - 1) * this.getPageSize();
		}
		return curRecord;
	}

	public void setCurRecord(int curRecord) {
		this.curRecord = curRecord;
	}

	public String getSortField() {
		return sortField;
	}

	public void setSortField(String sortField) {
		this.sortField = sortField;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public String getPagerStr() {
		StringBuffer sb = new StringBuffer();
		int _curPage = this.getCurPage();
		int _totalPages = this.getTotalPage();
		int _totalRecords = this.getTotalRecords();
		int _pageSize = this.getPageSize();
		boolean isFirst = _curPage <= 1;
		boolean isLast = _curPage >= _totalPages;

		sb.append("<div id=\"pager_bar\">");
		sb.append("<span>每页").append(_pageSize).append("条，共").append(_totalRecords).append("条</span>&nbsp;&nbsp;");
		sb.append("<input type=\"button\" id=\"page1\" data-mini=\"true\" data-inline=\"true\" onclick=\"goToPage(1);\" value=\"首页\"").append(isFirst ? " disabled" : "").append(" />&nbsp;");
		sb.append("<input type=\"button\" id=\"page2\" data-mini=\"true\" data-inline=\"true\" onclick=\"goToPage(").append(_curPage - 1).append(");\" value=\"上页\"").append(isFirst ? " disabled" : "").append(" />&nbsp;");
		sb.append("<input type=\"button\" id=\"page3\" data-mini=\"true\" data-inline=\"true\" onclick=\"goToPage(").append(_curPage + 1).append(");\" value=\"下页\"").append(isLast ? " disabled" : "").append(" />&nbsp;");
		sb.append("<input type=\"button\" id=\"page4\" data-mini=\"true\" data-inline=\"true\" onclick=\"goToPage(").append(_totalPages).append(");\" value=\"尾页\"").append(isLast ? " disabled" : "").append(" />");
		sb.append("&nbsp;&nbsp;<span>当前第").append(_curPage).append("页，共").append(_totalPages).append("页</span>");
		sb.append("</div>");
		return sb.toString();
	}

}
