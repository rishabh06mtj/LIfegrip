package com.lifegrip.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 *  this class contains the webelement of common page
 * @author 91958
 *
 */
public class CommonPage {
	@FindBy(xpath="//a[text()='Aegon Life']") private WebElement aegonLifeLink;
	@FindBy(linkText="CLIENTS") private WebElement clientsLink;
	@FindBy(xpath="//a[text()='AGENTS']") private WebElement agentsLink;
	@FindBy(xpath="//a[text()='POLICY']") private WebElement policyLink;
	@FindBy(xpath="//a[text()='NOMINEE']") private WebElement nomineeLink;
	@FindBy(xpath="//a[text()='PAYMENTS']") private WebElement paymentsLink;
	@FindBy(xpath="//a[@title='Logout']") private WebElement logOutLink;

	public CommonPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	/**
	 * this method is used to click on clients link
	 */
	public void clickOnClientsLink()
	{
		clientsLink.click();
	}

/**
 * this method is used to click on AegonLife link
 */
	public void clickOnAegonLifeLink()
	{
		aegonLifeLink.click();
	}

/**
 * this method is used to click on Agents link
 */
	public void clickOnAgentsLink()
	{
		agentsLink.click();
	}
	/**
	 * this method is used to click on Policy link
	 */
	public void clickOnPolicyLink()
	{
		policyLink.click();
	}
	/**
	 * this method is used to click on Nominee link
	 */
	public void clickOnNomineeLink()
	{
		nomineeLink.click();
	}
	/**
	 * this method is used to click on Payments link
	 */
	public void clickOnPaymentsLink()
	{
		paymentsLink.click();
	}
	/**
	 * this method is used to click on logout link
	 */
	public void clickOnLogoutLink()
	{
		logOutLink.click();
	}






}
