package com.lw.oa.mybatis.interceptor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import org.apache.ibatis.executor.parameter.DefaultParameterHandler;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author yuliang
 * @date 2015-9-21
 * @description 不在拦截器中计算总数，影响效率
 * @version V1.0
 * 
 *          分页拦截器，用于拦截需要进行分页查询的操作，然后对其进行分页处理。 利用拦截器实现Mybatis分页的原理：
 *          要利用JDBC对数据库进行操作就必须要有一个对应的Statement对象
 *          ，Mybatis在执行Sql语句前就会产生一个包含Sql语句的Statement对象，而且对应的Sql语句
 *          是在Statement之前产生的，所以我们就可以在它生成Statement之前对用来生成Statement的Sql语句下手
 *          。在Mybatis中Statement语句是通过RoutingStatementHandler对象的 prepare方法生成的。
 *          拦截器实现Mybatis分页的一个思路就是拦截StatementHandler接口的prepare方法
 *          ，然后在拦截器方法中把Sql语句改成对应的分页查询Sql语句，之后再调用
 *          StatementHandler对象的prepare方法，即调用invocation.proceed()。
 *          对于分页而言，在拦截器里面我们还需要做的一个操作就是统计满足当前条件的记录一共有多少
 *          ，这是通过获取到了原始的Sql语句后，把它改为对应的统计语句再利用Mybatis封装好的参数和设
 *          置参数的功能把Sql语句中的参数进行替换，之后再执行查询记录数的Sql语句进行总记录数的统计。
 * 
 */
@Intercepts({ @Signature(method = "prepare", type = StatementHandler.class, args = { Connection.class }) })
public class PaginationInterceptor implements Interceptor {
	// 日志对象
	protected static Logger log = LoggerFactory
			.getLogger(PaginationInterceptor.class);
	// 数据库类型，不同的数据库有不同的分页方法
	private String databaseType;
	// 后缀为ByPage的sqlid进行分页查询
	private String pageSqlId;
	// 根据不同的方言获取不同的分页sql
	private Dialect dialect;

	/**
	 * 拦截后要执行的方法
	 */

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		// TODO Auto-generated method stub
		// 对于StatementHandler其实只有两个实现类，一个是RoutingStatementHandler，另一个是抽象类BaseStatementHandler，
		// BaseStatementHandler有三个子类，分别是SimpleStatementHandler，PreparedStatementHandler和CallableStatementHandler，
		// SimpleStatementHandler是用于处理Statement的，PreparedStatementHandler是处理PreparedStatement的，而CallableStatementHandler是
		// 处理CallableStatement的。Mybatis在进行Sql语句处理的时候都是建立的RoutingStatementHandler，而在RoutingStatementHandler里面拥有一个
		// StatementHandler类型的delegate属性，RoutingStatementHandler会依据Statement的不同建立对应的BaseStatementHandler，即SimpleStatementHandler、
		// PreparedStatementHandler或CallableStatementHandler，在RoutingStatementHandler里面所有StatementHandler接口方法的实现都是调用的delegate对应的方法。
		// 我们在PageInterceptor类上已经用@Signature标记了该Interceptor只拦截StatementHandler接口的prepare方法，又因为Mybatis只有在建立RoutingStatementHandler的时候
		// 是通过Interceptor的plugin方法进行包裹的，所以我们这里拦截到的目标对象肯定是RoutingStatementHandler对象。
		final RoutingStatementHandler handler = (RoutingStatementHandler) invocation
				.getTarget();
		// 通过反射获取到当前RoutingStatementHandler对象的delegate属性
		final StatementHandler delegate = (StatementHandler) ReflectUtil
				.getFieldValue(handler, "delegate");
		// 通过反射获取delegate父类BaseStatementHandler的mappedStatement属性
		MappedStatement mappedStatement = (MappedStatement)ReflectUtil.getFieldValue(delegate, "mappedStatement");
		// 拦截需要分页的SQL
		if (mappedStatement.getId().matches(pageSqlId)) { 
			// 获取到当前StatementHandler的
			// boundSql，这里不管是调用handler.getBoundSql()还是直接调用delegate.getBoundSql()结果是一样的，因为之前已经说过了
			// RoutingStatementHandler实现的所有StatementHandler接口方法里面都是调用的delegate对应的方法。
			final BoundSql boundSql = delegate.getBoundSql();
			// 拿到当前绑定Sql的参数对象，就是我们在调用对应的Mapper映射语句时所传入的参数对象
			final Object obj = boundSql.getParameterObject();
			// 这里我们简单的通过传入的是Page对象就认定它是需要进行分页操作的。
			if (obj instanceof Pager<?>) {
				Pager<?> pager = (Pager<?>) obj;
				
				// 拦截到的prepare方法参数是一个Connection对象
				Connection connection = (Connection) invocation.getArgs()[0];
				// 获取当前要执行的Sql语句，也就是我们直接在Mapper映射语句中写的Sql语句
				String sql = boundSql.getSql();
				// 给当前的page参数对象设置总记录数 影响性能
				this.setTotalRecord(pager, mappedStatement, connection);
				dialect = null;
				switch(databaseType){
					case "Oracle":
						dialect = new OracleDialect();
						break;
					case "Mysql":
						dialect = new MysqlDialect();
						break;
					default:
						dialect = new MsDialect();					
				}
				String pageSql = dialect.getPageSql(pager, sql);
				// 利用反射设置当前BoundSql对应的sql属性为我们建立好的分页Sql语句
				ReflectUtil.setFieldValue(boundSql, "sql", pageSql);
			}			
		}
		return invocation.proceed();
	}

	/**
	 * 拦截器对应的封装原始对象的方法
	 */
	@Override
	public Object plugin(Object target) {
		// TODO Auto-generated method stub
		return Plugin.wrap(target, this);
	}

	/**
	 * 设置注册拦截器时设定的属性
	 */
	@Override
	public void setProperties(Properties properties) {
		// TODO Auto-generated method stub
		this.databaseType = properties.getProperty("databaseType");
		this.pageSqlId = properties.getProperty("pageSqlId");
	}

	/**
	 * 给当前的参数对象page设置总记录数
	 * 
	 * @param page
	 *            Mapper映射语句对应的参数对象
	 * @param mappedStatement
	 *            Mapper映射语句
	 * @param connection
	 *            当前的数据库连接
	 */
	private void setTotalRecord(Pager<?> pager,	MappedStatement mappedStatement, Connection connection) {
		// 获取对应的BoundSql，这个BoundSql其实跟我们利用StatementHandler获取到的BoundSql是同一个对象。
		// delegate里面的boundSql也是通过mappedStatement.getBoundSql(paramObj)方法获取到的。
		BoundSql boundSql = mappedStatement.getBoundSql(pager);
		// 获取到我们自己写在Mapper映射语句中对应的Sql语句
		String sql = boundSql.getSql();
		// 通过查询Sql语句获取到对应的计算总记录数的sql语句
		String countSql = this.getCountSql(sql);
		// 通过BoundSql获取对应的参数映射
		List<ParameterMapping> parameterMappings = boundSql
				.getParameterMappings();
		// 利用Configuration、查询记录数的Sql语句countSql、参数映射关系parameterMappings和参数对象page建立查询记录数对应的BoundSql对象。
		BoundSql countBoundSql = new BoundSql(
				mappedStatement.getConfiguration(), countSql,
				parameterMappings, pager);
		// 通过mappedStatement、参数对象page和BoundSql对象countBoundSql建立一个用于设定参数的ParameterHandler对象
		ParameterHandler parameterHandler = new DefaultParameterHandler(
				mappedStatement, pager, countBoundSql);
		// 通过connection建立一个countSql对应的PreparedStatement对象。
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = connection.prepareStatement(countSql);
			// 通过parameterHandler给PreparedStatement对象设置参数
			parameterHandler.setParameters(pstmt);
			// 之后就是执行获取总记录数的Sql语句和获取结果了。
			rs = pstmt.executeQuery();
			if (rs.next()) {
				int totalRecord = rs.getInt(1);
				// 给当前的参数page对象设置总记录数
				pager.setTotalRecord(totalRecord);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 根据原Sql语句对应的总记录数的Sql语句
	 * 
	 * @param sql
	 * @return
	 */
	private String getCountSql(String sql) {
		return "select count(*) from (" + sql + ") v";
	}

}
