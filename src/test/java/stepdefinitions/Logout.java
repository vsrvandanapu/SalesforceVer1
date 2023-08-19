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

public class Logout {
	WebDriver driver;
	private LoginPage loginPage;
	private HomePage homePage;
	//private DriverFactory driverFactory;
	
	@Given("I am logged in to Salesforce")
	public void i_am_logged_in_to_salesforce() {
		//driverFactory = new DriverFactory();
		driver = DriverFactory.getDriver();
		loginPage = new LoginPage(driver);
		loginPage.loginToApplication();
		
		/*
		driver.findElement(By.cssSelector("#username")).sendKeys("srinivas@cisolutions.com");
		driver.findElement(By.cssSelector("#password")).sendKeys("Selenium@1");
		driver.findElement(By.cssSelector("#Login")).click();*/
	}

	@When("I click the logout button")
	public void i_click_the_logout_button()  {
		//driver = DriverFactory.getDriver();
		homePage = new HomePage(driver);
		
		//Thread.sleep(3000);
		CommonUtils.waitTo(5);
		homePage.clickOnArrowNav();
		//driver.findElement(By.xpath("//div[@id='userNav-arrow']")).click();
		//Thread.sleep(3000);
		CommonUtils.waitTo(5);
		homePage.clickOnLogoutLink();
		//driver.findElement(By.xpath("//a[@title='Logout']")).click();
		//Thread.sleep(3000);
		CommonUtils.waitTo(5);
	}

	@Then("I should be redirected to the login page")
	public void i_should_be_redirected_to_the_login_page() {
		CommonUtils.waitTo(5);
		//driver = DriverFactory.getDriver();
		//LoginPage loginPage = new LoginPage(driver);
		Assert.assertTrue(loginPage.labelUsername());
		//Assert.assertTrue(driver.findElement(By.xpath("//label[text()='Username']")).isDisplayed());	
	}




}
