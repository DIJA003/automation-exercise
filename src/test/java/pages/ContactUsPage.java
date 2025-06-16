package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tools.BasePage;

public class ContactUsPage extends BasePage {
	
	public ContactUsPage(WebDriver driver) {
		super(driver);
		removeAd(driver);
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[@class='btn btn-success']")
		private WebElement homeBtn;
	@FindBy(xpath = "//div[@class='status alert alert-success']")
		private WebElement succMsg;
	@FindBy(xpath = "//input[@name='submit']")
		private WebElement submitBtn;
	@FindBy(xpath = "//input[@placeholder='Name']")
		private WebElement nameField;
	@FindBy(xpath = "//input[@placeholder='Email']")
		private WebElement emailField;
	@FindBy(xpath = "//input[@placeholder='Subject']")
		private WebElement subjectField;
	@FindBy(xpath = "//textarea[@id='message']")
		private WebElement messageField;
	@FindBy(xpath = "//input[@name='upload_file']")
		private WebElement chooseFile;
	@FindBy(xpath = "//h2[normalize-space()='Get In Touch']")
		private WebElement indicator;
	
	public HomePage clickHomeBtn() {
		homeBtn.click();
		return new HomePage(driver);
	}
	public ContactUsPage handleAlert() {
		driver.switchTo().alert().accept();
		return this;
	}
	public boolean isSubmitted() {
		return succMsg.isDisplayed();
	}
	
	public ContactUsPage clickSubmitBtn() {
		submitBtn.click();
		return this;
	}
	
	public boolean isContactusPageDisplayed() {
		return indicator.isDisplayed();
	}
	public ContactUsPage fillNameField(String name) {
		nameField.clear();
		nameField.sendKeys(name);
		return this;
	}
	public ContactUsPage fillEmailField(String email) {
		emailField.clear();
		emailField.sendKeys(email);
		return this;
	}
	public ContactUsPage fillSubjectField(String subject) {
		subjectField.clear();
		subjectField.sendKeys(subject);
		return this;
	}
	public ContactUsPage fillMessageField(String message) {
		messageField.clear();
		messageField.sendKeys(message);
		return this;
	}
	public ContactUsPage clickChooseFile(String path) {
		chooseFile.sendKeys(path);
		return this;
	}

}
