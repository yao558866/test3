package com.ys.appSpringBoot.pagesAction;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ys.appSpringBoot.pages.HomePage;
import com.ys.appSpringBoot.pages.KeyboardPage;
import com.ys.appSpringBoot.pages.LoginPage;
import com.ys.appSpringBoot.pages.WelcomePage;
import com.ys.appSpringBoot.utils.ButtonObject;
import com.ys.appSpringBoot.utils.CutImage;
import com.ys.appSpringBoot.utils.ProjectPath;
import com.ys.appSpringBoot.utils.Screenshot;
import com.ys.appSpringBoot.utils.adbUtil;
import com.ys.appSpringBoot.utils.appActionUtil;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class LoginAction{
	public	AndroidDriver driver;
	public  KeyboardPageAction keyboardPageAction;
	public static String imagepwd;
	
	public LoginAction(AndroidDriver driver) {
		this.driver = driver;
	}

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/** 输入用户名*/
	public void setLoginName(String loginName){
		appActionUtil.getElement(driver,LoginPage.loginName,3).sendKeys(loginName);
	}
	/** 单击密码框*/
	public void clickpwd(){
		appActionUtil.getElement(driver,LoginPage.pwd,3).click();
	}
	/** 单击登录按钮*/
	public void clicklogin(){
		System.out.println("即将点击登录按钮");
		appActionUtil.getElement(driver,LoginPage.login,3).click();
		System.out.println("完成点击登录按钮");
	}
	
	
	
	/**输入密码
	 * @throws InterruptedException */
	public int setpwd(String pwd) throws InterruptedException{
		keyboardPageAction=new KeyboardPageAction(driver);//创建键盘对象
		boolean type=true;//是否首次点击数字键盘
		Integer Lasttype=0;//0初始值，1代表数字，2代表字母
		
		for(int i=0;i<pwd.length();i++){
			String numberPWD=String.valueOf(pwd.charAt(i));
			if(isInteger(numberPWD)){
				if(Lasttype!=1){
					logger.info("需要输入的密码是数字");
					keyboardPageAction.clickNumber(KeyboardPage.number);
					Thread.sleep(1000);//等待键盘加载
					Lasttype=1;
				}
				if(type){
					logger.info("首次进入，开始密码截图操作");
					Screenshot.getImage();//截图
					keyboardPageAction.getProportion(KeyboardPage.numberArray);//截图
					imagepwd=keyboardPageAction.recognizeImages(keyboardPageAction.addimages());//识别
					type=false;
				}
				keyboardPageAction.clickPWD(KeyboardPage.numberArray,imagepwd,numberPWD);//点击密码
			}
			if(!isInteger(numberPWD)){
				logger.info("需要输入的密码是字母");
				if(Lasttype!=2){
					keyboardPageAction.clickNumber(KeyboardPage.Letter);
					Thread.sleep(1000);//等待键盘加载
					Lasttype=2;
				}
				keyboardPageAction.clickPWD(KeyboardPage.LetterArray,KeyboardPage.realityLetterArray,numberPWD);//点击密码
			}
		}
		keyboardPageAction.clickNumber(KeyboardPage.closenumber);
		Thread.sleep(1000);//等待键盘关闭
		keyboardPageAction.clickNumber(LoginPage.login);
		return 0;
	}
	public static boolean isInteger(String str) {  
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");  
        return pattern.matcher(str).matches();  
	}
	
	public void canvasAction() throws InterruptedException{
		keyboardPageAction=new KeyboardPageAction(driver);
		ButtonObject buttonObject=keyboardPageAction.getImageXYWH(LoginPage.canvas);
//		ButtonObject buttonObject=appActionUtil.getObject(driver,LoginPage.canvas,3);
			Thread.sleep(1000);//触摸前要等待1秒
			int startX = buttonObject.getNumberx();//获取元素的起始点x坐标
			int startY = buttonObject.getNumbery();//获取元素的起始点y坐标
			int height = buttonObject.getNumberheight();//获取元素的高
			int width = buttonObject.getNumberwidth();//获取元素的宽
			int xStep = width/6;//把宽分成6份
			int yStep = height/6;//把高分成6份
			int beginX = startX + xStep*3;//计算触摸起始点x坐标
			int beginY = startY + yStep;//计算触摸点y坐标
			
			TouchAction ta = new TouchAction(driver); //初始化TouchAction
			/**
			* 注意moveTo 的坐标是相对于前一个坐标的偏移量
			*/
			driver.context("NATIVE_APP");
			ta.press(beginX, beginY).moveTo(0, yStep*2).waitAction(500).moveTo(0, yStep*2).waitAction(500).moveTo(-xStep*2, 0).waitAction(500).release().perform();
			Thread.sleep(2000);
			System.out.println("滑动完毕");
	}
	
}
