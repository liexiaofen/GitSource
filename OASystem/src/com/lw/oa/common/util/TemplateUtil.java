package com.lw.oa.common.util;

import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.lw.oa.common.command.ApplyFormCommand;
import com.lw.oa.common.command.ResumeEntity;

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
	 * 设置A1履历
	 * 
	 * @param sheet
	 *            sheet
	 * @param type
	 *            休假类型
	 */
	public static void setA1Vacatereasontype(Sheet sheet, String type){
		Row typerow = sheet.getRow(7);
		if("0".equals(type)){			
			Cell typecell = typerow.getCell(0);
			typecell.setCellValue("●");
		}else if("1".equals(type)){
			Cell typecell = typerow.getCell(4);
			typecell.setCellValue("●");
		}else if("2".equals(type)){
			Cell typecell = typerow.getCell(7);
			typecell.setCellValue("●");
		}else if("3".equals(type)){
			Cell typecell = typerow.getCell(10);
			typecell.setCellValue("●");
		}else if("4".equals(type)){
			Cell typecell = typerow.getCell(13);
			typecell.setCellValue("●");
		}else if("5".equals(type)){
			Cell typecell = typerow.getCell(16);
			typecell.setCellValue("●");
		}else if("6".equals(type)){
			Cell typecell = typerow.getCell(19);
			typecell.setCellValue("●");
		}else if("7".equals(type)){
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
		if("0".equals(status)){
			Row applyempnamerow = sheet.getRow(22);
			Cell applyempnamecell = applyempnamerow.getCell(23);
			applyempnamecell.setCellValue(obj.getApplyempname());
		}else if("1".equals(status)){
			Row applyempnamerow = sheet.getRow(22);
			Cell applyempnamecell = applyempnamerow.getCell(23);
			applyempnamecell.setCellValue(obj.getApplyempname());
		}else if("2".equals(status)){
			Row applyempnamerow = sheet.getRow(22);
			Cell applyempnamecell = applyempnamerow.getCell(23);
			applyempnamecell.setCellValue(obj.getApplyempname());
			Row managerchecknamerow = sheet.getRow(22);
			Cell managerchecknamecell = managerchecknamerow.getCell(20);
			managerchecknamecell.setCellValue(obj.getManagercheckname());
		}else if("3".equals(status)){
			Row applyempnamerow = sheet.getRow(22);
			Cell applyempnamecell = applyempnamerow.getCell(23);
			applyempnamecell.setCellValue(obj.getApplyempname());
			Row managerchecknamerow = sheet.getRow(22);
			Cell managerchecknamecell = managerchecknamerow.getCell(20);
			managerchecknamecell.setCellValue(obj.getManagercheckname());
			Row personnelchecknamerow = sheet.getRow(22);
			Cell personnelchecknamecell = personnelchecknamerow.getCell(17);
			personnelchecknamecell.setCellValue(obj.getPersonnelcheckname());
		}else if("4".equals(status)){
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
		}else if("5".equals(status)){
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
		}else if("6".equals(status)||"7".equals(status)){
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
}
