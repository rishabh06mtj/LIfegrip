package com.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Practice2 {
public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriverManager.chromedriver().setup();
WebDriver driver=new ChromeDriver();
driver.manage().window().maximize();
driver.get("https://www.flipkart.com/search?q=iphone&otracker=search&otracker1=search&marketplace=FLIPKART&as-show=on&as=off");
driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

List<WebElement> prName=driver.findElements(By.xpath("//span[contains(text(),'results for')]/../../../following-sibling::div/div/div/div/a/div[2]/div[1]/div[1]"));




List<WebElement> prPrice=driver.findElements(By.xpath("//span[contains(text(),'results for')]/../../../following-sibling::div/div/div/div/a/div[2]/div[2]/div[1]/div[1]/div[1]"));
for(int i=0;i<prName.size();i++)
{
	String name=prName.get(i).getText();
	String price=prPrice.get(i).getText();
	
System.out.println(name+"------>"+price);	


}
}
}