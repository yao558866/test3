//package com.ys.appSpringBoot.base;
//
//import java.awt.image.BufferedImage;
//import java.io.ByteArrayInputStream;
//import java.io.File;
//import java.io.IOException;
//
//import javax.imageio.ImageIO;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedCondition;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import io.appium.java_client.android.AndroidDriver;
//
//public class BaseAction {
//
//	public	AndroidDriver driver;
//	public  Integer width;
//	public  Integer height;
//	
//	private Logger logger = LoggerFactory.getLogger(this.getClass());
//
//	public BaseAction(AndroidDriver driver) {
//		super();
//		this.driver = driver;
//		Baseget();
//	}
//	
//	public void Baseget(){
//		width=driver.manage().window().getSize().width;
//		height=driver.manage().window().getSize().height;
//		logger.info("获取屏幕宽"+width.toString());
//		logger.info("获取屏幕高"+height.toString());
//	}
//	/**
//	 * 从右向左滑动
//	 * @return
//	 */
//	public boolean SlideAction() {
//		try {
//			logger.info("开始滑动");
//			driver.swipe(width*3/4, height/2, width*1/4, height/2, 200);
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		return true;
//	}
//	/**
//	 * 判断元素是否存在
//	 * @return
//	 */
//	public boolean judgeElement(By by,int waittime){
//        try {
//        	getElement(by,waittime);
//			logger.info(by+"元素存在");
//			return true;
//		} catch (Exception e) {
//			logger.info(by+"不存在元素");
//			return false;
//		}
//	}
//	// 验证控件是否可用，超过规定检测时间仍然不可用就抛异常
//	private boolean waitToDisplayed(final By key,int waittime) {
//		boolean waitToDisplayed = new WebDriverWait(driver, waittime)
//				.until(new ExpectedCondition<Boolean>() {
//					public Boolean apply(WebDriver d) {
//						return d.findElement(key).isEnabled();
//					}
//				});
//		return waitToDisplayed;
//	}
//
//	// 验证目标空间是否存在，不存在返回空
//	public WebElement getElement(By key,int waittime) {
//		WebElement element = null;
//		if (this.waitToDisplayed(key,waittime)) {
//			element = driver.findElement(key);
//		}
//		return element;
//	}
//	
//	//元素截图
//	public void Screenshot(WebElement webElement){
//		String filename=Integer.toString(1);
//		BufferedImage originalImage;
//		org.openqa.selenium.Dimension size = webElement.getSize();
//		//截图
//		byte[] pingmu =((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//		try {
//			originalImage = ImageIO.read(new ByteArrayInputStream(pingmu));
//            BufferedImage croppedImage = originalImage.getSubimage(
//            		webElement.getLocation().getX(),
//            		webElement.getLocation().getY(),
//            		size.getWidth(),
//            		size.getHeight());
//            ImageIO.write(croppedImage, "png", new File("d://"+filename+".png"));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}  
//	}
//	
//	//获取元素位置
//	public void Screenshot1(WebElement webElement){
//		String filename=Integer.toString(1);
//		BufferedImage originalImage;
//		org.openqa.selenium.Dimension size = webElement.getSize();
//		//截图
//		byte[] pingmu =((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//		try {
//			originalImage = ImageIO.read(new ByteArrayInputStream(pingmu));
//            BufferedImage croppedImage = originalImage.getSubimage(
//            		webElement.getLocation().getX(),
//            		webElement.getLocation().getY(),
//            		size.getWidth(),
//            		size.getHeight());
//            System.out.println(webElement.getLocation().getX());
//            System.out.println(webElement.getLocation().getY());
//            System.out.println(size.getWidth());
//            System.out.println(size.getHeight());
////            ImageIO.write(croppedImage, "png", new File("d://"+filename+".png"));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}  
//	}
//}
