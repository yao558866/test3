package com.ys.appSpringBoot;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class User {
//	@Value("${mysqlurl}")
//	public  String abc;
	private  String name;
	private  String pwd;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public User() {
		this.name="张三";
		this.pwd="1234";
	}

	public void test() {
		System.out.println("我是实现A的User");
		
	}
	
	public void useradd(String str){
		System.out.println("添加了一个User:"+str);
	}
	
	
}
