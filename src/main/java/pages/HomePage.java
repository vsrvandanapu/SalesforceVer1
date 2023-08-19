package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class HomePage {
	
	WebDriver driver;
	private ElementUtils elementUtils;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(xpath="//a[@title='Home Tab']") private WebElement tabHome;
	@FindBy(xpath="//div[@id='userNav-arrow']") private WebElement arrowNav;
	@FindBy(xpath="//a[@title='Logout']") private WebElement lnkLogout;
	@FindBy(xpath="//a[@title='Leads Tab']") private WebElement tabLeads;
	@FindBy(xpath="//a[text()='Close']") private WebElement closePopup;
	
	public boolean homeTab() {
		return elementUtils.displayStatusOfElement(tabHome, CommonUtils.EXPLICIT_WAIT_TIME);
		//return tabHome.isDisplayed();
	}

	
	public void clickOnArrowNav() {
		elementUtils.clickOnElement(arrowNav, CommonUtils.EXPLICIT_WAIT_TIME);
		//arrowNav.click();
	}
	
	public void clickOnLogoutLink() {
		elementUtils.clickOnElement(lnkLogout, CommonUtils.EXPLICIT_WAIT_TIME);
		//lnkLogout.click();
	}
	
	public LeadsPage clickOnLeadsTab() {
		elementUtils.clickOnElement(tabLeads, CommonUtils.EXPLICIT_WAIT_TIME);
		//tabLeads.click();
		return new LeadsPage(driver);
	}
	
	public void clickOnClosePopup() {
		elementUtils.clickOnElement(closePopup, CommonUtils.EXPLICIT_WAIT_TIME);
		//closePopup.click();
	}
	public WebElement getElement() {
		//return elementUtils.getTextFromElement(tabLeads, 20);
		return tabLeads;
	}
}
