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
import com.lw.oa.common.dao.IMybatisDAO;
import com.lw.oa.common.dao.MybatisDAOImpl;
import com.lw.oa.common.model.ApplyForm;
import com.lw.oa.common.model.CommonBean;
import com.lw.oa.common.model.TicketDetail;
import com.lw.oa.common.util.ConstantUtil;
import com.lw.oa.common.util.DataUtil;
import com.lw.oa.common.util.DateUtil;

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
			CommonBean insertbean = DataUtil.getInsertCol(sysdate, request);
			// 设置共通更新字段
			DataUtil.setUpdateCol(entity, bean);
			entity.setProcessempid(bean.getUpdator());
			entity.setProcesstime(bean.getUpdatetime());
			// 根据申请单类型获取对应update sql
			String sqlid = getSqlidByApplytype(command);
			flag = mybatisDAOImpl.update( sqlid, entity);			
			// 获取履历id
			String hisid = DataUtil.getKey(sysdate);
			// 创建履历对象
			HashMap<String,Object> map  = DataUtil.creatHisMap("[dbo].[his_applyform]", hisid, command.getApplyid(), "A002", "0", "0", command.getRemark(), bean, request);
			mybatisDAOImpl.insert("common.insertHis", map);			
			// 出差申请特殊处理
			if(APPLY_A4.equals(command.getApplytype())){
				mybatisDAOImpl.delete("pc.pc002.pc002003PDTicketDetail", command.getApplyid());
				insertTicketDetail(command.getApplyid(), sysdate, insertbean, command.getTicketdetail());
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
	
	public String getSqlidByApplytype(ApplyFormCommand command){
		String sqlid = StringUtils.EMPTY;
		String applytype = command.getApplytype();
		String checklevel = command.getChecklevel();
		if(APPLY_A1.equals(applytype)){
			sqlid = "pc.pc002.pc002003A1Update";
		}else if(APPLY_A2.equals(applytype)){
			sqlid = "pc.pc002.pc002003A2Update";
		}else if(APPLY_A3.equals(applytype) && "1".equals(checklevel)){
			sqlid = "pc.pc002.pc002003A3Update1";
		}else if(APPLY_A3.equals(applytype) && "2".equals(checklevel)){
			sqlid = "pc.pc002.pc002003A3Update2";
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
			flag = mybatisDAOImpl.update( "pc.pc002.pc002003LDApplyform", entity);			
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
		if(APPLY_A1.equals(command.getApplytype())||APPLY_A2.equals(command.getApplytype())|| (APPLY_A3.equals(command.getApplytype()) && "1".equals(command.getChecklevel()))||APPLY_A4.equals(command.getApplytype())){
			entity.setApplystarthm( command.getApplystarthm());
			entity.setApplyendhm( command.getApplyendhm());		
			entity.setApplystart( DateUtil.parseDate( command.getApplystart(), DATE_FORMAT_YMD));
			entity.setApplyend( DateUtil.parseDate( command.getApplyend(), DATE_FORMAT_YMD));
			entity.setApplystarttime( new Timestamp(DateUtil.parseDate(command.getApplystart()+STRING_SPACE+command.getApplystarthm()+TIME_SS, DATE_FORMAT_YMDHMS).getTime()));
			entity.setApplyendtime( new Timestamp(DateUtil.parseDate(command.getApplyend()+STRING_SPACE+command.getApplyendhm()+TIME_SS, DATE_FORMAT_YMDHMS).getTime()));
		}else if(APPLY_A3.equals(command.getApplytype()) && "2".equals(command.getChecklevel())){
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
		entity.setStatus(command.getStatus());
		entity.setRemark(command.getRemark());		
		return entity;
	}
}
