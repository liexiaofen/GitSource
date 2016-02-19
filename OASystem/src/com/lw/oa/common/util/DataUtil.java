package com.lw.oa.common.util;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.lw.oa.common.command.SessionEntity;
import com.lw.oa.common.model.CommonBean;
/**
 * *@author yuliang
 */
public class DataUtil implements ConstantUtil {
	/**
	 * 取得履历数据
	 *  
	 * @return
	 */
	public static  HashMap<String,Object> creatHisMap(String tablename, String hisid, String pid, String operationcd, String viewflg, String replaceflg, String remark, CommonBean bean, HttpServletRequest request){
		String empname = STRING_EMPTY;
		HttpSession session = request.getSession();
		if(session.getAttribute("user") != null){
			SessionEntity sessionEntity = (SessionEntity)session.getAttribute("user");
			empname = sessionEntity.getEmpname();
		}
		HashMap<String,Object> map = new HashMap<String, Object>();
		map.put("table", tablename);
		map.put("creator", bean.getUpdator());
		map.put("createtime", bean.getUpdatetime());
		map.put("updator", bean.getUpdator());
		map.put("updatetime", bean.getUpdatetime());
		map.put("exclusivefg", bean.getUpdateexclusivefg());
		map.put("orgid", bean.getOrgid());
		map.put("deletefg", "0");
		map.put("hisid", hisid);
		map.put("pid", pid);
		map.put("operatorid", bean.getUpdator());
		map.put("operatorname", empname);
		map.put("operationcd", operationcd);
		map.put("viewflg", viewflg);
		map.put("replaceflg", replaceflg);
		map.put("remark", remark);
		return map;
	}
	/**
	 * 取得要插入数据
	 *  
	 * @return
	 */
	public static CommonBean getInsertCol( Date sysdate, HttpServletRequest request) throws Exception {
		String empid = STRING_EMPTY;
		HttpSession session = request.getSession();
		if(session.getAttribute("user") != null){
			SessionEntity sessionEntity = (SessionEntity)session.getAttribute("user");
			empid = sessionEntity.getEmpid();
		}
		CommonBean obj = new CommonBean();
		obj.setCreatetime(new Timestamp(sysdate.getTime())); // 登记时间
		obj.setUpdatetime(new Timestamp(sysdate.getTime())); // 更新时间
		obj.setCreator(empid); // 登记者
		obj.setUpdator(empid); // 更新者
		obj.setOrgid("999"); // 机构编号
		obj.setExclusivefg(getRandomNum(32)); // 排他标识
		obj.setUpdateexclusivefg(obj.getExclusivefg()); // 排他标识
		obj.setDeletefg("0"); // 删除区分
		return obj;
	}

	/**
	 * 取得更新数据
	 * 
	 * @return
	 */
	public static CommonBean getUpdateCol( Date sysdate, HttpServletRequest request) {
		String empid = STRING_EMPTY;
		HttpSession session = request.getSession();
		if(session.getAttribute("user") != null){
			SessionEntity sessionEntity = (SessionEntity)session.getAttribute("user");
			empid = sessionEntity.getEmpid();
		}
		CommonBean obj = new CommonBean();
		obj.setUpdatetime(new Timestamp(sysdate.getTime()));// 更新时间
		obj.setUpdator(empid);// 更新者
		obj.setOrgid("999"); // 机构编号
		obj.setUpdateexclusivefg(getRandomNum(32)); // 更新排他标识
		return obj;
	}

	/**
	 * 设置插入数据，同一业务处理时间保持一致
	 * 
	 * @param 目标对象
	 * @param 源对象
	 * 
	 * @return
	 */
	public static CommonBean setInsertCol(CommonBean dest, CommonBean src){
		dest.setCreatetime(src.getCreatetime()); // 登记时间
		dest.setUpdatetime(src.getUpdatetime()); // 更新时间
		dest.setCreator(src.getCreator()); // 登记者
		dest.setUpdator(src.getUpdator()); // 更新者
		dest.setOrgid(src.getOrgid()); // 机构编号
		dest.setExclusivefg(src.getExclusivefg()); // 排他标识
		dest.setDeletefg(src.getDeletefg()); // 删除区分
		return dest;
	}

	/**
	 * 设置更新数据，同一业务处理时间保持一致
	 * 
	 * @param 目标对象
	 * @param 源对象
	 * 
	 * @return
	 */
	public static CommonBean setUpdateCol(CommonBean dest, CommonBean src) {
		dest.setUpdatetime(src.getUpdatetime()); // 更新时间
		dest.setUpdator(src.getUpdator()); // 更新者
		dest.setOrgid(src.getOrgid());//机构编号
		dest.setUpdateexclusivefg(src.getUpdateexclusivefg()); // 更新排他标识		
		return dest;
	}
	
	/**
	 * 根据序列名获取序列号
	 * 
	 * @param seqName
	 *            序列名称
	 * @return
	 */
	public static String getKey(Date sysdate) {
		String sequence = DateUtil.formatDate(sysdate, "yyyyMMddHHmmss");
		sequence += getRandomNum(16);
		return sequence;
	}

	/**
	 * java生成随机数字和字母组合
	 * 
	 * @param length
	 *            [生成随机数的长度]
	 * @return
	 */
	public static String getRandomNum(int length) {
		StringBuffer val = new StringBuffer("");
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			// 输出字母还是数字
			String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
			// 字符串
			if ("char".equalsIgnoreCase(charOrNum)) {
				// 取得大写字母还是小写字母
				int choice = random.nextInt(2) % 2 == 0 ? 65 : 97;
				val.append((char) (choice + random.nextInt(26)));
			} else if ("num".equalsIgnoreCase(charOrNum)) { 
				// 数字
				val.append(String.valueOf(random.nextInt(10)));
			}
		}
		return val.toString();
	}
	
	public static void main(String[] args){	
	}
}
