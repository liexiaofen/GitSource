package com.lw.oa.pd.check.pd005;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import com.lw.oa.common.util.ResumeUtil;

/**
 ** @author yuliang
 */
@Service("pd005Service")
public class PD005ServiceImpl implements IPD005Service,ConstantUtil {

	private IMybatisDAO mybatisDAOImpl;

	public PD005ServiceImpl() {
		// TODO Auto-generated constructor stub
		mybatisDAOImpl = new MybatisDAOImpl();
	}

	@Override
	public List<?> pd005001search(ApplySearchCommand searchCommand) {
		// TODO Auto-generated method stub
		mybatisDAOImpl.openSession();
		@SuppressWarnings("unchecked")
		List<ApplyResultCommand> list = (List<ApplyResultCommand>) mybatisDAOImpl
				.queryByObj("pd.pd005.pd005001searchListByPage", searchCommand);
		mybatisDAOImpl.close();
		return list;
	}
	
	@Override
	public ApplyFormCommand pd005001view(ApplySearchCommand searchCommand) {
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
	public int pd005001file(ApplySearchCommand searchCommand, HttpServletRequest request) {
		// TODO Auto-generated method stub
		int flag = 1;
		ApplyForm[] applyform = searchCommand.getApplyform();
		try {
			mybatisDAOImpl.openSession();
			for(ApplyForm entity:applyform){
				// 设置状态
				entity.setStatus("6");
				// 获取系统时间
				Date sysdate = (Date)mybatisDAOImpl.expandByObj( "common.getDBSysDate", null);
				// 获取共通更新字段
				CommonBean bean = DataUtil.getUpdateCol(sysdate, request);
				// 设置共通更新字段
				DataUtil.setUpdateCol(entity, bean);
				// 设置处理人
				entity.setProcessempid(bean.getUpdator());
				entity.setProcesstime(bean.getUpdatetime());			
				flag = mybatisDAOImpl.update( "pd.pd005.pd005001file", entity);		
				if(flag < 1){
					mybatisDAOImpl.rollback();
					return flag;
				}
				// 获取履历id
				String hisid = DataUtil.getKey(sysdate);
				// 创建履历对象
				HashMap<String,Object> map  = DataUtil.creatHisMap("[dbo].[his_applyform]", hisid, entity.getApplyid(), "A011", "0", "0", "", bean, request);
				mybatisDAOImpl.insert("common.insertHis", map);			
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
	
}
