package com.lw.oa.pa.master.pa001;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.lw.oa.common.command.ResultCommand;
import com.lw.oa.common.dao.IMybatisDAO;
import com.lw.oa.common.dao.MybatisDAOImpl;
import com.lw.oa.common.model.CommonBean;
import com.lw.oa.common.model.Empinfo;
import com.lw.oa.common.model.Emporg;
import com.lw.oa.common.model.Emprole;
import com.lw.oa.common.util.ConstantUtil;
import com.lw.oa.common.util.CryptUtil;
import com.lw.oa.common.util.DataUtil;
import com.lw.oa.common.util.DateUtil;

/**
 ** @author yuliang
 */
@Service("pa001Service")
public class PA001ServiceImpl implements IPA001Service,ConstantUtil {

	private IMybatisDAO mybatisDAOImpl;

	public PA001ServiceImpl() {
		// TODO Auto-generated constructor stub
		mybatisDAOImpl = new MybatisDAOImpl();
	}

	@Override
	public List<?> pa001001search(PA001001SearchCommand searchCommand) {
		// TODO Auto-generated method stub
		mybatisDAOImpl.openSession();
		@SuppressWarnings("unchecked")
		List<PA001001ResultCommand> list = (List<PA001001ResultCommand>) mybatisDAOImpl
				.queryByObj("pa.pa001.pa001001searchListByPage", searchCommand);	
		if(list != null){
			if(list.size() != 0){
				for(PA001001ResultCommand entity:list){
					HashMap<String,String> map = new HashMap<String, String>();
					map.put("empid", entity.getEmpid());
					@SuppressWarnings("unchecked")
					List<ResultCommand> listOrg = (List<ResultCommand>) mybatisDAOImpl.queryByObj("common.zoom.searchOrgsByEmpid", map);
					entity.setListOrg(listOrg);
				}
			}			
		}		
		return list;
	}

	@Override
	public PA001Command pa001001view(PA001001SearchCommand searchCommand) {
		// TODO Auto-generated method stub
		mybatisDAOImpl.openSession();
		PA001Command command = (PA001Command) mybatisDAOImpl
				.expandByObj("pa.pa001.pa001001expandById", searchCommand);
		HashMap<String,String> map = new HashMap<String, String>();
		map.put("empid", searchCommand.getEmpid());
		@SuppressWarnings("unchecked")
		List<ResultCommand> emporg = (List<ResultCommand>) mybatisDAOImpl.queryByObj("common.zoom.searchOrgsByEmpid", map);
		command.setEmporg(emporg);
		// 组织机构拼接处理
		if(emporg != null){
			if(emporg.size() != 0){
				StringBuffer orgcddepposids = new StringBuffer();
				StringBuffer orgcddepposes = new StringBuffer();
				for(ResultCommand entity:emporg){
					orgcddepposids.append(entity.getOrgcdid()).append(":").append(entity.getDepid()).append(":").append(entity.getPosid()).append(",");		
					orgcddepposes.append(entity.getOrgshortname()).append(":").append(entity.getDepiddict()).append(":").append(entity.getPosiddict()).append(",");		
				}
				command.setOrgcddepposids(orgcddepposids.substring(0, orgcddepposids.length()-1));
				command.setOrgcddepposes(orgcddepposes.substring(0, orgcddepposes.length()-1));
			}
		}
		@SuppressWarnings("unchecked")
		List<ResultCommand> emprole = (List<ResultCommand>) mybatisDAOImpl.queryByObj("common.zoom.searchRolesByEmpid", map); 
		// 角色拼接处理
		if(emprole != null){
			if(emprole.size() != 0){
				StringBuffer roleids = new StringBuffer();
				StringBuffer roles = new StringBuffer();
				for(ResultCommand entity:emprole){
					roleids.append(entity.getRoleid()).append(",");		
					roles.append(entity.getRolename()).append(",");		
				}
				command.setRoleids(roleids.substring(0, roleids.length()-1));
				command.setRoles(roles.substring(0, roles.length()-1));
			}
		}
		return command;
	}

	@Override
	public int pa001003save(PA001Command command, HttpServletRequest request) {
		// TODO Auto-generated method stub
		int flag = 1;
		// 创建员工组织关联对象
		List<Emporg> empOrgList = creatEmpOrg(command);
		// 创建员工角色关联对象
		List<Emprole> empRolelist = creatEmpRole(command);
		try {
			mybatisDAOImpl.openSession();
			// 数据转换
			Empinfo entity = prepareCommand(command);
			//获取系统时间
			Date sysdate = (Date)mybatisDAOImpl.expandByObj( "common.getDBSysDate", null);
			// 获取key
			String key = DataUtil.getKey(sysdate);
			// 获取共通插入字段
			CommonBean bean = DataUtil.getInsertCol(sysdate, request);
			// 设置主键
			entity.setEmpid(key);
			// 设置共通插入字段
			DataUtil.setInsertCol(entity, bean);			
			mybatisDAOImpl.insert("common.insertEmpinfo", entity);
			if(empOrgList != null){
				if(empOrgList.size() != 0){
					for(Emporg emporg:empOrgList){
						emporg.setEmpid(key);
						// 设置共通插入字段
						DataUtil.setInsertCol(emporg, bean);
						// 插入员工组织表
						mybatisDAOImpl.insert("common.insertEmporg", emporg);
					}
				}
			}
			if(empRolelist != null){
				if(empRolelist.size() != 0){
					for(Emprole emprole:empRolelist){
						emprole.setEmpid(key);
						// 设置共通插入字段
						DataUtil.setInsertCol(emprole, bean);
						// 插入员工组织表
						mybatisDAOImpl.insert("common.insertEmprole", emprole);
					}
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
	public int pa001002update(PA001Command command, HttpServletRequest request) {
		// TODO Auto-generated method stub
		int flag = 1;
		// 创建员工组织关联对象
		List<Emporg> empOrgList = creatEmpOrg(command);
		// 创建员工角色关联对象
		List<Emprole> empRolelist = creatEmpRole(command);
		try {
			mybatisDAOImpl.openSession();			
			// 数据转换
			Empinfo entity = prepareCommand(command);
			// 获取系统时间
			Date sysdate = (Date)mybatisDAOImpl.expandByObj( "common.getDBSysDate", null);
			// 获取共通更新字段
			CommonBean updatebean = DataUtil.getUpdateCol(sysdate, request);
			// 设置共通更新字段
			DataUtil.setUpdateCol(entity, updatebean);
			// 获取共通插入字段
			CommonBean bean = DataUtil.getInsertCol(sysdate, request);
			flag = mybatisDAOImpl.update("pa.pa001.pa001002update", entity);
			if(flag == 0){
				return flag;
			}
			// 物理删除员工组织关联表
			mybatisDAOImpl.delete("pa.pa001.pa001002deleteEmporg", command.getEmpid());						
			if(empOrgList != null){
				if(empOrgList.size() != 0){
					for(Emporg emporg:empOrgList){
						emporg.setEmpid(command.getEmpid());
						// 设置共通插入字段
						DataUtil.setInsertCol(emporg, bean);
						// 插入员工组织表
						mybatisDAOImpl.insert("common.insertEmporg", emporg);
					}
				}
			}
			// 物理删除员工角色关联表
			mybatisDAOImpl.delete("pa.pa001.pa001002deleteEmprole", command.getEmpid());			
			if(empRolelist != null){
				if(empRolelist.size() != 0){
					for(Emprole emprole:empRolelist){
						emprole.setEmpid(command.getEmpid());
						// 设置共通插入字段
						DataUtil.setInsertCol(emprole, bean);
						// 插入员工组织表
						mybatisDAOImpl.insert("common.insertEmprole", emprole);
					}
				}
			}
			mybatisDAOImpl.commit();
		} catch (Exception e) {
			mybatisDAOImpl.rollback();
			flag = 999;
			e.printStackTrace();
		} finally {
			mybatisDAOImpl.close();
		}
		return flag;
	}

	@Override
	public int pa001002delete(PA001Command command, HttpServletRequest request) {
		// TODO Auto-generated method stub
		int flag = 1;
		try {
			mybatisDAOImpl.openSession();
			// 数据转换
			Empinfo entity = prepareCommand(command);
			//获取系统时间
			Date sysdate = (Date)mybatisDAOImpl.expandByObj( "common.getDBSysDate", null);
			// 获取共通更新字段
			CommonBean updatebean = DataUtil.getUpdateCol(sysdate, request);
			// 设置共通更新字段
			DataUtil.setUpdateCol(entity, updatebean);			
			flag = mybatisDAOImpl.update("pa.pa001.pa001002delete", entity);
			if(flag == 0){
				return flag;
			}
			//创建员工组织关联逻辑删除条件
//			HashMap<String, Object> map = new HashMap<String, Object>();
//			map.put("empid", command.getEmpid());
//			map.put("updator", updatebean.getUpdator());
//			map.put("updatetime", updatebean.getUpdatetime());
//			map.put("exclusivefg", updatebean.getUpdateexclusivefg());
//			map.put("orgid", updatebean.getOrgid());	
//			mybatisDAOImpl.update("pa.pa001.pa001002CancelEmporg", map);	
//			mybatisDAOImpl.update("pa.pa001.pa001002CancelEmprole", map);	
			mybatisDAOImpl.commit();
		} catch (Exception e) {
			mybatisDAOImpl.rollback();
			flag = 999;
			e.printStackTrace();
		} finally {
			mybatisDAOImpl.close();
		}
		return flag;
	}

	public List<Emporg> creatEmpOrg(PA001Command command){		 
		String orgcddepposids = command.getOrgcddepposids();
		if(StringUtils.isEmpty( orgcddepposids)){
			return null;
		}
		List<Emporg> list = new ArrayList<Emporg>();		
		String[] str = orgcddepposids.split(",");
		for(String orgcddepposid:str){
			Emporg emporg = new Emporg();
			String[] id = orgcddepposid.split(":");
			emporg.setOrgcdid(id[0]);
			emporg.setDepid(id[1]);
			emporg.setPosid(id[2]);
			list.add(emporg);
		}
		return list;
	}
	
	public List<Emprole> creatEmpRole(PA001Command command){		 
		String roleids = command.getRoleids();
		if(StringUtils.isEmpty( roleids)){
			return null;
		}
		List<Emprole> list = new ArrayList<Emprole>();		
		String[] str = roleids.split(",");
		for(String roleid:str){
			Emprole emprole = new Emprole();
			emprole.setRoleid(roleid);
			list.add(emprole);
		}
		return list;
	}
	
	public Empinfo prepareCommand(PA001Command command) {
		Empinfo entity = new Empinfo();
		entity.setEmpid(command.getEmpid());
		entity.setExclusivefg(command.getExclusivefg());
		entity.setEmpname(command.getEmpname());
		entity.setEmpenname(command.getEmpenname());
		entity.setEmpno(command.getEmpno());
		entity.setPosname(command.getPosname());
		entity.setWorkage(command.getWorkage());
		entity.setEmail(command.getEmail());
		entity.setDomestictel(command.getDomestictel());
		entity.setInternttel(command.getInternttel());
		entity.setExtension(command.getExtension());
		entity.setStraightline(command.getStraightline());
		entity.setSkypenum(command.getSkypenum());
		entity.setCardno(command.getCardno());
		entity.setEntrytime(DateUtil.parseDate(command.getEntrytime(),
				DATE_FORMAT_YMD));
		// entity.setOfftime(command.getOfftime());
		entity.setSex(command.getSex());
		entity.setStatus(command.getStatus());
		entity.setUsername(command.getUsername());
		try {
			entity.setPassword(CryptUtil.encryptBASE64( command.getPassword()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		entity.setRemark1(command.getRemark1());
		entity.setRemark2(command.getRemark2());
		entity.setRemark3(command.getRemark3());
		return entity;
	}
}
