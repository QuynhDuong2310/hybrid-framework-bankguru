package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.EditCustomerPageUI;

public class EditCustomerPageObject extends BasePage{	
	public EditCustomerPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}

	WebDriver driver;

	public void enterCustomerIDToTextbox(String customerID) {
		waitToElementVisible(driver, EditCustomerPageUI.CUSTOMER_ID_TEXTBOX);
		sendKeyToElement(driver, EditCustomerPageUI.CUSTOMER_ID_TEXTBOX, customerID);
	}

	public void clickToCustomerIDTextbox() {
		waitToElementVisible(driver, EditCustomerPageUI.CUSTOMER_ID_TEXTBOX);
		clickToElement(driver, EditCustomerPageUI.CUSTOMER_ID_TEXTBOX);
		
	}

	public void clickToCustomerIDLabel() {
		waitToElementVisible(driver, EditCustomerPageUI.CUSTOMER_ID_LABEL);
		clickToElement(driver, EditCustomerPageUI.CUSTOMER_ID_LABEL);
		
	}

	public boolean isCustomerIDErrorMesaaageDisplayed(String errorMessage) {
		waitToElementVisible(driver, EditCustomerPageUI.DYNAMIC_CUSTOMER_ID_MESSAGE, errorMessage);
		return isElementDisplayed(driver, EditCustomerPageUI.DYNAMIC_CUSTOMER_ID_MESSAGE, errorMessage);
	}

	public boolean isEditCustomerLableDisplayed() {
		waitToElementVisible(driver, EditCustomerPageUI.EDIT_CUSTOMER_LABLE_AT_EDIT_PAGE);
		return isElementDisplayed(driver, EditCustomerPageUI.EDIT_CUSTOMER_LABLE_AT_EDIT_PAGE);
	}

	public void clickToButton(String nameButton) {
		waitToElementVisible(driver, EditCustomerPageUI.DYNAMIC_BUTTON, nameButton);
		clickToElement(driver, EditCustomerPageUI.DYNAMIC_BUTTON, nameButton);
		
	}

	public void clickAndClearDataToFieldTextarea(String fieldName, String textArea) {
		waitToElementVisible(driver, EditCustomerPageUI.FIELD_TEXTAREA_AT_EDIT_PAGE, fieldName, textArea);
		clickToElement(driver, EditCustomerPageUI.FIELD_TEXTAREA_AT_EDIT_PAGE, fieldName, textArea);
		clearDataOfElement(driver, EditCustomerPageUI.FIELD_TEXTAREA_AT_EDIT_PAGE, fieldName, textArea);
	}

	public void clickToFieldLabel(String fieldName) {
		waitToElementVisible(driver, EditCustomerPageUI.DYNAMIC_FIELD_LABEL, fieldName);
		clickToElement(driver, EditCustomerPageUI.DYNAMIC_FIELD_LABEL, fieldName);
	}

	public void clickAndClearDataToFieldTextbox(String fieldName, String textboxName) {
		waitToElementVisible(driver, EditCustomerPageUI.FIELD_TEXTBOX_AT_EDIT_PAGE, fieldName, textboxName);
		clickToElement(driver, EditCustomerPageUI.FIELD_TEXTBOX_AT_EDIT_PAGE, fieldName, textboxName);
		clearDataOfElement(driver, EditCustomerPageUI.FIELD_TEXTBOX_AT_EDIT_PAGE, fieldName, textboxName);

	}

	public void enterValueToFieldTextBox(String value,  String fieldName, String textboxName) {
		waitToElementVisible(driver, EditCustomerPageUI.FIELD_TEXTBOX_AT_EDIT_PAGE, fieldName, textboxName);
		sendKeyToElement(driver, EditCustomerPageUI.FIELD_TEXTBOX_AT_EDIT_PAGE,value, fieldName, textboxName);
	}
	
}
