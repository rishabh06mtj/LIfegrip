package com.lifegrip.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * this class contains the webelemnt of add nominee page
 * @author 91958
 *
 */
public class AddNomineePage {
	@FindBy(xpath="//input[@name='name']") private WebElement nomineeNameTxtBx;
	@FindBy(xpath="//input[@name='sex']") private WebElement nomineeSexTxtBx;
	@FindBy(xpath = "//input[@name='birth_date']") private WebElement nomineeBirthDateTxtBx;
	@FindBy(xpath = "//input[@name='nid']") private WebElement nomineeNidTxtBx;
	@FindBy(xpath = "//input[@name='relationship']") private WebElement nomineeRelationshipTxtBx;
	@FindBy(xpath = "//input[@name='priority']") private WebElement nomineePriorityTxtBx;
	@FindBy(xpath = "//input[@name='phone']") private WebElement nomineePhoneTxtBx;
	@FindBy(xpath = "//input[@type='submit']") private WebElement submitBtn;

	public AddNomineePage(WebDriver driver)
	{
	PageFactory.initElements(driver, this);	
	}
/**
 * this method is used to enterNomineeName
 * @param nomineeName
 */
	public void enterNomineeName(String nomineeName)
	{
	nomineeNameTxtBx.sendKeys(nomineeName);
	}
	/**
	 * this method is used to enterNomineeSex
	 * @param nomineeSex
	 */
	public void enterNomineeSex(String nomineeSex)
	{
	nomineeSexTxtBx.sendKeys(nomineeSex);
	}
	/**
	 * this method is used to enterNomineeBirthDate
	 * @param nomineeBirthDate
	 */
	public void enterNomineeBirthDate(String nomineeBirthDate)
	{
	nomineeBirthDateTxtBx.sendKeys(nomineeBirthDate);
	}
	/**
	 * this method is used to enterNomineeNid
	 * @param nomineeNid
	 */
	public void enterNomineeNid(String nomineeNid)
	{
	nomineeNidTxtBx.sendKeys(nomineeNid);
	}
	/**
	 * this method is used to enterNomineeRelationship
	 * @param nomineeRelationship
	 */
	public void enterNomineeRelationship(String nomineeRelationship)
	{
	nomineeRelationshipTxtBx.sendKeys(nomineeRelationship);
	}
	/**
	 * this method is used to  enterPriority
	 * @param priority
	 */
	public void enterPriority(String priority)
	{
	nomineePriorityTxtBx.sendKeys(priority);
	}
	/**
	 * this method is used to  enterNomineePhone
	 * @param nomineePhoneNo
	 */
	public void enterNomineePhone(String nomineePhoneNo)
	{
	nomineePhoneTxtBx.sendKeys(nomineePhoneNo);
	}
	/**
	 * this method is used to  clickOnSubmitBtn
	 */
	public void clickOnSubmitBtn()
	{
		submitBtn.click();
	}
}
