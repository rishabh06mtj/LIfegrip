package com.lifegrip.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class InsertPaymentPage {
	@FindBy(xpath="//h1[@class='page-head-line']/parent::div")
	private WebElement paymentConfirmationMessage;

	public InsertPaymentPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * this method is used to get Insert  NomineeConfirmation Msg
	 * @param msg
	 */
	public void validatePaymentAdded(String msg)
	{
		String confirmationMessage = paymentConfirmationMessage.getText();
		SoftAssert softAssert=new SoftAssert();
		softAssert.assertTrue((confirmationMessage.contains(msg)));
		softAssert.assertAll();
}
	}
