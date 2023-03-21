package com.lifegrip.ObjectRepository;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.lifegrip.genericUtility.ExcelUtility;
import com.lifegrip.genericUtility.SheetName;
import com.lifegrip.genericUtility.WebDriverUtility;
/**
 * this class contains the webelemnt of Clients_Information Page
 * @author 91958
 *
 */
public class Clients_InformationPage {
	@FindBy(linkText="Add Client")
	private WebElement addClientLink;
	@FindBy(xpath="//table/tbody/tr/td[1]")
	private List<WebElement>allClientID;
	@FindBy(xpath="//table/tbody/tr/td[8]/a")
	private List<WebElement> editLinks;
	@FindBy(xpath="//table/tbody/tr/td[7]/a")
	private List<WebElement> statusLinks;
	@FindBy(name="marital_status")
	private WebElement maritalStatusTxtBox;
	@FindBy(name="submit")
	private WebElement submitBtn;
	@FindBy(xpath="//div[@id='page-wrapper']/div/div/h1")
	private WebElement elementToVisible;
	@FindBy(xpath="//div[@id='page-wrapper']/div/div")
	private WebElement confirmationMessage;

	public Clients_InformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	/**
	 * this method is used to  click On add client link
	 */
	public void clickOnAddClientLink() {
		addClientLink.click();

	}
	/**
	 * this method is used to compare the id
	 * and validate  the client 
	 * @param clientID
	 * @param excelUtility
	 */
	public void compareID( String clientID,ExcelUtility excelUtility )
	{  
		boolean counter =false;
		for (WebElement cId : allClientID) {
			String id=cId.getText();

			if(clientID.equals(id))
			{
				System.out.println("success----->client created successfully");
				excelUtility.setExcelData(SheetName.CLIENTS.convertToString(),2, 22,"pass");
				counter=true;
				break;
			}
		}
		if(!counter)
		{
			Assert.fail("fail--> client not created");
		}

	}
	/**
	 * this method is used to click on edit link
	 * @param ClientID
	 */
	public void clickOnEdit(String ClientID)
	{ 
		for (int i = editLinks.size()-1; i>=0; i--) {
			String id = allClientID.get(i).getText();
			if(id.equals(ClientID))
			{
				editLinks.get(i).click();
				break;
			}
		}
	}
	/**
	 * this method is used to enter maritalStatus
	 * @param status
	 */
	public void maritalStatus(String status)
	{
		maritalStatusTxtBox.clear();
		maritalStatusTxtBox.sendKeys(status);
	}
	/**
	 *  this method is used to click On Submit link
	 */
	public void clickOnSubmitBtn()
	{
		submitBtn.click();
	}
	/**
	 *  this method is used to wait for the element to visible so that we can compare
	 * @param webDriverUtility
	 * @param timeout
	 */
	public void elementToVisible(WebDriverUtility webDriverUtility ,long timeout) 
	{
		webDriverUtility.visibilityOfElement(timeout,elementToVisible);
	}
	/**
	 *  this method is used to confirmation of update
	 * @return
	 */
	public String confirmUpdation()
	{ 
		String msg=confirmationMessage.getText();
		return msg;
	}
	/**
	 *  this method is used to click On client status link
	 * @param clientID
	 */

	public void clickonCLientStatuslink(String clientID)
	{
		for (int i = statusLinks.size()-1; i>=0; i--) {
			String id = allClientID.get(i).getText();
			if(id.equals(clientID))
			{
				statusLinks.get(i).click();
				break;
			}
		}
	}









}
