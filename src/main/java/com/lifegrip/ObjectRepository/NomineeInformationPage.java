package com.lifegrip.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 *  this class contains the webelement of nominee information page
 * @author 91958
 *
 */
public class NomineeInformationPage {
@FindBy(name="priority")
private WebElement priorityTxtBox;
@FindBy(name="phone")
private WebElement phoneTxtBox;
@FindBy(xpath="//input[@type='submit']")
private WebElement updateButton;
public NomineeInformationPage(WebDriver driver) 
{ 
	
	PageFactory.initElements(driver, this);
	}
/**
 * this method is used to enter the priority 
 * @param priority
 */
public void enterThePriority(String priority)
{
	priorityTxtBox.clear();
	priorityTxtBox.sendKeys(priority);
}
/**
 * this method is used to enter the phone 
 * @param phone
 */
public void enterPhone(String phone)
{
	priorityTxtBox.clear();
	priorityTxtBox.sendKeys(phone);
}
/**
 * this method is used to click on update button
 */
public void clickOnupdateButton()
{
	updateButton.click();
	}
}