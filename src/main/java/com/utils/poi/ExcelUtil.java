package com.utils.poi;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.hssf.util.HSSFColor;

@SuppressWarnings("deprecation")
public class ExcelUtil {
	/**
	 * 保存EXCEL到文件（只能是2003格式,.xls）
	 * 
	 * @param hw
	 * @param filePath
	 * @throws Exception
	 */
	public static void saveExcel(HSSFWorkbook hw, String filePath) throws Exception{
		if(hw == null){
			throw new NullPointerException("EXCEL对象为null，保存失败");
		}
		if(filePath == null){
			throw new NullPointerException("保存文件地址为null，保存失败");
		}
		if(filePath.length() < 0 || !filePath.endsWith(".xls")){
			throw new RuntimeException("保存的EXCEL文件地址错误，且必须是.xls格式，保存失败");
		}
		FileOutputStream file = new FileOutputStream(new File(filePath));
		hw.write(file);
	}
	
	/**
	 * 创建EXCEL对象，并创建sheet页,指定sheet页名称
	 * 
	 * @param sheetName
	 * @return
	 * @throws Exception
	 */
	public static HSSFWorkbook createExcel(String sheetName) throws Exception{
		if(sheetName == null){
			throw new NullPointerException("sheet名称为null，创建EXCEL失败");
		}
		HSSFWorkbook hw = new HSSFWorkbook();
		hw.createSheet(sheetName);
		return hw;
	}
	
	/**
	 * 往sheet页中指定行，列的单元格中写入值
	 * 
	 * @param sheet
	 * @param value
	 * @param rowNum
	 * @param columnNum
	 */
	public static void writeCell(HSSFSheet sheet, HSSFCellStyle hcs, Object value, int rowNum, int columnNum ) throws Exception{
		if(sheet == null){
			throw new NullPointerException("sheet页为null，写入失败");
		}
		if(value == null){
			throw new NullPointerException("传入的value为null，写入失败");
		}
		if(columnNum < 0 || columnNum > 255){
			throw new RuntimeException("列值必须在合法的范围内[0,255]，columnNum = " + columnNum);
		}
		if( rowNum < 0 || rowNum > 65535){
			throw new RuntimeException("行值必须在合法的范围内[0,65535]，rowNum = " + rowNum);
		}
		
		HSSFRow row = sheet.getRow(rowNum);
		if(row == null){
			row = sheet.createRow(rowNum);
		}
		HSSFCell cell = row.getCell(columnNum);
		if(cell == null){
			cell = row.createCell(columnNum);
		}
		
		
		cell.setCellStyle(hcs);
		cell.setCellValue(value.toString());
	}
	
	public static HSSFCellStyle getBodyHssfCellStyle(HSSFWorkbook hw){
		HSSFCellStyle hcs = hw.createCellStyle();
		hcs.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		hcs.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		
		HSSFFont font = hw.createFont();
		font.setFontName("微软雅黑");
		hcs.setFont(font);
		
		return hcs;
	}
	
	public static HSSFCellStyle getHeadHssfCellStyle(HSSFWorkbook hw){
		HSSFCellStyle hcs = hw.createCellStyle();
		hcs.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		hcs.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		hcs.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND); 
		hcs.setFillForegroundColor(HSSFColor.LIGHT_BLUE.index); 
		
		HSSFFont font = hw.createFont();
		font.setFontName("微软雅黑");
		font.setFontHeightInPoints((short)11);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
		hcs.setFont(font);
		return hcs;
	}
	
	public static void setAutoColumnSize(HSSFSheet sheet){
		if(sheet != null){
			for(short i = 0; i<256; i++){
				sheet.autoSizeColumn(i);
			}
		}
	}
	/**
	 * 合并单元格
	 * @param sheet  
	 * @param startRow 起始行号
	 * @param endRow 终止行号
	 * @param startCol 起始列号
	 * @param endCol 终止列号
	 */
	public static void mergeCell(HSSFSheet sheet,int startRow,int endRow,int startCol,int endCol){
		sheet.addMergedRegion(new CellRangeAddress(0,0,1,2));
	}
	public static void main(String[] args) {
		try {
			HSSFWorkbook hw = createExcel("测试");
			writeCell(hw.getSheetAt(0), getBodyHssfCellStyle(hw), "测试测试", 12, 3);
			saveExcel(hw, "c:\\test.xls");
		} catch (Exception e) {
			e.printStackTrace();
		}
	} 
	
}
