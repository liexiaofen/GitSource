package com.lw.oa.pa.master.pa004;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.lw.oa.common.dao.IMybatisDAO;
import com.lw.oa.common.dao.MybatisDAOImpl;
import com.lw.oa.common.model.CommonBean;
import com.lw.oa.common.model.Organize;
import com.lw.oa.common.util.DataUtil;
import com.lw.oa.common.util.DateUtil;

/**
 ** @author yuliang
 */
@Service("pa004Service")
public class PA004ServiceImpl implements IPA004Service {

	private IMybatisDAO mybatisDAOImpl;

	public PA004ServiceImpl() {
		// TODO Auto-generated constructor stub
		mybatisDAOImpl = new MybatisDAOImpl();
	}

	@Override
	public List<?> pa004001search(PA004001SearchCommand searchCommand) {
		// TODO Auto-generated method stub
		mybatisDAOImpl.openSession();
		@SuppressWarnings("unchecked")
		List<PA004001ResultCommand> list = (List<PA004001ResultCommand>) mybatisDAOImpl
				.queryByObj("pa.pa004.pa004001searchListByPage", searchCommand);
		mybatisDAOImpl.close();
		return list;
	}

	@Override
	public PA004Command pa004001view(PA004001SearchCommand searchCommand) {
		// TODO Auto-generated method stub
		mybatisDAOImpl.openSession();
		PA004Command command = (PA004Command) mybatisDAOImpl.expandByObj(
				"pa.pa004.pa004001expandById", searchCommand);
		mybatisDAOImpl.close();
		return command;
	}

	@Override
	public int pa004003save(PA004Command command, HttpServletRequest request) {
		// TODO Auto-generated method stub
		int flag = 1;
		try {
			mybatisDAOImpl.openSession();
			// 数据转换
			Organize entity = prepareCommand(command);
			//获取系统时间
			Date sysdate = (Date)mybatisDAOImpl.expandByObj( "common.getDBSysDate", null);
			// 获取key
			String key = DataUtil.getKey(sysdate);
			// 获取共通插入字段
			CommonBean bean = DataUtil.getInsertCol(sysdate, request);
			// 设置主键
			entity.setOrgcdid(key);
			// 设置共通插入字段
			DataUtil.setInsertCol(entity, bean);			
			mybatisDAOImpl.insert("common.insertOrganize", entity);
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
	public int pa004002update(PA004Command command, HttpServletRequest request) {
		// TODO Auto-generated method stub
		int flag = 1;
		try {
			mybatisDAOImpl.openSession();
			// 数据转换
			Organize entity = prepareCommand(command);
			//获取系统时间
			Date sysdate = (Date)mybatisDAOImpl.expandByObj( "common.getDBSysDate", null);
			// 获取共通更新字段
			CommonBean bean = DataUtil.getUpdateCol(sysdate, request);
			// 设置共通更新字段
			DataUtil.setUpdateCol(entity, bean);			
			flag = mybatisDAOImpl.update("pa.pa004.pa004002update", entity);
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
	public int pa004002delete(PA004Command command, HttpServletRequest request) {
		// TODO Auto-generated method stub
		int flag = 1;
		try {
			mybatisDAOImpl.openSession();
			// 数据转换
			Organize entity = prepareCommand(command);
			//获取系统时间
			Date sysdate = (Date)mybatisDAOImpl.expandByObj( "common.getDBSysDate", null);
			// 获取共通更新字段
			CommonBean bean = DataUtil.getUpdateCol(sysdate, request);
			// 设置共通更新字段
			DataUtil.setUpdateCol(entity, bean);			
			flag = mybatisDAOImpl.update("pa.pa004.pa004002delete", entity);
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

	public Organize prepareCommand(PA004Command command) {
		Organize entity = new Organize();		
		entity.setExclusivefg(command.getExclusivefg());
		entity.setOrgcdid(command.getOrgcdid());
		entity.setRegionid(command.getRegionid());
		entity.setOrgname(command.getOrgname());
		entity.setOrgshortname(command.getOrgshortname());
		entity.setAddress(command.getAddress());
		entity.setTel(command.getTel());
		entity.setFax(command.getFax());
		entity.setZipcode(command.getZipcode());
		entity.setEffectivedate(DateUtil.parseDate(command.getEffectivedate(),
				"yyyy-MM-dd"));
		entity.setSortno(new Integer(command.getSortno()));
		return entity;
	}
}
