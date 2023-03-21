package com.practice;

import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGPractice {

	@Test(groups= {"sanity","reg"})
	public void test()
	{
		Reporter.log("hello",true);
	}

	@Test(groups= "reg")
	public void test2()
	{
		Reporter.log("hello2",true);
	}
//	@Parameters(value= {"browser","username","password"})
//	@Test(groups= "sanity")
//	public void test1(String browser,String username,String password)
//	{
//		Reporter.log("hello1",true);
//		Reporter.log("browser----> "+browser,true);
//		Reporter.log("username---> "+username,true);
//		Reporter.log("password---> "+password,true);
//		
//	}
}
