package com.ys.appSpringBoot.pages;

import org.openqa.selenium.By;

public class WelcomePage {
	/**欢迎页面图片*/
	public static final By img = By.xpath("/html/body/ion-nav-view/ion-view/ion-content/div/div[1]/ion-slide[1]/a/img"); 
	/**点击开启按钮*/
	public static final By open = By.xpath("/html/body/ion-nav-view/ion-view/ion-content/div/div[1]/ion-slide[3]/div/span"); 
	/**第一个下一步*/
	 public static final By one_Next_step = By.xpath("/html/body/ion-nav-view/ion-view/ion-content/div/div[2]/div[1]/div"); 
	/**第二个下一步*/
	 public static final By two_Next_step = By.xpath("/html/body/ion-nav-view/ion-view/ion-content/div/div[2]/div[2]/div"); 
	/**第三个下一步*/
	 public static final By three_Next_step = By.xpath("/html/body/ion-nav-view/ion-view/ion-content/div/div[2]/div[3]/div/div[2]"); 
	 /**第四个下一步*/
	 public static final By four_Next_step = By.xpath("/html/body/ion-nav-view/ion-view/ion-content/div/div[2]/div[4]/div/div[2]"); 
	 /**开始使用*/
	 public static final By start = By.xpath("/html/body/ion-nav-view/ion-view/ion-content/div/div[2]/div[5]/div");
	 /**root确定*/
	 public static final By root = By.xpath("/html/body/div[2]/div/div[3]/button");
	 /**root确定2*/
	 public static final By root2 = By.xpath("/html/body/div[3]/div/div[3]/button");
}
