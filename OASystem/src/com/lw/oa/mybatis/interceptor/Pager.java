package com.lw.oa.mybatis.interceptor;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pager<T>  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 当前页
	private int curPage=1;
	// 每页显示的记录数，默认是20
	private int pageSize = 20;
	// 总记录数
	private int totalRecord;
	// 总页数
	private int totalPage;
	// 是否第一页
	private boolean firstPage = false;
	// 是否最后一页
	private boolean lastPage = false;
	//对应的当前页记录  
	private List<T> results;
	//其他的参数我们把它分装成一个Map对象 
	private Map<String, Object> params = new HashMap<String, Object>();

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;		
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
		// 在设置总页数的时候计算出对应的总页数，在下面的三目运算中加法拥有更高的优先级，所以最后可以不加括号。
		int totalPage = totalRecord % pageSize == 0 ? totalRecord / pageSize
				: totalRecord / pageSize + 1;
		this.setTotalPage(totalPage);
		if(curPage == 1 && totalPage == 1){
			firstPage = true;
			lastPage = true;
		}else if(curPage == 1){
			firstPage = true;
			lastPage = false;
		}else if(curPage == totalPage){
			firstPage = false;
			lastPage = true;
		}else{
			firstPage = false;
			lastPage = false;
		}
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}	

	

	public boolean getFirstPage() {
		return firstPage;
	}

	public void setFirstPage(boolean firstPage) {
		this.firstPage = firstPage;
	}

	public boolean getLastPage() {
		return lastPage;
	}

	public void setLastPage(boolean lastPage) {
		this.lastPage = lastPage;
	}

	public List<T> getResults() {
		return results;
	}

	public void setResults(List<T> results) {
		this.results = results;
	}

	public Map<String, Object> getParams() {
		return params;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Page [curPage=").append(curPage).append(", pageSize=")
				.append(pageSize).append(", totalPage=").append(totalPage)
				.append(", totalRecord=").append(totalRecord).append(", results=")
				.append(results)
				.append("]");
		return builder.toString();
	}

}
