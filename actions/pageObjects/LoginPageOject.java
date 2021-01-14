package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.LoginPageUI;

public class LoginPageOject  extends BasePage{
	WebDriver driver;
	
	public LoginPageOject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToUsernameTextbox(String userName) {
		waitToElementVisible(driver, LoginPageUI.USER_TEXT_BOX);
		sendKeyToElement(driver, LoginPageUI.USER_TEXT_BOX, userName);
		
	}

	public void inputToPasswordTextbox(String password) {
		waitToElementVisible(driver, LoginPageUI.PASSWORD_TEXT_BOX);
		sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXT_BOX, password);
		
	}

	public HomePageObject clickToSubmitButton() {
		waitToElementToBeClickable(driver, LoginPageUI.SUBMIT_BUTTON);
		clickToElement(driver, LoginPageUI.SUBMIT_BUTTON);
		return PageGeneratorManager.getHomePage(driver);
		
		
	}

}
