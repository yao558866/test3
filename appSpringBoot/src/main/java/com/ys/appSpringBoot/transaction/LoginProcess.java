package com.ys.appSpringBoot.transaction;

import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.google.common.annotations.Beta;
import com.ys.appSpringBoot.base.PrpcessInterface;
import com.ys.appSpringBoot.pages.HomePage;
import com.ys.appSpringBoot.pages.KeyboardPage;
import com.ys.appSpringBoot.pages.LoginPage;
import com.ys.appSpringBoot.pages.WelcomePage;
import com.ys.appSpringBoot.pagesAction.HomeAction;
import com.ys.appSpringBoot.pagesAction.KeyboardPageAction;
import com.ys.appSpringBoot.pagesAction.LoginAction;
import com.ys.appSpringBoot.utils.MapUtil;
import com.ys.appSpringBoot.utils.appActionUtil;

import io.appium.java_client.android.AndroidDriver;

public class LoginProcess implements PrpcessInterface{
	public	AndroidDriver driver;
	
	public LoginProcess(AndroidDriver driver) {
		this.driver = driver;
	}
	

	public LoginProcess() {
	}


	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * 登录流程
	 * @throws InterruptedException
	 */
	@Override
	public String Process(String Parameter){
		String username = MapUtil.getParameter(Parameter, "username");
		String pwd = MapUtil.getParameter(Parameter, "pwd");
		
		System.out.println("获得的用户："+username+"，密码："+pwd);
		driver.context("WEBVIEW_com.kayakwise.hfcrd");
		HomeAction homeAction=new HomeAction(driver);
		LoginAction LoginAction=new LoginAction(driver);
		
		
		
		if(appActionUtil.waitToDisplayed(driver,HomePage.login,10)){
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			logger.info("进入登录流程");
			if(appActionUtil.waitToDisplayed(driver,HomePage.root3,3)){
				homeAction.clickroot3();
			}
			homeAction.clicklogin();
			homeAction.clickMe();
			
			try {
				LoginAction.canvasAction();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			
//			if(appActionUtil.waitToDisplayed(driver,LoginPage.loginName,3)){
//				LoginAction.setLoginName(username);
//				
//				LoginAction.clickpwd();
//				try {
//					Thread.sleep(2000);
//					LoginAction.setpwd(pwd);
//				} catch (InterruptedException e) {
//					logger.error("输入密码时错误");
//					e.printStackTrace();
//				}
//				logger.info("登录成功");
//				return "Pass";
//			}else{
//				try {
//					LoginAction.canvasAction();
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
		}
		logger.info("登录失败");
		return "Fail";
	}

}
