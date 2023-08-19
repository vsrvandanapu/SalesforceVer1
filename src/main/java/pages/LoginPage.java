package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class LoginPage {
	
	WebDriver driver;
	private ElementUtils elementUtils;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}

	@FindBy(xpath="//label[text()='Username']") private WebElement labelUsername;
	
	@FindBy(xpath="//input[@id='username']") private WebElement txtBoxUsername;
	
	@FindBy(xpath="//input[@id='password']") private WebElement txtBoxPassword;
	
	@FindBy(css="#Login") private WebElement btnLogin;
	
	@FindBy(xpath="//div[@id='error']") private WebElement warningMessage;
	
	public boolean  labelUsername() {
		return elementUtils.displayStatusOfElement(labelUsername, CommonUtils.EXPLICIT_WAIT_TIME);
//		return labelUsername.isDisplayed();
	}
	
	public void typeEmailId(String validEmail) {
		elementUtils.typeTextIntoElement(txtBoxUsername, validEmail, CommonUtils.EXPLICIT_WAIT_TIME);
		//txtBoxUsername.sendKeys(validEmail);
	}
	
	public void typePassword(String validPassword) {
		elementUtils.typeTextIntoElement(txtBoxPassword, validPassword, CommonUtils.EXPLICIT_WAIT_TIME);
		//txtBoxPassword.sendKeys(validPassword);
	}
	
	public HomePage clickOnLoginButton() {
		elementUtils.clickOnElement(btnLogin, CommonUtils.EXPLICIT_WAIT_TIME);
		//CommonUtils.waitTo(10);
		//btnLogin.click();
		return new HomePage(driver);
	}
	
	public HomePage loginToApplication() {
		elementUtils.typeTextIntoElement(txtBoxUsername, "srinivas@cisolutions.com", CommonUtils.EXPLICIT_WAIT_TIME);
		elementUtils.typeTextIntoElement(txtBoxPassword, "Selenium@1", CommonUtils.EXPLICIT_WAIT_TIME);
		elementUtils.clickOnElement(btnLogin, CommonUtils.EXPLICIT_WAIT_TIME);
		return new HomePage(driver);
		/*
		txtBoxUsername.sendKeys("srinivas@cisolutions.com");
		txtBoxPassword.sendKeys("Selenium@1");
		btnLogin.click();*/
		
	}
	public LoginPage loginToApplication(String validEmail, String validPassword) {
		elementUtils.typeTextIntoElement(txtBoxUsername, validEmail, CommonUtils.EXPLICIT_WAIT_TIME);
		elementUtils.typeTextIntoElement(txtBoxPassword, validPassword, CommonUtils.EXPLICIT_WAIT_TIME);
		elementUtils.clickOnElement(btnLogin, CommonUtils.EXPLICIT_WAIT_TIME);
		return new LoginPage(driver);
		/*
		txtBoxUsername.sendKeys(validEmail);
		txtBoxPassword.sendKeys(validPassword);
		btnLogin.click();*/
		
	} 
	
	public String getWarningMessageText() {
		return elementUtils.getTextFromElement(warningMessage,CommonUtils.EXPLICIT_WAIT_TIME);
		//return warningMessage.getText();
	}
}
