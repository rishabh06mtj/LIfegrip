package com.lifegrip.genericUtility;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import com.lifegrip.ObjectRepository.CommonPage;
import com.lifegrip.ObjectRepository.LoginPage;
/**
 * this class is common for all the test classes
 * and contains common methods 
 * @author 91958
 *
 */
public class BaseClass {
	protected FileUtility fileUtility;
	protected ExcelUtility excelUtility;
	protected JavaUtility javaUtility;
	protected WebDriverUtility webDriverUtility;
	protected WebDriver driver;
	protected LoginPage login;
	protected CommonPage commonPage;
	protected int randomNumber;
	protected long timeout;
	/**
	 * create objects for generic utility
	 * read data from property file
	 * open excel file
	 * launch browser,application and setup browser
	 * create object for common pom classes
	 */

	@BeforeClass
	public void classsetup()
	{
		fileUtility=new FileUtility();	
		excelUtility=new ExcelUtility();
		javaUtility=new JavaUtility();
		webDriverUtility=new WebDriverUtility();
		

		//open the PropertyFIle
		fileUtility.openPropertyFile();

		//read from propertyFile
	String browser=fileUtility.getDataFromPropertyFile(PropertyFileKeys.BROWSER.convertToString());
		String url=fileUtility.getDataFromPropertyFile(PropertyFileKeys.URL.convertToString());

		timeout=(Long)javaUtility.stringToAnyDataType(fileUtility.getDataFromPropertyFile(PropertyFileKeys.TIMEOUT.convertToString()),"long");
		String randomNumberLimit=fileUtility.getDataFromPropertyFile(PropertyFileKeys.RANDOM_NUMBER_LIMIT.convertToString());
		randomNumber=javaUtility.getRandomNumber((Integer) javaUtility.stringToAnyDataType(randomNumberLimit,"int"));

		//oepn the excel
		excelUtility.openExcel();
		
		//making webdriverutility object as thread safe
		ThreadSafe.setWebdriverUtility(webDriverUtility);

		//open the browser
		driver=webDriverUtility.launchApplication(browser, timeout, url);

		login=new LoginPage(driver);
		commonPage=new CommonPage(driver);
	}
	/**
	 * this method is used to enter username 
	 * password and click on login 
	 */
	@BeforeMethod
	public void methodsetup()
	{
		String username=fileUtility.getDataFromPropertyFile(PropertyFileKeys.USERNAME.convertToString());
		String password=fileUtility.getDataFromPropertyFile(PropertyFileKeys.PASSWORD.convertToString());
		login.loginAction(username, password);
	}
	/**
	 * this method is used to signout from the application
	 */
	@AfterMethod
	public void methodTearDown()
	{
		commonPage.clickOnLogoutLink();
	}
	/**
	 * this method is used to close the browser
	 */
	@AfterClass
	public void classTearDown()
	{
		fileUtility.closePropertyFile();
		excelUtility.closeExcel();
		webDriverUtility.closeBrowser();
	}



}
