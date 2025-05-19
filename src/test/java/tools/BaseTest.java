package tools;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	protected WebDriver driver;
	
	@BeforeMethod
		public void openBrowser() {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		  	driver.manage().window().maximize();
		  	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  	driver.get("https://automationexercise.com/");
		}
	 
	@AfterMethod
		public void closeBrowser() throws InterruptedException {
			driver.close();
	  	}
	
	
}
