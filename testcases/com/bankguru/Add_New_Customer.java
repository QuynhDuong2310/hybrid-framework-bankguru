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
	String address = "3A building";
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
		
		log.info("Preconditon - Step 01: Open Login Page");
		loginPage = PageGeneratorManager.getLoginPage(driver);

		log.info("Preconditon - Step 02: Input to username textbox with value: " + userName);
		loginPage.inputToUsernameTextbox(userName);

		log.info("Preconditon - Step 03: Input to password textbox with value: " + password);
		loginPage.inputToPasswordTextbox(passWord);

		log.info("Preconditon - Step 04: Click on submit button");
		homepage = loginPage.clickToSubmitButton();

		log.info("Preconditon - Step 05: Click on new customer link");
		homepage.openNewPageByName(driver, "New Customer");

		log.info("Preconditon - Step 06: Get new customer Page");
		newCustomerPage = PageGeneratorManager.getNewCustomerPage(driver);
	}

	@Test
	public void Add_New_Customer_01_Successfully() {

		log.info("Add new customer- Step 1: Input Customer Name " + customerName);
		newCustomerPage.enterToCustomerNameTextbox(customerName);

		log.info("Add new customer- Step 2: Select Female Radio Button");
		newCustomerPage.selectFemaleRadiobutton();

		log.info("Add new customer- Step 3: Select Date Of Birth with value: " + dateOfBirth);
		newCustomerPage.selectDateOfBirthCalendar(dateOfBirth);

		log.info("Add new customer- Step 4: Input to address with value: " + address);
		newCustomerPage.enterToAddressTextarea(address);

		log.info("Add new customer- Step 5: Input to City with value: " + city);
		newCustomerPage.enterToCityTextbox(city, "city");

		log.info("Add new customer- Step 6: Input to state with value: " + state);
		newCustomerPage.enterToStateTextbox(state, "state");

		log.info("Add new customer- Step 7: Input to pin with value: " + pin);
		newCustomerPage.enterToPinTextbox(pin, "pinno");

		log.info("Add new customer- Step 8: Input to mobilePhone with value: " + mobilePhone);
		newCustomerPage.enterToMobileNumberTextbox(mobilePhone, "telephoneno");

		log.info("Add new customer- Step 9: Input to email with value: " + email);
		newCustomerPage.enterToEmailTextbox(email, "emailid");

		log.info("Add new customer- Step 10: Input to password with value: " + password);
		newCustomerPage.enterToPasswordTextbox(password, "password");

		log.info("Add new customer- Step 11: Click on Submite button");
		newCustomerPage.clickToSubmiButton();
		
		log.info("Add new customer- Step 12: Open Home page");
		homepage = PageGeneratorManager.getHomePage(driver);
		
		log.info("Add new customer- Step 13: Verify Registered Successfully Message");
		verifyEquals(homepage.getCustomerRegisteredSuccessfully(), "Customer Registered Successfully!!!");
		
		log.info("Add new customer- Step 14: Get ra Customer ID");
		customerID = homepage.getCustomerID();
		
		log.info("Add new customer- Step 15: Click on  Edit customer link");
		homepage.openNewPageByName(driver, "Edit Customer");
		
		log.info("Add new customer- Step 16: Open  Edit Customer Page");
		editCustomerPage = PageGeneratorManager.getEditCustomerPage(driver);
		
		log.info("Add new customer- Step 17: Input to CustomerID textbox with value: "+ customerID);
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
