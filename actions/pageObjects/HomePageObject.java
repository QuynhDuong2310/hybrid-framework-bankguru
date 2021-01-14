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

	public void clickToNameField() {
		waitToElementToBeClickable(driver, HomePageUI.NAME_TEXT_BOX);
		clickToElement(driver, HomePageUI.NAME_TEXT_BOX);
	}

	public void clickToSubmiButton() {
		waitToElementToBeClickable(driver, HomePageUI.SUBMIT_BUTTON);
		clickToElement(driver, HomePageUI.SUBMIT_BUTTON);

	}

	public boolean isCustomerNameCanNotBeBlankErrorMesaaageDisplayed() {
		waitToElementVisible(driver, HomePageUI.ERROR_MESSAGE);
		return isElementDisplayed(driver, HomePageUI.ERROR_MESSAGE);
	}

}
