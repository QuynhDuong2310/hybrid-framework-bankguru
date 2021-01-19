package commons;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageUIs.AbstractPageUI;

public class BasePage {

	public void openPageUrl(WebDriver driver, String url) {
		driver.get(url);
	}

	public String getCurrentPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getCurrentPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getCurrentPageSource(WebDriver driver) {
		return driver.getPageSource();

	}

	public void backToPage(WebDriver driver) {
		driver.navigate().back();
		;
	}

	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}

	public void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public String getTextlAlert(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}

	public void setToAlert(WebDriver driver, String value) {
		driver.switchTo().alert().sendKeys(value);
	}

	public void waitToAlertPresence(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.alertIsPresent());
	}

	public void switchToWindowByID(WebDriver driver, String parentID) {
		Set<String> allWindowns = driver.getWindowHandles();
		for (String runWIndown : allWindowns) {
			if (!runWIndown.equals(parentID)) {
				driver.switchTo().window(runWIndown);
			}

		}
	}

	public void switchToWindowByTitle(WebDriver driver, String title) {
		Set<String> allWindowns = driver.getWindowHandles();
		for (String runWIndown : allWindowns) {
			driver.switchTo().window(runWIndown);
			String currentWindown = driver.getTitle();
			if (currentWindown.equals(title)) {
				break;

			}
		}
	}

	public void closeAllWindownsExceptforParent(WebDriver driver, String parentID) {
		Set<String> allWindowns = driver.getWindowHandles();
		for (String runWIndown : allWindowns) {
			if (!runWIndown.equals(parentID)) {
				driver.switchTo().window(runWIndown).close();
				;
			}
		}
		driver.switchTo().window(parentID);
	}

	public WebElement getElement(WebDriver driver, String locator) {
		return driver.findElement(getByXpath(locator));
	}

	public List<WebElement> getElements(WebDriver driver, String locator) {
		return driver.findElements(getByXpath(locator));
	}

	public By getByXpath(String locator) {
		return By.xpath(locator);
	}

	public void clickToElement(WebDriver driver, String locator) {
		element = getElement(driver, locator);
		element.click();
	}
	public String getTextElement(WebDriver driver, String locator) {
		element = getElement(driver, locator);
		return element.getText();
	}

	public void sendKeyToElement(WebDriver driver, String locator, String value) {
		element = getElement(driver, locator);
		element.clear();
		element.sendKeys(value);
	}

	public void selectItemInDefaultDropDown(WebDriver driver, String locator, String itemValue) {
		element = getElement(driver, locator);
		select = new Select(element);
		select.selectByVisibleText(itemValue);

	}

	public String getFirstSlectedTextInDropdown(WebDriver driver, String locator) {
		element= getElement(driver, locator);
		select = new Select(element);
		return select.getFirstSelectedOption().getText();
	}
	
	public boolean isDropdownMultiple(WebDriver driver, String locator) {
		element= getElement(driver, locator);
		select = new Select(element);
		return select.isMultiple();
	}
	
	public void selectItemInCustomDropdown(WebDriver driver, String parenLoactor, String childItem, String expectedItem) {
		
		//Click vao item cha de xo ra duoc cac item con
		getElement(driver, parenLoactor).click();
		sleepInsecond(1);
		explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childItem)));
		
		elements = getElements(driver, childItem);
		for (WebElement item : elements) {
			if (item.getText().equals(expectedItem)) {
				jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("argument[0].scrollIntoView(true)", item);
				sleepInsecond(1);
				item.click();
				sleepInsecond(1);
				break;
			}
		}
		
		
	}
	public void sleepInsecond(long timeout) {
		 try {
			Thread.sleep(timeout*1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	 }

	public String getElementAttribute(WebDriver driver, String locator, String attributName) {
		element = getElement(driver, locator);
		return element.getAttribute(attributName);
	}
	
	public String getElementText(WebDriver driver, String locator) {
		element = getElement(driver, locator);
		return element.getText();
	}
	
	public int countElementSize(WebDriver driver, String locator) {
		return getElements(driver, locator).size();
		
	}
	
	public void checkTocheckBox(WebDriver driver, String locator) {
		element = getElement(driver, locator);
		if (!element.isSelected()) {			
			element.click();
		}
	}
	
	public void unCheckTocheckBox(WebDriver driver, String locator) {
		element = getElement(driver, locator);
		if (element.isSelected()) {			
			element.click();
		}
	}
	
	public boolean isElementDisplayed(WebDriver driver, String locator) {
		element = getElement(driver, locator);
		return element.isDisplayed();
	}
	public boolean isElementEnabled(WebDriver driver, String locator) {
		element = getElement(driver, locator);
		return element.isEnabled();
	}
	
	
	public boolean isElementSelected(WebDriver driver, String locator) {
		element = getElement(driver, locator);
		return element.isSelected();
	}
	

	
	public void switchToFrame(WebDriver driver, String locator) {
		driver.switchTo().frame(getElement(driver, locator));
	}
	public void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	public void doubleClickToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.doubleClick(getElement(driver, locator)).perform();
		
	}
	public void rightClickToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.contextClick(getElement(driver, locator)).perform();
		
	}
	public void hovermouseToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.moveToElement(getElement(driver, locator)).perform();
		
	}
	public void clickAndHouseToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.clickAndHold(getElement(driver, locator)).perform();
		
	}
	
	public void drapAndDropElement(WebDriver driver, String sourceLocator, String targetLocator) {
		action = new Actions(driver);
		action.dragAndDrop(getElement(driver, sourceLocator), getElement(driver, targetLocator)).perform();
	}
	
	public void sendKeyBordToElemt(WebDriver driver, String locator, Keys key) {
		action = new Actions(driver);
		action.sendKeys(getElement(driver, locator), key).perform();
	}
	
	public Object executorForBrowser(WebDriver driver, String javaSript) {
		jsExecutor = (JavascriptExecutor) driver;
		return jsExecutor.executeScript(javaSript);		
	}
	
	public boolean areExpectedTextInInnerText(WebDriver driver, String textExpected) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		String textActual = (String) jsExecutor.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0]");
		return textActual.equals(textExpected);
	}
	public String getInnerText(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return document.documentElement.innerText;");
	}
	public void scrollToBottomPage(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void navigateToUrlByJS(WebDriver driver, String url) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.location = '" + url + "'");
	}

	public void highlightElement(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getElement(driver, locator);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
		sleepInsecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getElement(driver, locator);
		jsExecutor.executeScript("arguments[0].click();", element);
	}

	public void scrollToElement(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getElement(driver, locator);
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getElement(driver, locator);
		jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", element);
	}

	public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getElement(driver, locator);
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", element);
	}

	public boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};

		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

	public String getElementValidationMessage(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getElement(driver, locator);
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", element);
	}

	public boolean isImageLoaded(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		element= getElement(driver, locator);
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWisth !=\"undefined\" && arguments[0].natualWidth > 0", element);
		if (status) {
			return true;		
		} else {
			return false;
		}
	}

	public void waitToElementVisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait (driver, 30);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
	}
	public void waitToElementInisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait (driver, 30);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(locator)));
	}
	public void waitToElementToBeClickable(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait (driver, 30);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(locator)));
	}
	
	public String getDynamicLoctor(String locator, String...values) {
		return locator = String.format(locator, (Object[])values);
	}
	public void waitToElementToBeClickable(WebDriver driver, String locator, String...values) {
		explicitWait = new WebDriverWait (driver, 30);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(getDynamicLoctor(locator, values))));
	}
	

	public void waitToElementVisible(WebDriver driver, String locator, String...values) {
		explicitWait = new WebDriverWait (driver, 30);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(getDynamicLoctor(locator, values))));
	}
	public void waitToElementInisible(WebDriver driver, String locator, String...values) {
		explicitWait = new WebDriverWait (driver, 30);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(getDynamicLoctor(locator, values))));
	}
	public void clickToElement(WebDriver driver, String locator, String...values) {
		element = getElement(driver, getDynamicLoctor(locator, values));
		element.click();
	}

	public void sendKeyToElement(WebDriver driver, String locator, String value, String...values) {
		element = getElement(driver, getDynamicLoctor(locator, values));
		element.clear();
		element.sendKeys(value);
	}
	
	public void clearDataOfElement(WebDriver driver, String locator) {
		element = getElement(driver, locator);
		element.clear();
		
	}
	
	public void clearDataOfElement(WebDriver driver, String locator, String...values) {
		element = getElement(driver, getDynamicLoctor(locator, values));
		element.clear();
		
	}
	
	public boolean isElementDisplayed(WebDriver driver, String locator, String...values) {
		element = getElement(driver, getDynamicLoctor(locator, values));
		return element.isDisplayed();
	}
	public boolean isElementEnabled(WebDriver driver, String locator, String...values) {
		element = getElement(driver, getDynamicLoctor(locator, values));
		return element.isEnabled();
	}
	public void openNewPageByName(WebDriver driver, String pageName) {
		waitToElementToBeClickable(driver, AbstractPageUI.DYNAMIC_MENU_LINK, pageName);
		clickToElement(driver, AbstractPageUI.DYNAMIC_MENU_LINK, pageName);
	}
	private WebElement element;
	private Select select;
	private List<WebElement> elements;
	private Actions action;
	private WebDriverWait explicitWait;
	private JavascriptExecutor jsExecutor;
	
}
