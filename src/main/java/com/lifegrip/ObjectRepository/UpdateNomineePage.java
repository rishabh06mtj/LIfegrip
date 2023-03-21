package com.lifegrip.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 *  this class contains the webelemnt of update nomine page
 * @author 91958
 *
 */
public class UpdateNomineePage {
@FindBy(xpath="//div[@id='page-wrapper']/div/div")
private WebElement confirmationMsg;

@FindBy(linkText="Add Nominee")
private WebElement addNomineeLink;

public UpdateNomineePage(WebDriver driver)
{
	PageFactory.initElements(driver,this);
	}
/**
 * this method is used to compare the confirmation msg
 * @param msg
 */
public void confirmationMsg(String msg)
{  String message =confirmationMsg.getText();
if(message.contains(msg))
{
	System.out.println("pass---> update success");
}
else
{
	System.out.println("fail----> not updated");
}

}

}