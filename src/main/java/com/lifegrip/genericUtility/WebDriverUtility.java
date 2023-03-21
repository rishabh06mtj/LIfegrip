package com.lifegrip.genericUtility;
import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * this class contains common webdriver actions
 * @author 91958
 *
 */
public class WebDriverUtility {
	private WebDriver driver;
	private WebDriverWait wait;
	private JavascriptExecutor js;

	/**
	 * this method is used to 
	 * launch the browser based on browser key
	 * maximize the browser
	 * provide implicitly wait
	 * launch application by using url
	 * @param browser
	 * @param timeout
	 * @param url
	 * @return
	 */

	public WebDriver launchApplication(String browser,long timeout,String url)
	{    
		if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(browser.equals("ie")) 
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new InternetExplorerDriver();
		}
		else {
			System.out.println("Please enter valid browser name");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(timeout,TimeUnit.SECONDS);
		driver.get(url);
		return driver;
	}
	/**
	 * this method is used to wait for a particular element to be visible
	 * @param driver
	 * @param timeout
	 * @param element
	 */
	public void visibilityOfElement(long timeout,WebElement element) {
		wait=new WebDriverWait(driver,timeout);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * this method is used to perform mouse actions like
	 * mouseHover
	 * right click
	 * double click
	 * @param element
	 */
	public void action_mouseHover(WebElement element,String strategy)
	{
		Actions a =new Actions(driver);
		if(strategy.contains("mousehover")){
			a.moveToElement(element).perform();
		}
		else if(strategy.contains("rightclick"))
		{
			a.contextClick(element).perform();
		}

		else if(strategy.contains("doubleclick"))
		{ 
			a.doubleClick(element).perform();
		}

	}
	/**
	 * this method is used to upload the photo
	 * @param element
	 * @param filePath
	 */
	public void fileUpload(WebElement element, String filePath)
	{
		File f=new File(filePath);
		String absolutePath = f.getAbsolutePath();
		element.sendKeys(absolutePath);
	}
	/**
	 * this method is used to handle dropdowns using index
	 * @param element
	 * @param index
	 */
	public void handleDropDowns(WebElement element,int index)
	{
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	/**
	 * this method is used to handle dropdowns using value
	 * 
	 * @param element
	 * @param value
	 */
	public void handleDropDowns(WebElement element,String value)
	{
		Select s=new Select(element);
		s.selectByValue(value);
	}
	/**
	 * this is method is used to handle the disableelement
	 * @param Script
	 */
	public void  handleDisable_element(String Script)
	{
		js=(JavascriptExecutor)driver;
		js.executeScript(Script);
		//"document.getElementBYId().value='value'
	}
	/**
	 * this method is used to handle the scrollbar
	 * @param x
	 * @param y
	 */
	public void  scrollBar(int x,int y)
	{
		js.executeScript("window.scrollBy("+x+","+y+")");
	}
	/**
	 * this method will wait for the alert
	 * @param timeout
	 * @param element
	 */
	public void alert_Is_present(long timeout,WebElement element)
	{
		wait=new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.alertIsPresent());
	}
	/**
	 * this method will wait for the element till it is clickable
	 * @param timeout
	 * @param element
	 */
	public void element_To_Be_Clickable(long timeout,WebElement element)
	{
		wait=new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * this method will hold the execution till the expected 
	 * @param timeout
	 * @param element
	 */
	public void element_To_Clickable(long timeout,String title)
	{
		wait=new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.titleContains(title));
	}
	/**
	 * this method is used to hold the execution
	 * @param timeout
	 */
	public void implicitlyWait(long timeout)
	{
		driver.manage().timeouts().implicitlyWait(timeout,TimeUnit.SECONDS);
	}
	/**
	 * this method is used to click on element directly in dom when it is not clicking
	 */
	public void elementNotIntercepted(WebElement ele)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", ele);
	}
	/**
	 * this method is used to provide customwait
	 * @param duration
	 * @param element
	 * @param pollingTime
	 */
	public void customWait(int duration,WebElement element,long pollingTime)
	{
		int count=0;
		while(count<duration)
		{
			try {
				element.click();
				break;
			}
			catch(Exception e) {
				try {
					Thread.sleep(pollingTime);
				} catch (InterruptedException e1) {
				
					e1.printStackTrace();
				}
				count++;};
		}

	}
	/**
	 * this method is used to take the screenshot and return the path of folder
	 * @param testCaseName
	 * @return
	 */
	public String takeScreenshot()
	{ 
		//String fileName=testCaseName+"_"+new JavaUtility().getDateAndTime();
		TakesScreenshot ts=(TakesScreenshot)driver;
		String src = ts.getScreenshotAs(OutputType.BASE64);
		//File src = ts.getScreenshotAs(OutputType.FILE);
		return src;
//		File dest = new File("./errorshots/"+fileName+".png");
//		try {
//			FileUtils.copyFile(src, dest);
//		} catch (IOException e) {
//			
//			e.printStackTrace();
//		}
//
//		return dest.getAbsolutePath();
	}
	/**
	 * this method is used to close the browser
	 */
	public void closeBrowser()
	{
		driver.quit();
	}



}