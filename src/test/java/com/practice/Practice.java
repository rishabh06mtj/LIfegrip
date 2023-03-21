package com.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriverManager.chromedriver().setup();
WebDriver driver=new ChromeDriver();
driver.get("https://www.amazon.in/s?k=mobile+phone+under+15000&ref=nb_sb_noss");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
List<String> productList=new ArrayList<String>();
 
productList.add("Redmi A1 (Light Blue, 2GB RAM, 32GB Storage) | Helio A22 | 5000 mAh Battery | 8MP AI Dual Cam | Leather Texture Design | Android 12");
productList.add("Samsung Galaxy M13 (Aqua Green, 6GB, 128GB Storage) | 6000mAh Battery | Upto 12GB RAM with RAM Plus");
productList.add("OPPO A74 5G (Fantastic Purple,6GB RAM,128GB Storage) with No Cost EMI/Additional Exchange Offers");

productList.add("realme narzo 50i (Carbon Black, 4GB RAM+64GB Storage) Octa Core Processor | 6.5\" inch Large Display");
for(String prName:productList)
{
	String price=driver.findElement(By.xpath("//span[text()='"+prName+"']/ancestor::div[@class='a-section a-spacing-none puis-padding-right-small s-title-instructions-style']/following-sibling::div[@class='sg-row']//span[@class='a-price-whole']")).getText();	
System.out.println(price);
}
	}}

	
