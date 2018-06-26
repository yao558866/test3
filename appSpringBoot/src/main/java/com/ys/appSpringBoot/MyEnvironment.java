package com.ys.appSpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.core.env.Environment;

@SpringBootConfiguration
public class MyEnvironment{

    @Autowired//通过注解直接注入对象
    private Environment environment;

    @Value("${mysqlurl}")
    private String defaultPort;
//    @Value("${tomcat.port}")
//    private String tomcatPort;
//    //可以通过此方式给属性设置默认值
//    @Value("${my.port:1212}")
//    private String myPort;

    public void show(){
//        System.out.println(environment.getProperty("ip.localhost"));
        System.out.println(defaultPort);
//        System.out.println(tomcatPort);
//        System.out.println(myPort);
    }
}

