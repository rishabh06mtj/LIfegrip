package com.practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.lifegrip.genericUtility.ExcelUtility;

public class TestNgDataProvider {

	@Test(dataProvider = "getData")
	public void test(String username,String password)
	{
		System.out.println("username------>"+username+"   password----->"+password);

	}
	@DataProvider
	public String[][] getData()
	{
		ExcelUtility excelUtility=new ExcelUtility();
		excelUtility.openExcel();
		String[][] arr=excelUtility.getDataFromExcel("Sheet1");
		return arr;
	}
}
