package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tools.BasePage;

public class TestCasesPage extends BasePage {
	public TestCasesPage(WebDriver driver) {
		super(driver);
		removeAd(driver);
		PageFactory.initElements(driver, this);
	} 
	@FindBy(xpath = "//b[normalize-space()='Test Cases']")
		private WebElement indicator;
	
	public boolean isTestCasePageDisplayed() {
		return indicator.isDisplayed();
	}

}
