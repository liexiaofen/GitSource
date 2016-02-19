package com.lw.oa.common.dao;

import java.io.Reader;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
/**
 **@author yuliang
 */
public class MybatisDAOImpl implements IMybatisDAO {
	private static SqlSessionFactory sqlSessionFactory;
	private static Reader reader;
	private SqlSession sqlSession;
	static{
		try {
			reader = Resources.getResourceAsReader("SqlMapConfig.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);				
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public MybatisDAOImpl(){
		
	}	
	@Override
	public List<?> query(String namedsqlid) {
		// TODO Auto-generated method stub
		List<?> list = null;
		list = sqlSession.selectList(namedsqlid);		
		return list;
	}
	@Override
	public List<?> queryByObj(String namedsqlid, Object obj) {
		// TODO Auto-generated method stub
		List<?> list = null;
		list = sqlSession.selectList(namedsqlid, obj);		
		return list;
	}

	@Override
	public List<?> excuteSql(String namedsqlid, Object obj) {
		// TODO Auto-generated method stub
		List<?> list = null;
		list = sqlSession.selectList(namedsqlid, obj);
		return list;
	}
	@Override
	public Object expandByObj(String namedsqlid, Object obj) {
		// TODO Auto-generated method stub
		Object obj1 = null;
		obj1 = sqlSession.selectOne(namedsqlid, obj);
		return obj1;
	}
	@Override
	public int delete(String namedsqlid, Object obj) {	
		// TODO Auto-generated method stub
		return sqlSession.delete(namedsqlid, obj);		
	}
	@Override
	public void insert(String namedsqlid, Object obj) {
		// TODO Auto-generated method stub
		sqlSession.insert(namedsqlid, obj);
	}
	@Override
	public int update(String namedsqlid, Object obj) {
		// TODO Auto-generated method stub
		return sqlSession.update(namedsqlid, obj);
	}	
	
	@Override
	public void openSession() {
		// TODO Auto-generated method stub
		sqlSession = sqlSessionFactory.openSession(false);
	}
	@Override
	public void commit(){
		sqlSession.commit();
	}
	@Override
	public void rollback(){
		sqlSession.rollback();
	}
	@Override
	public void close(){
		sqlSession.close();
	}
}
