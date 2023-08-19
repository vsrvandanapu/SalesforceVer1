package hooks;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.CommonUtils;
import utils.ConfigReader;

public class MyHooks {
	
	
	WebDriver driver;
	//private ConfigReader configReader;
	//private DriverFactory driverFactory;
	
	@Before
	public void setup() {
		Properties prop = new ConfigReader().initializeProperties();
		//Properties prop = configReader.initializeProperties();
		/*
		 configReader = new ConfigReader();
		Properties prop = configReader.initializeProperties();
		 */
		//DriverFactory driverFactory = new DriverFactory();
		driver = DriverFactory.initializeBrowser(prop.getProperty("browser"));
//		driver = DriverFactory.getDriver();
//		driver.manage().deleteAllCookies();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(prop.getProperty("applicationURL"));
	}
	@After
	public void tearDown(Scenario scenario) {
		CommonUtils.waitTo(5);
		String scenarioName = scenario.getName().replaceAll(" ", "_");
		if(scenario.isFailed()) {
			byte[] srcScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(srcScreenshot, "image/png", scenarioName);
		}
		CommonUtils.waitTo(5);
		driver.quit();
	}
	/*
	WebDriver driver;
	@Before
	public void setup() {
		DriverFactory.initializeBrowser("chrome");
		driver = DriverFactory.getDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://login.salesforce.com/?locale=in");
	}
	 */
	

}
