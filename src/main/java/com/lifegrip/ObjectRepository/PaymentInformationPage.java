package com.lifegrip.ObjectRepository;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentInformationPage {
	@FindBy(linkText="Add Payment")
	private WebElement addPaymentLink;
	@FindBy(xpath="//table/tbody/tr/td[7]/a")
	private List<WebElement> editPaymentLinks;
	@FindBy(xpath="//table/tbody/tr/td[2]")
	private List<WebElement>clientIds;

	public  PaymentInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public void clickOnaddPaymentLink()
	{
		addPaymentLink.click();
	}
	public void clickOnEditPaymentLink(String clientID)
	{

		for(int i=0;i<editPaymentLinks.size();i++)
		{
			String actualClientId=clientIds.get(i).getText();
			if(actualClientId.equals(clientID))
			{
				editPaymentLinks.get(i).click();
			}
		}
	}




}
