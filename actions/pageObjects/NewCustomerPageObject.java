package pageObjects;

import org.openqa.selenium.WebDriver;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import commons.BasePage;
import pageUIs.HomePageUI;
import pageUIs.NewCustomerPageUI;

public class NewCustomerPageObject extends BasePage {
	public NewCustomerPageObject(WebDriver driver) {

		this.driver = driver;
	}

	WebDriver driver;

	public void clickToNameField() {
		waitToElementToBeClickable(driver, NewCustomerPageUI.CUSTOMER_TEXT_BOX);
		clickToElement(driver, NewCustomerPageUI.CUSTOMER_TEXT_BOX);
	}

	public HomePageObject clickToSubmiButton() {
		waitToElementToBeClickable(driver, NewCustomerPageUI.SUBMIT_BUTTON);
		clickToElement(driver, NewCustomerPageUI.SUBMIT_BUTTON);
		return new PageGeneratorManager().getHomePage(driver);

	}

	public boolean isCustomerNameCanNotBeBlankErrorMesaaageDisplayed() {
		waitToElementVisible(driver, NewCustomerPageUI.NAME_CANOT_BE_EMPTY_ERROR_MESSAGE);
		return isElementDisplayed(driver, NewCustomerPageUI.NAME_CANOT_BE_EMPTY_ERROR_MESSAGE);
	}

	public void enterNumbericToNameTextbox(String numberic) {
		waitToElementVisible(driver, NewCustomerPageUI.CUSTOMER_TEXT_BOX);
		sendKeyToElement(driver, NewCustomerPageUI.CUSTOMER_TEXT_BOX, numberic);

	}

	public boolean isCustomerNameCanNotIncludedNumbericErrorMesaaageDisplayed() {
		waitToElementVisible(driver, NewCustomerPageUI.NUMBERS_ARE_NOT_ALLOWED_ERROR_MESSAGE);
		return isElementDisplayed(driver, NewCustomerPageUI.NUMBERS_ARE_NOT_ALLOWED_ERROR_MESSAGE);
	}

	public void enterSpecialCharacterToNameTextbox(String specialCharacter) {
		waitToElementVisible(driver, NewCustomerPageUI.CUSTOMER_TEXT_BOX, specialCharacter);
		sendKeyToElement(driver, NewCustomerPageUI.CUSTOMER_TEXT_BOX, specialCharacter);

	}

	public boolean isCustomerNameCanNotIncludedSpecialCharacterErrorMesaaageDisplayed() {
		waitToElementVisible(driver, NewCustomerPageUI.SPECIAL_CHARACTER_ARE_NOT_ALLOWED_ERROR_MESSAGE);
		return isElementDisplayed(driver, NewCustomerPageUI.SPECIAL_CHARACTER_ARE_NOT_ALLOWED_ERROR_MESSAGE);
	}

	public void enterFirstCharacterWithBlankToNameTextbox(String blankFirst) {
		waitToElementVisible(driver, NewCustomerPageUI.CUSTOMER_TEXT_BOX, blankFirst);
		sendKeyToElement(driver, NewCustomerPageUI.CUSTOMER_TEXT_BOX, blankFirst);

	}

	public boolean isCustomerNameCanNotIncludedBlankFirstCharacterErrorMesaaageDisplayed() {
		waitToElementVisible(driver,
				NewCustomerPageUI.BLANK_FIRST_CHARACTER_AT_CUSTOMER_NAME_ARE_NOT_ALLOWED_ERROR_MESSAGE);
		return isElementDisplayed(driver,
				NewCustomerPageUI.BLANK_FIRST_CHARACTER_AT_CUSTOMER_NAME_ARE_NOT_ALLOWED_ERROR_MESSAGE);

	}

	public void clickToAdressField() {
		waitToElementVisible(driver, NewCustomerPageUI.ADDRESS_TEXT_BOX);
		clickToElement(driver, NewCustomerPageUI.ADDRESS_TEXT_BOX);

	}

	public boolean isCustomerAdressCanNotBeBlankErrorMesaaageDisplayed() {
		waitToElementVisible(driver, NewCustomerPageUI.ADRESS_CAN_NOT_BE_EMPTY_ERROR_MESSAGE);
		return isElementDisplayed(driver, NewCustomerPageUI.ADRESS_CAN_NOT_BE_EMPTY_ERROR_MESSAGE);

	}

	public void focusOutAdressTextbox() {
		waitToElementVisible(driver, NewCustomerPageUI.CITY_TEXT_BOX);
		clickToElement(driver, NewCustomerPageUI.CITY_TEXT_BOX);

	}

	public void enterFirstCharacterWithBlankToAdressTextbox(String blankFirst) {
		waitToElementVisible(driver, NewCustomerPageUI.ADDRESS_TEXT_BOX, blankFirst);
		sendKeyToElement(driver, NewCustomerPageUI.ADDRESS_TEXT_BOX, blankFirst);

	}

	public boolean isCustomerAdressCanNotIncludedBlankFirstCharacterErrorMesaaageDisplayed() {
		waitToElementVisible(driver, NewCustomerPageUI.BLANK_FIRST_CHARACTER_AT_ADRESS_ARE_NOT_ALLOWED_ERROR_MESSAGE);
		return isElementDisplayed(driver,
				NewCustomerPageUI.BLANK_FIRST_CHARACTER_AT_ADRESS_ARE_NOT_ALLOWED_ERROR_MESSAGE);

	}

	public boolean isFielDisplayedCorrectly(String fieldLabel) {
		waitToElementVisible(driver, NewCustomerPageUI.DYNAMIC_FIELD_LABLE, fieldLabel);
		return isElementDisplayed(driver, NewCustomerPageUI.DYNAMIC_FIELD_LABLE, fieldLabel);
	}

	public void enterToCustomerNameTextbox(String customerName) {
		waitToElementVisible(driver, NewCustomerPageUI.CUSTOMER_TEXT_BOX, customerName);
		sendKeyToElement(driver, NewCustomerPageUI.CUSTOMER_TEXT_BOX, customerName);

	}

	public void selectFemaleRadiobutton() {
		waitToElementToBeClickable(driver, NewCustomerPageUI.GENDER_RADIOBUTTON);
		clickToElement(driver, NewCustomerPageUI.GENDER_RADIOBUTTON);

	}

	public void selectDateOfBirthCalendar(String DateOfBirth) {
		waitToElementToBeClickable(driver, NewCustomerPageUI.CALENDAR, DateOfBirth);
		sendKeyToElement(driver, NewCustomerPageUI.CALENDAR, DateOfBirth);

	}

	public void enterToAddressTextarea(String address) {
		waitToElementVisible(driver, NewCustomerPageUI.ADDRESS_TEXT_BOX);
		sendKeyToElement(driver, NewCustomerPageUI.ADDRESS_TEXT_BOX, address);
	}

	public void enterToCityTextbox(String city, String cityTextbox) {
		waitToElementVisible(driver, NewCustomerPageUI.DYNAMIC_TEXT_BOX_AT_ADD_NEW_CUSTOMER, cityTextbox);
		sendKeyToElement(driver, NewCustomerPageUI.DYNAMIC_TEXT_BOX_AT_ADD_NEW_CUSTOMER, city, cityTextbox);
	}

	public void enterToStateTextbox(String state, String stateTextbox) {
		waitToElementVisible(driver, NewCustomerPageUI.DYNAMIC_TEXT_BOX_AT_ADD_NEW_CUSTOMER, stateTextbox);
		sendKeyToElement(driver, NewCustomerPageUI.DYNAMIC_TEXT_BOX_AT_ADD_NEW_CUSTOMER, state, stateTextbox);
	}

	public void enterToPinTextbox(String pin, String pinTextbox) {
		waitToElementVisible(driver, NewCustomerPageUI.DYNAMIC_TEXT_BOX_AT_ADD_NEW_CUSTOMER, pinTextbox);
		sendKeyToElement(driver, NewCustomerPageUI.DYNAMIC_TEXT_BOX_AT_ADD_NEW_CUSTOMER, pin, pinTextbox);
	}

	public void enterToMobileNumberTextbox(String mobilePhone, String mobilePhoneTextbox) {
		waitToElementVisible(driver, NewCustomerPageUI.DYNAMIC_TEXT_BOX_AT_ADD_NEW_CUSTOMER, mobilePhoneTextbox);
		sendKeyToElement(driver, NewCustomerPageUI.DYNAMIC_TEXT_BOX_AT_ADD_NEW_CUSTOMER, mobilePhone, mobilePhoneTextbox);
	}

	public void enterToEmailTextbox(String email, String emailTextbox) {
		waitToElementVisible(driver, NewCustomerPageUI.DYNAMIC_TEXT_BOX_AT_ADD_NEW_CUSTOMER, emailTextbox);
		sendKeyToElement(driver, NewCustomerPageUI.DYNAMIC_TEXT_BOX_AT_ADD_NEW_CUSTOMER, email, emailTextbox);


	}

	public void enterToPasswordTextbox(String password, String passwordTextbox) {
		waitToElementVisible(driver, NewCustomerPageUI.DYNAMIC_TEXT_BOX_AT_ADD_NEW_CUSTOMER, passwordTextbox);
		sendKeyToElement(driver, NewCustomerPageUI.DYNAMIC_TEXT_BOX_AT_ADD_NEW_CUSTOMER, password, passwordTextbox);
	}


	


}
