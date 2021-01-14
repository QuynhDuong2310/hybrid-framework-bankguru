package com.bankguru.newcustomer;

import org.testng.annotations.Test;

import pageObjects.HomePageObject;
import pageObjects.LoginPageOject;
import pageObjects.PageGeneratorManager;

import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class New_Customer{
	WebDriver driver;
	String projectLocator = System.getProperty("user.dir");
	String userName = "mngr302795";
	String passWord = "ybemAqe" ;
	String currentUrl;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", projectLocator + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/v4/");
		currentUrl = driver.getCurrentUrl();
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		loginPage = PageGeneratorManager.getLoginPage(driver);
		}

	@Test
	public void TC_01_Name_Can_Not_Be_Empty() {
		
		loginPage.inputToUsernameTextbox(userName);
		
		loginPage.inputToPasswordTextbox(passWord);
		
		homepage= loginPage.clickToSubmitButton();
		
		homepage.clickToNewCustomerLink();
		
		homepage.clickToNameField();
		
		homepage.clickToSubmiButton();
		
		Assert.assertTrue(homepage.isCustomerNameCanNotBeBlankErrorMesaaageDisplayed());
		  		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	HomePageObject homepage;
	LoginPageOject loginPage;
}
