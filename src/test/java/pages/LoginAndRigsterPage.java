package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tools.BasePage;

public class LoginAndRigsterPage extends BasePage {

	public LoginAndRigsterPage(WebDriver driver){
		super(driver);
		removeAd(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//h2[normalize-space()='Login to your account']")
		private WebElement loginTitle;
	
	@FindBy(xpath = "//h2[normalize-space()='New User Signup!']")
		private WebElement signupTitle;
	
	@FindBy(xpath = "(//input[@placeholder='Name'])[1]")
		private WebElement registerName;
	
	@FindBy(xpath = "(//input[@data-qa='signup-email'])[1]")
		private	WebElement registerEmail;
	
	@FindBy(xpath = "(//button[normalize-space()='Signup'])[1]")
		private	WebElement registerBtn;
	
	@FindBy(xpath = "(//input[@data-qa='login-email'])[1]")
		private WebElement loginEmail;
	
	@FindBy(xpath = "(//input[@placeholder='Password'])[1]")
		private WebElement loginPassword;
	
	@FindBy(xpath = "(//button[normalize-space()='Login'])[1]")
		private WebElement loginBtn;
	
	@FindBy(xpath = "//*[contains(text(), 'Email Address already exist!')]")
		private WebElement emailExistMsg;
	
	public boolean isEmailExist() {
		return emailExistMsg.isDisplayed();
	}
	
	public boolean isLoginTitleDisplayed() {
		return loginTitle.isDisplayed();
	}
	
	public boolean isSignupTitleDisplayed() {
		return signupTitle.isDisplayed();
	}
	
	public LoginAndRigsterPage registerName(String name) {
		registerName.clear();
		registerName.sendKeys(name);
		return this;
	}
	
	public LoginAndRigsterPage registerEmail(String email) {
		registerEmail.clear();
		registerEmail.sendKeys(email);
		return this;
	}
	
	public LoginAndRigsterPage registerNameAndEmail(String name, String email) {
		registerName(name);
		registerEmail(email);
		return this;
	}
	
	public SignUpPage clickSignUp() {
		registerBtn.click();
		return new SignUpPage(driver);
	}
	
	public LoginAndRigsterPage loginEmail(String email) {
		loginEmail.clear();
		loginEmail.sendKeys(email);
		return this;
	}
	
	public LoginAndRigsterPage loginPassword(String password) {
		loginPassword.clear();
		loginPassword.sendKeys(password);
		return this;
	}
	
	public LoginAndRigsterPage loginByEmailAndPassword(String email, String password) {
		loginEmail(email);
		loginPassword(password);
		return this;
	}
	
	public HomePage clickLogin() {
		loginBtn.click();
		return new HomePage(driver);
	}

}
