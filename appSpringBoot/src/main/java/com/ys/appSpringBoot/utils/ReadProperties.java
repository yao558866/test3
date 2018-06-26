package com.ys.appSpringBoot.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {
	public static void main(String[] args) {
		String s=ReadProperties.GetPropertyByKey("adb");
		System.out.println(s);
	}
	
    public static String GetPropertyByKey(String key) {
        Properties pps = new Properties();
        try {
        	File directory = new File(".");
            String sourceFile = directory.getCanonicalPath() +File.separator+"res"+File.separator+"config.properties";
            System.out.println("sourceFile="+sourceFile);
            InputStream in = new BufferedInputStream (new FileInputStream(sourceFile));  
            pps.load(in);
            String value = pps.getProperty(key);
            return value;
            
        }catch (IOException e) {
            return null;
        }
    }
//    public static String GetPropertyByClassName(String key) {
//        Properties pps = new Properties();
//        try {
//        	File directory = new File(".");
//            String sourceFile = directory.getCanonicalPath() +File.separator+"src"+File.separator+"resources"+File.separator+"reflect.properties";
//            InputStream in = new BufferedInputStream (new FileInputStream(sourceFile));  
//            pps.load(in);
//            String value = pps.getProperty(key);
//            return value;
//            
//        }catch (IOException e) {
//            return null;
//        }
//    }  
//    public static String GetPropertyByClassName(String key,String qudao) {
//        Properties pps = new Properties();
//        try {
//        	File directory = new File(".");
//            String sourceFile = directory.getCanonicalPath() +File.separator+"src"+File.separator+"resources"+File.separator+qudao+"_reflect.properties";
//            InputStream in = new BufferedInputStream (new FileInputStream(sourceFile));  
//            pps.load(in);
//            String value = pps.getProperty(key);
//            return value;
//            
//        }catch (IOException e) {
//            return null;
//        }
//    }  
}
