package com.ys.appSpringBoot.utils;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class addimage {
	public static void main(String[] args) {
		String[] files={"E:\\sxt111\\appSpringBoot\\image\\0.png",
				"E:\\sxt111\\appSpringBoot\\image\\1.png",
				"E:\\sxt111\\appSpringBoot\\image\\2.png",
				"E:\\sxt111\\appSpringBoot\\image\\3.png",
				"E:\\sxt111\\appSpringBoot\\image\\4.png",
				"E:\\sxt111\\appSpringBoot\\image\\5.png",
				"E:\\sxt111\\appSpringBoot\\image\\6.png",
				"E:\\sxt111\\appSpringBoot\\image\\7.png",
				"E:\\sxt111\\appSpringBoot\\image\\8.png",
				"E:\\sxt111\\appSpringBoot\\image\\9.png"
		};
		mergeImage(files,1,"E:\\sxt111\\appSpringBoot\\image\\100.png");
	}
	/** 
     * @Description:图片拼接 （注意：必须两张图片长宽一致哦） 
     * @author:liuyc 
     * @time:2016年5月27日 下午5:52:24 
     * @param files 要拼接的文件列表 
     * @param type1  横向拼接， 2 纵向拼接 
     */  
    public static void mergeImage(String[] files, int type, String targetFile) {  
        int len = files.length;  
        if (len < 1) {  
            throw new RuntimeException("图片数量小于1");  
        }  
        File[] src = new File[len];  
        BufferedImage[] images = new BufferedImage[len];  
        int[][] ImageArrays = new int[len][];  
        for (int i = 0; i < len; i++) {  
            try {  
                src[i] = new File(files[i]);  
                images[i] = ImageIO.read(src[i]);  
            } catch (Exception e) {  
                throw new RuntimeException(e);  
            }  
            int width = images[i].getWidth();  
            int height = images[i].getHeight();  
            ImageArrays[i] = new int[width * height];  
            ImageArrays[i] = images[i].getRGB(0, 0, width, height, ImageArrays[i], 0, width);  
        }  
        int newHeight = 0;  
        int newWidth = 0;  
        for (int i = 0; i < images.length; i++) {  
            // 横向  
            if (type == 1) {  
                newHeight = newHeight > images[i].getHeight() ? newHeight : images[i].getHeight();  
                newWidth += images[i].getWidth();  
            } else if (type == 2) {// 纵向  
                newWidth = newWidth > images[i].getWidth() ? newWidth : images[i].getWidth();  
                newHeight += images[i].getHeight();  
            }  
        }  
        if (type == 1 && newWidth < 1) {  
            return;  
        }  
        if (type == 2 && newHeight < 1) {  
            return;  
        }  
  
        // 生成新图片  
        try {  
            BufferedImage ImageNew = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);  
            int height_i = 0;  
            int width_i = 0;  
            for (int i = 0; i < images.length; i++) {  
                if (type == 1) {  
                    ImageNew.setRGB(width_i, 0, images[i].getWidth(), newHeight, ImageArrays[i], 0,  
                            images[i].getWidth());  
                    width_i += images[i].getWidth();  
                } else if (type == 2) {  
                    ImageNew.setRGB(0, height_i, newWidth, images[i].getHeight(), ImageArrays[i], 0, newWidth);  
                    height_i += images[i].getHeight();  
                }  
            }  
            //输出想要的图片  
            ImageIO.write(ImageNew, targetFile.split("\\.")[1], new File(targetFile));  
  
        } catch (Exception e) {  
            throw new RuntimeException(e);  
        }  
    }  
}