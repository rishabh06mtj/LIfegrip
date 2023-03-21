package com.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dynamic2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://rmgtestingserver:8888/index.php?module=Home&action=index&parenttab=My%20Home%20Page");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//td[@class='tabUnSelected']/a[text()='Organizations']")).click();
		WebDriverWait wait=new WebDriverWait(driver,10);
		//driver.findElement(By.linkText("Organizations")).click();
		String page=driver.findElement(By.xpath("//span[@name='Accounts_listViewCountContainerName'. ]")).getText();
		String expOrg="tcs67";
		List<WebElement>listOrg=driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr/td[3]"));
		for(int i=1;i<listOrg.size();i++)
		{
			String acOrg=listOrg.get(i).getText();
			if(acOrg.equals(expOrg))						
			{
				driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr["+(i+2)+"]/td/input..")).click();
				break;
			}

		}

	}

}
