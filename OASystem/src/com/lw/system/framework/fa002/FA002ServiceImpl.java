package com.lw.system.framework.fa002;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.lw.oa.common.dao.IMybatisDAO;
import com.lw.oa.common.dao.MybatisDAOImpl;
import com.lw.oa.common.model.Role;
import com.lw.oa.common.model.RoleResource;
import com.lw.oa.common.util.ConstantUtil;
import com.lw.oa.common.util.DataUtil;

/**
 ** @author yuliang
 */
@Service("fa002Service")
public class FA002ServiceImpl implements IFA002Service,ConstantUtil {

	private IMybatisDAO mybatisDAOImpl;

	public FA002ServiceImpl() {
		// TODO Auto-generated constructor stub
		mybatisDAOImpl = new MybatisDAOImpl();
	}

	@Override
	public List<?> fa002001search(FA002001SearchCommand searchCommand) {
		// TODO Auto-generated method stub
		mybatisDAOImpl.openSession();
		@SuppressWarnings("unchecked")
		List<FA002001ResultCommand> list = (List<FA002001ResultCommand>) mybatisDAOImpl
				.queryByObj("fa.fa002.fa002001searchListByPage", searchCommand);
		mybatisDAOImpl.close();
		return list;
	}

	@Override
	public int fa002001delete(FA002001SearchCommand searchCommand,
			HttpServletRequest request) {
		// TODO Auto-generated method stub
		int flag = 1;
		Role[] role = searchCommand.getRole();
		try {
			mybatisDAOImpl.openSession();
			for(Role entity:role){			
				flag = mybatisDAOImpl.delete( "fa.fa002.fa002001PDRole", entity.getRoleid());	
				mybatisDAOImpl.delete( "fa.fa002.fa002001PDRoleResource", entity.getRoleid());	
				mybatisDAOImpl.delete( "fa.fa002.fa002001PDEmpRole", entity.getRoleid());					
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
	public int fa002001setAuthority(FA002001SearchCommand searchCommand,
			HttpServletRequest request) {
		// TODO Auto-generated method stub
		int flag = 1;
		String roleid = searchCommand.getRoleid();
		try {
			mybatisDAOImpl.openSession();
			//根据roleid物理删除角色资源表
			mybatisDAOImpl.delete( "fa.fa002.fa002001PDRoleResource", roleid);
			for(RoleResource entity:searchCommand.getRoleresource()){
				if(!FLAG_0.equals(entity.getResourceid())){
					mybatisDAOImpl.insert( "common.insertRoleResource", entity);					
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
	public int fa002002update(FA002Command command, HttpServletRequest request) {
		// TODO Auto-generated method stub
		int flag = 1;
		try {
			mybatisDAOImpl.openSession();
			// 数据转换
			Role entity = prepareCommand(command);
			flag = mybatisDAOImpl.update("fa.fa002.fa002002update", entity);
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
	public int fa002002insert(FA002Command command, HttpServletRequest request) {
		// TODO Auto-generated method stub
		int flag = 1;
		try {
			mybatisDAOImpl.openSession();
			// 数据转换
			Role entity = prepareCommand(command);
			//获取系统时间
			Date sysdate = (Date)mybatisDAOImpl.expandByObj( "common.getDBSysDate", null);
			// 获取key
			String key = DataUtil.getKey(sysdate);
			// 设置主键
			entity.setRoleid(key);
			// 插入资源表
			mybatisDAOImpl.insert("common.insertRole", entity);			
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
	
	public Role prepareCommand(FA002Command command) {
		Role entity = new Role();
		entity.setRoleid(command.getRoleid());
		entity.setRolename(command.getRolename());
		entity.setRolecode(command.getRolecode());
		entity.setRoletype(command.getRoletype());	
		return entity;
	}
	
}
