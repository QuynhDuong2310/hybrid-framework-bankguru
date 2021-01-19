package commons;

import java.util.Collections;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
	private WebDriver driver;
	private String projectLocator = System.getProperty("user.dir");
	
	protected WebDriver getBrowserDriver(String browserName) {
		if(browserName.equals("chrome_ui"))
		{
			System.setProperty("webdriver.chrome.driver", projectLocator + "\\browserDrivers\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("useAutomationExtenion", false);
			options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
			driver = new ChromeDriver();
		}else if(browserName.equals("firefox_ui"))
		{
			System.setProperty("webdriver.gecko.driver", projectLocator + "\\browserDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}else
		{
			throw new RuntimeException("Please input valid browser name!");

		}
		driver.get("http://demo.guru99.com/v4/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}
	

	

	protected int getRandomNuber() {
	Random random = new Random();
	return random.nextInt(9999);
		}
}

