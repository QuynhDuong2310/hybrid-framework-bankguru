package com.bankguru;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.EditCustomerPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageOject;
import pageObjects.NewCustomerPageObject;
import pageObjects.PageGeneratorManager;

public class Edit_Customer  extends BaseTest{
	WebDriver driver;
	String userName = "mngr302795";
	String passWord = "ybemAqe";
	String customerID = "17747";

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {		
		driver = getBrowserDriver(browserName);

		loginPage = PageGeneratorManager.getLoginPage(driver);

		loginPage.inputToUsernameTextbox(userName);

		loginPage.inputToPasswordTextbox(passWord);

		homepage = loginPage.clickToSubmitButton();

		homepage.openNewPageByName(driver, "Edit Customer");

		editCustomerPage = PageGeneratorManager.getEditCustomerPage(driver);

	}

	public void Edit_Customer_01_CustomerID_Can_Not_Be_Empty() {

		editCustomerPage.clickToCustomerIDTextbox();

		editCustomerPage.clickToCustomerIDLabel();

		Assert.assertTrue(editCustomerPage.isCustomerIDErrorMesaaageDisplayed("Customer ID is required"));
	}

	public void Edit_Customer_02_CustomerID_Must_Be_Numberic() {

		editCustomerPage.enterCustomerIDToTextbox("fjdsf");

		Assert.assertTrue(editCustomerPage.isCustomerIDErrorMesaaageDisplayed("Characters are not allowed"));

	}

	public void Edit_Customer_03_CustomerID_Can_Not_Have_Special_Character() {

		editCustomerPage.enterCustomerIDToTextbox("@(*&^");

		Assert.assertTrue(editCustomerPage.isCustomerIDErrorMesaaageDisplayed("Special characters are not allowed"));
	}

	@Test
	public void Edit_Customer_04_Valid_CustomerID() {
		editCustomerPage.enterCustomerIDToTextbox(customerID);

		editCustomerPage.clickToButton("submit");

		Assert.assertTrue(editCustomerPage.isEditCustomerLableDisplayed());

	}

	public void Edit_Customer_05_Adress_Can_Not_Be_Empty() {
		editCustomerPage.clickAndClearDataToFieldTextarea("Address", "addr");
		editCustomerPage.clickToFieldLabel("Address");
		Assert.assertTrue(editCustomerPage.isCustomerIDErrorMesaaageDisplayed("Address Field must not be blank"));
	}

	public void Edit_Customer_06_City_Can_Not_Be_Empty() {
		editCustomerPage.clickAndClearDataToFieldTextbox("City", "city");
		editCustomerPage.clickToFieldLabel("City");
		Assert.assertTrue(editCustomerPage.isCustomerIDErrorMesaaageDisplayed("City Field must not be blank"));
	}

	public void Edit_Customer_07_State_Must_Be_Numberic() {

		editCustomerPage.clickAndClearDataToFieldTextbox("State", "state");

		editCustomerPage.enterValueToFieldTextBox("1234", "State", "state");

		Assert.assertTrue(editCustomerPage.isCustomerIDErrorMesaaageDisplayed("Numbers are not allowed"));

	}

	public void Edit_Customer_08_State_Can_Not_Have_Special_Character() {

		editCustomerPage.clickAndClearDataToFieldTextbox("State", "state");

		editCustomerPage.enterValueToFieldTextBox("!$#", "State", "state");

		Assert.assertTrue(editCustomerPage.isCustomerIDErrorMesaaageDisplayed("Special characters are not allowed"));
	}

	public void Edit_Customer_09_Pin_Can_Not_Be_Empty() {
		editCustomerPage.clickAndClearDataToFieldTextbox("PIN", "pinno");
		editCustomerPage.clickToFieldLabel("PIN");
		Assert.assertTrue(editCustomerPage.isCustomerIDErrorMesaaageDisplayed("PIN Code must not be blank"));
	}

	public void Edit_Customer_10_State_Must_Be_Numberic() {

		editCustomerPage.clickAndClearDataToFieldTextbox("State", "state");

		editCustomerPage.enterValueToFieldTextBox("1234", "State", "state");

		Assert.assertTrue(editCustomerPage.isCustomerIDErrorMesaaageDisplayed("Numbers are not allowed"));

	}

	public void Edit_Customer_11_State_Can_Not_Have_Special_Character() {

		editCustomerPage.clickAndClearDataToFieldTextbox("State", "state");

		editCustomerPage.enterValueToFieldTextBox("!$#", "State", "state");

		Assert.assertTrue(editCustomerPage.isCustomerIDErrorMesaaageDisplayed("Special characters are not allowed"));
	}

	public void Edit_Customer_12_State_Must_Have_6_Character() {

		editCustomerPage.clickAndClearDataToFieldTextbox("State", "state");

		editCustomerPage.enterValueToFieldTextBox("123", "State", "state");

		Assert.assertTrue(editCustomerPage.isCustomerIDErrorMesaaageDisplayed("PIN Code must have 6 Digits"));
	}

	@Test
	public void Edit_Customer_13_Telephone_Can_Not_Be_Empty() {
		editCustomerPage.clickAndClearDataToFieldTextbox("Mobile Number", "telephoneno");
		editCustomerPage.clickToFieldLabel("Mobile Number");
		Assert.assertTrue(editCustomerPage.isCustomerIDErrorMesaaageDisplayed("Mobile no must not be blank"));
	}

	@Test
	public void Edit_Customer_14_Telephone_Can_Not_Have_Special_Character() {

		editCustomerPage.clickAndClearDataToFieldTextbox("Mobile Number", "telephoneno");

		editCustomerPage.enterValueToFieldTextBox("!$#", "Mobile Number", "telephoneno");

		Assert.assertTrue(editCustomerPage.isCustomerIDErrorMesaaageDisplayed("Special characters are not allowed"));
	}

	@Test
	public void Edit_Customer_15_Email_Can_Not_Be_Empty() {
		editCustomerPage.clickAndClearDataToFieldTextbox("E-mail", "emailid");
		editCustomerPage.clickToFieldLabel("E-mail");
		Assert.assertTrue(editCustomerPage.isCustomerIDErrorMesaaageDisplayed("Email-ID must not be blank"));
	}

	@Test
	public void Edit_Customer_16_Email_Invalid() {

		editCustomerPage.clickAndClearDataToFieldTextbox("E-mail", "emailid");

		editCustomerPage.enterValueToFieldTextBox("Quynh", "E-mail", "emailid");

		Assert.assertTrue(editCustomerPage.isCustomerIDErrorMesaaageDisplayed("Email-ID is not valid"));
	}

	@Test
	public void Edit_Customer_18_Email_Invalid() {

		editCustomerPage.clickAndClearDataToFieldTextbox("E-mail", "emailid");

		editCustomerPage.enterValueToFieldTextBox("Quynh@", "E-mail", "emailid");

		Assert.assertTrue(editCustomerPage.isCustomerIDErrorMesaaageDisplayed("Email-ID is not valid"));
	}

	@Test
	public void Edit_Customer_19_Email_Invalid() {

		editCustomerPage.clickAndClearDataToFieldTextbox("E-mail", "emailid");

		editCustomerPage.enterValueToFieldTextBox("Quynhgmail.com", "E-mail", "emailid");

		Assert.assertTrue(editCustomerPage.isCustomerIDErrorMesaaageDisplayed("Email-ID is not valid"));
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
