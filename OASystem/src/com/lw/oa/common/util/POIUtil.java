package com.lw.oa.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.lw.oa.common.command.ApplyFormCommand;
/**
 * *@author yuliang
 */
public class POIUtil implements ConstantUtil {
	/**
	 * 申请单下载
	 * 
	 * @param response
	 *            response对象
	 * @param tempPath
	 *            EXCEL模板目录
	 * @param tempFilename
	 *            模板文件名
	 * @param obj
	 *            数据集合
	 * @throws IOException
	 * @throws ParseException
	 */
	public static void applyFormDownload(HttpServletResponse response,
			String tempPath, String tempFilename, ApplyFormCommand obj) throws Exception {
		FileInputStream is = null;
		OutputStream out = null;
		try {
			Workbook workbook = null; // 变量声明
			File in = new File(tempPath + tempFilename);// 创建文件对象
			is = new FileInputStream(in);// 文件流
			workbook = WorkbookFactory.create(is); // 同时支持Excel 2003、2007、2010
			// 模板数据处理
			templateDataProcess(workbook, obj);
			// 文件名设定
			String filename = obj.getApplyempname() + "_" + obj.getApplyno() + ".xlsx";
			workbook.setActiveSheet(0);
			String mimetype = " application/octet-stream;charset=ISO8859-1 ";
			response.setContentType(mimetype);
			filename = new String(filename.getBytes("GB2312"), "ISO-8859-1");
			response.setHeader("Content-disposition", "attachment; filename="
					+ filename);
			response.setCharacterEncoding("UTF-8");
			out = response.getOutputStream();
			// 保存报表文件
			workbook.write(out);
			out.close();
			response.flushBuffer();
		} catch (Exception ex) {
			throw ex;
		} finally {
			if (is != null) {
				is.close();
			}
			if (out != null) {
				out.close();
			}
		}
	}
	/**
	 * 文件生成
	 * 
	 * @param response
	 *            response对象
	 * @param tempPath
	 *            EXCEL模板目录
	 * @param tempFilename
	 *            模板文件名
	  * @param serverPath
	 *            服务器路径          
	 * @param obj
	 *            数据集合
	 * @throws IOException
	 * @throws ParseException
	 */	
	public static void fileGenerate( String tempPath, String tempFileName, String serverPath, ApplyFormCommand obj) throws Exception {
		FileInputStream is = null;
		OutputStream out = null;
		try {
			Workbook workbook = null; // 变量声明
			File in = new File(tempPath+tempFileName);// 创建文件对象
			is = new FileInputStream(in);// 文件流
			workbook = WorkbookFactory.create(is); // 同时支持Excel 2003、2007、2010
			// 模板数据处理
			templateDataProcess(workbook, obj);
			// 文件名设定
			String filename = obj.getApplyempname()+"_"+obj.getApplyno() + ".xlsx";
			workbook.setActiveSheet(0);
			//创建服务器目录
			serverPath = serverPath + "\\" + DateUtil.getSystemTime(DATE_FORMAT_YYYYMMDD);
			FileUtil.mkdirs(serverPath);
			out = new FileOutputStream(serverPath+"\\"+filename);
			// 保存报表文件
			workbook.write(out);
			out.close();
		} catch (Exception ex) {
			throw ex;
		} finally {
			if (is != null) {
				is.close();
			}
			if (out != null) {
				out.close();
			}
		}
	}
	/**
	 * 模板数据处理
	 * 
	 * @param workbook
	 *            工作簿
	 * @param obj
	 *            数据集合
	 */
	public static void templateDataProcess( Workbook workbook, ApplyFormCommand obj){
		if(APPLY_A1.equals(obj.getApplytype())){
			TemplateUtil.templateA1write(workbook, obj);
		}else if(APPLY_A2.equals(obj.getApplytype())){
			TemplateUtil.templateA2write(workbook, obj);
		}else if(APPLY_A3.equals(obj.getApplytype())){
			TemplateUtil.templateA3write(workbook, obj);
		}else if(APPLY_A4.equals(obj.getApplytype())){
			TemplateUtil.templateA4write(workbook, obj);
		}else if(APPLY_A5.equals(obj.getApplytype())){
			TemplateUtil.templateA5write(workbook, obj);
		}
	}
	/**
	 * 根据申请类型获取模板
	 * 
	 * @param type
	 *            申请类型
	 * @return 字符串           
	 */
	public static String getTemplateFileName(String type){
		String tempFileName = StringUtils.EMPTY;
		if(APPLY_A1.equals(type)){
			tempFileName = TEMPLATE_A1_FILE;
		}else if(APPLY_A2.equals(type)){
			tempFileName = TEMPLATE_A2_FILE;
		}else if(APPLY_A3.equals(type)){
			tempFileName = TEMPLATE_A3_FILE;
		}else if(APPLY_A4.equals(type)){
			tempFileName = TEMPLATE_A4_FILE;
		}else if(APPLY_A5.equals(type)){
			tempFileName = TEMPLATE_A5_FILE;
		}
		return tempFileName;
	}
	
	
	
	public String getCellValue(Cell cell, int cellType) {
		String cellValue = null;
	    SimpleDateFormat fmt = new SimpleDateFormat(DATE_FORMAT_YMD);
		switch (cellType) {
			case Cell.CELL_TYPE_STRING: // 文本
				cellValue = cell.getStringCellValue();
				break;
			case Cell.CELL_TYPE_NUMERIC: // 数字、日期
				try {
					cellValue = fmt.format(cell.getDateCellValue()); // 日期型
				} catch(Exception e) {
					cellValue = String.valueOf(cell.getNumericCellValue()); // 数字
				}
				break;
			case Cell.CELL_TYPE_BOOLEAN: // 布尔型
				cellValue = String.valueOf(cell.getBooleanCellValue());
				break;
			case Cell.CELL_TYPE_BLANK: // 空白
				cellValue = cell.getStringCellValue();
				break;
			case Cell.CELL_TYPE_ERROR: // 错误
				cellValue = cell.getStringCellValue();
				break;
			case Cell.CELL_TYPE_FORMULA: // 公式
				cellValue = cell.getStringCellValue();
				break;
			default:
				cellValue = cell.getStringCellValue();
		}
		return cellValue;
	}
}
