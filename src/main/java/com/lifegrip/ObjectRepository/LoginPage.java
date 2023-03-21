package com.lifegrip.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 *  this class contains the webelement of login page
 * @author 91958
 *
 */
public class LoginPage {
	@FindBy(name="username") private WebElement usernameTxtField;
	@FindBy(name="password") private WebElement passwordTxtField;
	@FindBy(xpath="//button[text()='login']") private WebElement loginButton;

	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	/**
	 * 
	 * this method is used to enter username
	 * this method is used to enter password
	 * this method is used to click on login
	 * @param username
	 * @param password
	 */
	public void loginAction(String username,String password)
	{usernameTxtField.sendKeys(username);
	passwordTxtField.sendKeys(password);
		loginButton.click();
	}
}
