package com.practice;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class ExtentReportPractice {

	public static void main(String[] args) {
		ExtentSparkReporter spark=new ExtentSparkReporter("./extentReport/extentHtmlReport.html");
		spark.config().setDocumentTitle("Subho serianna");
		spark.config().setReportName("subho uccha");
		spark.config().setTheme(Theme.STANDARD);

		ExtentReports report =new ExtentReports();
		report.attachReporter(spark);
		
		
		report.setSystemInfo("Operating System","Windows 10");
		report.setSystemInfo("Browser name","Chrome");
		report.setSystemInfo("Browser version","108");
		report.setSystemInfo("Reporter name","Rishabh");
		
		ExtentTest test1=report.createTest("test11");
		test1.info("this information coming from script");
		test1.warning("warning message");
		ExtentTest test2=report.createTest("test12");
		test2.info("info of test");
		test2.pass("Test is passed");
		report.createTest("test3").fail("test is failed");
		report.flush();


	
	




	}
}
