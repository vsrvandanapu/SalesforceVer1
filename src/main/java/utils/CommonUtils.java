package utils;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonUtils {
	
	public static final int IMPLICIT_WAIT_TIME=10;
	public static final int PAGE_LOAD_TIME=15;
	public static final int EXPLICIT_WAIT_TIME=30;
	/*
	public static String getEmailWithTimeStamp() {
		Date d = new Date();
		return "srinivas"+d.toString().replace(" " , "_").replace(":", "_")+"@gmail.com";
	}*/
	public String getEmailWithTimeStamp() {
		Date d = new Date();
		return "srinivas"+d.toString().replace(" " , "_").replace(":", "_")+"@gmail.com";
	}
	
	public static void waitTo(long seconds) {
		try {
			Thread.sleep(1000 * seconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	public static WebElement waitToElement(WebDriver driver, WebElement ele)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(ele));
		return ele;
	}*/
}
