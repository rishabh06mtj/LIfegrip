package com.santam.client;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.lifegrip.ObjectRepository.AddClientPage;
import com.lifegrip.ObjectRepository.Clients_InformationPage;
import com.lifegrip.genericUtility.BaseClass;
import com.lifegrip.genericUtility.SheetName;

public class EditClientTest extends BaseClass{
	@Test
	public  void editClientTest() {

		//fetch data from excel file
		String clientPassword=excelUtility.getDataFromExcel(SheetName.CLIENTS.convertToString(),2,1);
		String clientName=excelUtility.getDataFromExcel(SheetName.CLIENTS.convertToString(),2,2);
		String clientGender=excelUtility.getDataFromExcel(SheetName.CLIENTS.convertToString(),2,3);
		String clientBirthDate=excelUtility.getDataFromExcel(SheetName.CLIENTS.convertToString(),2,4);
		String clientMaritalStatus=excelUtility.getDataFromExcel(SheetName.CLIENTS.convertToString(),2,5);
		String clientNewMaritalStatus=excelUtility.getDataFromExcel(SheetName.CLIENTS.convertToString(),3,5);
		String clientNationalId=excelUtility.getDataFromExcel(SheetName.CLIENTS.convertToString(),2,6);
		String clientPhone=excelUtility.getDataFromExcel(SheetName.CLIENTS.convertToString(),2,7);
		String clientAddress=excelUtility.getDataFromExcel(SheetName.CLIENTS.convertToString(),2,8);
		String clientPolicyId=excelUtility.getDataFromExcel(SheetName.CLIENTS.convertToString(),2,9);
		String nomineeName=excelUtility.getDataFromExcel(SheetName.CLIENTS.convertToString(),2,10);
		String nomineeGender=excelUtility.getDataFromExcel(SheetName.CLIENTS.convertToString(),2,11);
		String nomineeAddress=excelUtility.getDataFromExcel(SheetName.CLIENTS.convertToString(),2,12);
		String nomineeBirthDate=excelUtility.getDataFromExcel(SheetName.CLIENTS.convertToString(),2,13);
		String nomineeNationalId=excelUtility.getDataFromExcel(SheetName.CLIENTS.convertToString(),2,14);
		String nomineeRelationship=excelUtility.getDataFromExcel(SheetName.CLIENTS.convertToString(),2,15);
		String priority=excelUtility.getDataFromExcel(SheetName.CLIENTS.convertToString(),2,16);
		String nomineePhone=excelUtility.getDataFromExcel(SheetName.CLIENTS.convertToString(),2,17);

		Clients_InformationPage clientsInformationPage=new Clients_InformationPage(driver);
		AddClientPage addClientPage=new AddClientPage(driver);


		commonPage.clickOnClientsLink();
		clientsInformationPage.clickOnAddClientLink();
		//get the unique client id
		String clientId=addClientPage.clientID();
		System.out.println(clientId);

		addClientPage.enterClientPassword(clientPassword);
		addClientPage.enterClientName(clientName+randomNumber);
		addClientPage.fileUpload(webDriverUtility,"./src/test/resources/Photo/2.jpg");
		addClientPage.enterClientGender(clientGender);
		addClientPage.enterClientBirthDate(clientBirthDate);
		addClientPage.enterClientMaritalStatus(clientMaritalStatus);
		addClientPage.enterClientNationalId(clientId);
		addClientPage.enterClientPhone(clientPhone);
		addClientPage.enterClientAddress(clientAddress);
		addClientPage.enterClientPolicyId(clientPolicyId);
		addClientPage.enterNomineeName(nomineeName);
		addClientPage.enterNomineeGender(nomineeGender);
		addClientPage.enterNomineeBirthDate(nomineeBirthDate);
		addClientPage.enterNomineeNationalId(nomineeNationalId);
		addClientPage.enterNomineeRelationship(nomineeRelationship);
		addClientPage.enterPriority(priority);
		addClientPage.enterNomineePhone(nomineePhone);
		addClientPage.clickOnSubmitButton();
		commonPage.clickOnClientsLink();
		clientsInformationPage.clickOnEdit(clientId);
		clientsInformationPage.maritalStatus(clientNewMaritalStatus);
		clientsInformationPage.clickOnSubmitBtn();
		clientsInformationPage.elementToVisible(webDriverUtility, timeout);
		String msg=clientsInformationPage.confirmUpdation();
		if(msg.contains("Client record updated successfully"))
		{
			System.out.println("success---->update successfull");
		}
		else
		{
			System.out.println("fail----> not updated");
			Assert.fail();
		}
	}

}





















































//driver.findElement(By.linkText("CLIENTS")).click();

/*	List<WebElement> actualClientId = driver.findElements(By.xpath("//table/tbody/tr/td[1]"));

		List<WebElement> editLinks = driver.findElements(By.xpath("//table/tbody/tr/td[8]/a"));

		for (int i = 0; i < editLinks.size(); i++) {
			String id = actualClientId.get(i).getText();
			if(id.equals(clientId))
			{
				editLinks.get(i).click();
				break;
			}
		}*/

//		driver.findElement(By.name("marital_status")).clear();
//		driver.findElement(By.name("marital_status")).sendKeys("Unmarried");

//driver.findElement(By.name("submit"));

//	WebElement elementToVisible =driver.findElement(By.xpath("//div[@id='page-wrapper']/div/div/h1"));
//using explicitlywait
//webDriverUtility.visibilityOfElement(timeout, elementToVisible);

//		String confirmationMessage = driver.findElement(By.xpath("//div[@id='page-wrapper']/div/div")).getText();
//
//		if(confirmationMessage.contains("Client record updated successfully"))
//		{
//			System.out.println("success---->update successfull");
//		}
//		else
//		{
//			System.out.println("fail----> not updated");
//		}

//driver.findElement(By.xpath("//a[@title='Logout']")).click();



