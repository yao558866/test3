package com.ys.appSpringBoot.base;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.ys.appSpringBoot.App;
import com.ys.appSpringBoot.transaction.WelcomeProcess;
import com.ys.appSpringBoot.utils.ProjectPath;
import com.ys.appSpringBoot.utils.appActionUtil;

import io.appium.java_client.android.AndroidDriver;
/**
 * @description 启动和结束测试，以及数据提供者，提供测试数据
 * */
public class BasePrepare {
	
	public	AndroidDriver driver;
		
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public ConfigurableApplicationContext Context = null;
	
	@BeforeClass
	public void initTest() throws MalformedURLException, InterruptedException{
		Context = SpringApplication.run(App.class, "");
		logger.info("==================测试开启===================");
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("deviceName","G6H6AMR45TEA7LAM");//设备名，命令： adb devices//G6H6AMR45TEA7LAM/html/body/ion-nav-view/ion-view/ion-content/div/div[1]/ion-slide[3]/div/span
//		cap.setCapability("deviceName","7d5992987d32");//设备名，命令： adb devices//G6H6AMR45TEA7LAM/html/body/ion-nav-view/ion-view/ion-content/div/div[1]/ion-slide[3]/div/span
		cap.setCapability("platformVersion", "4.4.2");//手机系统版本
//		cap.setCapability("platformVersion", "5.1.1");//手机系统版本
		cap.setCapability("automationName", "Appium");
		cap.setCapability("platformName", "Android");
		cap.setCapability("sessionOverride", true);
		cap.setCapability("app", ProjectPath.getProjectPath()+"/res/hxLife.apk");//d:\hxLife.apk
		cap.setCapability("noReset", true);//不重新安装
		cap.setCapability("appPackage", "com.kayakwise.hfcrd");//被测apk的包名，命令：   aapt dump badging 包名
		cap.setCapability("appActivity", "com.kayakwise.hfcrd.MainActivity");
		cap.setCapability("devicereadyTimeout", 30);
		cap.setCapability("unicodeKeyboard", true);//是否支持中文
		cap.setCapability("resetKeyboard", true);////android独有 - 是否重置键盘，如果设置了unicodeKeyboard键盘，可以将此参数设置为true，然后键盘会重置为系统默认的
//		installApp tssb=new installApp();
//		tssb.start();
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
//		tssb.stopMe();
		
		appActionUtil.Baseget(driver);
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		logger.info("屏幕分辨率宽:"+appActionUtil.width);
		logger.info("屏幕分辨率高:"+appActionUtil.height);
		
		if(driver.isAppInstalled("com.kayakwise.hfcrd")){
			logger.info("安装成功");
			new WelcomeProcess(driver).Process("");
		}else{
			logger.info("安装失败");
		}
		logger.info("安装阶段结束");
	  }
	
	  @AfterClass
	  public void clenTest() {
	  }
	  
	

}
