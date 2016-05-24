package com.lw.system.framework.fa001;

import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;
import com.lw.oa.common.dao.IMybatisDAO;
import com.lw.oa.common.dao.MybatisDAOImpl;
import com.lw.oa.common.model.Resource;
import com.lw.oa.common.util.ConstantUtil;
import com.lw.oa.common.util.DataUtil;

/**
 ** @author yuliang
 */
@Service("fa001Service")
public class FA001ServiceImpl implements IFA001Service,ConstantUtil {

	private IMybatisDAO mybatisDAOImpl;

	public FA001ServiceImpl() {
		// TODO Auto-generated constructor stub
		mybatisDAOImpl = new MybatisDAOImpl();
	}

	@Override
	public List<?> fa001001search(FA001001SearchCommand searchCommand) {
		// TODO Auto-generated method stub
		mybatisDAOImpl.openSession();
		@SuppressWarnings("unchecked")
		List<FA001001ResultCommand> list = (List<FA001001ResultCommand>) mybatisDAOImpl
				.queryByObj("fa.fa001.fa001001searchListByPage", searchCommand);
		mybatisDAOImpl.close();
		return list;
	}

	@Override
	public FA001Command fa001001view(FA001001SearchCommand searchCommand) {
		// TODO Auto-generated method stub
		mybatisDAOImpl.openSession();
		FA001Command command = (FA001Command) mybatisDAOImpl
				.expandByObj("fa.fa001.fa001001expandById", searchCommand);
		mybatisDAOImpl.close();
		return command;
	}

	@Override
	public int fa001001delete(FA001001SearchCommand searchCommand,
			HttpServletRequest request) {
		// TODO Auto-generated method stub
		int flag = 1;
		Resource[] resource = searchCommand.getResource();
		try {
			mybatisDAOImpl.openSession();
			for(Resource entity:resource){			
				flag = mybatisDAOImpl.delete( "fa.fa001.fa001001PDResource", entity.getResourceid());	
				//mybatisDAOImpl.delete( "fa.fa001.fa001001PDSubResource", entity.getResourceid());	
				if(flag < 1){
					mybatisDAOImpl.rollback();
					return flag;
				}	
			}
			mybatisDAOImpl.commit();
		} catch (Exception e) {
			mybatisDAOImpl.rollback();
			flag = 0;
			e.printStackTrace();
		} finally {
			mybatisDAOImpl.close();
		}
		return flag;
	}

	@Override
	public int fa001002update(FA001Command command, HttpServletRequest request) {
		// TODO Auto-generated method stub
		int flag = 1;
		try {
			mybatisDAOImpl.openSession();
			// 数据转换
			Resource entity = prepareCommand(command);
			flag = mybatisDAOImpl.update("fa.fa001.fa001002update", entity);
			if(flag == 0){
				return flag;
			}
			mybatisDAOImpl.commit();
		} catch (Exception e) {
			mybatisDAOImpl.rollback();
			flag = 0;
			e.printStackTrace();
		} finally {
			mybatisDAOImpl.close();
		}
		return flag;
	}

	@Override
	public int fa001003insert(FA001Command command, HttpServletRequest request) {
		// TODO Auto-generated method stub
		int flag = 1;
		try {
			mybatisDAOImpl.openSession();
			// 数据转换
			Resource entity = prepareCommand(command);
			//获取系统时间
			Date sysdate = (Date)mybatisDAOImpl.expandByObj( "common.getDBSysDate", null);
			// 获取key
			String key = DataUtil.getKey(sysdate);
			// 设置主键
			entity.setResourceid(key);
			// 插入资源表
			mybatisDAOImpl.insert("common.insertResource", entity);			
			mybatisDAOImpl.commit();
		} catch (Exception e) {
			mybatisDAOImpl.rollback();
			flag = 0;
			e.printStackTrace();
		} finally {
			mybatisDAOImpl.close();
		}
		return flag;
	}
	
	public Resource prepareCommand(FA001Command command) {
		Resource entity = new Resource();
		entity.setResourceid(command.getResourceid());
		entity.setResourcename(command.getResourcename());
		entity.setResourcecode(command.getResourcecode());
		entity.setIsleaf(command.getIsleaf());
		entity.setResourcelevel(command.getResourcelevel());	
		entity.setResourceaction(command.getResourceaction());	
		entity.setParentid(command.getParentid());	
		entity.setResourcetype(command.getResourcetype());	
		entity.setSortno(command.getSortno());	
		return entity;
	}
	
}
