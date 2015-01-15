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
		String path=QrCodeUtils.encoderQrCode("我是java生成的二维码");
		System.out.println(path);
		assertTrue(new File(path).exists());
		assertEquals(QrCodeUtils.decoderQRCode(path),"我是java生成的二维码");
	}
	

}
