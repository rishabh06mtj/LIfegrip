package com.lifegrip.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * this class contains the webelemnt of add payment page
 * @author 91958
 *
 */
public class AddPaymentPage {
@FindBy(name="month")
private WebElement monthTxtBox;
@FindBy(name="amount")
private WebElement amountTxtBox;
@FindBy(name="due")
private WebElement dueTxtBox;
@FindBy(name="fine")
private WebElement fineTxtBox;
@FindBy(xpath="//input[@type='submit']")
private WebElement submitButton;


public AddPaymentPage(WebDriver driver)
{
PageFactory.initElements(driver, this);
}
/**
 * this method is used to enter the month
 * @param month
 */
public void enterMonth(String month)
{
	monthTxtBox.sendKeys(month);
	}
/**
 * this method is used to enter the amount
 * @param amount
 */
public void enterAmount(String amount)
{
	amountTxtBox.sendKeys(amount);
	}
/**
 * this method is used to enter the due
 * @param due
 */
public void enterDue(String due)
{
	dueTxtBox.sendKeys(due);
	}
/**
 * this method is used to enter the fine
 * @param fine
 */
public void enterFine(String fine)
{
	fineTxtBox.sendKeys(fine);
	}
/**
 * this method is used to  click On Submit
 */
public void clickOnSubmit()
{
	submitButton.click();
	}
}
