package com.utils.qrcode;  
  
import java.awt.image.BufferedImage;  
  
import jp.sourceforge.qrcode.data.QRCodeImage;  
  
public class CustomQrCodeImage implements QRCodeImage {  
  
    BufferedImage bufImg;  
      
    public CustomQrCodeImage(BufferedImage bufImg) {  
        this.bufImg = bufImg;  
    }  
      
    public int getHeight() {  
        return bufImg.getHeight();  
    }  
  
    public int getPixel(int x, int y) {  
        return bufImg.getRGB(x, y);  
    }  
  
    public int getWidth() {  
        return bufImg.getWidth();  
    }  
  
}  