package com.lw.oa.common.dao;
import java.util.List;
/**
 **@author yuliang
 */
public interface IDictDAO {
	public List<?> queryByObj(String namedsqlid, Object obj);
	public List<?> excuteSql(String namedsqlid, Object obj);
	public Object expandByObj(String namedsqlid, Object obj);
	public void openSession();
	public void close();
}
