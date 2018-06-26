package com.ys.appSpringBoot.pagesAction;

import java.io.File;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ys.appSpringBoot.pages.HomePage;
import com.ys.appSpringBoot.pages.LoginPage;
import com.ys.appSpringBoot.pages.WelcomePage;
import com.ys.appSpringBoot.pages.KeyboardPage;
import com.ys.appSpringBoot.utils.ButtonObject;
import com.ys.appSpringBoot.utils.CutImage;
import com.ys.appSpringBoot.utils.OCRHelper;
import com.ys.appSpringBoot.utils.ProjectPath;
import com.ys.appSpringBoot.utils.adbUtil;
import com.ys.appSpringBoot.utils.addimage;
import com.ys.appSpringBoot.utils.appActionUtil;

import io.appium.java_client.android.AndroidDriver;

public class KeyboardPageAction{
	public	AndroidDriver driver;
	public ButtonObject buttonObject;
	
	public KeyboardPageAction(AndroidDriver driver) {
		this.driver = driver;
		getbody();
	}

	public  static Integer screenwidth;//屏幕宽
	public  static Integer screenheight;//屏幕高
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	/**单击控件*/
	public void clickNumber(By by){
//		keyboardPageAction=new KeyboardPageAction(driver);
		int[] array=getclickXY(by);
		try {
			adbUtil.readCmd("adb shell input tap "+array[0]+" "+array[1]);
			logger.info("adb shell input tap "+array[0]+" "+array[1]);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**获取屏幕宽高*/
	public void getbody(){
		WebElement w3=appActionUtil.getElement(driver,KeyboardPage.body,3);
		org.openqa.selenium.Dimension size3 =w3.getSize();
		screenwidth=size3.getWidth();
		screenheight=size3.getHeight();
		logger.info("屏幕宽是："+screenwidth);
		logger.info("屏幕高是："+screenheight);
		
	}
	/**获取分辨率中元素宽高*/
	public ButtonObject getImageXYWH(By by){
		buttonObject=appActionUtil.getObject(driver,by,3);
		logger.info("转换前："+buttonObject.toString());
		Integer x=buttonObject.getNumberx();
		Integer y=buttonObject.getNumbery();
		double a=getDouble(x/(screenwidth*1.0));
		double b=getDouble(y/(screenheight*1.0));
		x=(int)(a*appActionUtil.width);
		y=(int)(b*appActionUtil.height);
		
		Integer width=buttonObject.getNumberwidth();
		Integer height=buttonObject.getNumberheight();
		double c=getDouble(width/(screenwidth*1.0));
		double d=getDouble(height/(screenheight*1.0));
		width=(int)(c*appActionUtil.width);
		height=(int)(d*appActionUtil.height);
		
		buttonObject.setNumberx(x);
		buttonObject.setNumbery(y);
		buttonObject.setNumberwidth(width);
		buttonObject.setNumberheight(height);
		return buttonObject;
	}
	/**截取图片*/
	public void getProportion(By[] numberArray){
		for(int i=0;i<numberArray.length;i++){
			buttonObject=getImageXYWH(numberArray[i]);
			logger.info("转换后："+buttonObject.toString()+",第几次截图："+i);
			Integer basex=buttonObject.getNumberx();
			Integer basey=buttonObject.getNumbery();
			Integer basew=buttonObject.getNumberwidth();
			Integer baseh=buttonObject.getNumberheight();
			
			Integer base=basew/10;
			
			Integer x=basex+(base*4);
			Integer y=basey+30;
			Integer width=base*2;
			Integer height=baseh-30;
			CutImage.cutImage(ProjectPath.getProjectPath()+"/image/pwd.png", 
					ProjectPath.getProjectPath()+"/image/"+i+".png",
					x,
					y,
					width, 
					height);
		}
	}
	/**拼接图片*/
	public String addimages(){
		String path=ProjectPath.getProjectPath();
		String[] files={path+"/image/0.png",
				path+"/image/1.png",
				path+"/image/2.png",
				path+"/image/3.png",
				path+"/image/4.png",
				path+"/image/5.png",
				path+"/image/6.png",
				path+"/image/7.png",
				path+"/image/8.png",
				path+"/image/9.png",
		};
		addimage.mergeImage(files,1,path+"/image/100.png");
		logger.info("拼接图片位置为:"+path+"/image/100.png");
		return path+"/image/100.png";
	}
	/**识别图片*/
	public String recognizeImages(String String){
		File file = new File(String);
		String recognizeText="";
		try {
			recognizeText = new OCRHelper().recognizeText(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("识别后数字："+recognizeText);
		return recognizeText;
	}
	
	/**点击多个控件*/
	public void clickPWD(By[] ByArray,String pwdStr,String PWD){
		By[] numberArray=ByArray;
		logger.info("识别的密码是："+pwdStr+",需要点击的密码是："+PWD);
		logger.info("密码在数组中的位置是:"+pwdStr.indexOf(PWD));
		By by=numberArray[pwdStr.indexOf(PWD)];
		clickNumber(by);
		logger.info("点击了密码键盘");
	}
	
	/**获取按键点击位置*/
	public int[] getclickXY(By by){
		buttonObject=appActionUtil.getObject(driver,by,3);
//		System.out.println(buttonObject.toString());
		Integer x=buttonObject.getNumberwidth()/2+buttonObject.getNumberx();
		Integer y=buttonObject.getNumberheight()/2+buttonObject.getNumbery();
		double a=getDouble(x/(screenwidth*1.0));
		double b=getDouble(y/(screenheight*1.0));
		x=(int)(a*appActionUtil.width);
		y=(int)(b*appActionUtil.height);
		int[] array={x,y};
		return array;
	}
	
	
	public double getDouble(double d){
		BigDecimal bg = new BigDecimal(d);
	    double d3 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
//	    System.out.println(d3);
		return d3;
	}
	
	
}
