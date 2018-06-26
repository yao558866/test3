package com.ys.appSpringBoot.pages;

import org.openqa.selenium.By;

public class LoginPage {
	//
	/**登录按钮*/
	public static final By login = By.xpath("/html/body/ion-nav-view/ion-view/ion-content/div/div/form/div[4]"); 
	/**用户名*/
	public static final By loginName = By.xpath("/html/body/ion-nav-view/ion-view/ion-content/div/div/form/div[1]/div[2]/input"); 
	/**密码框*/
	public static final By pwd = By.xpath("//*[@id='loginPassword1']"); 
	/**手势密码*/
	public static final By canvas = By.xpath("//*[@id='gesture']/canvas"); 
	
	
}
