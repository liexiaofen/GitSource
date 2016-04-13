package com.lw.oa.pb.daily.pb001;

import java.io.Serializable;
import java.util.List;
import com.lw.oa.common.model.NationLegalday;

/**
 * *@author yuliang
 */
public class PB001001ResultTitleCommand implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<NationLegalday> list;
	public List<NationLegalday> getList() {
		return list;
	}
	public void setList(List<NationLegalday> list) {
		this.list = list;
	}

}
