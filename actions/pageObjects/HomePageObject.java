package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.HomePageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToNewCustomerLink() {
		waitToElementToBeClickable(driver, HomePageUI.NEW_CUSTOMER_LINK);
		clickToElement(driver, HomePageUI.NEW_CUSTOMER_LINK);
	}

	public String getCustomerRegisteredSuccessfully() {
		waitToElementVisible(driver, HomePageUI.CUSTOMER_REGISTERED_SUCCESSFULLY_MESAGE);
		return getTextElement(driver, HomePageUI.CUSTOMER_REGISTERED_SUCCESSFULLY_MESAGE);
	}

	public String getCustomerID() {
		waitToElementVisible(driver, HomePageUI.CUSTOMER_ID);
		return getElementText(driver, HomePageUI.CUSTOMER_ID);
	}

	
}
