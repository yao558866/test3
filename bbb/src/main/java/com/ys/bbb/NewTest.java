package com.ys.bbb;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class NewTest {
  @Test(dataProvider = "dp")
  public void f(Integer n, String s) {
	  System.out.println("靠靠靠1111111111111111111111111111111111111："+s);
  }

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, "gggggggggggggg" },
      new Object[] { 2, "hhhhhhhhhhhhh" },
    };
  }
  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

}
