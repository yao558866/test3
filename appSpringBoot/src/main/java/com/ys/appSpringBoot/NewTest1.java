//package com.ys.appSpringBoot;
//
//import io.appium.java_client.android.AndroidDriver;
//
//import java.lang.reflect.Method;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Set;
//import java.util.concurrent.TimeUnit;
//
//import net.sf.json.JSONObject;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.ConfigurableApplicationContext;
//import org.springframework.util.ReflectionUtils;
//import org.testng.annotations.Test;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.AfterClass;
//
//import com.ys.appSpringBoot.base.BasePrepare;
//import com.ys.appSpringBoot.transaction.loginProcess;
//import com.ys.appSpringBoot.utils.ProjectPath;
//import com.ys.appSpringBoot.utils.app_testData;
//
////public class NewTest1 extends BasePrepare{
//public class NewTest1{
//	
//	private Logger logger = LoggerFactory.getLogger(this.getClass());
//
////	@Test
//	@Test(dataProvider = "renmai", dataProviderClass = app_testData.class)
//	public void f(HashMap<String, Object> data) throws Exception{
//		System.out.println(JSONObject.fromObject(data).toString());
//		
//		ConfigurableApplicationContext Context = SpringApplication.run(App.class, "");
//		
////		Object obj=Context.getBean(data.get("Process").toString());
////    	Method  mh = ReflectionUtils.findMethod(obj.getClass(), "Process",new Class[]{String.class} );  
////        ReflectionUtils.invokeMethod(mh,obj,data.get("Parameter").toString());
//		
//    	Object a=Context.getBean("user");
//    	
//    	Method  mh = ReflectionUtils.findMethod(a.getClass(), "useradd",new Class[]{String.class} );  
//        ReflectionUtils.invokeMethod(mh,a,"13761036955");
//        
//        
////		new LoginProcess(driver).Process("18234837159","123123qq");
//		
//	}
//
//}
