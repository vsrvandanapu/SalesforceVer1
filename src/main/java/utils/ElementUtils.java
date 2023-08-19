package utils;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {

	WebDriver driver;

	public ElementUtils(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnElement(WebElement element, long durationInSeconds) {
		WebElement webElement = waitForElement(element, durationInSeconds);
		webElement.click();
	}

	public void typeTextIntoElement(WebElement element, String textTobeType, long durationInSeconds) {
		WebElement webElement = waitForElement(element, durationInSeconds);
		webElement.click();
		webElement.clear();
		webElement.sendKeys(textTobeType);
	}
	public String getTextFromElement(WebElement element, long durationInSeconds) {
		WebElement webElement = waitForElement(element, durationInSeconds);
		return webElement.getText();
	}
	public boolean displayStatusOfElement(WebElement element, long durationInSeconds) {
		try {
			WebElement webElement = waitForElement(element, durationInSeconds);
			return webElement.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public void selectOptionInDropdown(WebElement element, String dropdownOption, long durationInSeconds) {
		WebElement webElement = waitForElement(element, durationInSeconds);
		Select sel = new Select(webElement);
		sel.selectByValue(dropdownOption);

	}

	public void selectOptionInDropdown(WebElement element, int indexNo, long durationInSeconds) {
		WebElement webElement = waitForElement(element, durationInSeconds);
		Select sel = new Select(webElement);
		sel.selectByIndex(indexNo);

	}

	public WebElement waitForElement(WebElement element, long durationInSeconds) {
		WebElement webElement = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
			webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return webElement;
	}

	public void acceptAlert(long durationInSeconds) {
		Alert alert = waitForAlert(durationInSeconds);
		alert.accept();
	}

	public void dismissAlert(long durationInSeconds) {
		Alert alert = waitForAlert(durationInSeconds);
		alert.dismiss();
	}

	public Alert waitForAlert(long durationInSeconds) {
		Alert alert = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
			alert = wait.until(ExpectedConditions.alertIsPresent());
		} catch (Throwable t) {
			t.printStackTrace();
		}
		return alert;
	}

	public void mouseHoverAndClick(WebElement element, long durationInSeconds) {
		WebElement webElement = waitForVisibilityOfElement(element, durationInSeconds);
		Actions act = new Actions(driver);
		act.moveToElement(webElement).click().build().perform();
	}

	/*
	 * public void mouseHoverAndClick(WebElement element, long durationInSeconds) {
	 * WebElement webElement; WebDriverWait wait = new WebDriverWait(driver,
	 * Duration.ofSeconds(durationInSeconds)); webElement =
	 * wait.until(ExpectedConditions.visibilityOf(element)); Actions act = new
	 * Actions(driver); act.moveToElement(webElement).click().build().perform(); }
	 */
	public WebElement waitForVisibilityOfElement(WebElement element, long durationInSeconds) {
		WebElement webElement = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
			webElement = wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return webElement;
	}

	public void javascriptClick(WebElement element, long durationInSeconds) {

		WebElement webElement = waitForVisibilityOfElement(element, durationInSeconds);
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", webElement);
	}

	public void javascriptType(WebElement element, long durationInSeconds, String textTobeType) {

		WebElement webElement = waitForVisibilityOfElement(element, durationInSeconds);
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].value='"+textTobeType+"'", webElement);
	}
	/*
	 * 
	 * public void clickOnElement(WebElement element, long durationInSeconds) {
	 * WebDriverWait wait = new WebDriverWait(driver,
	 * Duration.ofSeconds(durationInSeconds)); WebElement webElement =
	 * wait.until(ExpectedConditions.elementToBeClickable(element));
	 * webElement.click(); }
	 * 
	 * public void typeTextIntoElement(WebElement element, String textTobeType, long
	 * durationInSeconds) { WebDriverWait wait = new WebDriverWait(driver,
	 * Duration.ofSeconds(durationInSeconds)); WebElement webElement =
	 * wait.until(ExpectedConditions.elementToBeClickable(element));
	 * webElement.click(); webElement.clear(); webElement.sendKeys(textTobeType); }
	 */
}
