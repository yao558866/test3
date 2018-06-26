package com.ys.appSpringBoot.pages;

import org.openqa.selenium.By;

public class KeyboardPage {
	
	public static final By body = By.xpath("/html/body/ion-nav-view"); 
	/**第一排*/
	public static final By L0 = By.xpath("//*[@id='L0']"); 
	public static final By L1 = By.xpath("//*[@id='L1']"); 
	public static final By L2 = By.xpath("//*[@id='L2']"); 
	public static final By L3 = By.xpath("//*[@id='L3']"); 
	public static final By L4 = By.xpath("//*[@id='L4']"); 
	public static final By L5 = By.xpath("//*[@id='L5']"); 
	public static final By L6 = By.xpath("//*[@id='L6']"); 
	public static final By L7 = By.xpath("//*[@id='L7']"); 
	public static final By L8 = By.xpath("//*[@id='L8']"); 
	public static final By L9 = By.xpath("//*[@id='L9']"); 
	/**第二排*/
	public static final By L10 = By.xpath("//*[@id='L10']"); 
	public static final By L11 = By.xpath("//*[@id='L11']"); 
	public static final By L12 = By.xpath("//*[@id='L12']"); 
	public static final By L13 = By.xpath("//*[@id='L13']"); 
	public static final By L14 = By.xpath("//*[@id='L14']"); 
	public static final By L15 = By.xpath("//*[@id='L15']"); 
	public static final By L16 = By.xpath("//*[@id='L16']"); 
	public static final By L17 = By.xpath("//*[@id='L17']"); 
	public static final By L18 = By.xpath("//*[@id='L18']"); 
	/**第三排*/
	public static final By L19 = By.xpath("//*[@id='L19']"); 
	public static final By L20 = By.xpath("//*[@id='L20']"); 
	public static final By L21 = By.xpath("//*[@id='L21']"); 
	public static final By L22 = By.xpath("//*[@id='L22']"); 
	public static final By L23 = By.xpath("//*[@id='L23']"); 
	public static final By L24 = By.xpath("//*[@id='L24']"); 
	public static final By L25 = By.xpath("//*[@id='L25']"); 
	/**字母按键集合*/
	public static By[] LetterArray={L0,L1,L2,L3,L4,L5,L6,L7,L8,L9,L10,L11,L12,L13,L14,L15,L16,L17,L18,L19,L20,L21,L22,L23,L24,L25};
	/**字母按键集合对照表*/
	public static String realityLetterArray="qwertyuiopasdfghjklzxcvbnm";
	
	
	/**关闭键盘*/
	public static final By closenumber = By.xpath("//*[@id='keyboard-header-icon']"); //关闭键盘
	/**转换成数字键盘*/
	public static final By number = By.xpath("//*[@id='keyboard-number']"); //*[@id="keyboard-number"]
	
	/**转换成字母键盘*/
	public static final By Letter = By.xpath("//*[@id='keyboard-switch']"); 
	/**第1排第1个按键*/
	public static final By no1 = By.xpath("//*[@id='N0']"); 
	/**第1排第2个按键*/
	public static final By no2 = By.xpath("//*[@id='N1']"); 
	/**第1排第3个按键*/
	public static final By no3 = By.xpath("//*[@id='N2']"); 
	/**第2排第1个按键*/
	public static final By no4 = By.xpath("//*[@id='N3']"); 
	/**第2排第2个按键*/
	public static final By no5 = By.xpath("//*[@id='N4']"); 
	/**第2排第3个按键*/
	public static final By no6 = By.xpath("//*[@id='N5']"); 
	/**第3排第1个按键*/
	public static final By no7 = By.xpath("//*[@id='N6']"); 
	/**第3排第2个按键*/
	public static final By no8 = By.xpath("//*[@id='N7']"); 
	/**第3排第3个按键*/
	public static final By no9 = By.xpath("//*[@id='N8']"); 
	/**第4排第2个按键*/
	public static final By no10 = By.xpath("//*[@id='N9']"); 
	/**数字按键集合*/
	public static By[] numberArray={no1,no2,no3,no4,no5,no6,no7,no8,no9,no10};//*[@id="keyboard-contain"]
	
	/**键盘区域*/
	public static final By KBDTrack=By.xpath("//*[@id='keyboard-contain']"); 
	
}
