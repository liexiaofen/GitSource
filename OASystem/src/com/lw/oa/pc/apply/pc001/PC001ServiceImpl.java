package com.lw.oa.pc.apply.pc001;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.lw.oa.common.command.ResultCommand;
import com.lw.oa.common.dao.IMybatisDAO;
import com.lw.oa.common.dao.MybatisDAOImpl;
import com.lw.oa.common.model.AnnualVctn;
import com.lw.oa.common.model.ApplyForm;
import com.lw.oa.common.model.CommonBean;
import com.lw.oa.common.model.TicketDetail;
import com.lw.oa.common.util.ConstantUtil;
import com.lw.oa.common.util.DataUtil;
import com.lw.oa.common.util.DateUtil;
import com.lw.oa.common.util.SequencenoUtil;
/**
 ** @author yuliang
 */
@Service("pc001Service")
public class PC001ServiceImpl implements IPC001Service,ConstantUtil {

	private IMybatisDAO mybatisDAOImpl;
	
	public PC001ServiceImpl() {
		// TODO Auto-generated constructor stub
		mybatisDAOImpl = new MybatisDAOImpl();
	}

	@Override
	public PC001Command pc001001apply(PC001001SearchCommand searchCommand) {
		// TODO Auto-generated method stub
		mybatisDAOImpl.openSession();
		PC001Command command = new PC001Command();
		// 设置导航
		command.setApplyempid(searchCommand.getEmpid());
		command.setApplyempname(searchCommand.getEmpname());
		command.setApplytype(searchCommand.getApplytype());
		// 设置查询条件
		command.setPc001001searchcommand(searchCommand);
		HashMap<String,String> map = new HashMap<String, String>();
		map.put("empid", searchCommand.getEmpid());
		// 获取年假信息
		AnnualVctn annualvctn = (AnnualVctn)mybatisDAOImpl.expandByObj("common.expandAnnualvctn", map);
		command.setUnlegalvctn(annualvctn.getUnlegalvctn());
		command.setUnwealvctn(annualvctn.getUnwealvctn());
		command.setUnextraworkvctn(annualvctn.getUnextraworkvctn());
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
		mybatisDAOImpl.close();
		return command;
	}
	
	@Override
	public int pc001002save(PC001Command command, HttpServletRequest request) {
		// TODO Auto-generated method stub
		int flag = 1;		
		try {
			mybatisDAOImpl.openSession();
			// 获取申请单号
			String applyno = SequencenoUtil.getApplyNo( command.getApplytype(), mybatisDAOImpl);					
			// 数据转换
			ApplyForm entity = prepareCommand(command);
			// 获取系统时间
			Date sysdate = (Date)mybatisDAOImpl.expandByObj( "common.getDBSysDate", null);
			// 获取申请id
			String key = DataUtil.getKey(sysdate);				
			// 获取共通插入字段
			CommonBean bean = DataUtil.getInsertCol(sysdate, request);
			// 设置主键
			entity.setApplyid(key);
			entity.setApplyno(applyno);
			entity.setProcessempid(bean.getUpdator());
			entity.setProcesstime(bean.getUpdatetime());
			entity.setStatus("1");
			// 设置共通插入字段
			DataUtil.setInsertCol(entity, bean);		
			// 插入申请单表
			mybatisDAOImpl.insert("common.insertApplyForm", entity);
			// 获取履历id
			String hisid = DataUtil.getKey(sysdate);
			// 创建履历对象
			HashMap<String,Object> map  = DataUtil.creatHisMap("[dbo].[his_applyform]", hisid, key, "A001", "0", "0", "", bean, request);
			mybatisDAOImpl.insert("common.insertHis", map);
			if(APPLY_A4.equals(command.getApplytype())){
				insertTicketDetail(key, sysdate, bean, command.getTicketdetail());
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
	
	public void insertTicketDetail(String applyid, Date sysdate, CommonBean bean, TicketDetail[] ticketdetail){
		for(TicketDetail detail:ticketdetail){
			// 获取订票明细id
			String ticketdetailid = DataUtil.getKey(sysdate);
			detail.setTicketdetailid(ticketdetailid);
			//设置applyid
			detail.setApplyid(applyid);
			// 设置共通插入字段
			DataUtil.setInsertCol(detail, bean);	
			mybatisDAOImpl.insert("common.insertTicketDetail", detail);
		}
	}
	
	public ApplyForm prepareCommand(PC001Command command) {
		ApplyForm entity = new ApplyForm();
		entity.setApplyid(command.getApplyid());
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
		if(APPLY_A1.equals(command.getApplytype())||APPLY_A2.equals(command.getApplytype())||APPLY_A3.equals(command.getApplytype())||APPLY_A4.equals(command.getApplytype())||APPLY_A5.equals(command.getApplytype())){
			entity.setApplystarthm( command.getApplystarthm());
			entity.setApplyendhm( command.getApplyendhm());		
			entity.setApplystart( DateUtil.parseDate( command.getApplystart(), DATE_FORMAT_YMD));
			entity.setApplyend( DateUtil.parseDate( command.getApplyend(), DATE_FORMAT_YMD));
			entity.setApplystarttime( new Timestamp(DateUtil.parseDate(command.getApplystart()+STRING_SPACE+command.getApplystarthm()+TIME_SS, DATE_FORMAT_YMDHMS).getTime()));
			entity.setApplyendtime( new Timestamp(DateUtil.parseDate(command.getApplyend()+STRING_SPACE+command.getApplyendhm()+TIME_SS, DATE_FORMAT_YMDHMS).getTime()));
		}else{
			entity.setExtraworkstarthm( command.getExtraworkstarthm());
			entity.setExtraworkendhm( command.getExtraworkendhm());
			entity.setExtraworkstart( DateUtil.parseDate( command.getExtraworkstart(), DATE_FORMAT_YMD));
			entity.setExtraworkend( DateUtil.parseDate( command.getExtraworkend(), DATE_FORMAT_YMD));
			entity.setExtraworkstarttime( new Timestamp(DateUtil.parseDate(command.getExtraworkstart()+STRING_SPACE+command.getExtraworkstarthm()+TIME_SS, DATE_FORMAT_YMDHMS).getTime()));
			entity.setExtraworkendtime( new Timestamp(DateUtil.parseDate(command.getExtraworkend()+STRING_SPACE+command.getExtraworkendhm()+TIME_SS, DATE_FORMAT_YMDHMS).getTime()));
		}
		entity.setExtraworkapplytype(command.getExtraworkapplytype());
		entity.setEvectionworkflag(command.getEvectionworkflag());
		entity.setEvectionaddress(command.getEvectionaddress());
		entity.setEvectioncountry(command.getEvectioncountry());
		entity.setEvectionprovince(command.getEvectionprovince());
		entity.setEvectioncity(command.getEvectioncity());
		entity.setEvectionaddress1(command.getEvectionaddress1());
		entity.setEvectionaddress2(command.getEvectionaddress2());	
		entity.setEvectionconnects(command.getEvectionconnects());
		entity.setEvectionstart(command.getEvectionstart());
		entity.setAirplaneflag(command.getAirplaneflag());
		entity.setTotalhours(command.getTotalhours());					
		entity.setEvectionmoney(new BigDecimal(command.getEvectionmoney()==null ? "0" : command.getEvectionmoney()));						
		entity.setEvectionallowance(new BigDecimal(command.getEvectionallowance()==null ? "0" : command.getEvectionallowance()));						
		entity.setTotalmoney(new BigDecimal(command.getTotalmoney()==null ? "0" : command.getTotalmoney()));					
		entity.setRemark(command.getRemark());		
		return entity;
	}
}
