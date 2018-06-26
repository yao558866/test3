package com.ys.appSpringBoot.pagesAction;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.ys.appSpringBoot.pages.WelcomePage;
import com.ys.appSpringBoot.utils.appActionUtil;
import io.appium.java_client.android.AndroidDriver;

public class WelcomeAction{
	public	AndroidDriver driver;
	
	public WelcomeAction(AndroidDriver driver) {
		this.driver = driver;
	}

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * 欢迎界面点击开始
	 */
	public void clickOpen(){
		appActionUtil.getElement(driver,WelcomePage.open,3).click();
	}
	/**
	 * 引导界面点击下一步
	 */
	public void next1(){
		appActionUtil.getElement(driver,WelcomePage.one_Next_step,3).click();
	}
	/**
	 * 引导界面点击下一步
	 */
	public void next2(){
		appActionUtil.getElement(driver,WelcomePage.two_Next_step,3).click();
	}
	/**
	 * 引导界面点击下一步
	 */
	public void next3(){
		appActionUtil.getElement(driver,WelcomePage.three_Next_step,3).click();
	}
	/**
	 * 引导界面点击下一步
	 */
	public void next4(){
		appActionUtil.getElement(driver,WelcomePage.four_Next_step,3).click();
	}
	/**
	 * 引导界面点击下一步
	 */
	public void start(){
		appActionUtil.getElement(driver,WelcomePage.start,3).click();
	}
	/**
	 * 引导界面点击确定root
	 */
	public void clickroot(){
		appActionUtil.getElement(driver,WelcomePage.root,3).click();
	}
	/**
	 * 引导界面点击确定root2
	 */
	public void clickroot2(){
		appActionUtil.getElement(driver,WelcomePage.root2,3).click();
	}
	
}
