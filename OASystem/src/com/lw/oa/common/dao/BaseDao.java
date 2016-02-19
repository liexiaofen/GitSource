package com.lw.oa.common.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
/**
 **@author yuliang
 */
public class BaseDao {
	public static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	public static final String URL = "jdbc:sqlserver://localhost:1433;databasename = oa";
	public static final String UID  = "sa";
	public static final String PWD = "000000";
	protected Connection con = null;
	protected PreparedStatement pstmt = null;
	protected ResultSet rs = null;
	
	/**
	 * 得到数据库连接
	 * @return 数据库连接对象con
	 */
	public Connection getConn(){
		try {
			Class.forName(DRIVER);
			this.con = DriverManager.getConnection(URL,UID,PWD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	/**
	 * 释放资源
	 * @param conn 数据库连接
	 * @param pstmt PreparedStatement对象
	 * @param rs 结果集
	 */
	public void closeAll(Connection conn,PreparedStatement pstmt,ResultSet rs){
		try {
			if(rs !=null){
				rs.close();
				rs = null;
			}
			if(pstmt !=null){
				pstmt.close();
				pstmt = null;
			}
			if (conn !=null) {
				conn.close();
				conn = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 执行SQL语句，可以进行增删改的操作
	 * @param sql 预编译的sql语句
	 * @param param 预编译中SQL语句中的？参数的字符串
	 * @return 影响条数
	 */
	public int executeSQL(String sql,String[] param){
		Connection conn  = null;
		PreparedStatement pstmt = null;
		int num = 0;
		//得到数据连接
		try {
			conn = this.getConn();
			//得到PreparedStatement的对象
			pstmt =conn.prepareStatement(sql);
			//为预编译sql设置参数
			if(pstmt !=null){
				for (int i = 0; i < param.length; i++) {
					pstmt.setString(i + 1, param[i]);
				}
			}
			//执行SQL语句
			num = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll(conn, pstmt, rs);
		}
		return num;
	}
	/**
	 * 执行SQL语句，可以进行增删改的操作
	 * @param <T>
	 * @param sql 预编译的sql语句
	 * @param param 预编译中SQL语句中的？参数的字符串
	 * @return list
	 */
	public List<?> executeQuery(String sql,String[] param){
		Connection conn  = null;
		PreparedStatement pstmt = null;
		//得到数据连接
		try {
			conn = this.getConn();
			//得到PreparedStatement的对象
			pstmt =conn.prepareStatement(sql);
			//为预编译sql设置参数
			if(pstmt !=null){
				for (int i = 0; i < param.length; i++) {
					pstmt.setString(i + 1, param[i]);
				}
				//执行SQL语句
				rs = pstmt.executeQuery();
			}else{
				rs = null;
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll(conn, pstmt, rs);
		}
		return null;
	}	
}
