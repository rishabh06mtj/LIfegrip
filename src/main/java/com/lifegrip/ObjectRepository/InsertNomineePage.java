package com.lifegrip.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.lifegrip.genericUtility.WebDriverUtility;

public class InsertNomineePage {
	
		@FindBy(xpath = "//div[@id='page-wrapper']/div/div/h1") private WebElement insertNomineeTxt;
		@FindBy(xpath = "//div[@id='page-wrapper']/div/div") private WebElement insertNomineeConfirmationPage;
		
	
		
		public InsertNomineePage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
/**
 * this method is used to wait for insert nominee text
 * @param webDriverUtility
 * @param timeout
 */
		public void waitForinsertNomineeText(WebDriverUtility webDriverUtility,long timeout)
		{
			webDriverUtility.visibilityOfElement(timeout, insertNomineeTxt);
		}
		/**
		 * this method is used to get Insert  NomineeConfirmation Msg
		 * @param msg
		 */
		public void getInsertNomineeConfirmationMsg(String msg)
		{
			String confirmationMessage = insertNomineeConfirmationPage.getText();
SoftAssert softAssert=new SoftAssert();
softAssert.assertTrue(confirmationMessage.contains(msg));
//			if(confirmationMessage.contains(msg))
//			{
//				System.out.println("success---->New Nominee ADDED updated successfull");
//			}
//			else
//			{
//				System.out.println("fail----> not updated");
//			}
		}
}
