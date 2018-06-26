package com.ys.appSpringBoot.utils;

import org.testng.annotations.DataProvider;

public class app_testData {
	
	  @DataProvider(name="app")
	  public static Object[][] dp(){
		  ReadExcels readExcels = new ReadExcels("DataAll.xls","TestCase");
		  try {
			return readExcels.readExcels_return();
		} catch (Exception e) {
			e.printStackTrace();
		}
		  return null;
	  }

}
