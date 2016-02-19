package com.winsolution.weixin.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winsolution.weixin.common.BizContextNames;
import com.winsolution.weixin.dao.ITempSignDao;
import com.winsolution.weixin.entity.TempSignEntity;
import com.winsolution.weixin.service.ITempSignService;
@Service("tempSignService")
public class TempSignServiceImpl implements ITempSignService {

	@Autowired
	private ITempSignDao tempSignDao;
	// 业务处理结果返回
	private Map<String,Object> resultMap = null;
	private String ERR_MESSAGE = "";
	
	
	@Override
	public int insertTempSign(TempSignEntity tempSignEntity) {
		// TODO Auto-generated method stub
		return tempSignDao.insertTempSign(tempSignEntity);
	}
	
	@Override
	public Map<String, Object> getTempSign(TempSignEntity tempSignEntity) {
		// TODO Auto-generated method stub
		resultMap = getResultMap();
		try {
			List<TempSignEntity> list = tempSignDao.getTempSignLst(tempSignEntity);
			resultMap.put(BizContextNames.TEMPSIGN_LIST, list);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			ERR_MESSAGE = "考勤记录查询失败！::" + e.getMessage();
		}
		resultMap.put(BizContextNames.ERR_MESSAGE, ERR_MESSAGE);
		return resultMap;
	}
	
	@Override
	public Map<String, Object> getMap(TempSignEntity tempSignEntity) {
		// TODO Auto-generated method stub
		resultMap = getResultMap();
		try {
			List<TempSignEntity> list = tempSignDao.getMap(tempSignEntity);
			resultMap.put(BizContextNames.MAP_LIST, getJson(list));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			ERR_MESSAGE = "考勤记录查询失败！::" + e.getMessage();
		}
		resultMap.put(BizContextNames.ERR_MESSAGE, ERR_MESSAGE);
		return resultMap;
	}
	
	/*
	 * 转换List数据变成Json格式
	 * 
	 */
	public String getJson(List<TempSignEntity> list)
	{
		/*[
		{"empname":"王秀营","signtime":"09:29","geo":{"lng":121.525403,"lat":31.248791}},
		{"empname":"刘振华","signtime":"09:20","geo":{"lng":121.525403,"lat":31.248791}},
		{"empname":"徐文进","signtime":"09:19","geo":{"lng":121.510941,"lat":31.246584}},
		{"empname":"王作昆","signtime":"08:56","geo":{"lng":121.510941,"lat":31.246584}},
		{"empname":"高宇","signtime":"09:46","geo":{"lng":121.413376,"lat":31.203213}}
		]*/
		long l = 0;
		Date date = null;
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		//拼接 json
		StringBuffer stringBuffer = new StringBuffer();
		if(list != null && list.size() > 0)
		{
			stringBuffer.append("[");
			int i = 1;
			for (TempSignEntity tempSignEntity : list) {
				stringBuffer.append("{\"empname\":").append("\""+tempSignEntity.getTempInfo().getUsrname()+"\"").append(",");
				
				l = new Long(tempSignEntity.getMsgtime()).longValue();
				date = new Date(l);
				str = sdf.format(date);
				
				stringBuffer.append("\"signtime\":").append("\""+str+"\"").append(",");
				stringBuffer.append("\"geo\":").append("{\"lng\":").append(tempSignEntity.getLongitude()).append(",").append("\"lat\":").append(tempSignEntity.getLatitude()).append("}}");
				if(i < list.size())
				{
					stringBuffer.append(",");
				}
				i++;
			}
			stringBuffer.append("]");
		}
		System.out.println(stringBuffer.toString());
		return stringBuffer.toString();
	}
	
	public Map<String,Object> getResultMap() {
			return new HashMap<String,Object>();
	}
}
