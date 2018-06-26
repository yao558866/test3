package com.ys.bbb;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.server.handler.FindElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.internal.EventFiringKeyboard;
import org.openqa.selenium.support.events.internal.EventFiringMouse;
import org.testng.annotations.Test;


public class day2 {
	public By asd=By.id("kw");
	public static void main(String[] args) {
		
			try {
				new day2().firedriver1();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		

	}
	
	public void firedriver1() throws InterruptedException {
			
//			File file=new File("d:/ff/g6tq991s.default");
//			FirefoxProfile filrfoxProfile=new FirefoxProfile(file);
//			//���������������
//	//		filrfoxProfile.setEnableNativeEvents(true);
//			//�ر�firebug
//			filrfoxProfile.setPreference("extensions.firebug.allPagesActivation", "off");
//			filrfoxProfile.setPreference("signed.applets.codebase_principal_support", "true");
//			WebDriver driver =new FirefoxDriver(filrfoxProfile);
//			Navigation navigation=driver.navigate();
		System.setProperty("webdriver.ie.driver","filse/IE64DriverServer.exe");
		DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
		ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
		WebDriver driver1 = new InternetExplorerDriver(ieCapabilities);
		
//		EventFiringMouse mouse=new EventFiringMouse(driver1, new MywebdriverListener());
//		Coordinates ccc=new shubiao();
//		mouse.mouseDown(ccc);
//		mouse.mouseMove(ccc);
//		mouse.mouseUp(ccc);
//		mouse.click(ccc);
//		mouse.contextClick(ccc);
//		mouse.doubleClick(ccc);
//		mouse.mouseMove(ccc, 0L, 0L);
//		
//		
//		Thread.sleep(5000);
		
		EventFiringWebDriver driver=new EventFiringWebDriver(driver1);
		driver.register(new MywebdriverListener());
		
		Navigation navigation=driver.navigate();
			navigation.to("http://www.baidu.com");
			
			
			WebElement baiduTextBox=driver.findElement(asd);
			baiduTextBox.sendKeys("ys1");
			Thread.sleep(5000);
			driver.navigate().refresh();
			driver.findElement(asd).sendKeys("ys2");
			Thread.sleep(5000);
			baiduTextBox=driver.findElement(By.id("su"));
			baiduTextBox.click();
			Thread.sleep(5000);
			driver.quit();
			/*
			Thread.sleep(2000);
			System.exit(0);
			
				
			baiduTextBox=driver.findElement(By.xpath("//div[@id='content_left']/div[1]/h3/a/em"));
			baiduTextBox.click();
			
		
			Thread.sleep(2000);
			
			//baiduTextBox=driver.findElement(By.linkText("��¼"));
			baiduTextBox=driver.findElement(By.xpath(".//*[@id='userbar']/ul/li[2]/a[text()='��¼']"));
			//String ss=baiduTextBox.getText();
			//System.out.println(ss);
			baiduTextBox.click();
			*/
			
		}

}
