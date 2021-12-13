package com.crm.SDET25.Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Crm3  {
	

	@Test 
	public void Create() throws IOException, InterruptedException	
	{
	WebDriver driver = null;
	
	FileInputStream file = new FileInputStream("./data.properties");
	
	Properties p = new Properties();
	p.load(file);
	
	String url = p.getProperty("url");
	String username = p.getProperty("username");
	String password = p.getProperty("password");
	String browser = p.getProperty("browser");
	
	if(browser.equals("chrome"))
	{driver=new ChromeDriver();}
	else driver = new FirefoxDriver();
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
	// via property file
	driver.get(url);
	driver.findElement(By.name("user_name")).sendKeys(username);
	driver.findElement(By.name("user_password")).sendKeys(password);
	driver.findElement(By.id("submitButton")).click();
	
	//click on organization and enter fields
	driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
	driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	driver.findElement(By.name("accountname")).sendKeys("lohith1112");
	
	//select Education Education like Industry
	Select s= new Select(driver.findElement(By.name("industry")));
	s.selectByVisibleText("Education");
	driver.findElement(By.name("button")).click();
	
	Actions a=new Actions(driver);
	Thread.sleep(5000);
	WebElement ele=driver.findElement(By.xpath("//td[@class='small'))/img[contains(@src,'user.PNG')]"));
	

	
	a.moveToElement(ele).perform();
	driver.findElement(By.xpath("//a[text()='SignOut']")).click();
	
	
	
	


	

}

	
		
	}
