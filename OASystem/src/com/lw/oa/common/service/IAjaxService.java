package com.lw.oa.common.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.lw.oa.common.command.RetInfo;

/**
 **@author yuliang
 */
public interface IAjaxService {
	public int fileGenerate( HttpServletRequest request, String empid);
	public int checkUniqueCardno(String cardno);
	public List<?> getDepsByOrgcdid(String orgcdid);
	public List<?> getOrgidsByRegionid(String regionid);
	public List<?> getResources();
	public List<?> getEmpsByOrgcdDepid(String orgcdid, String depid);
	public int checkUniqueUsername(String username, String empid);
	public int checkUniqueTypeId(String typeid, String busidicttypeid);
	public int updateBusiDictType(String typeid, String typename, String busidicttypeid);
	public int checkLegalyear(String legalyear);
	public int checkAnnualVctn(String year);	
	public RetInfo checkDeviceOrder(String eventdevicesid, String eventstart, String eventend, String eventstarthm, String eventendhm, String dailycycle, String eventid);
	public RetInfo checkDailyConflict(String eventdevicesid, String eventstart, String eventend, String eventstarthm, String eventendhm, String dailycycle, String empid, String eventid);
	public String getDeviceName(String dailydeviceid);
	public String getEmpName(String empid);
}
