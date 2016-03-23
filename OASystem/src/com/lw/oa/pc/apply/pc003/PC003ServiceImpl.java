package com.lw.oa.pc.apply.pc003;

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
import com.lw.oa.common.model.TicketDetail;
import com.lw.oa.common.util.ConstantUtil;
import com.lw.oa.common.util.DataUtil;
import com.lw.oa.common.util.ResumeUtil;

/**
 ** @author yuliang
 */
@Service("pc003Service")
public class PC003ServiceImpl implements IPC003Service,ConstantUtil {

	private IMybatisDAO mybatisDAOImpl;

	public PC003ServiceImpl() {
		// TODO Auto-generated constructor stub
		mybatisDAOImpl = new MybatisDAOImpl();
	}

	@Override
	public List<?> pc003001search(ApplySearchCommand searchCommand) {
		// TODO Auto-generated method stub
		mybatisDAOImpl.openSession();
		@SuppressWarnings("unchecked")
		List<ApplyResultCommand> list = (List<ApplyResultCommand>) mybatisDAOImpl
				.queryByObj("pc.pc003.pc003001searchListByPage", searchCommand);
		mybatisDAOImpl.close();
		return list;
	}

	@Override
	public ApplyFormCommand pc003001view(ApplySearchCommand searchCommand) {
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
		//不同申请类型的特殊处理
		specialProcess( command);	
		mybatisDAOImpl.close();
		return command;
	}
	public void specialProcess(ApplyFormCommand command){
		//申请类型为出差申请
		if(APPLY_A4.equals(command.getApplytype())){
			@SuppressWarnings("unchecked")
			List<TicketDetail> ticketdetail = (List<TicketDetail>)mybatisDAOImpl.queryByObj("common.queryTicketDetailByApplyid", command.getApplyid());
			TicketDetail[] array = new TicketDetail[ticketdetail.size()];
			for(int i=0; i<ticketdetail.size(); i++){
				TicketDetail detail = new TicketDetail();
				detail.setOrderdate(ticketdetail.get(i).getOrderdate());
				detail.setFlight(ticketdetail.get(i).getFlight());
				detail.setStart(ticketdetail.get(i).getStart());
				detail.setReach(ticketdetail.get(i).getReach());
				detail.setDiscountflag(ticketdetail.get(i).getDiscountflag());
				detail.setTicketflag(ticketdetail.get(i).getTicketflag());
				array[i] = detail;
			}
			command.setTicketdetail( array);
		}
	}
	@Override
	public int pc003003update(ApplyFormCommand command, HttpServletRequest request) {
		// TODO Auto-generated method stub
		int flag = 1;
		try {
			mybatisDAOImpl.openSession();
			setAgreeStatus(command);
			// 数据转换
			ApplyForm entity = convertCommand(command);
			//获取系统时间
			Date sysdate = (Date)mybatisDAOImpl.expandByObj( "common.getDBSysDate", null);
			// 获取共通更新字段
			CommonBean bean = DataUtil.getUpdateCol(sysdate, request);
			// 设置共通更新字段
			DataUtil.setUpdateCol(entity, bean);
			// 设置处理人、状态
			entity.setProcessempid(bean.getUpdator());
			entity.setProcesstime(bean.getUpdatetime());					
			flag = mybatisDAOImpl.update( "pc.pc003.pc003003Update", entity);		
			// 根据不同的申请类型，状态做相应的特殊处理
			specialProcess( command, entity);
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
	
	@Override
	public int pc003003reject(ApplyFormCommand command, HttpServletRequest request) {
		// TODO Auto-generated method stub
		int flag = 1;
		try {
			mybatisDAOImpl.openSession();
			setRejectStatus(command);
			// 数据转换
			ApplyForm entity = convertCommand(command);
			//获取系统时间
			Date sysdate = (Date)mybatisDAOImpl.expandByObj( "common.getDBSysDate", null);
			// 获取共通更新字段
			CommonBean bean = DataUtil.getUpdateCol(sysdate, request);
			// 设置共通更新字段
			DataUtil.setUpdateCol(entity, bean);
			// 设置处理人、状态
			entity.setProcessempid(bean.getUpdator());
			entity.setProcesstime(bean.getUpdatetime());	
			flag = mybatisDAOImpl.update( "pc.pc003.pc003003Update", entity);			
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
	
	public void setAgreeStatus(ApplyFormCommand command){		
		String status = StringUtils.EMPTY;
		String operationcd = StringUtils.EMPTY;
		String applytype = command.getApplytype();
		String sts = command.getStatus();
		String checklevel = command.getChecklevel();
		if(APPLY_A1.equals(applytype) || APPLY_A2.equals(applytype)){
			if(APPLY_STATUS_1.equals(sts)){
				status = APPLY_STATUS_2;//经理已审批
				operationcd = "A003";
			}else if(APPLY_STATUS_2.equals(sts)){
				status = APPLY_STATUS_3;//人事已审批
				operationcd = "A005";
			}else if(APPLY_STATUS_3.equals(sts)){
				status = APPLY_STATUS_4;//副总已审批
				operationcd = "A007";
			}else if(APPLY_STATUS_4.equals(sts)){
				status = APPLY_STATUS_5;//总经理已审批
				operationcd = "A009";
			}
		}else if(APPLY_A3.equals(applytype)){
			if(APPLY_STATUS_1.equals(sts)){
				status = APPLY_STATUS_2;//经理已审批
				operationcd = "A003";
			}else if(APPLY_STATUS_2.equals(sts) && "1".equals(checklevel)){
				status = APPLY_STATUS_4;//副总已审批
				operationcd = "A007";
			}else if(APPLY_STATUS_2.equals(sts) && "2".equals(checklevel)){
				status = APPLY_STATUS_5;//总经理已审批
				operationcd = "A009";
			}
		}else if(APPLY_A4.equals(applytype)){
			if(APPLY_STATUS_1.equals(sts)){
				status = APPLY_STATUS_2;//经理已审批
				operationcd = "A003";
			}else if(APPLY_STATUS_2.equals(sts)){
				status = APPLY_STATUS_4;//副总已审批
				operationcd = "A007";
			}else if(APPLY_STATUS_4.equals(sts)){
				status = APPLY_STATUS_5;//总经理已审批
				operationcd = "A009";
			}
		}
		command.setStatus(status);
		command.setOperationcd(operationcd);
	}
	
	public void setRejectStatus(ApplyFormCommand command){
		String status = APPLY_STATUS_0;
		String operationcd = StringUtils.EMPTY;
		String applytype = command.getApplytype();
		String sts = command.getStatus();
		String checklevel = command.getChecklevel();
		if(APPLY_A1.equals(applytype) || APPLY_A2.equals(applytype)){
			if(APPLY_STATUS_1.equals(sts)){
				operationcd = "A004";//经理驳回
			}else if(APPLY_STATUS_2.equals(sts)){
				operationcd = "A006";//人事驳回
			}else if(APPLY_STATUS_3.equals(sts)){
				operationcd = "A008";//副总驳回
			}else if(APPLY_STATUS_4.equals(sts)){
				operationcd = "A010";//总经理驳回
			}
		}else if(APPLY_A3.equals(applytype)){
			if(APPLY_STATUS_1.equals(sts)){
				operationcd = "A004";//经理驳回
			}else if(APPLY_STATUS_2.equals(sts)  && "1".equals(checklevel)){
				operationcd = "A008";//副总驳回
			}else if(APPLY_STATUS_2.equals(sts)  && "2".equals(checklevel)){
				operationcd = "A010";//总经理驳回
			}
		}else if(APPLY_A4.equals(applytype)){
			if(APPLY_STATUS_1.equals(sts)){
				operationcd = "A004";//经理驳回
			}else if(APPLY_STATUS_2.equals(sts)){
				operationcd = "A008";//副总驳回
			}else if(APPLY_STATUS_4.equals(sts)){
				operationcd = "A010";//总经理驳回
			}
		}
		command.setStatus(status);
		command.setOperationcd(operationcd);
	}
	
	public void specialProcess( ApplyFormCommand cmd, ApplyForm entity){			
		//申请类型为加班申请，状态为副总已审批，进入加班确认申请流程
		if(APPLY_A3.equals(cmd.getApplytype()) && APPLY_STATUS_4.equals(cmd.getStatus())){						
			entity.setStatus(APPLY_STATUS_1);
			entity.setChecklevel("2");
			//加班时间初始化
			entity.setExtraworkstart(entity.getApplystart());
			entity.setExtraworkend(entity.getApplyend());
			entity.setExtraworkstarthm(entity.getApplystarthm());
			entity.setExtraworkendhm(entity.getApplyendhm());
			entity.setExtraworkstarttime(entity.getApplystarttime());
			entity.setExtraworkendtime(entity.getApplyendtime());		
			mybatisDAOImpl.update( "pc.pc003.pc003003UpdateChecklevel", entity);	
		}
	}
	
	@Override
	public int pc003003delete(ApplyFormCommand command, HttpServletRequest request) {
		// TODO Auto-generated method stub
		int flag = 1;
		try {
			mybatisDAOImpl.openSession();
			// 数据转换
			ApplyForm entity = convertCommand(command);
			//获取系统时间
			Date sysdate = (Date)mybatisDAOImpl.expandByObj( "common.getDBSysDate", null);
			// 获取共通更新字段
			CommonBean bean = DataUtil.getUpdateCol(sysdate, request);
			// 设置共通更新字段
			DataUtil.setUpdateCol(entity, bean);			
			flag = mybatisDAOImpl.update("pc.pc003.pc003003delete", entity);
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
	
	public ApplyForm convertCommand(ApplyFormCommand command) {
		ApplyForm entity = new ApplyForm();
		entity.setApplyid(command.getApplyid());
		entity.setExclusivefg(command.getExclusivefg());
		entity.setSourceid(command.getSourceid());
		entity.setApplyno(command.getApplyno());
		entity.setStatus(command.getStatus());
		entity.setRemark(command.getRemark());		
		return entity;
	}
}
