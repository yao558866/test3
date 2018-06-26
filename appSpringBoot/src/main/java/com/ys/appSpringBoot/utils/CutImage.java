package com.ys.appSpringBoot.utils;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
/** 
 * 图片裁剪 
 * @param srcImageFile 图片裁剪地址 
 * @param result 图片输出文件夹 
 * @param destWidth 图片裁剪宽度 
 * @param destHeight 图片裁剪高度 
 */ 
public class CutImage {
	public static void main(String[] args) {
		cutImage("d:\\pwd.png","d:\\pwd1.png",0,0,1080,1920);
	}
	public final static void cutImage(String srcImageFile, String result, int x,int y, int destWidth, int destHeight) {  
		try {  
			Thread.sleep(1000);
	        Iterator iterator = ImageIO.getImageReadersByFormatName("PNG");/*PNG,BMP*/     
	        ImageReader reader = (ImageReader)iterator.next();/*获取图片尺寸*/  
	        InputStream inputStream = new FileInputStream(srcImageFile);    
	        ImageInputStream iis = ImageIO.createImageInputStream(inputStream);     
	        reader.setInput(iis, true);     
	        ImageReadParam param = reader.getDefaultReadParam();     
	        Rectangle rectangle = new Rectangle(x,y, destWidth, destHeight);/*指定截取范围*/      
	        param.setSourceRegion(rectangle);     
	        BufferedImage bi = reader.read(0,param);   
	        ImageIO.write(bi, "JPEG", new File(result));
	    } catch (Exception e) {  
	    	e.printStackTrace();
	        System.out.println(("图片裁剪出现异常:"+e));
	    }  
	}  
}
