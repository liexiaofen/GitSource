package com.lw.oa.pa.master.pa002;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.lw.oa.common.dao.IMybatisDAO;
import com.lw.oa.common.dao.MybatisDAOImpl;
import com.lw.oa.common.model.CommonBean;
import com.lw.oa.common.model.Deviceinfo;
import com.lw.oa.common.util.DataUtil;

/**
 ** @author yuliang
 */
@Service("pa002Service")
public class PA002ServiceImpl implements IPA002Service {

	private IMybatisDAO mybatisDAOImpl;

	public PA002ServiceImpl() {
		// TODO Auto-generated constructor stub
		mybatisDAOImpl = new MybatisDAOImpl();
	}

	@Override
	public List<?> pa002001search(PA002001SearchCommand searchCommand) {
		// TODO Auto-generated method stub
		mybatisDAOImpl.openSession();
		@SuppressWarnings("unchecked")
		List<PA002001ResultCommand> list = (List<PA002001ResultCommand>) mybatisDAOImpl
				.queryByObj("pa.pa002.pa002001searchListByPage", searchCommand);
		mybatisDAOImpl.close();
		return list;
	}

	@Override
	public PA002Command pa002001view(PA002001SearchCommand searchCommand) {
		// TODO Auto-generated method stub
		mybatisDAOImpl.openSession();
		PA002Command command = (PA002Command) mybatisDAOImpl.expandByObj(
				"pa.pa002.pa002001expandById", searchCommand);
		mybatisDAOImpl.close();
		return command;
	}

	@Override
	public int pa002003save(PA002Command command, HttpServletRequest request) {
		// TODO Auto-generated method stub
		int flag = 1;
		try {
			mybatisDAOImpl.openSession();
			// 数据转换
			Deviceinfo entity = prepareCommand(command);
			//获取系统时间
			Date sysdate = (Date)mybatisDAOImpl.expandByObj( "common.getDBSysDate", null);
			// 获取key
			String key = DataUtil.getKey(sysdate);
			// 获取共通插入字段
			CommonBean bean = DataUtil.getInsertCol(sysdate, request);
			// 设置主键
			entity.setDailydeviceid(key);
			// 设置共通插入字段
			DataUtil.setInsertCol(entity, bean);			
			mybatisDAOImpl.insert("common.insertDeviceinfo", entity);
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
	public int pa002002update(PA002Command command, HttpServletRequest request) {
		// TODO Auto-generated method stub
		int flag = 1;
		try {
			mybatisDAOImpl.openSession();
			// 数据转换
			Deviceinfo entity = prepareCommand(command);
			//获取系统时间
			Date sysdate = (Date)mybatisDAOImpl.expandByObj( "common.getDBSysDate", null);
			// 获取共通更新字段
			CommonBean bean = DataUtil.getUpdateCol(sysdate, request);
			// 设置共通更新字段
			DataUtil.setUpdateCol(entity, bean);			
			flag = mybatisDAOImpl.update("pa.pa002.pa002002update", entity);
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
	public int pa002002delete(PA002Command command, HttpServletRequest request) {
		// TODO Auto-generated method stub
		int flag = 1;
		try {
			mybatisDAOImpl.openSession();
			// 数据转换
			Deviceinfo entity = prepareCommand(command);
			//获取系统时间
			Date sysdate = (Date)mybatisDAOImpl.expandByObj( "common.getDBSysDate", null);
			// 获取共通更新字段
			CommonBean bean = DataUtil.getUpdateCol(sysdate, request);
			// 设置共通更新字段
			DataUtil.setUpdateCol(entity, bean);			
			flag = mybatisDAOImpl.update("pa.pa002.pa002002delete", entity);
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

	public Deviceinfo prepareCommand(PA002Command command) {
		Deviceinfo entity = new Deviceinfo();
		entity.setDailydeviceid(command.getDailydeviceid());
		entity.setExclusivefg(command.getExclusivefg());
		entity.setOrgcdid(command.getOrgcdid());
		entity.setDailydevicename(command.getDailydevicename());
		entity.setComment(command.getComment());
		return entity;
	}
}
