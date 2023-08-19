package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import utils.CommonUtils;
import utils.ElementUtils;
public class Login {
	
	WebDriver driver;
	
	private LoginPage loginPage;
	private HomePage homePage;
	private CommonUtils commonUtils;
	//private DriverFactory driverFactory;
	
	@Given("User navigates to login page")
	public void user_navigates_to_login_page() {
		//driverFactory = new DriverFactory();
		driver = DriverFactory.getDriver();
		loginPage = new LoginPage(driver);
		//driver.findElement(By.xpath("//label[text()='Username']")).isDisplayed();
		//Assert.assertTrue(driver.findElement(By.xpath("//label[text()='Username']")).isDisplayed());
		Assert.assertTrue(loginPage.labelUsername());
	}

	@When("^user enters valid email address (.+) into username filed$")
	public void user_enters_valid_email_address_into_username_filed(String validEmail) {
		loginPage.typeEmailId(validEmail);
		
	}

	
	@When("^user enters valid password (.+) into password filed$")
	public void user_enters_valid_password_into_password_filed(String validPassword) {
		loginPage.typePassword(validPassword);
	}

	@When("clicks on Login button")
	public void clicks_on_login_button() {
		//driver = DriverFactory.getDriver();
//		LoginPage loginPage = new LoginPage(driver);
		homePage = loginPage.clickOnLoginButton();
		//driver.findElement(By.cssSelector("#Login")).click();
	}

	@Then("user should login successfully")
	public void user_should_login_successfully() {
		//driver = DriverFactory.getDriver();
		//homePage = new HomePage(driver);
		Assert.assertTrue(homePage.homeTab());
		// Assert.assertTrue(driver.findElement(By.xpath("//a[@title='Home Tab']")).isDisplayed());
	}

	/*
	@When("user enters invalid email address {string} into username filed")
	public void user_enters_invalid_email_address_into_username_filed(String invalidEmail) {
		driver.findElement(By.cssSelector("#username")).sendKeys(invalidEmail);
	}
	*/
	@When("user enters invalid email address into username filed")
	public void user_enters_invalid_email_address_into_username_filed() {
		//driver = DriverFactory.getDriver();
		//LoginPage loginPage = new LoginPage(driver);
		commonUtils = new CommonUtils();
		loginPage.typeEmailId(commonUtils.getEmailWithTimeStamp());
		//loginPage.typeEmailId(getEmailWithTimeStamp());
		//driver.findElement(By.cssSelector("#username")).sendKeys(getEmailWithTimeStamp());
	}
	@When("enter invalid password {string} into password filed")
	public void enter_invalid_password_into_password_filed(String invalidPassword) {
		//driver = DriverFactory.getDriver();
		//LoginPage loginPage = new LoginPage(driver);
		loginPage.typePassword(invalidPassword);
		//driver.findElement(By.cssSelector("#password")).sendKeys(invalidPassword);
	}

	@Then("user should get a proper warning message about credentials mismatch")
	public void user_should_get_a_proper_warning_message_about_credentials_mismatch() {
		//driver = DriverFactory.getDriver();
//		LoginPage loginPage = new LoginPage(driver);
		Assert.assertTrue(loginPage.getWarningMessageText().contains("Please check your username and password. If you still can't log in, contact your Salesforce administrator."));
		//Assert.assertTrue(driver.findElement(By.xpath("//div[@id='error']")).getText().contains("Please check your username and password. If you still can't log in, contact your Salesforce administrator."));
		//Assert.fail();
	}
	
	/*
	private String getEmailWithTimeStamp() {
		Date d = new Date();
		return "srinivas"+d.toString().replace(" " , "_").replace(":", "_")+"@gmail.com";
	}*/

}
