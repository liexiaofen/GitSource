package com.lw.oa.common.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lw.oa.common.command.ApplyFormCommand;
import com.lw.oa.common.command.ApplySearchCommand;
import com.lw.oa.common.command.ResultCommand;
import com.lw.oa.common.command.ResumeEntity;
import com.lw.oa.common.dao.IMybatisDAO;
import com.lw.oa.common.dao.MybatisDAOImpl;
import com.lw.oa.common.model.TicketDetail;
import com.lw.oa.common.util.ConstantUtil;
import com.lw.oa.common.util.CryptUtil;
import com.lw.oa.common.util.ResumeUtil;

/**
 ** @author yuliang
 */
@Service("commonService")
public class CommonServiceImpl implements ICommonService,ConstantUtil {
	
	private IMybatisDAO mybatisDAOImpl;
	public CommonServiceImpl() {
		// TODO Auto-generated constructor stub
		mybatisDAOImpl = new MybatisDAOImpl();
	}

	@Override
	public ResultCommand checkUserAndPwd(String username, String password, String orgcdid){
		// TODO Auto-generated method stub
		mybatisDAOImpl.openSession();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("username", username);
		try {
			map.put("password", CryptUtil.encryptBASE64( password));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		map.put("orgcdid", orgcdid);
		ResultCommand command = (ResultCommand) mybatisDAOImpl.expandByObj(
				"common.expandEmpByUserPwd", map);		
		return command;
	}
	
	@Override
	public ApplyFormCommand expandApplyForm(ApplySearchCommand searchCommand) {
		// TODO Auto-generated method stub
		mybatisDAOImpl.openSession();
		ApplyFormCommand command = (ApplyFormCommand) mybatisDAOImpl.expandByObj(
				"common.expandApplyForm", searchCommand);
		// 设置查询条件				
		HashMap<String,String> map = new HashMap<String, String>();
		map.put("empid", command.getApplyempid());
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
		List<ResumeEntity> list = ResumeUtil.getResumeListByPid(command.getApplyid(), "OA_PC001_Operationcd", "[dbo].[his_applyform]");
		command.setList(list);
		//不同申请类型的特殊处理
		specialProcess( command);
		mybatisDAOImpl.close();
		return command;
	}
	public void specialProcess(ApplyFormCommand command){
		//申请类型为出差申请
		if(APPLY_A4.equals(command.getApplytype()) || APPLY_A5.equals(command.getApplytype())){
			String applyid = command.getApplyid();
			if(APPLY_A5.equals(command.getApplytype())){
				applyid = command.getSourceid();
			}
			@SuppressWarnings("unchecked")
			List<TicketDetail> ticketdetail = (List<TicketDetail>)mybatisDAOImpl.queryByObj("common.queryTicketDetailByApplyid", applyid);
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
	public ApplyFormCommand getMessageCount(String empid){
		// 总件数
		int totalcount = 0;
		// 未审核件数
		int uncheckcount = 0;
		// 经理未审核件数
		int unmanagercheckcount = 0;
		// 人事未审核件数
		int unpersonnelcheckcount = 0;
		// 副总未审核件数
		int unvicepresicheckcount = 0;
		// 总经理未审核件数
		int unpresicheckcount = 0;
		// 人事未归档审核件数
		int unpersonfilecheckcount = 0;
		mybatisDAOImpl.openSession();
		HashMap<String,String> map = new HashMap<String, String>();
		map.put("empid", empid);
		uncheckcount = (int) mybatisDAOImpl.expandByObj(
				"common.message.selectUnCheckCount", map);
		/*unmanagercheckcount = (int) mybatisDAOImpl.expandByObj(
				"common.message.selectUnManagerCheckCount", map);
		unpersonnelcheckcount = (int) mybatisDAOImpl.expandByObj(
				"common.message.selectUnPersonnelCheckCount", map);
		unvicepresicheckcount = (int) mybatisDAOImpl.expandByObj(
				"common.message.selectUnVicepresiCheckCount", map);
		unpresicheckcount = (int) mybatisDAOImpl.expandByObj(
				"common.message.selectUnPresiCheckCount", map);*/
		unpersonfilecheckcount = (int) mybatisDAOImpl.expandByObj(
				"common.message.selectUnPersonFileCheckCount", map);
		totalcount = uncheckcount + unpersonfilecheckcount;
		ApplyFormCommand command = new ApplyFormCommand();
		command.setTotalcount(String.valueOf(totalcount));
		command.setUncheckcount(String.valueOf(uncheckcount));
		command.setUnmanagercheckcount(String.valueOf(unmanagercheckcount));
		command.setUnpersonnelcheckcount(String.valueOf(unpersonnelcheckcount));
		command.setUnvicepresicheckcount(String.valueOf(unvicepresicheckcount));
		command.setUnpresicheckcount(String.valueOf(unpresicheckcount));
		command.setUnpersonfilecheckcount(String.valueOf(unpersonfilecheckcount));
		mybatisDAOImpl.close();
		return command;
	}
}
