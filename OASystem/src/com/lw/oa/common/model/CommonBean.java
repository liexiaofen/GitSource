package com.lw.oa.common.model;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * *@author yuliang
 */
public class CommonBean  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 创建者
	private String creator;
	// 创建日
	private Timestamp createtime;
	// 更新者
	private String updator;
	// 更新日
	private Timestamp updatetime;
	// 排他标识
	private String exclusivefg;
	// 更新排他标识
	private String updateexclusivefg;
	// 组织代码
	private String orgid;
	// 删除区分
	private String deletefg;

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Timestamp getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	public String getUpdator() {
		return updator;
	}

	public void setUpdator(String updator) {
		this.updator = updator;
	}

	public Timestamp getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

	public String getExclusivefg() {
		return exclusivefg;
	}

	public void setExclusivefg(String exclusivefg) {
		this.exclusivefg = exclusivefg;
	}

	public String getUpdateexclusivefg() {
		return updateexclusivefg;
	}

	public void setUpdateexclusivefg(String updateexclusivefg) {
		this.updateexclusivefg = updateexclusivefg;
	}

	public String getOrgid() {
		return orgid;
	}

	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	public String getDeletefg() {
		return deletefg;
	}

	public void setDeletefg(String deletefg) {
		this.deletefg = deletefg;
	}
}
