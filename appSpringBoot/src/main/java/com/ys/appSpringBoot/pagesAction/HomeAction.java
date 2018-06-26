package com.ys.appSpringBoot.pagesAction;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.ys.appSpringBoot.pages.HomePage;
import com.ys.appSpringBoot.pages.LoginPage;
import com.ys.appSpringBoot.pages.WelcomePage;
import com.ys.appSpringBoot.utils.appActionUtil;
import io.appium.java_client.android.AndroidDriver;

public class HomeAction{
	public	AndroidDriver driver;
	
	public HomeAction(AndroidDriver driver) {
		this.driver = driver;
	}

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * 点击右下角登录菜单
	 */
	public void clicklogin(){
		appActionUtil.getElement(driver,HomePage.login,3).click();
	}
	/**
	 * 点击我的按钮
	 */
	public void clickMe(){
		appActionUtil.getElement(driver,HomePage.me,3).click();
	}
	/**
	 * 点击root
	 */
	public void clickroot3(){
		appActionUtil.getElement(driver,HomePage.root3,3).click();
	}
	
}
