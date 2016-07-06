package com.lw.oa.pa.master.pa005;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.lw.oa.common.command.ResultCommand;
import com.lw.oa.common.dao.IMybatisDAO;
import com.lw.oa.common.dao.MybatisDAOImpl;
import com.lw.oa.common.model.AnnualVctn;
import com.lw.oa.common.model.CommonBean;
import com.lw.oa.common.util.ConstantUtil;
import com.lw.oa.common.util.DataUtil;

/**
 ** @author yuliang
 */
@Service("pa005Service")
public class PA005ServiceImpl implements IPA005Service,ConstantUtil {

	private IMybatisDAO mybatisDAOImpl;

	public PA005ServiceImpl() {
		// TODO Auto-generated constructor stub
		mybatisDAOImpl = new MybatisDAOImpl();
	}

	@Override
	public List<?> pa005001search(PA005001SearchCommand searchCommand) {
		// TODO Auto-generated method stub
		mybatisDAOImpl.openSession();
		@SuppressWarnings("unchecked")
		List<PA005001ResultCommand> list = (List<PA005001ResultCommand>) mybatisDAOImpl
				.queryByObj("pa.pa005.pa005001searchListByPage", searchCommand);
		mybatisDAOImpl.close();
		return list;
	}

	@Override
	public PA005Command pa005001view(PA005001SearchCommand searchCommand) {
		// TODO Auto-generated method stub
		mybatisDAOImpl.openSession();
		PA005Command command = (PA005Command) mybatisDAOImpl.expandByObj(
				"pa.pa005.pa005001expandByEmpidYear", searchCommand);
		mybatisDAOImpl.close();
		return command;
	}

	@Override
	public int pa005003save(PA005Command command, HttpServletRequest request) {
		// TODO Auto-generated method stub
		int flag = 1;		
		try {
			mybatisDAOImpl.openSession();
			//删除年假信息
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("year", command.getYear());
			mybatisDAOImpl.delete("pa.pa005.pa005003deleteAnnualvctn", map);			
			// 获取员工列表 
			@SuppressWarnings("unchecked")
			List<ResultCommand> list = (List<ResultCommand>) mybatisDAOImpl
					.queryByObj("pa.pa005.pa005003searchEmpList", command.getPa005001searchcommand());
			// 根据工龄不同获取员工年假列表
			List<AnnualVctn> lst = getAnnualVctnList(list, command);
			// 获取系统时间
			Date sysdate = (Date) mybatisDAOImpl.expandByObj(
					"common.getDBSysDate", null);
			// 获取共通插入字段
			CommonBean bean = DataUtil.getInsertCol(sysdate, request);
			for (AnnualVctn entity : lst) {				
				// 设置共通插入字段
				DataUtil.setInsertCol(entity, bean);
				mybatisDAOImpl.insert("common.insertAnnualvctn", entity);
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

	public List<AnnualVctn> getAnnualVctnList(List<ResultCommand> list, PA005Command command){
		List<AnnualVctn> lst = new ArrayList<AnnualVctn>();
		for (ResultCommand entity : list) {
			AnnualVctn annualvctn = new AnnualVctn();
			annualvctn.setEmpid(entity.getEmpid());
			annualvctn.setYear(command.getYear());
			int workage = Integer.parseInt(entity.getWorkage());
			if(workage >= WORKAGE_TWENTY){
				annualvctn.setLegalvctn(WORKAGE_TWENTY_HOURS);
			}else if(workage >= WORKAGE_TEN){
				annualvctn.setLegalvctn(WORKAGE_TEN_HOURS);
			}else if(workage >= WORKAGE_ZERO){
				annualvctn.setLegalvctn(WORKAGE_ZERO_HOURS);
			}
			annualvctn.setWealvctn(WEAL_HOURS);
			annualvctn.setExtraworkvctn(STRING_ZERO);
			
			annualvctn.setHaslegalvctn(STRING_ZERO);
			annualvctn.setHaswealvctn(STRING_ZERO);
			annualvctn.setHasextraworkvctn(STRING_ZERO);
			
			annualvctn.setUnlegalvctn(annualvctn.getLegalvctn());
			annualvctn.setUnwealvctn(annualvctn.getWealvctn());
			annualvctn.setUnextraworkvctn(annualvctn.getExtraworkvctn());
			lst.add(annualvctn);
		}
		return lst;
	}
	
	@Override
	public int pa005004update(PA005Command command, HttpServletRequest request) {
		// TODO Auto-generated method stub
		int flag = 1;
		try {
			// 数据转换
			AnnualVctn entity = prepareCommand(command);
			// 获取系统时间
			Date sysdate = (Date) mybatisDAOImpl.expandByObj(
					"common.getDBSysDate", null);
			// 获取共通更新字段
			CommonBean bean = DataUtil.getUpdateCol(sysdate, request);
			// 设置共通更新字段
			DataUtil.setUpdateCol(entity, bean);
			mybatisDAOImpl.openSession();
			flag = mybatisDAOImpl.update("pa.pa005.pa005004update", entity);
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

	public AnnualVctn prepareCommand(PA005Command command) {
		AnnualVctn entity = new AnnualVctn();
		entity.setExclusivefg(command.getExclusivefg());
		entity.setEmpid(command.getEmpid());
		entity.setYear(command.getYear());
		entity.setLegalvctn(new BigDecimal(command.getLegalvctn()).toBigInteger().toString());
		entity.setWealvctn(new BigDecimal(command.getWealvctn()).toBigInteger().toString());
		entity.setExtraworkvctn(new BigDecimal(command.getExtraworkvctn()).toBigInteger().toString());
		//法定休假
		BigDecimal legalvctn = new BigDecimal(command.getLegalvctn());
		//福利休假
		BigDecimal wealvctn = new BigDecimal(command.getWealvctn());
		//加班调休
		BigDecimal extraworkvctn = new BigDecimal(command.getExtraworkvctn());
		//已休法定休假
		BigDecimal haslegalvctn = new BigDecimal(command.getHaslegalvctn());
		//已休福利休假
		BigDecimal haswealvctn = new BigDecimal(command.getHaswealvctn());
		//已休加班调休
		BigDecimal hasextraworkvctn = new BigDecimal(command.getHasextraworkvctn());
		
		entity.setUnlegalvctn(legalvctn.subtract(haslegalvctn).toBigInteger().toString());
		entity.setUnwealvctn(wealvctn.subtract(haswealvctn).toBigInteger().toString());
		entity.setUnextraworkvctn(extraworkvctn.subtract(hasextraworkvctn).toBigInteger().toString());
		return entity;
	}

}
