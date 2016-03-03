package com.lw.oa.pc.apply.pc002;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.lw.oa.common.command.ApplyFormCommand;
import com.lw.oa.common.command.ApplyResultCommand;
import com.lw.oa.common.command.ApplySearchCommand;
import com.lw.oa.common.command.ResultCommand;
import com.lw.oa.common.dao.IMybatisDAO;
import com.lw.oa.common.dao.MybatisDAOImpl;
import com.lw.oa.common.model.ApplyForm;
import com.lw.oa.common.model.CommonBean;
import com.lw.oa.common.util.ConstantUtil;
import com.lw.oa.common.util.DataUtil;
import com.lw.oa.common.util.DateUtil;
import com.lw.oa.common.util.ResumeUtil;

/**
 ** @author yuliang
 */
@Service("pc002Service")
public class PC002ServiceImpl implements IPC002Service,ConstantUtil {

	private IMybatisDAO mybatisDAOImpl;

	public PC002ServiceImpl() {
		// TODO Auto-generated constructor stub
		mybatisDAOImpl = new MybatisDAOImpl();
	}

	@Override
	public List<?> pc002001search(ApplySearchCommand searchCommand) {
		// TODO Auto-generated method stub
		mybatisDAOImpl.openSession();
		@SuppressWarnings("unchecked")
		List<ApplyResultCommand> list = (List<ApplyResultCommand>) mybatisDAOImpl
				.queryByObj("pc.pc002.pc002001searchListByPage", searchCommand);
		mybatisDAOImpl.close();
		return list;
	}

	@Override
	public ApplyFormCommand pc002001view(ApplySearchCommand searchCommand) {
		// TODO Auto-generated method stub
		mybatisDAOImpl.openSession();
		ApplyFormCommand command = (ApplyFormCommand) mybatisDAOImpl.expandByObj(
				"common.expandApplyForm", searchCommand);
		// 设置查询条件				
		HashMap<String,String> map = new HashMap<String, String>();
		map.put("empid", searchCommand.getEmpid());
		@SuppressWarnings("unchecked")
		List<ResultCommand> emporg = (List<ResultCommand>) mybatisDAOImpl.queryByObj("common.zoom.searchOrgsByEmpid", map);
		command.setEmporg(emporg);
		// 组织机构拼接处理
		if(emporg != null){
			if(emporg.size() != 0){
				StringBuffer orgcddepposes = new StringBuffer();
				for(ResultCommand entity:emporg){
					orgcddepposes.append(entity.getOrgshortname()).append(":").append(entity.getDepiddict()).append(":").append(entity.getPosiddict()).append(",");		
				}
				command.setOrgcddepposes(orgcddepposes.substring(0, orgcddepposes.length()-1));
			}
		}
		//获取履历
		String resume = ResumeUtil.getResumeByPid(command.getApplyid(), "OA_PC001_Operationcd", "[dbo].[his_applyform]");
		command.setResume(resume);
		mybatisDAOImpl.close();
		return command;
	}

	@Override
	public int pc002003update(ApplyFormCommand command, HttpServletRequest request) {
		// TODO Auto-generated method stub
		int flag = 1;
		try {
			mybatisDAOImpl.openSession();
			// 数据转换
			ApplyForm entity = prepareCommand(command);
			//获取系统时间
			Date sysdate = (Date)mybatisDAOImpl.expandByObj( "common.getDBSysDate", null);
			// 获取共通更新字段
			CommonBean bean = DataUtil.getUpdateCol(sysdate, request);
			// 设置共通更新字段
			DataUtil.setUpdateCol(entity, bean);
			entity.setProcessempid(bean.getUpdator());
			entity.setProcesstime(bean.getUpdatetime());
			// 根据申请单类型获取对应update sql
			String sqlid = getSqlidByApplytype(command.getApplytype());
			flag = mybatisDAOImpl.update( sqlid, entity);			
			// 获取履历id
			String hisid = DataUtil.getKey(sysdate);
			// 创建履历对象
			HashMap<String,Object> map  = DataUtil.creatHisMap("[dbo].[his_applyform]", hisid, command.getApplyid(), "A002", "0", "0", command.getRemark(), bean, request);
			mybatisDAOImpl.insert("common.insertHis", map);			
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

	public String getSqlidByApplytype(String applytype){
		String sqlid = StringUtils.EMPTY;
		if(APPLY_A1.equals(applytype)){
			sqlid = "pc.pc002.pc002003A1Update";
		}else if(APPLY_A2.equals(applytype)){
			sqlid = "pc.pc002.pc002003A2Update";
		}else if(APPLY_A3.equals(applytype)){
			sqlid = "pc.pc002.pc002003A3Update";
		}else if(APPLY_A4.equals(applytype)){
			sqlid = "pc.pc002.pc002003A4Update";
		}
		return sqlid;
	}
	
	@Override
	public int pc002003delete(ApplyFormCommand command, HttpServletRequest request) {
		// TODO Auto-generated method stub
		int flag = 1;
		try {
			mybatisDAOImpl.openSession();
			// 数据转换
			ApplyForm entity = prepareCommand(command);
			//获取系统时间
			Date sysdate = (Date)mybatisDAOImpl.expandByObj( "common.getDBSysDate", null);
			// 获取共通更新字段
			CommonBean bean = DataUtil.getUpdateCol(sysdate, request);
			// 设置共通更新字段
			DataUtil.setUpdateCol(entity, bean);
			// 设置处理人、状态
			entity.setProcessempid(bean.getUpdator());
			entity.setProcesstime(bean.getUpdatetime());			
			flag = mybatisDAOImpl.update( "pc.pc002.pc002003delete", entity);			
			// 获取履历id
			String hisid = DataUtil.getKey(sysdate);
			// 创建履历对象
			HashMap<String,Object> map  = DataUtil.creatHisMap("[dbo].[his_applyform]", hisid, command.getApplyid(), command.getOperationcd(), "0", "0", command.getRemark(), bean, request);
			mybatisDAOImpl.insert("common.insertHis", map);			
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

	public ApplyForm prepareCommand(ApplyFormCommand command) {
		ApplyForm entity = new ApplyForm();
		entity.setApplyid(command.getApplyid());
		entity.setExclusivefg(command.getExclusivefg());
		entity.setSourceid(command.getSourceid());
		entity.setApplyno(command.getApplyno());
		entity.setApplyempid( command.getApplyempid());
		entity.setManagercheckid( command.getManagercheckid());
		entity.setManagerorgcdid( command.getManagerorgcdid());
		entity.setManagerdepid( command.getManagerdepid());
		entity.setPersonnelcheckid( command.getPersonnelcheckid());
		entity.setPersonnelorgcdid( command.getPersonnelorgcdid());
		entity.setPersonneldepid( command.getPersonneldepid());
		entity.setVicepresicheckid( command.getVicepresicheckid());
		entity.setVicepresiorgcdid( command.getVicepresiorgcdid());
		entity.setVicepresidepid( command.getVicepresidepid());
		entity.setPresicheckid( command.getPresicheckid());
		entity.setPresiorgcdid( command.getPresiorgcdid());
		entity.setPresidepid( command.getPresidepid());
		entity.setPersonfilecheckid( command.getPersonfilecheckid());
		entity.setPersonfileorgcdid( command.getPersonfileorgcdid());
		entity.setPersonfiledepid( command.getPersonfiledepid());
		entity.setApplytype( command.getApplytype());
		entity.setVacatereasontype( command.getVacatereasontype());
		entity.setOtherremark( command.getOtherremark());
		entity.setApplyreason( command.getApplyreason());
		if(APPLY_A1.equals(command.getApplytype())||APPLY_A2.equals(command.getApplytype())||APPLY_A3.equals(command.getApplytype())){
			entity.setApplystarthm( command.getApplystarthm());
			entity.setApplyendhm( command.getApplyendhm());		
			entity.setApplystart( DateUtil.parseDate( command.getApplystart(), DATE_FORMAT_YMD));
			entity.setApplyend( DateUtil.parseDate( command.getApplyend(), DATE_FORMAT_YMD));
			entity.setApplystarttime( new Timestamp(DateUtil.parseDate(command.getApplystart()+STRING_SPACE+command.getApplystarthm()+TIME_SS, DATE_FORMAT_YMDHMS).getTime()));
			entity.setApplyendtime( new Timestamp(DateUtil.parseDate(command.getApplyend()+STRING_SPACE+command.getApplyendhm()+TIME_SS, DATE_FORMAT_YMDHMS).getTime()));
		}else if(APPLY_A4.equals(command.getApplytype())){
			entity.setExtraworkstarthm( command.getExtraworkstarthm());
			entity.setExtraworkendhm( command.getExtraworkendhm());
			entity.setExtraworkstart( DateUtil.parseDate( command.getExtraworkstart(), DATE_FORMAT_YMD));
			entity.setExtraworkend( DateUtil.parseDate( command.getExtraworkend(), DATE_FORMAT_YMD));
			entity.setExtraworkstarttime( new Timestamp(DateUtil.parseDate(command.getExtraworkstart()+STRING_SPACE+command.getExtraworkstarthm()+TIME_SS, DATE_FORMAT_YMDHMS).getTime()));
			entity.setExtraworkendtime( new Timestamp(DateUtil.parseDate(command.getExtraworkend()+STRING_SPACE+command.getExtraworkendhm()+TIME_SS, DATE_FORMAT_YMDHMS).getTime()));
		}
		entity.setExtraworkapplytype(command.getExtraworkapplytype());
		entity.setEvectionworkflag(command.getEvectionworkflag());		
		entity.setEvectioncountry(command.getEvectioncountry());
		entity.setEvectionprovince(command.getEvectionprovince());
		entity.setEvectioncity(command.getEvectioncity());
		entity.setEvectionaddress1(command.getEvectionaddress1());
		entity.setEvectionaddress2(command.getEvectionaddress2());					
		entity.setTotalhours(command.getTotalhours());					
		entity.setEvectionmoney(new BigDecimal(command.getEvectionmoney()==null ? "0" : command.getEvectionmoney()));						
		entity.setEvectionallowance(new BigDecimal(command.getEvectionallowance()==null ? "0" : command.getEvectionallowance()));						
		entity.setTotalmoney(new BigDecimal(command.getTotalmoney()==null ? "0" : command.getTotalmoney()));	
		entity.setStatus(command.getStatus());
		entity.setRemark(command.getRemark());		
		return entity;
	}
}
