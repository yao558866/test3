package com.ys.appSpringBoot;

import java.lang.reflect.Method;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.util.ReflectionUtils;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App {
	
    public static void main( String[] args ) throws Exception{
    	ConfigurableApplicationContext Context=SpringApplication.run(App.class, args);
    	
//    	User u=Context.getBean(User.class);
//    	System.out.println(u.getName()+","+u.getPwd());
    	
    	System.out.println("=========================================");
    	
//    	Object a=Context.getBean("user");
//    	
//    	Method  mh = ReflectionUtils.findMethod(a.getClass(), "useradd",new Class[]{String.class} );  
//        ReflectionUtils.invokeMethod(mh,a,"13761036955");  
        
//        System.out.println(Context.getEnvironment().getProperty("mysqlurl"));
//        Context.getBean(MyEnvironment.class).show();
        
        
        
        
        
    	
//    	//获得这个类  
//        Object myMethod = Class.forName("com.ys.appSpringBoot.User").newInstance();  
//        //获得这个类中名叫say的参数为Integer的方法  
//        Method method = myMethod.getClass().getMethod("useradd", String.class);  
//        //调用这个方法，12是参数，String与之类似  
//        method.invoke(myMethod, "abcdddd");
    }
}
