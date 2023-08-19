package stepdefinitions;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LeadsPage;
import pages.LoginPage;
import utils.CommonUtils;

public class CreateLead {
	WebDriver driver;
	private LoginPage loginPage;
	private HomePage homePage;
	private LeadsPage leadsPage;
	//private DriverFactory driverFactory;
	
	@Given("Registered user logged in to Salesforce")
	public void registered_user_logged_in_to_salesforce() {
		//driverFactory = new DriverFactory();
		driver = DriverFactory.getDriver();
		loginPage = new LoginPage(driver);
//		LoginPage loginPage = new LoginPage(driver);
		homePage = loginPage.loginToApplication();
		/*
		driver.findElement(By.cssSelector("#username")).sendKeys("srinivas@cisolutions.com");
		driver.findElement(By.cssSelector("#password")).sendKeys("Selenium@1");
		driver.findElement(By.cssSelector("#Login")).click();*/
	   
	}

	@When("user navigate to the leads creation page")
	public void user_navigate_to_the_leads_creation_page() {
		//driver = DriverFactory.getDriver();
//		homePage = new HomePage(driver);
		leadsPage = homePage.clickOnLeadsTab();
		//driver.findElement(By.xpath("//a[@title='Leads Tab']")).click();
		//Thread.sleep(5000);
		CommonUtils.waitTo(5);
		homePage.clickOnClosePopup();
		//driver.findElement(By.xpath("//a[text()='Close']")).click();
//		Thread.sleep(5000);
		CommonUtils.waitTo(5);
		//LeadsPage leadsPage = new LeadsPage(driver);
		leadsPage.clickOnNewLeadButton();
		//driver.findElement(By.xpath("//input[@title='New']")).click();
		CommonUtils.waitTo(5);
	   
	}

	@When("user fill in to below fields")
	public void user_fill_in_to_below_fields(DataTable dataTable) {
		//driver = DriverFactory.getDriver();
		// leadsPage = new LeadsPage(driver);
		 Map<String, String> map = dataTable.asMap(String.class, String.class);
		 leadsPage.typeFirstname(map.get("firstName"));
		 leadsPage.typeLastname(map.get("lastName"));
		 leadsPage.typeCompanyname(map.get("companyName"));
		 leadsPage.typeEmailId(map.get("email"));
		 leadsPage.selectDropdownLeadStatus(map.get("leadStatus"));
		 //leadsPage.clickOnDropdownLeadStatus(leadStatus);
		/* driver.findElement(By.xpath("//label[text()='First Name']//following::input[1]")).sendKeys(map.get("firstName"));
		 driver.findElement(By.xpath("//label[text()='Last Name']//following::input[1]")).sendKeys(map.get("lastName"));
		 driver.findElement(By.xpath("//label[text()='Company']//following::input[1]")).sendKeys(map.get("companyName"));
		 driver.findElement(By.xpath("//label[text()='Email']//following::input[1]")).sendKeys(map.get("email"));
		 WebElement leadStatusDropdown = driver.findElement(By.xpath("//label[text()='Lead Status']//following::select[1]"));
		 Select select = new Select(leadStatusDropdown);
		    select.selectByValue(map.get("leadStatus"));*/
//		    Thread.sleep(5000);
		 CommonUtils.waitTo(5);
	}

	@When("I click the save button")
	public void i_click_the_save_button() {
		//driver = DriverFactory.getDriver();
//		LeadsPage leadsPage = new LeadsPage(driver);
		leadsPage.clickOnSaveButton();
//		Thread.sleep(5000);
		CommonUtils.waitTo(5);
		//driver.findElement(By.xpath("//h3[text()='Optional']//following::input[@title='Save']")).click();
	}

	@Then("the lead should be created successfully")
	public void the_lead_should_be_created_successfully() throws InterruptedException {
		//driver = DriverFactory.getDriver();
//		LeadsPage leadsPage = new LeadsPage(driver);
		//CommonUtils.waitToElement(driver, homePage.getElement());
		String leadName = leadsPage.captureTheLeadName();
//		Thread.sleep(5000);
		CommonUtils.waitTo(7);
		Assert.assertTrue(leadsPage.captureTheLeadName().contains(leadName));
		//String leadName=driver.findElement(By.xpath("//div[@class='textBlock']//following::h2[@class='topName']")).getText();
		//Assert.assertTrue(driver.findElement(By.xpath("//div[@class='textBlock']//following::h2[@class='topName']")).getText().contains(leadName));
		//Thread.sleep(5000);
		CommonUtils.waitTo(5);
	}

}
