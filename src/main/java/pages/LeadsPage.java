package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utils.CommonUtils;
import utils.ElementUtils;

public class LeadsPage {
	
	WebDriver driver;
	private ElementUtils elementUtils;
	public LeadsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(xpath="//input[@title='New']") private WebElement btnNewLead;
	@FindBy(xpath="//label[text()='First Name']//following::input[1]") private WebElement txtboxFirstName;
	@FindBy(xpath="//label[text()='Last Name']//following::input[1]") private WebElement txtboxLastName;
	@FindBy(xpath="//label[text()='Company']//following::input[1]") private WebElement txtboxCompanytName;
	@FindBy(xpath="//label[text()='Email']//following::input[1]") private WebElement txtboxEmail;
	@FindBy(xpath="//label[text()='Lead Status']//following::select[1]") private WebElement dropdownLeadStatus;
	@FindBy(xpath="//h3[text()='Optional']//following::input[@title='Save']") private WebElement btnSave;
	@FindBy(xpath="//div[@class='textBlock']//following::h2[@class='topName']") private WebElement textLeadName;
	
	public void clickOnNewLeadButton() {
		elementUtils.clickOnElement(btnNewLead, CommonUtils.EXPLICIT_WAIT_TIME);
		//btnNewLead.click();
	}
	public void typeFirstname(String firstName) {
		elementUtils.typeTextIntoElement(txtboxFirstName, firstName, CommonUtils.EXPLICIT_WAIT_TIME);
		//txtboxFirstName.sendKeys(firstName);
	}
	public void typeLastname(String lastName) {
		elementUtils.typeTextIntoElement(txtboxLastName, lastName, CommonUtils.EXPLICIT_WAIT_TIME);
		//txtboxLastName.sendKeys(lastName);
	}
	public void typeCompanyname(String companyName) {
		elementUtils.typeTextIntoElement(txtboxCompanytName, companyName, CommonUtils.EXPLICIT_WAIT_TIME);
//		txtboxCompanytName.sendKeys(companyName);
	}
	public void typeEmailId(String email) {
		elementUtils.typeTextIntoElement(txtboxEmail, email, CommonUtils.EXPLICIT_WAIT_TIME);
		//txtboxEmail.sendKeys(email);
	}
	
	public void selectDropdownLeadStatus(String leadStatus) {
		elementUtils.selectOptionInDropdown(dropdownLeadStatus, leadStatus, CommonUtils.EXPLICIT_WAIT_TIME);
		/*
		Select sel = new Select(dropdownLeadStatus);
		sel.selectByValue(leadStatus);
		*/
	}
	public void clickOnSaveButton() {
		elementUtils.clickOnElement(btnSave, CommonUtils.EXPLICIT_WAIT_TIME);
		//btnSave.click();
	}
	
	public String captureTheLeadName() {
		return elementUtils.getTextFromElement(textLeadName, CommonUtils.EXPLICIT_WAIT_TIME);
		//return textLeadName.getText();
	}

}
