package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	
	
	public static LoginPageOject getLoginPage(WebDriver driver) {
		return new LoginPageOject(driver);
	}
	
	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}
	
	
}
