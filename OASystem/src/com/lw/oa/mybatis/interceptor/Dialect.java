package com.lw.oa.mybatis.interceptor;

/**
 * @author yuliang
 */
public abstract class Dialect {
	// 数据库方言
	public static enum Type {
		MYSQL, ORACLE, MS
	}

	/**
	 * 根据page对象获取对应的分页查询Sql语句
	 * 
	 * @param page
	 *            分页对象
	 * @param sql
	 *            原sql语句
	 * @return
	 */
	public abstract String getPageSql(Pager<?> pager, String sql);
}
