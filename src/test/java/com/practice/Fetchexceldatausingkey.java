package com.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Fetchexceldatausingkey {
	/*public static void main(String[] args) throws Exception {
	// TODO Auto-generated method stub
	FetchExcelDataUsingKey f=new FetchExcelDataUsingKey();
	String clientPassword=f.fetchExcelData("Clients","CreateClientTest","ClientPassword");
	String clientName=f.fetchExcelData("Clients","CreateClientTest","ClientName");
	String clientGender=f.fetchExcelData("Clients","CreateClientTest","Gender");
	String clientDob=f.fetchExcelData("Clients","CreateClientTest","BirthDate");
	String clientMaritalStatus=f.fetchExcelData("Clients","CreateClientTest","MaritalStatus");
	String clientNationalId=f.fetchExcelData("Clients","CreateClientTest","Nid");
	String clientPhone=f.fetchExcelData("Clients","CreateClientTest","Phone");
	String clientAddress=f.fetchExcelData("Clients","CreateClientTest","Address");
	String clientPolicyId=f.fetchExcelData("Clients","CreateClientTest","PolicyId");
	String clientNomineeName=f.fetchExcelData("Clients","CreateClientTest","NomineeName");
	String clientNomineeSex=f.fetchExcelData("Clients","CreateClientTest","NomineeSex");
	String clientNomineeBirthDate=f.fetchExcelData("Clients","CreateClientTest","NomineeBirthDate");
	String clientNomineeNid=f.fetchExcelData("Clients","CreateClientTest","NomineeNid");
	String clientNomineeRelationship=f.fetchExcelData("Clients","CreateClientTest","NomineeRelationship");
	String Priority=f.fetchExcelData("Clients","CreateClientTest","Priority");
	String clientNomineePhone=f.fetchExcelData("Clients","CreateClientTest","NomineePhone");
	
	
	
}*/
public String fetchExcelData(String sheetName,String testCaseName,String columnName)
{ 
	FileInputStream fis = null;
	try {
		fis = new FileInputStream("./src/test/resources/testscript.xlsx");
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	Workbook wb = null;
	try {
		wb = WorkbookFactory.create(fis);
	} catch (EncryptedDocumentException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	DataFormatter df=new  DataFormatter();
	String data="";
	
		Sheet sheet=wb.getSheet(sheetName);
		int rowLength= sheet.getLastRowNum();
		int lastCellNum=sheet.getRow(0).getLastCellNum();
		System.out.println(rowLength);
		System.out.println(lastCellNum);
		String expectedTestCaseName=testCaseName;
		String expectedcolumnName=columnName;
		for(int i=0;i<=rowLength;i++)
		{ 
			String actualTestCaseName=sheet.getRow(i).getCell(0).getStringCellValue();
			
			if(actualTestCaseName.equals(expectedTestCaseName)){
				for(int j=1;j<lastCellNum-1;j++)
				{
					String actualColumnName = sheet.getRow(i).getCell(j).getStringCellValue();
					
					if(actualColumnName.equals(expectedcolumnName))
					{
						data=df.formatCellValue(sheet.getRow(i+1).getCell(j));
						break;
					}
				}
				break;
			}
		}

	
	return data;
}
}
