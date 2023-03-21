package com.lifegrip.genericUtility;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementationClass implements ITestListener{
	private ExtentSparkReporter spark;
	private ExtentReports report;
	private ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(Thread.currentThread().getId()+"onTestSTart---->test");
		test=report.createTest(result.getMethod().getMethodName());
		ThreadSafe.setExtentTest(test);
		test.info("this information coming from script");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(Thread.currentThread().getId()+"onTestSuccess---->test");
		test.pass(result.getMethod().getMethodName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(Thread.currentThread().getId()+"onTestFailure---->test");
		ThreadSafe.getExtentTest().fail(result.getMethod().getMethodName());
		ThreadSafe.getExtentTest().fail(result.getThrowable());
		String screenShot=ThreadSafe.getWebdriverUtility().takeScreenshot();
		ThreadSafe.getExtentTest().addScreenCaptureFromBase64String(screenShot,result.getMethod().getMethodName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println(Thread.currentThread().getId()+"onTestSkipped---->test");
		test.skip(result.getMethod().getMethodName());
		test.skip(result.getThrowable());
		String screenShot=ThreadSafe.getWebdriverUtility().takeScreenshot();
		ThreadSafe.getExtentTest().addScreenCaptureFromBase64String(screenShot,result.getMethod().getMethodName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println(Thread.currentThread().getId()+"onTestFailedButWithinSuccessPercentage---->test");
	}

	@Override
	public void onStart(ITestContext context)
	{
		System.out.println(Thread.currentThread().getId()+"ONStart---->test");
		spark=new ExtentSparkReporter("./extentReport/extentHtmlReport.html");
		spark.config().setDocumentTitle("Subho serianna");
		spark.config().setReportName("subho uccha");
		spark.config().setTheme(Theme.STANDARD);

		report =new ExtentReports();
		report.attachReporter(spark);


		report.setSystemInfo("Operating System","Windows 10");
		report.setSystemInfo("Browser name","Chrome");
		report.setSystemInfo("Browser version","108");
		report.setSystemInfo("Reporter name","Rishabh");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println(Thread.currentThread().getId()+"onTestFinish---->test");
		report.flush();
	}


}
