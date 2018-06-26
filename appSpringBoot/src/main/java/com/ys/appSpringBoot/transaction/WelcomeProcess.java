package com.ys.appSpringBoot.transaction;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ys.appSpringBoot.base.PrpcessInterface;
import com.ys.appSpringBoot.pages.HomePage;
import com.ys.appSpringBoot.pages.WelcomePage;
import com.ys.appSpringBoot.pagesAction.WelcomeAction;
import com.ys.appSpringBoot.utils.appActionUtil;

import io.appium.java_client.android.AndroidDriver;

public class WelcomeProcess implements PrpcessInterface{
	public	AndroidDriver driver;
	public  WelcomeAction welcomeAction;
	
	public WelcomeProcess(AndroidDriver driver) {
		this.driver = driver;
	}

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * 欢迎界面流程
	 * @throws InterruptedException
	 */
	@Override
	public String Process(String Parameter){
		welcomeAction=new WelcomeAction(driver);
		
		Set<String> contextNames = driver.getContextHandles();
		for (String contextName : contextNames) {
			logger.info(contextName); // 用于返回被测app是NATIVE_APP还是WEBVIEW，如果两者都有就是混合型App  /html/body/div[2]/div/div[3]/button
		}
		appActionUtil.Baseget(driver);
		driver.context("WEBVIEW_com.kayakwise.hfcrd");
		if(appActionUtil.waitToDisplayed(driver,WelcomePage.img,3)){
			logger.info("开始欢迎页面流程");
//			appActionUtil.Baseget(driver);
			logger.info("点击确定root");
			welcomeAction.clickroot();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			driver.context("NATIVE_APP");
			logger.info("滑动1次");
			appActionUtil.SlideAction(driver);
			logger.info("滑动2次");
			appActionUtil.SlideAction(driver);
			driver.context("WEBVIEW_com.kayakwise.hfcrd");
			welcomeAction.clickOpen();
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			logger.info("点击确定root");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			welcomeAction.clickroot2();
			welcomeAction.next1();
			welcomeAction.next2();
			welcomeAction.next3();
			welcomeAction.next4();
			welcomeAction.start();
			if(!appActionUtil.waitToDisplayed(driver,HomePage.login,3)){
				logger.info("欢迎界面流程正确完成");
				return "Pass";
			}
		}
		logger.info("无欢迎页面");
		return "Fail";
	}
	
}
