package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginAndRigsterPage {
	WebDriver driver;
	
	public LoginAndRigsterPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//input[@placeholder='Name'])[1]")
		WebElement registerName;
	
	@FindBy(xpath = "(//input[@data-qa='signup-email'])[1]")
		WebElement registerEmail;
	
	@FindBy(xpath = "(//button[normalize-space()='Signup'])[1]")
		WebElement registerBtn;
	
	@FindBy(xpath = "(//input[@data-qa='login-email'])[1]")
		WebElement loginEmail;
	
	@FindBy(xpath = "(//input[@placeholder='Password'])[1]")
		WebElement loginPassword;
	
	@FindBy(xpath = "(//button[normalize-space()='Login'])[1]")
		WebElement loginBtn;
	
	@FindBy(xpath = "//*[contains(text(), 'Email Address already exist!')]")
		private WebElement emailExistMsg;
	
	public boolean isEmailExist() {
		return emailExistMsg.isDisplayed();
	}
	
	public void registerName(String name) {
		registerName.clear();
		registerName.sendKeys(name);
	}
	
	public void registerEmail(String email) {
		registerEmail.clear();
		registerEmail.sendKeys(email);
	}
	
	public void registerNameAndEmail(String name, String email) {
		registerName(name);
		registerEmail(email);
	}
	
	public void clickSignUp() {
		registerBtn.click();
	}
	
	public void loginEmail(String email) {
		loginEmail.clear();
		loginEmail.sendKeys(email);
	}
	
	public void loginPassword(String password) {
		loginPassword.clear();
		loginPassword.sendKeys(password);
	}
	
	public void loginByEmailAndPassword(String email, String password) {
		loginEmail(email);
		loginPassword(password);
	}
	
	public void clickLogin() {
		loginBtn.click();
	}

}
