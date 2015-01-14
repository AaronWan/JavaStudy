package com.utils.poi.excelparser.exception;

public class ExcelParsingException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7588967789227560998L;

	public ExcelParsingException(String message) {
		super(message);
	}

	public ExcelParsingException(String message, Exception exception) {
		super(message, exception);
	}

}
