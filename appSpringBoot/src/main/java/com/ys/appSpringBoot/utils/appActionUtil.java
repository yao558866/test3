package com.ys.appSpringBoot.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ys.appSpringBoot.pages.KeyboardPage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class appActionUtil {

	public  static Integer width;//屏幕分辨率宽
	public  static Integer height;//屏幕分辨率高
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	
	public static void Baseget(AndroidDriver driver){
		width=driver.manage().window().getSize().width;
		height=driver.manage().window().getSize().height;
	}
	/**
	 * 从右向左滑动
	 * @return
	 */
	public static boolean SlideAction(AndroidDriver driver) {
		try {
//			driver.swipe(width*4/5, height/2, width*1/6, height/2, 200);
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return true;
	}
	/**
	 * 判断元素是否存在
	 * @return
	 */
	public static  boolean judgeElement(AndroidDriver driver,By by,int waittime){
        try {
        	getElement(driver,by,waittime);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	// 验证控件是否可用，超过规定检测时间仍然不可用就抛异常
	public static  boolean waitToDisplayed(AndroidDriver driver,final By key,int waittime){
		int count=waittime;
		do{
			try {
				driver.findElement(key);
				return true;
			} catch (Exception e) {
				System.out.println("未找到"+key.toString());
//				e.printStackTrace();
			}
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
			}
			count--;
		}while(count>=0);
		new RuntimeException();
		return false;
	}

	// 验证目标空间是否存在
	public static  WebElement getElement(AndroidDriver driver,By key,int waittime) {
		int count=waittime;
		WebElement element;
		do{
			try {
				element=driver.findElement(key);
				return element;
			} catch (Exception e) {
				System.out.println("未找到"+key.toString());
//				e.printStackTrace();
			}
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			count--;
		}while(count>=0);
		new RuntimeException();
		return null;
	}
	
	// 验证控件是否可用，超过规定检测时间仍然不可用就抛异常
//	public static  WebElement waitToDisplayed2(AndroidDriver driver,final By key,int waittime){
//		int count=waittime;
//		WebElement element;
//		do{
//			try {
//				element=driver.findElement(key);
//				return element;
//			} catch (Exception e) {
//				System.out.println("未找到"+key.toString());
////				e.printStackTrace();
//			}
//			try {
//				Thread.sleep(2000);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			count--;
//		}while(count>=0);
//		return null;
//	}
	
	
	/**控件转换成对象*/
	public static ButtonObject getObject(AndroidDriver driver,By key,int waittime){
		WebElement w3=appActionUtil.getElement(driver,key,waittime);
		org.openqa.selenium.Dimension size3 =w3.getSize();
		Integer screenwidth=size3.getWidth();
		Integer screenheight=size3.getHeight();
		Integer numberx=w3.getLocation().getX();
		Integer numbery=w3.getLocation().getY();
//		System.out.println("转换对象"+screenwidth);
//		System.out.println("转换对象"+screenheight);
//		System.out.println("转换对象"+numberx);
//		System.out.println("转换对象"+numbery);
		ButtonObject buttonObject=new ButtonObject(screenwidth,screenheight,numberx,numbery);
		return buttonObject;
	}
}
