package com.lw.oa.common.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.lw.oa.common.command.ResumeEntity;
import com.lw.oa.common.dao.IMybatisDAO;
import com.lw.oa.common.dao.MybatisDAOImpl;

/**
 * *@author yuliang
 */
public class ResumeUtil {
	private static IMybatisDAO mybatisDAOImpl;	
	static{
		mybatisDAOImpl = new MybatisDAOImpl();
	}
	/**
	 * 功能：根据pid获取履历
	 * 输入：pid, busidicttypeid, tablename
	 * 输出：字符串
	 */
	public static String getResumeByPid( String pid, String busidicttypeid, String tablename) {
		String info = StringUtils.EMPTY;	
		try{
			// 连接数据库
			mybatisDAOImpl.openSession();
			HashMap<String, String> map = new HashMap<String, String>();
			map.put( "pid", pid);	
			map.put( "busidicttypeid", busidicttypeid);
			map.put( "table", tablename);
			@SuppressWarnings("unchecked")
			List<ResumeEntity> list = (List<ResumeEntity>) mybatisDAOImpl.queryByObj( "common.queryResumeByPid", map);
			String remark;
			for(ResumeEntity entity:list) {
				remark = entity.getRemark();
				info += entity.getUpdatetime() + "  "
						+ entity.getOperatorname() + "  "
						+ entity.getOperationcddict() + "\n";
				if (remark != null && !"".equals(remark)) {
					info += remark + "\n";
				}
			}
		}catch(Exception e){
			mybatisDAOImpl.rollback();
			e.printStackTrace();
		} finally {
			try {
				mybatisDAOImpl.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
		return info;
	}
	
	/**
	 * 功能：根据pid获取履历
	 * 输入：pid, busidicttypeid, tablename
	 * 输出：集合
	 */
	@SuppressWarnings("unchecked")
	public static List<ResumeEntity> getResumeListByPid( String pid, String busidicttypeid, String tablename) {
		List<ResumeEntity> list = new ArrayList<ResumeEntity>();
		try{
			// 连接数据库
			mybatisDAOImpl.openSession();
			HashMap<String, String> map = new HashMap<String, String>();
			map.put( "pid", pid);	
			map.put( "busidicttypeid", busidicttypeid);
			map.put( "table", tablename);			
			list = (List<ResumeEntity>) mybatisDAOImpl.queryByObj( "common.queryResumeByPid", map);			
		}catch(Exception e){
			mybatisDAOImpl.rollback();
			e.printStackTrace();
		} finally {
			try {
				mybatisDAOImpl.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
		return list;
	}
}
