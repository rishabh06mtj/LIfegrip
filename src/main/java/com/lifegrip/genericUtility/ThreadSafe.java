package com.lifegrip.genericUtility;

import com.aventstack.extentreports.ExtentTest;

/**
 * this class is used to make object references as Thread Safe
 * @author 91958
 *
 */
public class ThreadSafe {

	private static ThreadLocal<WebDriverUtility> webdriverUtility=new ThreadLocal<>();
	private static ThreadLocal<ExtentTest> extentTest=new ThreadLocal<>();
	
/**
 * this method is used to get the webdriverUtility object value
 * @return
 */
	public static WebDriverUtility getWebdriverUtility() {
		return webdriverUtility.get();
	}
/**
 * this method is used to set the webdriverUtility object value
 * @param swebdriverUtility
 */
	public static void setWebdriverUtility(WebDriverUtility swebdriverUtility) {
		webdriverUtility.set(swebdriverUtility);
	}
public static ExtentTest getExtentTest() {
	return extentTest.get();
}
public static void setExtentTest(ExtentTest sextentTest) {
	extentTest.set(sextentTest);
}
}
