package com.lw.oa.mybatis.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *@author yuliang
 */
public class MysqlDialect extends Dialect {
	// 日志对象
	protected static Logger log = LoggerFactory.getLogger(Dialect.class);
	@Override
	public String getPageSql(Pager<?> pager, String sql) {
		// TODO Auto-generated method stub
		//计算第一条记录的位置，Mysql中记录的位置是从0开始的。  
		int offset = (pager.getCurPage() - 1) * pager.getPageSize();  
		StringBuffer sqlBuffer = new StringBuffer(sql);  
		sqlBuffer.append(" limit ").append(offset).append(",").append(pager.getPageSize());  
		log.debug(sqlBuffer.toString());
		return sqlBuffer.toString();
	}
}
