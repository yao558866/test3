package com.ys.appSpringBoot.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * //获取屏幕宽高
//adb -s G6H6AMR45TEA7LAM shell dumpsys window displays
//adb -s G6H6AMR45TEA7LAM shell wm size
 * //点击屏幕位置
//adb -s G6H6AMR45TEA7LAM shell input tap 588 1760
 * @author Administrator
 *
 *安装程序辅助类，用于处理安全软件提示信息
 */
public class installApp extends Thread{

	public static String xycoordinate;
	
    private boolean stopMe = true;  

    public void stopMe() {  
        stopMe = false;  
    }  
	
	static{
		try {
			String result=readCmd("adb -s G6H6AMR45TEA7LAM shell wm size");
//			String result=readCmd("adb -s 7d5992987d32 shell wm size");
			String xy = getRegxString(result, "(?<=Physical size: ).*(?=\n)");
			xycoordinate= getcoordinate(xy);
			System.out.println("获取坐标为："+xycoordinate);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		   while (stopMe) {  
				try {
					Runtime.getRuntime().exec("adb -s G6H6AMR45TEA7LAM shell input tap "+xycoordinate);//点击屏幕位置
//					Runtime.getRuntime().exec("adb -s 7d5992987d32 shell input tap "+xycoordinate);//点击屏幕位置
					System.out.println("尝试点击确定");
					Thread.sleep(5000);
				} catch (Exception e) {
					e.printStackTrace();
				}
		   } 
		   System.out.println("尝试结束");
	}
	
	/**
	 * 获取按键坐标
	 */
	public static String getcoordinate(String xy){
		String[] strlist=xy.split("x");
		int a=0;
		int b=0;
		if(strlist.length>0 && strlist!=null){
			//定位右下角
			a=Integer.parseInt(strlist[0]);
			a=a/2+20;
			b=Integer.parseInt(strlist[1]);
			b=b-20;
		}
		return a+" "+b;
	}
	/**
	 * 获取包名
	 * 
	 * @param appPath
	 * @return
	 * @throws Exception
	 */
	public String getApkPackage(String appPath) throws Exception {
		System.out.println("获取apk包名 <" + appPath + ">...");
		String result = readCmd("aapt dump badging " + appPath + " |findstr package");
		String packageName = getRegxString(result, "(?<=package: name=').*(?=' versionCode)");
		return packageName;
	}
	/**
	 * 执行adb命令并返回结果
	 * 
	 * @param command
	 * @return
	 * @throws Exception
	 */
	public static String readCmd(String command) throws Exception {
		System.out.println("执行命令：" + command);
		Runtime runtime = Runtime.getRuntime();

		// 有管道符命令，需要这样处理
		BufferedReader br = new BufferedReader(
				new InputStreamReader(runtime.exec(new String[] { "cmd.exe", "/c", command }).getInputStream(), "GBK"));
		String line = null;
		StringBuffer b = new StringBuffer();
		while ((line = br.readLine()) != null) {
			b.append(line + "\n");
		}

		System.out.println(b.toString());
		return b.toString();
	}
	/**
	 * 将匹配的字符串取出
	 * 
	 * @param str
	 * @param regx
	 * @return
	 */
	public static String getRegxString(String str, String regx) {
		// 将正在表达式封装成对象Patten 类来实现
		Pattern pattern = Pattern.compile(regx);
		// 将字符串和正则表达式相关联
		Matcher matcher = pattern.matcher(str);
		String result = null;

		// 查找符合规则的子串
		while (matcher.find()) {
			// 获取字符串
			result = matcher.group();
			// System.out.println(result);
		}
		return result;
	}
}
