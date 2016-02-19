package com.lw.oa.mybatis.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *@author yuliang
 */
public class MsDialect extends Dialect {
	// 日志对象
	protected static Logger log = LoggerFactory.getLogger(MsDialect.class);
	@Override
	public String getPageSql(Pager<?> pager, String sql) {
		// TODO Auto-generated method stub
		// 计算第一条记录的位置，Sql Server分页是通过rownum进行的，而rownum是从1开始的
		int offset = (pager.getCurPage() - 1) * pager.getPageSize() + 1;
		StringBuffer sqlBuffer = new StringBuffer(sql);
		sqlBuffer.insert(0, "select u.* from (").append(") u where rownum >= ").append(offset)
				.append(" and rownum < ").append(offset + pager.getPageSize());
		log.debug(sqlBuffer.toString());
		// select u.* from (select * from t_user) u where rownum >= 16 and rownum < 31
		return sqlBuffer.toString();
	}
}
