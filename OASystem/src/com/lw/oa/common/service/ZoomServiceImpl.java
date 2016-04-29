package com.lw.oa.common.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lw.oa.common.command.ApplyResultCommand;
import com.lw.oa.common.command.DeviceOrderSearchCommand;
import com.lw.oa.common.command.ResultCommand;
import com.lw.oa.common.dao.IMybatisDAO;
import com.lw.oa.common.dao.MybatisDAOImpl;
import com.lw.oa.common.util.ConstantUtil;
import com.lw.oa.common.util.StringUtil;
/**
 ** @author yuliang
 */
@Service("zoomService")
public class ZoomServiceImpl implements IZoomService,ConstantUtil {
	
	private IMybatisDAO mybatisDAOImpl;
	public ZoomServiceImpl() {
		// TODO Auto-generated constructor stub
		mybatisDAOImpl = new MybatisDAOImpl();
	}
	@Override
	public List<?> searchEmpList( String orgcdid, String depid, String empname){
		// TODO Auto-generated method stub
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("orgcdid", orgcdid);
		map.put("orgcdids", StringUtil.split(SEPERATORS_COMMA, orgcdid));
		map.put("depid", depid);
		map.put("empname", empname);		
		mybatisDAOImpl.openSession();
		@SuppressWarnings("unchecked")
		List<ResultCommand> list = (List<ResultCommand>) mybatisDAOImpl
				.queryByObj("common.zoom.searchEmpList", map);		
		if(list != null){
			if(list.size() != 0){
				for(ResultCommand entity:list){
					HashMap<String,String> mapOrg = new HashMap<String, String>();
					mapOrg.put("empid", entity.getEmpid());
					@SuppressWarnings("unchecked")
					List<ResultCommand> listOrg = (List<ResultCommand>) mybatisDAOImpl.queryByObj("common.zoom.searchOrgsByEmpid", mapOrg);
					entity.setList(listOrg);
				}
			}			
		}			
		return list;
	}
	@Override
	public List<?> searchRoleList( String rolename){
		// TODO Auto-generated method stub
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("rolename", rolename);		
		mybatisDAOImpl.openSession();
		@SuppressWarnings("unchecked")
		List<ResultCommand> list = (List<ResultCommand>) mybatisDAOImpl
				.queryByObj("common.zoom.searchRoleList", map);	
		return list;
	}
	@Override
	public List<?> searchDeviceOrderList(DeviceOrderSearchCommand searchCommand){
		// TODO Auto-generated method stub
		//in条件处理
		String orgcdid = searchCommand.getOrgcdid();
		String[] array = StringUtil.split(SEPERATORS_COMMA, orgcdid);
		searchCommand.setOrgcdids(array);
		mybatisDAOImpl.openSession();
		@SuppressWarnings("unchecked")
		List<ResultCommand> list = (List<ResultCommand>) mybatisDAOImpl
				.queryByObj("common.zoom.searchDeviceOrderListByPage", searchCommand);
		return list;
	}	
	@Override
	public List<?> searchDeviceList( String orgcdid,String dailydevicename){
		// TODO Auto-generated method stub
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("orgcdid", orgcdid);
		map.put("orgcdids", StringUtil.split(SEPERATORS_COMMA, orgcdid));
		map.put("dailydevicename", dailydevicename);
		mybatisDAOImpl.openSession();
		@SuppressWarnings("unchecked")
		List<ResultCommand> list = (List<ResultCommand>) mybatisDAOImpl
				.queryByObj("common.zoom.searchDeviceList", map);
		return list;
	}
	@Override
	public List<?> searchOrgList( String regionid,String orgname){
		// TODO Auto-generated method stub
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("regionid", regionid);
		map.put("orgname", orgname);
		mybatisDAOImpl.openSession();
		@SuppressWarnings("unchecked")
		List<ResultCommand> list = (List<ResultCommand>) mybatisDAOImpl
				.queryByObj("common.zoom.searchOrgList", map);
		return list;
	}	
	@Override
	public List<?> searchApplyA1List( String empid, String applyno){
		// TODO Auto-generated method stub
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("empid", empid);
		map.put("applyno", applyno);		
		mybatisDAOImpl.openSession();
		@SuppressWarnings("unchecked")
		List<ApplyResultCommand> list = (List<ApplyResultCommand>) mybatisDAOImpl
				.queryByObj("common.zoom.searchApplyA1List", map);
		return list;
	}
	@Override
	public List<?> searchApplyA4List( String empid, String applyno){
		// TODO Auto-generated method stub
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("empid", empid);
		map.put("applyno", applyno);		
		mybatisDAOImpl.openSession();
		@SuppressWarnings("unchecked")
		List<ApplyResultCommand> list = (List<ApplyResultCommand>) mybatisDAOImpl
				.queryByObj("common.zoom.searchApplyA4List", map);
		return list;
	}
}
