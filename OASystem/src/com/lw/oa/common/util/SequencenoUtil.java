package com.lw.oa.common.util;

import java.util.HashMap;
import org.apache.commons.lang.StringUtils;
import com.lw.oa.common.command.ResultCommand;
import com.lw.oa.common.dao.IMybatisDAO;

/**
 * *@author yuliang
 */
public class SequencenoUtil implements ConstantUtil {
	/**
	 * 功能：获得申请单号
	 * 输入：申请类型
	 * 输出：申请单号的序列号值
	 */
	public static String getApplyNo( String applytype, IMybatisDAO mybatisDAOImpl) {
		String applyno = StringUtils.EMPTY;		
		String key = StringUtils.EMPTY;	 
		String seq = StringUtils.EMPTY;	
		try{
			// 取得生成时间
			String sysdate = DateUtil.getSystemTime(DATE_FORMAT_YYYYMMDD);	
			// 申请番号最大值的取得
			HashMap<String, String> map = new HashMap<String, String>();
			map.put( "sysdate", sysdate);			
			ResultCommand command = (ResultCommand) mybatisDAOImpl.expandByObj(
					"common.expandApplyNo", map);
			if(command == null){
				seq = "0";
			}else{
				seq = command.getApplyno().substring(command.getApplyno().length()-5);
			}
			key = applytype + "-" + sysdate;
			// 申请番号最大值+1
			seq = (Integer.parseInt(seq)+1)+StringUtils.EMPTY;
			applyno = key + StringUtil.padString(seq, 5, "0", true);
		} catch(Exception e){
			mybatisDAOImpl.rollback();
			e.printStackTrace();
		} 
		return applyno;
	}
}
