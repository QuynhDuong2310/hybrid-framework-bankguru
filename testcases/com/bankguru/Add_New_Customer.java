package com.bankguru;

import org.testng.annotations.Test;

import commons.BaseTest;
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

public class Add_New_Customer extends BaseTest{
	WebDriver driver;
	String projectLocator = System.getProperty("user.dir");
	String userName = "mngr302795";
	String passWord = "ybemAqe";
	String customerName = "QuynhDuong";
	String dateOfBirth = "01/22/2022";
	String adrress = "3A building";
	String city = "Ha Noi";
	String state = "Cau Giay";
	String pin = "123456";
	String mobilePhone = "012345689";
	String email = "Quynhxoansh95" + getRandomNuber() + "@gmail.com";
	String password = "12345678";
	String customerID;
	

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", projectLocator + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/v4/");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		loginPage = PageGeneratorManager.getLoginPage(driver);

		loginPage.inputToUsernameTextbox(userName);

		loginPage.inputToPasswordTextbox(passWord);

		homepage = loginPage.clickToSubmitButton();

		homepage.openNewPageByName(driver, "New Customer");

		newCustomerPage = PageGeneratorManager.getNewCustomerPage(driver);
	}

	@Test
	public void Add_New_Customer_01_Successfully() {

		newCustomerPage.enterToCustomerNameTextbox(customerName);

		newCustomerPage.selectFemaleRadiobutton();

		newCustomerPage.selectDateOfBirthCalendar(dateOfBirth);

		newCustomerPage.enterToAddressTextarea(adrress);

		newCustomerPage.enterToCityTextbox(city, "city");

		newCustomerPage.enterToStateTextbox(state, "state");

		newCustomerPage.enterToPinTextbox(pin, "pinno");

		newCustomerPage.enterToMobileNumberTextbox(mobilePhone, "telephoneno");

		newCustomerPage.enterToEmailTextbox(email, "emailid");

		newCustomerPage.enterToPasswordTextbox(password, "password");

		newCustomerPage.clickToSubmiButton();
		
		
		homepage = PageGeneratorManager.getHomePage(driver);
		
		Assert.assertEquals(homepage.getCustomerRegisteredSuccessfully(), "Customer Registered Successfully!!!");
		
		customerID = homepage.getCustomerID();
		
		homepage.openNewPageByName(driver, "Edit Customer");
		
		editCustomerPage = PageGeneratorManager.getEditCustomerPage(driver);
		
		editCustomerPage.enterCustomerIDToTextbox(customerID);
		
		
		

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
