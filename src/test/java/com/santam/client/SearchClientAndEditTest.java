package com.santam.client;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.lifegrip.genericUtility.ExcelUtility;
import com.lifegrip.genericUtility.FileUtility;
import com.lifegrip.genericUtility.IConstantPath;
import com.lifegrip.genericUtility.JavaUtility;
import com.lifegrip.genericUtility.PropertyFileKeys;
import com.lifegrip.genericUtility.SheetName;
import com.lifegrip.genericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchClientAndEditTest {

	public static void main(String[] args) throws Exception {
		//create object for generic utility
		FileUtility fileUtility=new FileUtility();	
		ExcelUtility excelUtility=new ExcelUtility();
		JavaUtility javaUtility=new JavaUtility();
		WebDriverUtility webDriverUtility=new WebDriverUtility();

		//open the PropertyFIle
		fileUtility.openPropertyFile();

		//read from propertyFile
		String browser=fileUtility.getDataFromPropertyFile(PropertyFileKeys.BROWSER.convertToString());
		String url=fileUtility.getDataFromPropertyFile(PropertyFileKeys.URL.convertToString());
		String username=fileUtility.getDataFromPropertyFile(PropertyFileKeys.USERNAME.convertToString());
		String password=fileUtility.getDataFromPropertyFile(PropertyFileKeys.PASSWORD.convertToString());
		long timeout=(Long)javaUtility.stringToAnyDataType(fileUtility.getDataFromPropertyFile(PropertyFileKeys.TIMEOUT.convertToString()),"long");
		String randomNumberLimit=fileUtility.getDataFromPropertyFile(PropertyFileKeys.RANDOM_NUMBER_LIMIT.convertToString());
		int randomNumber=javaUtility.getRandomNumber((Integer) javaUtility.stringToAnyDataType(randomNumberLimit,"int"));


		//oepn the excel
		excelUtility.openExcel();
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


		//open the browser
		WebDriver driver=webDriverUtility.launchApplication(browser, timeout, url);


		//login in to application
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[text()='login']")).click();


		//navigate to client module and click on add client button
		driver.findElement(By.linkText("CLIENTS")).click();
		driver.findElement(By.linkText("Add Client")).click();

		//get the unique client id
		String clientId=driver.findElement(By.name("client_id")).getAttribute("value");
		System.out.println(clientId);

		//enter all the client details
		driver.findElement(By.name("client_password")).sendKeys(clientPassword);
		driver.findElement(By.name("name")).sendKeys(clientName+randomNumber);

		File f1=new File("./src/test/resources/Photo/2.jpg");
		String absolutePath = f1.getAbsolutePath();
		driver.findElement(By.name("fileToUpload")).sendKeys(absolutePath);

		driver.findElement(By.name("sex")).sendKeys(clientGender);
		driver.findElement(By.name("birth_date")).sendKeys(clientBirthDate);
		driver.findElement(By.name("maritial_status")).sendKeys(clientMaritalStatus);
		driver.findElement(By.name("nid")).sendKeys(clientNationalId);
		driver.findElement(By.name("phone")).sendKeys(clientPhone);
		driver.findElement(By.name("address")).sendKeys(clientAddress);
		driver.findElement(By.name("policy_id")).sendKeys(clientPolicyId);

		//enter all the nominee detailsclientNomineeName
		driver.findElement(By.name("nominee_name")).sendKeys(nomineeName);
		driver.findElement(By.name("nominee_sex")).sendKeys(nomineeGender);
		driver.findElement(By.name("nominee_birth_date")).sendKeys(nomineeBirthDate);
		driver.findElement(By.name("nominee_nid")).sendKeys(nomineeNationalId);
		driver.findElement(By.name("nominee_relationship")).sendKeys(nomineeRelationship);
		driver.findElement(By.name("priority")).sendKeys(priority);
		driver.findElement(By.name("nominee_phone")).sendKeys(nomineePhone);
		driver.findElement(By.xpath("//input[@type='submit']")).click();


		driver.findElement(By.xpath("//a[text()='Aegon Life']")).click();
		driver.findElement(By.name("key")).sendKeys(clientId);
		driver.findElement(By.xpath("//input[@class='searchBtn']")).click();
		List<WebElement> actualClientId = driver.findElements(By.xpath("//table/tbody/tr/td[1]"));


		for (int i = 0; i < actualClientId.size(); i++) {
			String id = actualClientId.get(i).getText();
			if(id.equals(clientId))
			{
				System.out.println("testcasepassed");
				break;
			}
		}
		driver.findElement(By.xpath("//a[@title='Logout']")).click();
		fileUtility.closePropertyFile();
		excelUtility.closeExcel();
		driver.quit();




	}

}
