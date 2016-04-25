package com.lw.oa.pa.master.pa006;

import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.lw.oa.common.dao.IMybatisDAO;
import com.lw.oa.common.dao.MybatisDAOImpl;
import com.lw.oa.common.model.CommonBean;
import com.lw.oa.common.util.ConstantUtil;
import com.lw.oa.common.util.CryptUtil;
import com.lw.oa.common.util.DataUtil;

/**
 ** @author yuliang
 */
@Service("pa006Service")
public class PA006ServiceImpl implements IPA006Service,ConstantUtil {

	private IMybatisDAO mybatisDAOImpl;

	public PA006ServiceImpl() {
		// TODO Auto-generated constructor stub
		mybatisDAOImpl = new MybatisDAOImpl();
	}
	@Override
	public PA006Command pa006001view(String empid) {
		// TODO Auto-generated method stub
		mybatisDAOImpl.openSession();
		HashMap<String,String> map = new HashMap<String, String>();
		map.put("empid", empid);
		PA006Command command = (PA006Command) mybatisDAOImpl
				.expandByObj("pa.pa006.pa006001expandById", map);
		if(command != null){
			try {
				command.setPassword(CryptUtil.decryptBASE64(command.getPassword()));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		mybatisDAOImpl.close();
		return command;
	}
	@Override
	public int pa006001save(PA006Command command, HttpServletRequest request) {
		// TODO Auto-generated method stub
		int flag = 1;		
		try {
			mybatisDAOImpl.openSession();		
			// 获取系统时间
			Date sysdate = (Date)mybatisDAOImpl.expandByObj( "common.getDBSysDate", null);
			// 获取共通更新字段
			CommonBean updatebean = DataUtil.getUpdateCol(sysdate, request);
			HashMap<String,Object> map = new HashMap<String, Object>();
			// 设置共通更新字段
			map.put("empid", command.getEmpid());
			map.put("exclusivefg", command.getExclusivefg());
			map.put("newpassword", CryptUtil.encryptBASE64( command.getNewpassword()));
			map.put("updator", updatebean.getUpdator());
			map.put("updatetime", updatebean.getUpdatetime());
			map.put("updateexclusivefg", updatebean.getUpdateexclusivefg());
			map.put("orgid", updatebean.getOrgid());			
			flag = mybatisDAOImpl.update("pa.pa006.pa006001updatePassword", map);
			if(flag == 0){
				return flag;
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
}
