package com.lw.oa.common.dao;

import java.io.Reader;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DictDAOImpl implements IDictDAO {
	private static SqlSessionFactory sqlSessionFactory;
	private static Reader reader;
	private static SqlSession sqlSession;
	static{
		try {
			reader = Resources.getResourceAsReader("SqlMapConfig.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			sqlSession = sqlSessionFactory.openSession(false);
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void openSession() {
		// TODO Auto-generated method stub
		sqlSession = sqlSessionFactory.openSession(false);
	}
	@Override
	public void close(){
		sqlSession.close();
	}
	@Override
	public List<?> excuteSql(String namedsqlid, Object obj) {
		// TODO Auto-generated method stub
		List<?> list = null;
		list = sqlSession.selectList(namedsqlid, obj);
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
	public Object expandByObj(String namedsqlid, Object obj) {
		// TODO Auto-generated method stub
		Object obj1 = null;
		obj1 = sqlSession.selectOne(namedsqlid, obj);
		return obj1;
	}
}
