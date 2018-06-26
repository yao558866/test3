package com.ys.appSpringBoot.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class adbUtil {

	public static String readCmd(String command) throws Exception {
//		System.out.println("执行命令：" + command);
		Runtime runtime = Runtime.getRuntime();

		BufferedReader br = new BufferedReader(
				new InputStreamReader(runtime.exec(new String[] { "cmd.exe", "/c", command }).getInputStream(), "GBK"));
		String line = null;
		StringBuffer b = new StringBuffer();
		while ((line = br.readLine()) != null) {
			b.append(line + "\n");
		}

//		System.out.println(b.toString());
		return b.toString();
	}
}
