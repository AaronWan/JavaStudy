package com.utils.poi;

import junit.framework.TestCase;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelUtilTest extends TestCase {
	public void testExcel() {
		try {
			HSSFWorkbook hw = ExcelUtil.createExcel("测试");
			ExcelUtil.writeCell(hw.getSheetAt(0), ExcelUtil.getBodyHssfCellStyle(hw), "测试测试", 12, 3);
			ExcelUtil.saveExcel(hw, "c:\\test.xls");
			ExcelUtil.writeCell(hw.getSheetAt(1), ExcelUtil.getBodyHssfCellStyle(hw), "测试测试222",
					12, 3);
			ExcelUtil.saveExcel(hw, "c:\\test.xls");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
