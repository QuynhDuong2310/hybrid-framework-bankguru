package com.bankguru;

import org.testng.annotations.Test;

import pageObjects.EditCustomerPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageOject;
import pageObjects.NewCustomerPageObject;
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
		
		loginPage.inputToUsernameTextbox(userName);
		
		loginPage.inputToPasswordTextbox(passWord);
		
		homepage = loginPage.clickToSubmitButton();
		
		homepage.openNewPageByName(driver, "New Customer");
		
		newCustomerPage = PageGeneratorManager.getNewCustomerPage(driver);
		}

	
	public void TC_01_Name_Can_Not_Be_Empty() {
		
		newCustomerPage.clickToNameField();
		
		newCustomerPage.clickToSubmiButton();
		
		Assert.assertTrue(newCustomerPage.isCustomerNameCanNotBeBlankErrorMesaaageDisplayed());
	}

	
	public void TC_02_Name_Can_Not_Be_Numberic() {
		
		newCustomerPage.clickToNameField();
		
		newCustomerPage.enterNumbericToNameTextbox("12343");
		
		Assert.assertTrue(newCustomerPage.isCustomerNameCanNotIncludedNumbericErrorMesaaageDisplayed());
		
	}
	
	
	public void TC_03_Name_Can_Not_Have_Special_Character() {
		
		newCustomerPage.enterSpecialCharacterToNameTextbox("!@#*(#&$");
		
		Assert.assertTrue(newCustomerPage.isCustomerNameCanNotIncludedSpecialCharacterErrorMesaaageDisplayed());
	}
	
	
	public void TC_04_Name_Can_Not_Start_With_Blank_Character() {
		
		newCustomerPage.enterFirstCharacterWithBlankToNameTextbox(" ");
		
		Assert.assertTrue(newCustomerPage.isCustomerNameCanNotIncludedBlankFirstCharacterErrorMesaaageDisplayed());
	}
	
	
	public void TC_05_Adress_Can_Not_Be_Empty() {
		newCustomerPage.clickToAdressField();	
		newCustomerPage.focusOutAdressTextbox();
		Assert.assertTrue(newCustomerPage.isCustomerAdressCanNotBeBlankErrorMesaaageDisplayed());
	}
	
	
	public void TC_06_Adress_Can_Not_Start_With_Blank_Character() {
		
		newCustomerPage.enterFirstCharacterWithBlankToAdressTextbox(" ");
		
		Assert.assertTrue(newCustomerPage.isCustomerAdressCanNotIncludedBlankFirstCharacterErrorMesaaageDisplayed());
	}
	
	@Test
	public void TC_07_Verify_Field_Labels() {
		Assert.assertTrue(newCustomerPage.isFielDisplayedCorrectly("Customer Name"));
		Assert.assertTrue(newCustomerPage.isFielDisplayedCorrectly("Gender"));
		Assert.assertTrue(newCustomerPage.isFielDisplayedCorrectly("Date of Birth"));
		Assert.assertTrue(newCustomerPage.isFielDisplayedCorrectly("Address"));
		Assert.assertTrue(newCustomerPage.isFielDisplayedCorrectly("City"));
		Assert.assertTrue(newCustomerPage.isFielDisplayedCorrectly("State"));
		Assert.assertTrue(newCustomerPage.isFielDisplayedCorrectly("PIN"));
		Assert.assertTrue(newCustomerPage.isFielDisplayedCorrectly("Mobile Number"));
		Assert.assertTrue(newCustomerPage.isFielDisplayedCorrectly("E-mail"));
		Assert.assertTrue(newCustomerPage.isFielDisplayedCorrectly("Passwords"));
		
	}
	
	@AfterClass

	public void afterClass() {
		driver.quit();
	}

	HomePageObject homepage;
	LoginPageOject loginPage;
	NewCustomerPageObject newCustomerPage;
	EditCustomerPageObject editCustomerPage;
	
}
