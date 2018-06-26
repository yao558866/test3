package com.ys.bbb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class MywebdriverListener  implements WebDriverEventListener{

	public void afterChangeValueOf(WebElement arg0, WebDriver arg1) {
		System.out.println("元素值变更后");
		
	}

	public void afterClickOn(WebElement arg0, WebDriver arg1) {
		System.out.println("单击元素后");
		
	}

	public void afterFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		System.out.println("查找元素后");
	}

	public void afterNavigateBack(WebDriver arg0) {
		System.out.println("浏览器后退后");
		
	}

	public void afterNavigateForward(WebDriver arg0) {
		System.out.println("浏览器前进后");
		
	}

	public void afterNavigateTo(String arg0, WebDriver arg1) {
		System.out.println("页面跳转后");
		
	}

	public void afterScript(String arg0, WebDriver arg1) {
		System.out.println("脚本执行后");
		
	}

	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	public void beforeClickOn(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	public void beforeFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateBack(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateForward(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateTo(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	public void beforeScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	public void onException(Throwable arg0, WebDriver arg1) {
		System.out.println("异常后");
		
	}

}
