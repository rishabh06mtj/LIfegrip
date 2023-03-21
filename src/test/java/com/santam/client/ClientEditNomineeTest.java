package com.santam.client;

import org.testng.annotations.Test;

import com.lifegrip.ObjectRepository.AddClientPage;
import com.lifegrip.ObjectRepository.ClientStatusPage;
import com.lifegrip.ObjectRepository.Clients_InformationPage;
import com.lifegrip.ObjectRepository.NomineeInformationPage;
import com.lifegrip.ObjectRepository.UpdateNomineePage;
import com.lifegrip.genericUtility.BaseClass;
import com.lifegrip.genericUtility.SheetName;

public class ClientEditNomineeTest extends BaseClass{

@Test
	public  void clientEditNomineeTest() {
      //fetch data from excel file
		String clientPassword=excelUtility.getDataFromExcel(SheetName.CLIENTS.convertToString(),2,1);
		String clientName=excelUtility.getDataFromExcel(SheetName.CLIENTS.convertToString(),2,2);
		String clientGender=excelUtility.getDataFromExcel(SheetName.CLIENTS.convertToString(),2,3);
		String clientBirthDate=excelUtility.getDataFromExcel(SheetName.CLIENTS.convertToString(),2,4);
		String clientMaritalStatus=excelUtility.getDataFromExcel(SheetName.CLIENTS.convertToString(),2,5);
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
		NomineeInformationPage nomineeInformationPage=new NomineeInformationPage(driver);
		ClientStatusPage clientStatuspage=new ClientStatusPage(driver);
		UpdateNomineePage updateNomineePage=new UpdateNomineePage(driver);
	

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
		addClientPage.enterClientNationalId(clientNationalId);
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
		clientsInformationPage.compareID(clientId, excelUtility);
		commonPage.clickOnClientsLink();
		clientsInformationPage.clickonCLientStatuslink(clientId);
		clientStatuspage.clickOnEditNominee(nomineeName);
		nomineeInformationPage.enterThePriority(priority);
		nomineeInformationPage.clickOnupdateButton();
		updateNomineePage.confirmationMsg("Record updated successfully");
		
	}}
	


























	