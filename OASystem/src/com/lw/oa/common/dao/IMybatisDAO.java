package com.lw.oa.common.dao;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
/**
 **@author yuliang
 */
public interface IMybatisDAO {
	public List<?> query(String namedsqlid);
	public List<?> queryByObj(String namedsqlid, Object obj);
	public List<?> excuteSql(String namedsqlid, Object obj);
	public Object expandByObj(String namedsqlid, Object obj);
	public int delete(String namedsqlid, Object obj);
	public void insert(String namedsqlid, Object obj);
	public int update(String namedsqlid, Object obj);
	public void openSession();
	public void commit();
	public void rollback();
	public void close();
	public SqlSession getSqlSession();
}
