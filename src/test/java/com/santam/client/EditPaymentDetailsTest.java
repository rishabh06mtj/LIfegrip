package com.santam.client;
import org.testng.annotations.Test;

import com.lifegrip.ObjectRepository.AddClientPage;
import com.lifegrip.ObjectRepository.AddNomineePage;
import com.lifegrip.ObjectRepository.AddPaymentPage;
import com.lifegrip.ObjectRepository.ClientStatusPage;
import com.lifegrip.ObjectRepository.Clients_InformationPage;
import com.lifegrip.ObjectRepository.CommonPage;
import com.lifegrip.ObjectRepository.InsertNomineePage;
import com.lifegrip.ObjectRepository.InsertPaymentPage;
import com.lifegrip.ObjectRepository.PaymentInformationPage;
import com.lifegrip.genericUtility.BaseClass;
import com.lifegrip.genericUtility.IConstantPath;
import com.lifegrip.genericUtility.SheetName;

public class EditPaymentDetailsTest extends BaseClass {
@Test
public void editPaymentDetailsTest()
{//fetch data from excel file
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
	String paymentMonth=excelUtility.getDataFromExcel(SheetName.CLIENTS.convertToString(),2,17);
	String paymentAmount=excelUtility.getDataFromExcel(SheetName.CLIENTS.convertToString(),2,18);
	String paymentDue=excelUtility.getDataFromExcel(SheetName.CLIENTS.convertToString(),2,19);
	String paymentFine=excelUtility.getDataFromExcel(SheetName.CLIENTS.convertToString(),2,20);
	

	
	Clients_InformationPage clientsInformationPage=new Clients_InformationPage(driver);
	ClientStatusPage clientStatusPage=new ClientStatusPage(driver);
	AddClientPage addClientPage=new AddClientPage(driver);
	AddNomineePage addNomineePage=new AddNomineePage(driver);
	InsertNomineePage insertNomineePage=new InsertNomineePage(driver);
	AddPaymentPage addPaymentPage=new AddPaymentPage(driver);
	InsertPaymentPage insertPaymentPage=new InsertPaymentPage(driver); 
	PaymentInformationPage paymentInformationPage=new PaymentInformationPage(driver);
	


	commonPage.clickOnClientsLink();
	clientsInformationPage.clickOnAddClientLink();
	//get the unique client id
	String clientId=addClientPage.clientID();
	System.out.println(clientId);

	addClientPage.enterClientPassword(clientPassword);
	addClientPage.enterClientName(clientName+randomNumber);
	addClientPage.fileUpload(webDriverUtility,IConstantPath.PHOTO_PATH);
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
	clientsInformationPage.clickonCLientStatuslink(clientId);
	clientStatusPage.clickOnAddPaymentLink();
	addPaymentPage.enterMonth(paymentMonth);
	addPaymentPage.enterAmount(paymentAmount);
	addPaymentPage.enterDue(paymentDue);
	addPaymentPage.enterFine(paymentFine);
	addPaymentPage.clickOnSubmit();
	insertPaymentPage.validatePaymentAdded("New Payment ADDED");
    commonPage.clickOnPaymentsLink();
    paymentInformationPage.clickOnEditPaymentLink(clientId);
}
	
}
