package com.utils.qrcode;

import java.io.File;

import junit.framework.TestCase;

public class QrCodeUtilsTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testEncoderQrCode(){
		String path=QrCodeUtils.encoderQrCode("http://www.hwbuluo.com");
		System.out.println(path);
		assertTrue(new File(path).exists());
		assertEquals(QrCodeUtils.decoderQRCode(path),"http://www.hwbuluo.com");
	}
	

}
