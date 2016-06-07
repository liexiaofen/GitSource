package com.lw.oa.common.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
/**
 ** @author yuliang
 */
public class MybatisDAOImpl implements IMybatisDAO {

	public MybatisDAOImpl() {

	}
	private SqlSession sqlSession;
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
		sqlSession = MyBatisUtils.getSqlSession();		
		System.out.println("当前的打开的session：" + getSqlSession());
	}

	@Override
	public void commit() {
		// TODO Auto-generated method stub
		MyBatisUtils.commitSqlSession();
	}

	@Override
	public void rollback() {
		// TODO Auto-generated method stub
		MyBatisUtils.rollbackSqlSession();
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		System.out.println("当前的关闭的session：" + getSqlSession());
		MyBatisUtils.closeSqlSession();
	}

	public SqlSession getSqlSession() {
		return sqlSession;
	}
}
