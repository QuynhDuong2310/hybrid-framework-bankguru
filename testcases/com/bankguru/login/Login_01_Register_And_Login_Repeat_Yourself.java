package com.bankguru.login;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Login_01_Register_And_Login_Repeat_Yourself{
	WebDriver driver;
	String projectLocator = System.getProperty("user.dir");
	String userName, passWord, currentUrl;

	@BeforeClass
	public void initBrowser() {
		System.setProperty("webdriver.chrome.driver",  projectLocator + "\\browserDrivers\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("http://demo.guru99.com/v4/");
		currentUrl= driver.getCurrentUrl();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test
	public void Login_01_Register_To_System() {
		driver.findElement(By.xpath("//a[text()='here']")).click();
		driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys(getRandomEmail());
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
		userName = driver.findElement(By.xpath("//td[text()='User ID :']/following-sibling::td")).getText();
		passWord = driver.findElement(By.xpath("//td[text()='Password :']/following-sibling::td")).getText();
	
	}

	@Test
	public void Login_02_Login_To_System() {
		driver.get(currentUrl);
		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(userName);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(passWord);
		
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
		String welcomeMessage = driver.findElement(By.cssSelector("marquee.heading3")).getText();
		Assert.assertEquals(welcomeMessage, "Welcome To Manager's Page of Guru99 Bank");
		
	}
	
	public String getRandomEmail() {
		Random rand = new Random();
		return "testing" + rand.nextInt(9999) + "@live.com";
	} 

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
