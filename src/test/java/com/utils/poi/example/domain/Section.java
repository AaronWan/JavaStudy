package com.utils.poi.example.domain;

import java.util.List;

import com.utils.poi.excelparser.annotations.ExcelField;
import com.utils.poi.excelparser.annotations.ExcelObject;
import com.utils.poi.excelparser.annotations.MappedExcelObject;
import com.utils.poi.excelparser.annotations.ParseType;

@ExcelObject(parseType = ParseType.COLUMN, start = 2, end = 2)
public class Section {

	@ExcelField(position = 2)
	private String year;

	@ExcelField(position = 3)
	private String section;
	
	@MappedExcelObject
	private List<Student> students;

	public List<Student> getStudents() {
    	return students;
    }

	public String getYear() {
		return year;
	}

	public String getSection() {
		return section;
	}
}
