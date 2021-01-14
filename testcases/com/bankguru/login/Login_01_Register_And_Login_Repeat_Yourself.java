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

import commons.BasePage;
import pageObjects.HomePageObject;
import pageObjects.LoginPageOject;

public class Login_01_Register_And_Login_Repeat_Yourself extends BasePage{
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
		
		clickToElement(driver, "//a[text()='here']");
		sendKeyToElement(driver, "//input[@name='emailid']", getRandomEmail());
		clickToElement(driver, "//input[@name='btnLogin']");
		userName= getElementText(driver, "//td[text()='User ID :']/following-sibling::td");
		passWord = getElementText(driver, "//td[text()='Password :']/following-sibling::td");
		
	
	}

	@Test
	public void Login_02_Login_To_System() {
		driver.get(currentUrl);
		sendKeyToElement(driver, "//input[@name='uid']", userName);
		sendKeyToElement(driver, "//input[@name='password']", passWord);
		
		clickToElement(driver, "//input[@name='btnLogin']");
		String welcomeMessage = getElementText(driver, "//marquee[@class='heading3']");
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
