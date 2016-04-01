package com.lw.oa.common.util;

import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.lw.oa.common.command.ApplyFormCommand;
import com.lw.oa.common.command.ResumeEntity;
import com.lw.oa.common.model.TicketDetail;

public class TemplateUtil implements ConstantUtil{
	/**
	 * 休假申请模板数据写入
	 * 
	 * @param workbook
	 *            工作簿
	 * @param obj
	 *            数据集合
	 */
	public static void templateA1write( Workbook workbook, ApplyFormCommand obj){
		Sheet sheet = workbook.getSheetAt(0);
		// 设置当前日期
		Row daterow = sheet.getRow(2);
		Cell datecell = daterow.getCell(18);
		String sysdate = DateUtil.getSystemTime(DATE_FORMAT_YMDHMS);
		datecell.setCellValue(sysdate);
		// 设置申请人
		Row emprow = sheet.getRow(3);
		Cell empcell = emprow.getCell(4);
		empcell.setCellValue(obj.getApplyempname());
		// 设置申请单号
		Row applynorow = sheet.getRow(3);
		Cell applynocell = applynorow.getCell(17);
		applynocell.setCellValue(obj.getApplyno());
		// 设置机构
		Row orgrow = sheet.getRow(4);
		Cell orgcell = orgrow.getCell(4);
		orgcell.setCellValue(obj.getOrgcddepposes());
		// 设置请假事由
		String vacatetype = obj.getVacatereasontype();
		setA1Vacatereasontype(sheet, vacatetype);
		// 设置备注			 
		Row otherremarkrow = sheet.getRow(8);
		Cell otherremarkcell = otherremarkrow.getCell(12);
		otherremarkcell.setCellValue(obj.getOtherremark());
		// 设置请假时间
		Row startrow = sheet.getRow(9);
		Cell startcell = startrow.getCell(4);
		startcell.setCellValue(obj.getApplystarttime());
		Row endrow = sheet.getRow(9);
		Cell endcell = endrow.getCell(11);
		endcell.setCellValue(obj.getApplyendtime());
		// 设置总工时
		Row totalhoursrow = sheet.getRow(10);
		Cell totalhourscell = totalhoursrow.getCell(4);
		totalhourscell.setCellValue(obj.getTotalhours());
		// 设置法定休假
		Row legalvctnrow = sheet.getRow(14);
		Cell legalvctncell = legalvctnrow.getCell(5);
		legalvctncell.setCellValue(obj.getUnlegalvctn());
		// 设置福利休假
		Row wealvctnrow = sheet.getRow(15);
		Cell wealvctncell = wealvctnrow.getCell(5);
		wealvctncell.setCellValue(obj.getUnwealvctn());
		// 设置加班调休
		Row extraworkvctnrow = sheet.getRow(16);
		Cell extraworkvctncell = extraworkvctnrow.getCell(5);
		extraworkvctncell.setCellValue(obj.getUnextraworkvctn());
		// 设置审核人
		String status = obj.getStatus();
		setA1Checkname( sheet,  status,  obj);	
		// 设置审核履历
		setA1Resume( sheet, obj);
	}
	/**
	 * 休假取消申请模板数据写入
	 * 
	 * @param workbook
	 *            工作簿
	 * @param obj
	 *            数据集合
	 */
	public static void templateA2write( Workbook workbook, ApplyFormCommand obj){
		Sheet sheet = workbook.getSheetAt(0);
		// 设置当前日期
		Row daterow = sheet.getRow(2);
		Cell datecell = daterow.getCell(18);
		String sysdate = DateUtil.getSystemTime(DATE_FORMAT_YMDHMS);
		datecell.setCellValue(sysdate);
		// 设置申请人
		Row emprow = sheet.getRow(3);
		Cell empcell = emprow.getCell(4);
		empcell.setCellValue(obj.getApplyempname());
		// 设置申请单号
		Row applynorow = sheet.getRow(3);
		Cell applynocell = applynorow.getCell(11);
		applynocell.setCellValue(obj.getApplyno());
		// 设置休假申请单号
		Row sourceapplynorow = sheet.getRow(3);
		Cell sourceapplynocell = sourceapplynorow.getCell(20);
		sourceapplynocell.setCellValue(obj.getSourceapplyno());
		// 设置机构
		Row orgrow = sheet.getRow(4);
		Cell orgcell = orgrow.getCell(4);
		orgcell.setCellValue(obj.getOrgcddepposes());		
		// 设置请假事由
		String vacatetype = obj.getVacatereasontype();
		setA1Vacatereasontype(sheet, vacatetype);
		// 设置备注			 
		Row otherremarkrow = sheet.getRow(8);
		Cell otherremarkcell = otherremarkrow.getCell(12);
		otherremarkcell.setCellValue(obj.getOtherremark());
		// 设置请假时间
		Row startrow = sheet.getRow(9);
		Cell startcell = startrow.getCell(4);
		startcell.setCellValue(obj.getApplystarttime());
		Row endrow = sheet.getRow(9);
		Cell endcell = endrow.getCell(11);
		endcell.setCellValue(obj.getApplyendtime());
		// 设置总工时
		Row totalhoursrow = sheet.getRow(10);
		Cell totalhourscell = totalhoursrow.getCell(4);
		totalhourscell.setCellValue(obj.getTotalhours());
		// 设置法定休假
		Row legalvctnrow = sheet.getRow(14);
		Cell legalvctncell = legalvctnrow.getCell(5);
		legalvctncell.setCellValue(obj.getUnlegalvctn());
		// 设置福利休假
		Row wealvctnrow = sheet.getRow(15);
		Cell wealvctncell = wealvctnrow.getCell(5);
		wealvctncell.setCellValue(obj.getUnwealvctn());
		// 设置加班调休
		Row extraworkvctnrow = sheet.getRow(16);
		Cell extraworkvctncell = extraworkvctnrow.getCell(5);
		extraworkvctncell.setCellValue(obj.getUnextraworkvctn());
		// 设置审核人
		String status = obj.getStatus();
		setA1Checkname( sheet,  status,  obj);	
		// 设置审核履历
		setA1Resume( sheet, obj);
	}
	/**
	 * 加班申请模板数据写入
	 * 
	 * @param workbook
	 *            工作簿
	 * @param obj
	 *            数据集合
	 */
	public static void templateA3write( Workbook workbook, ApplyFormCommand obj){
		Sheet sheet = workbook.getSheetAt(0);
		// 设置当前日期
		Row daterow = sheet.getRow(2);
		Cell datecell = daterow.getCell(18);
		String sysdate = DateUtil.getSystemTime(DATE_FORMAT_YMDHMS);
		datecell.setCellValue(sysdate);
		// 设置申请人
		Row emprow = sheet.getRow(3);
		Cell empcell = emprow.getCell(4);
		empcell.setCellValue(obj.getApplyempname());
		// 设置申请单号
		Row applynorow = sheet.getRow(3);
		Cell applynocell = applynorow.getCell(17);
		applynocell.setCellValue(obj.getApplyno());
		// 设置机构
		Row orgrow = sheet.getRow(4);
		Cell orgcell = orgrow.getCell(4);
		orgcell.setCellValue(obj.getOrgcddepposes());
		// 设置申请事由
		String applyreason = obj.getApplyreason();
		Row applyreasonrow = sheet.getRow(6);
		Cell applyreasoncell = applyreasonrow.getCell(5);
		applyreasoncell.setCellValue(applyreason);
		// 设置加班申请时间
		Row startrow = sheet.getRow(7);
		Cell startcell = startrow.getCell(6);
		startcell.setCellValue(obj.getApplystarttime());
		Row endrow = sheet.getRow(7);
		Cell endcell = endrow.getCell(13);
		endcell.setCellValue(obj.getApplyendtime());
		// 设置申请加班类型
		String extraworkapplytype = obj.getExtraworkapplytype();
		setA3Extraworkapplytype(sheet, extraworkapplytype);
		// 设置是否出差地加班
		String evectionworkflag = obj.getEvectionworkflag();
		setA3Evectionworkflag(sheet, evectionworkflag);		
		// 设置加班实施时间
		Row startrow1 = sheet.getRow(17);
		Cell startcell1 = startrow1.getCell(9);
		startcell1.setCellValue(obj.getExtraworkstarttime());
		Row endrow1 = sheet.getRow(17);
		Cell endcell1 = endrow1.getCell(16);
		endcell1.setCellValue(obj.getExtraworkendtime());
		// 设置审核人
		String status = obj.getStatus();
		String checklevel = obj.getChecklevel();
		setA3Checkname( sheet,  status, checklevel, obj);	
		// 设置审核履历
		setA1Resume( sheet, obj);
	}
	/**
	 * 出差申请模板数据写入
	 * 
	 * @param workbook
	 *            工作簿
	 * @param obj
	 *            数据集合
	 */
	public static void templateA4write( Workbook workbook, ApplyFormCommand obj){
		Sheet sheet = workbook.getSheetAt(0);
		// 设置当前日期
		Row daterow = sheet.getRow(2);
		Cell datecell = daterow.getCell(18);
		String sysdate = DateUtil.getSystemTime(DATE_FORMAT_YMDHMS);
		datecell.setCellValue(sysdate);
		// 设置申请人
		Row emprow = sheet.getRow(3);
		Cell empcell = emprow.getCell(4);
		empcell.setCellValue(obj.getApplyempname());
		// 设置申请单号
		Row applynorow = sheet.getRow(3);
		Cell applynocell = applynorow.getCell(17);
		applynocell.setCellValue(obj.getApplyno());
		// 设置机构
		Row orgrow = sheet.getRow(4);
		Cell orgcell = orgrow.getCell(4);
		orgcell.setCellValue(obj.getOrgcddepposes());
		// 设置出差目的
		Row applyreasonrow = sheet.getRow(6);
		Cell applyreasoncell = applyreasonrow.getCell(4);
		applyreasoncell.setCellValue(obj.getApplyreason());
		// 设置出差地	 
		Row evectionaddressrow = sheet.getRow(7);
		Cell evectionaddresscell = evectionaddressrow.getCell(4);
		evectionaddresscell.setCellValue(obj.getEvectionaddress());
		// 设置出差地1	 
		Row evectionaddressrow1 = sheet.getRow(7);
		Cell evectionaddresscell1 = evectionaddressrow1.getCell(9);
		evectionaddresscell1.setCellValue(obj.getEvectionaddress1());
		// 设置出差地2	 
		Row evectionaddressrow2 = sheet.getRow(7);
		Cell evectionaddresscell2 = evectionaddressrow2.getCell(13);
		evectionaddresscell2.setCellValue(obj.getEvectionaddress2());
		// 设置是否利用飞机
		String airplaneflag = obj.getAirplaneflag();
		setA4Airportflag(sheet, airplaneflag);
		// 设置同行人
		Row evectionconnectsrow = sheet.getRow(8);
		Cell evectionconnectscell = evectionconnectsrow.getCell(4);
		evectionconnectscell.setCellValue(obj.getEvectionconnects());
		// 设置出发自
		String evectionstart = obj.getEvectionstart();
		setA4Evectionstart(sheet, evectionstart);
		// 设置出差时间
		Row startrow = sheet.getRow(9);
		Cell startcell = startrow.getCell(4);
		startcell.setCellValue(obj.getApplystarttime());
		Row endrow = sheet.getRow(9);
		Cell endcell = endrow.getCell(11);
		endcell.setCellValue(obj.getApplyendtime());	
		// 设置订票明细
		setA4TicketDetail( sheet, obj);
		// 设置审核人
		String status = obj.getStatus();
		setA4Checkname( sheet,  status,  obj);	
		// 设置审核履历
		setA1Resume( sheet, obj);
	}
	/**
	 * 出差申请模板数据写入
	 * 
	 * @param workbook
	 *            工作簿
	 * @param obj
	 *            数据集合
	 */
	public static void templateA5write( Workbook workbook, ApplyFormCommand obj){
		Sheet sheet = workbook.getSheetAt(0);
		// 设置当前日期
		Row daterow = sheet.getRow(2);
		Cell datecell = daterow.getCell(18);
		String sysdate = DateUtil.getSystemTime(DATE_FORMAT_YMDHMS);
		datecell.setCellValue(sysdate);
		// 设置申请人
		Row emprow = sheet.getRow(3);
		Cell empcell = emprow.getCell(4);
		empcell.setCellValue(obj.getApplyempname());
		// 设置申请单号
		Row applynorow = sheet.getRow(3);
		Cell applynocell = applynorow.getCell(11);
		applynocell.setCellValue(obj.getApplyno());
		// 设置休假申请单号
		Row sourceapplynorow = sheet.getRow(3);
		Cell sourceapplynocell = sourceapplynorow.getCell(20);
		sourceapplynocell.setCellValue(obj.getSourceapplyno());
		// 设置机构
		Row orgrow = sheet.getRow(4);
		Cell orgcell = orgrow.getCell(4);
		orgcell.setCellValue(obj.getOrgcddepposes());
		// 设置出差目的
		Row applyreasonrow = sheet.getRow(6);
		Cell applyreasoncell = applyreasonrow.getCell(4);
		applyreasoncell.setCellValue(obj.getApplyreason());
		// 设置出差地	 
		Row evectionaddressrow = sheet.getRow(7);
		Cell evectionaddresscell = evectionaddressrow.getCell(4);
		evectionaddresscell.setCellValue(obj.getEvectionaddressdict());
		// 设置出差地1	 
		Row evectionaddressrow1 = sheet.getRow(7);
		Cell evectionaddresscell1 = evectionaddressrow1.getCell(9);
		evectionaddresscell1.setCellValue(obj.getEvectionaddress1());
		// 设置出差地2	 
		Row evectionaddressrow2 = sheet.getRow(7);
		Cell evectionaddresscell2 = evectionaddressrow2.getCell(13);
		evectionaddresscell2.setCellValue(obj.getEvectionaddress2());
		// 设置是否利用飞机
		String airplaneflag = obj.getAirplaneflag();
		setA4Airportflag(sheet, airplaneflag);
		// 设置同行人
		Row evectionconnectsrow = sheet.getRow(8);
		Cell evectionconnectscell = evectionconnectsrow.getCell(4);
		evectionconnectscell.setCellValue(obj.getEvectionconnects());
		// 设置出发自
		String evectionstart = obj.getEvectionstart();
		setA4Evectionstart(sheet, evectionstart);
		// 设置出差时间
		Row startrow = sheet.getRow(9);
		Cell startcell = startrow.getCell(4);
		startcell.setCellValue(obj.getApplystarttime());
		Row endrow = sheet.getRow(9);
		Cell endcell = endrow.getCell(11);
		endcell.setCellValue(obj.getApplyendtime());	
		// 设置订票明细
		setA4TicketDetail( sheet, obj);
		// 设置审核人
		String status = obj.getStatus();
		setA4Checkname( sheet,  status,  obj);	
		// 设置审核履历
		setA1Resume( sheet, obj);
	}
	/**
	 * 设置A1履历
	 * 
	 * @param sheet
	 *            sheet
	 * @param obj
	 *            数据集合
	 */
	public static void setA1Resume( Sheet sheet, ApplyFormCommand obj){
		int startindex = 28;
		List<ResumeEntity> list = obj.getList();
		if(list != null){
			if(list.size() != 0){
				for(int i=startindex; i<startindex+list.size(); i++){
					Row row = sheet.getRow(i);
					// 设置受理人
					Cell cell1 = row.getCell(1);
					cell1.setCellValue(list.get(i-startindex).getOperatorname());
					// 设置操作代码
					Cell cell2 = row.getCell(5);
					cell2.setCellValue(list.get(i-startindex).getOperationcddict());
					// 设置备注
					Cell cell3 = row.getCell(10);
					cell3.setCellValue(list.get(i-startindex).getRemark());
					// 设置处理时间
					Cell cell4 = row.getCell(19);
					cell4.setCellValue(list.get(i-startindex).getUpdatetime());
				}
			}
		}
	}
	/**
	 * 设置A1休假类型
	 * 
	 * @param sheet
	 *            sheet
	 * @param type
	 *            休假类型
	 */
	public static void setA1Vacatereasontype(Sheet sheet, String type){
		Row typerow = sheet.getRow(7);
		if(VACATEREASON_TYPE_0.equals(type)){			
			Cell typecell = typerow.getCell(0);
			typecell.setCellValue("●");
		}else if(VACATEREASON_TYPE_1.equals(type)){
			Cell typecell = typerow.getCell(4);
			typecell.setCellValue("●");
		}else if(VACATEREASON_TYPE_2.equals(type)){
			Cell typecell = typerow.getCell(7);
			typecell.setCellValue("●");
		}else if(VACATEREASON_TYPE_3.equals(type)){
			Cell typecell = typerow.getCell(10);
			typecell.setCellValue("●");
		}else if(VACATEREASON_TYPE_4.equals(type)){
			Cell typecell = typerow.getCell(13);
			typecell.setCellValue("●");
		}else if(VACATEREASON_TYPE_5.equals(type)){
			Cell typecell = typerow.getCell(16);
			typecell.setCellValue("●");
		}else if(VACATEREASON_TYPE_6.equals(type)){
			Cell typecell = typerow.getCell(19);
			typecell.setCellValue("●");
		}else if(VACATEREASON_TYPE_7.equals(type)){
			Cell typecell = typerow.getCell(22);
			typecell.setCellValue("●");
		}
	}
	/**
	 * 设置A1审核人
	 * 
	 * @param sheet
	 *            sheet
	 * @param status
	 *            状态
	 * @param obj
	 *            数据集合
	 */
	public static void setA1Checkname(Sheet sheet, String status, ApplyFormCommand obj){
		if(APPLY_STATUS_0.equals(status)){
			Row applyempnamerow = sheet.getRow(22);
			Cell applyempnamecell = applyempnamerow.getCell(23);
			applyempnamecell.setCellValue(obj.getApplyempname());
		}else if(APPLY_STATUS_1.equals(status)){
			Row applyempnamerow = sheet.getRow(22);
			Cell applyempnamecell = applyempnamerow.getCell(23);
			applyempnamecell.setCellValue(obj.getApplyempname());
		}else if(APPLY_STATUS_2.equals(status)){
			Row applyempnamerow = sheet.getRow(22);
			Cell applyempnamecell = applyempnamerow.getCell(23);
			applyempnamecell.setCellValue(obj.getApplyempname());
			Row managerchecknamerow = sheet.getRow(22);
			Cell managerchecknamecell = managerchecknamerow.getCell(20);
			managerchecknamecell.setCellValue(obj.getManagercheckname());
		}else if(APPLY_STATUS_3.equals(status)){
			Row applyempnamerow = sheet.getRow(22);
			Cell applyempnamecell = applyempnamerow.getCell(23);
			applyempnamecell.setCellValue(obj.getApplyempname());
			Row managerchecknamerow = sheet.getRow(22);
			Cell managerchecknamecell = managerchecknamerow.getCell(20);
			managerchecknamecell.setCellValue(obj.getManagercheckname());
			Row personnelchecknamerow = sheet.getRow(22);
			Cell personnelchecknamecell = personnelchecknamerow.getCell(17);
			personnelchecknamecell.setCellValue(obj.getPersonnelcheckname());
		}else if(APPLY_STATUS_4.equals(status)){
			Row applyempnamerow = sheet.getRow(22);
			Cell applyempnamecell = applyempnamerow.getCell(23);
			applyempnamecell.setCellValue(obj.getApplyempname());
			Row managerchecknamerow = sheet.getRow(22);
			Cell managerchecknamecell = managerchecknamerow.getCell(20);
			managerchecknamecell.setCellValue(obj.getManagercheckname());
			Row personnelchecknamerow = sheet.getRow(22);
			Cell personnelchecknamecell = personnelchecknamerow.getCell(17);
			personnelchecknamecell.setCellValue(obj.getPersonnelcheckname());				
			Row vicepresichecknamerow = sheet.getRow(22);
			Cell vicepresichecknamecell = vicepresichecknamerow.getCell(14);
			vicepresichecknamecell.setCellValue(obj.getVicepresicheckname());
		}else if(APPLY_STATUS_5.equals(status)){
			Row applyempnamerow = sheet.getRow(22);
			Cell applyempnamecell = applyempnamerow.getCell(23);
			applyempnamecell.setCellValue(obj.getApplyempname());
			Row managerchecknamerow = sheet.getRow(22);
			Cell managerchecknamecell = managerchecknamerow.getCell(20);
			managerchecknamecell.setCellValue(obj.getManagercheckname());
			Row personnelchecknamerow = sheet.getRow(22);
			Cell personnelchecknamecell = personnelchecknamerow.getCell(17);
			personnelchecknamecell.setCellValue(obj.getPersonnelcheckname());				
			Row vicepresichecknamerow = sheet.getRow(22);
			Cell vicepresichecknamecell = vicepresichecknamerow.getCell(14);
			vicepresichecknamecell.setCellValue(obj.getVicepresicheckname());
			Row presichecknamerow = sheet.getRow(22);
			Cell presichecknamecell = presichecknamerow.getCell(11);
			presichecknamecell.setCellValue(obj.getPresicheckname());
		}else if(APPLY_STATUS_6.equals(status)||APPLY_STATUS_7.equals(status)){
			Row applyempnamerow = sheet.getRow(22);
			Cell applyempnamecell = applyempnamerow.getCell(23);
			applyempnamecell.setCellValue(obj.getApplyempname());
			Row managerchecknamerow = sheet.getRow(22);
			Cell managerchecknamecell = managerchecknamerow.getCell(20);
			managerchecknamecell.setCellValue(obj.getManagercheckname());
			Row personnelchecknamerow = sheet.getRow(22);
			Cell personnelchecknamecell = personnelchecknamerow.getCell(17);
			personnelchecknamecell.setCellValue(obj.getPersonnelcheckname());				
			Row vicepresichecknamerow = sheet.getRow(22);
			Cell vicepresichecknamecell = vicepresichecknamerow.getCell(14);
			vicepresichecknamecell.setCellValue(obj.getVicepresicheckname());
			Row presichecknamerow = sheet.getRow(22);
			Cell presichecknamecell = presichecknamerow.getCell(11);
			presichecknamecell.setCellValue(obj.getPresicheckname());
			Row personfilechecknamerow = sheet.getRow(22);
			Cell personfilechecknamecell = personfilechecknamerow.getCell(7);
			personfilechecknamecell.setCellValue(obj.getPersonfilecheckname());
		}
	}
	/**
	 * 设置A3加班类型
	 * 
	 * @param sheet
	 *            sheet
	 * @param type
	 *            加班类型
	 */
	public static void setA3Extraworkapplytype(Sheet sheet, String extraworkapplytype){
		Row typerow = sheet.getRow(8);
		if(VACATEREASON_TYPE_0.equals(extraworkapplytype)){			
			Cell typecell = typerow.getCell(6);
			typecell.setCellValue("●");
		}else if(VACATEREASON_TYPE_1.equals(extraworkapplytype)){
			Cell typecell = typerow.getCell(9);
			typecell.setCellValue("●");
		}else if(VACATEREASON_TYPE_2.equals(extraworkapplytype)){
			Cell typecell = typerow.getCell(12);
			typecell.setCellValue("●");
		}
	}	
	/**
	 * 设置A3是否出差地加班
	 * 
	 * @param sheet
	 *            sheet
	 * @param type
	 *            是否出差地加班
	 */
	public static void setA3Evectionworkflag(Sheet sheet, String evectionworkflag){
		Row typerow = sheet.getRow(9);
		if(FLAG_1.equals(evectionworkflag)){			
			Cell typecell = typerow.getCell(9);
			typecell.setCellValue("●");
		}else if(FLAG_0.equals(evectionworkflag)){
			Cell typecell = typerow.getCell(12);
			typecell.setCellValue("●");
		}
	}
	/**
	 * 设置A3审核人
	 * 
	 * @param sheet
	 *            sheet
	 * @param status
	 *            状态
	 * @param obj
	 *            数据集合
	 */
	public static void setA3Checkname(Sheet sheet, String status, String checklevel, ApplyFormCommand obj){
		if(CHECKLEVEL_1.equals(checklevel)){	
			if(APPLY_STATUS_0.equals(status)){
				//申请人
				Row applyempnamerow = sheet.getRow(14);
				Cell applyempnamecell = applyempnamerow.getCell(23);
				applyempnamecell.setCellValue(obj.getApplyempname());
			}else if(APPLY_STATUS_1.equals(status)){
				//申请人
				Row applyempnamerow = sheet.getRow(14);
				Cell applyempnamecell = applyempnamerow.getCell(23);
				applyempnamecell.setCellValue(obj.getApplyempname());
			}else if(APPLY_STATUS_2.equals(status)){
				//申请人
				Row applyempnamerow = sheet.getRow(14);
				Cell applyempnamecell = applyempnamerow.getCell(23);
				applyempnamecell.setCellValue(obj.getApplyempname());
				//经理
				Row managerchecknamerow = sheet.getRow(14);
				Cell managerchecknamecell = managerchecknamerow.getCell(20);
				managerchecknamecell.setCellValue(obj.getManagercheckname());
			}
		}else if(CHECKLEVEL_2.equals(checklevel)){	
			if(APPLY_STATUS_0.equals(status)){
				//申请人
				Row applyempnamerow = sheet.getRow(14);
				Cell applyempnamecell = applyempnamerow.getCell(23);
				applyempnamecell.setCellValue(obj.getApplyempname());
				//经理
				Row managerchecknamerow = sheet.getRow(14);
				Cell managerchecknamecell = managerchecknamerow.getCell(20);
				managerchecknamecell.setCellValue(obj.getManagercheckname());
				//副总
				Row vicepresichecknamerow = sheet.getRow(14);
				Cell vicepresichecknamecell = vicepresichecknamerow.getCell(17);
				vicepresichecknamecell.setCellValue(obj.getVicepresicheckname());
				//申请人
				Row applyempnamerow1 = sheet.getRow(22);
				Cell applyempnamecell1 = applyempnamerow1.getCell(23);
				applyempnamecell1.setCellValue(obj.getApplyempname());
			}else if(APPLY_STATUS_1.equals(status)){
				//申请人
				Row applyempnamerow = sheet.getRow(14);
				Cell applyempnamecell = applyempnamerow.getCell(23);
				applyempnamecell.setCellValue(obj.getApplyempname());
				//经理
				Row managerchecknamerow = sheet.getRow(14);
				Cell managerchecknamecell = managerchecknamerow.getCell(20);
				managerchecknamecell.setCellValue(obj.getManagercheckname());
				//副总
				Row vicepresichecknamerow = sheet.getRow(14);
				Cell vicepresichecknamecell = vicepresichecknamerow.getCell(17);
				vicepresichecknamecell.setCellValue(obj.getVicepresicheckname());
				//申请人
				Row applyempnamerow1 = sheet.getRow(22);
				Cell applyempnamecell1 = applyempnamerow1.getCell(23);
				applyempnamecell1.setCellValue(obj.getApplyempname());
			}else if(APPLY_STATUS_2.equals(status)){				
				//申请人
				Row applyempnamerow = sheet.getRow(14);
				Cell applyempnamecell = applyempnamerow.getCell(23);
				applyempnamecell.setCellValue(obj.getApplyempname());
				//经理
				Row managerchecknamerow = sheet.getRow(14);
				Cell managerchecknamecell = managerchecknamerow.getCell(20);
				managerchecknamecell.setCellValue(obj.getManagercheckname());
				//副总
				Row vicepresichecknamerow = sheet.getRow(14);
				Cell vicepresichecknamecell = vicepresichecknamerow.getCell(17);
				vicepresichecknamecell.setCellValue(obj.getVicepresicheckname());
				//申请人
				Row applyempnamerow1 = sheet.getRow(22);
				Cell applyempnamecell1 = applyempnamerow1.getCell(23);
				applyempnamecell1.setCellValue(obj.getApplyempname());
				//经理
				Row managerchecknamerow1 = sheet.getRow(21);
				Cell managerchecknamecell1 = managerchecknamerow1.getCell(20);
				managerchecknamecell1.setCellValue(obj.getManagercheckname());
			}else if(APPLY_STATUS_5.equals(status)){				
				//申请人
				Row applyempnamerow = sheet.getRow(14);
				Cell applyempnamecell = applyempnamerow.getCell(23);
				applyempnamecell.setCellValue(obj.getApplyempname());
				//经理
				Row managerchecknamerow = sheet.getRow(14);
				Cell managerchecknamecell = managerchecknamerow.getCell(20);
				managerchecknamecell.setCellValue(obj.getManagercheckname());
				//副总
				Row vicepresichecknamerow = sheet.getRow(14);
				Cell vicepresichecknamecell = vicepresichecknamerow.getCell(17);
				vicepresichecknamecell.setCellValue(obj.getVicepresicheckname());
				//申请人
				Row applyempnamerow1 = sheet.getRow(22);
				Cell applyempnamecell1 = applyempnamerow1.getCell(23);
				applyempnamecell1.setCellValue(obj.getApplyempname());
				//经理
				Row managerchecknamerow1 = sheet.getRow(22);
				Cell managerchecknamecell1 = managerchecknamerow1.getCell(20);
				managerchecknamecell1.setCellValue(obj.getManagercheckname());
				//总经理
				Row presichecknamerow = sheet.getRow(22);
				Cell presichecknamecell = presichecknamerow.getCell(17);
				presichecknamecell.setCellValue(obj.getPresicheckname());
			}else if(APPLY_STATUS_6.equals(status)||APPLY_STATUS_7.equals(status)){
				//申请人
				Row applyempnamerow = sheet.getRow(14);
				Cell applyempnamecell = applyempnamerow.getCell(23);
				applyempnamecell.setCellValue(obj.getApplyempname());
				//经理
				Row managerchecknamerow = sheet.getRow(14);
				Cell managerchecknamecell = managerchecknamerow.getCell(20);
				managerchecknamecell.setCellValue(obj.getManagercheckname());
				//副总
				Row vicepresichecknamerow = sheet.getRow(14);
				Cell vicepresichecknamecell = vicepresichecknamerow.getCell(17);
				vicepresichecknamecell.setCellValue(obj.getVicepresicheckname());
				//申请人
				Row applyempnamerow1 = sheet.getRow(22);
				Cell applyempnamecell1 = applyempnamerow1.getCell(23);
				applyempnamecell1.setCellValue(obj.getApplyempname());
				//经理
				Row managerchecknamerow1 = sheet.getRow(22);
				Cell managerchecknamecell1 = managerchecknamerow1.getCell(20);
				managerchecknamecell1.setCellValue(obj.getManagercheckname());
				//总经理
				Row presichecknamerow = sheet.getRow(22);
				Cell presichecknamecell = presichecknamerow.getCell(17);
				presichecknamecell.setCellValue(obj.getPresicheckname());
				//人事归档				
				Row personfilechecknamerow = sheet.getRow(22);
				Cell personfilechecknamecell = personfilechecknamerow.getCell(11);
				personfilechecknamecell.setCellValue(obj.getPersonfilecheckname());
			}
		}
	}
	/**
	 * 设置A4是否利用飞机
	 * 
	 * @param sheet
	 *            sheet
	 * @param type
	 *            是否利用飞机
	 */
	public static void setA4Airportflag(Sheet sheet, String airportflag){
		Row typerow = sheet.getRow(7);
		if(FLAG_0.equals(airportflag)){			
			Cell typecell = typerow.getCell(21);
			typecell.setCellValue("●");
		}else if(FLAG_1.equals(airportflag)){
			Cell typecell = typerow.getCell(23);
			typecell.setCellValue("●");
		}
	}
	/**
	 * 设置A4出发自
	 * 
	 * @param sheet
	 *            sheet
	 * @param type
	 *            出发自
	 */
	public static void setA4Evectionstart(Sheet sheet, String evectionstart){
		Row typerow = sheet.getRow(8);
		if(FLAG_0.equals(evectionstart)){			
			Cell typecell = typerow.getCell(14);
			typecell.setCellValue("●");
		}else if(FLAG_1.equals(evectionstart)){
			Cell typecell = typerow.getCell(17);
			typecell.setCellValue("●");
		}
	}
	/**
	 * 设置A4审核人
	 * 
	 * @param sheet
	 *            sheet
	 * @param status
	 *            状态
	 * @param obj
	 *            数据集合
	 */
	public static void setA4Checkname(Sheet sheet, String status, ApplyFormCommand obj){
		if(APPLY_STATUS_0.equals(status)){
			Row applyempnamerow = sheet.getRow(22);
			Cell applyempnamecell = applyempnamerow.getCell(23);
			applyempnamecell.setCellValue(obj.getApplyempname());
		}else if(APPLY_STATUS_1.equals(status)){
			Row applyempnamerow = sheet.getRow(22);
			Cell applyempnamecell = applyempnamerow.getCell(23);
			applyempnamecell.setCellValue(obj.getApplyempname());
		}else if(APPLY_STATUS_2.equals(status)){
			Row applyempnamerow = sheet.getRow(22);
			Cell applyempnamecell = applyempnamerow.getCell(23);
			applyempnamecell.setCellValue(obj.getApplyempname());
			Row managerchecknamerow = sheet.getRow(22);
			Cell managerchecknamecell = managerchecknamerow.getCell(20);
			managerchecknamecell.setCellValue(obj.getManagercheckname());
		}else if(APPLY_STATUS_4.equals(status)){
			Row applyempnamerow = sheet.getRow(22);
			Cell applyempnamecell = applyempnamerow.getCell(23);
			applyempnamecell.setCellValue(obj.getApplyempname());
			Row managerchecknamerow = sheet.getRow(22);
			Cell managerchecknamecell = managerchecknamerow.getCell(20);
			managerchecknamecell.setCellValue(obj.getManagercheckname());
			Row vicepresichecknamerow = sheet.getRow(22);
			Cell vicepresichecknamecell = vicepresichecknamerow.getCell(17);
			vicepresichecknamecell.setCellValue(obj.getVicepresicheckname());
		}else if(APPLY_STATUS_5.equals(status)){
			Row applyempnamerow = sheet.getRow(22);
			Cell applyempnamecell = applyempnamerow.getCell(23);
			applyempnamecell.setCellValue(obj.getApplyempname());
			Row managerchecknamerow = sheet.getRow(22);
			Cell managerchecknamecell = managerchecknamerow.getCell(20);
			managerchecknamecell.setCellValue(obj.getManagercheckname());
			Row vicepresichecknamerow = sheet.getRow(22);
			Cell vicepresichecknamecell = vicepresichecknamerow.getCell(17);
			vicepresichecknamecell.setCellValue(obj.getVicepresicheckname());	
			Row presichecknamerow = sheet.getRow(22);
			Cell presichecknamecell = presichecknamerow.getCell(14);
			presichecknamecell.setCellValue(obj.getPresicheckname());
		}else if(APPLY_STATUS_6.equals(status)||APPLY_STATUS_7.equals(status)){
			Row applyempnamerow = sheet.getRow(22);
			Cell applyempnamecell = applyempnamerow.getCell(23);
			applyempnamecell.setCellValue(obj.getApplyempname());
			Row managerchecknamerow = sheet.getRow(22);
			Cell managerchecknamecell = managerchecknamerow.getCell(20);
			managerchecknamecell.setCellValue(obj.getManagercheckname());			
			Row vicepresichecknamerow = sheet.getRow(22);
			Cell vicepresichecknamecell = vicepresichecknamerow.getCell(17);
			vicepresichecknamecell.setCellValue(obj.getVicepresicheckname());
			Row presichecknamerow = sheet.getRow(22);
			Cell presichecknamecell = presichecknamerow.getCell(14);
			presichecknamecell.setCellValue(obj.getPresicheckname());
			Row personfilechecknamerow = sheet.getRow(22);
			Cell personfilechecknamecell = personfilechecknamerow.getCell(10);
			personfilechecknamecell.setCellValue(obj.getPersonfilecheckname());
		}
	}
	/**
	 * 设置A4订票明细
	 * 
	 * @param sheet
	 *            sheet
	 * @param obj
	 *            数据集合
	 */
	public static void setA4TicketDetail( Sheet sheet, ApplyFormCommand obj){
		int startindex = 12;
		TicketDetail[] detail = obj.getTicketdetail();
		if(detail != null){
			if(detail.length != 0){
				for(int i=startindex; i<startindex+detail.length; i++){
					Row row = sheet.getRow(i);
					// 设置日期
					Cell cell1 = row.getCell(1);
					cell1.setCellValue(detail[i-startindex].getOrderdate());
					// 设置航班
					Cell cell2 = row.getCell(5);
					cell2.setCellValue(detail[i-startindex].getFlight());
					// 设置出发
					Cell cell3 = row.getCell(8);
					cell3.setCellValue(detail[i-startindex].getStart());
					// 设置到达
					Cell cell4 = row.getCell(12);
					cell4.setCellValue(detail[i-startindex].getReach());
					// 设置是否折扣
					Cell cell5 = row.getCell(16);
					if(FLAG_0.equals(detail[i-startindex].getDiscountflag())){
						cell5.setCellValue("全价");
					}else if(FLAG_1.equals(detail[i-startindex].getDiscountflag())){
						cell5.setCellValue("折扣");
					}
					// 设置是否出票
					Cell cell6 = row.getCell(19);
					if(FLAG_0.equals(detail[i-startindex].getTicketflag())){
						cell6.setCellValue("否");
					}else if(FLAG_1.equals(detail[i-startindex].getTicketflag())){
						cell6.setCellValue("是");
					}
				}
			}
		}
	}
}
