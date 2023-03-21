package com.lifegrip.ObjectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 *  this class contains the webelemnt of client status page
 * @author 91958
 *
 */
public class ClientStatusPage {

	@FindBy(linkText = "Edit Client") private WebElement editLink;
	@FindBy(linkText = "Add Nominee") private WebElement addNomineeLink;
	@FindBy(linkText = "Add Payment") private WebElement addPaymentLink;
	@FindBy(linkText = "Delete Client") private WebElement deleteClientLink;
	@FindBy(xpath = "//div[@id='page-wrapper']/div/div") private WebElement deleteClientConfirmationMsg;
	@FindBy(xpath = "//b[text()='Nominee']/following-sibling::table[@class='table']/tbody/tr/td[1]") private List<WebElement> nomineeNames;
	@FindBy(xpath = "//b[text()='Nominee']/following-sibling::table[@class='table']/tbody/tr/td[7]/a") private List<WebElement> nomineeEditLinks;

	public ClientStatusPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	/**
	 *  this method is used to get Delete Confirmation Msg
	 * @param clientdeleteMsg
	 */

	public void getDeleteConfirmationMsg(String clientdeleteMsg)
	{
		String deleteMsg=deleteClientConfirmationMsg.getText();
		if(deleteMsg.equals(clientdeleteMsg)) {
			System.out.println("Client deleted successfully");
		}
		else
			System.out.println("Client not deleted successfully");
	}

/**
 * this method is used to click on edit button
 */
	public void clickOnEditLink()
	{
		editLink.click();
	}
	/**
	 * this method is used to click On Add Nominee Link
	 */
	public void clickOnAddNomineeLink()
	{
		addNomineeLink.click();
	}
/**
 * this method is used to click On Add Payment Link
 */
	public void clickOnAddPaymentLink()
	{
		addPaymentLink.click();
	}
	/**
	 * this method is used to click On delete client Link
	 */
	public void clickOnDeleteClientLink()
	{
		deleteClientLink.click();
	}
	/**
	 * this method is used to click On edit Nominee Link
	 * @param nomineeName
	 */
	public void clickOnEditNominee(String nomineeName)
	{
		for (int i = 0; i < nomineeEditLinks.size(); i++) {
			String name = nomineeNames.get(i).getText();
			if(name.equals(nomineeName))
			{
				System.out.println("succes in finding the name");
				nomineeEditLinks.get(i).click();
				break;
			}
		}

	}

}
