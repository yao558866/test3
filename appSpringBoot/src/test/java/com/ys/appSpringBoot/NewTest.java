package com.ys.appSpringBoot;

import io.appium.java_client.android.AndroidDriver;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import net.sf.json.JSONObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ReflectionUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import com.ys.appSpringBoot.base.BasePrepare;
import com.ys.appSpringBoot.base.PrpcessInterface;
import com.ys.appSpringBoot.transaction.LoginProcess;
import com.ys.appSpringBoot.utils.ProjectPath;
import com.ys.appSpringBoot.utils.SheetUtils;
import com.ys.appSpringBoot.utils.app_testData;

public class NewTest extends BasePrepare{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@SuppressWarnings("rawtypes")
	@Test(dataProvider = "app", dataProviderClass = app_testData.class)
	public void f(HashMap<String, Object> data) throws Exception{
		System.out.println(JSONObject.fromObject(data).toString());
		String classname="com.ys.appSpringBoot.transaction."+data.get("Process").toString();
		Class cls = Class.forName(classname);
		Class[] paramTypes = { AndroidDriver.class};
		Object[] params = {driver}; 
		@SuppressWarnings("unchecked")
		Constructor con = cls.getConstructor(paramTypes);     
		PrpcessInterface Prpcess=(PrpcessInterface)con.newInstance(params);
		
		Long startTime=System.currentTimeMillis();
		String result=Prpcess.Process(data.get("Parameter").toString());
		Long endTime=System.currentTimeMillis();
		String time=(endTime-startTime)/1000+"秒";
//		new LoginProcess(driver).Process("18234837159","123123qq");
		
		//数据回写
		SheetUtils sheet = new SheetUtils("DataAll.xls", "Output");
		sheet.writeExcel(
				data.get("NO").toString(), 
				data.get("TCNO").toString(),
				data.get("Step").toString(), 
				data.get("Description").toString(),
				data.get("Process").toString(),
				data.get("Parameter").toString(),
				data.get("Expect").toString(),
				result, 
				time);
		if (result.indexOf("Fail") != -1) {
			Assert.assertTrue(false);
		} else {
			Assert.assertTrue(true);
		}
	}

}
