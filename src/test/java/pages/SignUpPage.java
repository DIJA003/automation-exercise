package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {
	WebDriver driver;
	
	public SignUpPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='id_gender1']")
	private WebElement manBtn;
	
	@FindBy(xpath = "//input[@id='id_gender2']")
	private WebElement womanBtn;
	
	@FindBy(xpath = "(//input[@id='password'])[1]")
	private WebElement password;
	
	@FindBy(xpath = "(//select[@id='days'])[1]")
	private WebElement day;
	
	@FindBy(xpath = "(//select[@id='months'])[1]")
	private WebElement month;
	
	@FindBy(xpath = "(//select[@id='years'])[1]")
	private WebElement year;
	
	@FindBy(xpath = "(//input[@id='newsletter'])[1]")
	private WebElement newsletterbtn;
	
	@FindBy(xpath = "(//input[@id='optin'])[1]")
	private WebElement reciveOffersBtn;
	
	@FindBy(xpath = "(//input[@id='first_name'])[1]")
	private WebElement firstName;
	
	@FindBy(xpath = "(//input[@id='last_name'])[1]")
	private WebElement lastName;
	
	@FindBy(xpath = "(//input[@id='company'])[1]")
	private WebElement company;
	
	@FindBy(xpath = "(//input[@id='address1'])[1]")
	private WebElement address1;
	
	@FindBy(xpath = "(//input[@id='address2'])[1]")
	private WebElement address2;
	
	@FindBy(xpath = "(//select[@id='country'])[1]")
	private WebElement country;
	
	@FindBy(xpath = "(//input[@id='state'])[1]")
	private WebElement state;
	
	@FindBy(xpath = "(//input[@id='city'])[1]")
	private WebElement city;
	
	@FindBy(xpath = "(//input[@id='zipcode'])[1]")
	private WebElement zipCode;
	
	@FindBy(xpath = "(//input[@id='mobile_number'])[1]")
	private WebElement mobileNumber;
	
	@FindBy(xpath = "(//button[normalize-space()='Create Account'])[1]")
	private WebElement creatAccoutnBtn;
	
	@FindBy(xpath = "(//b[normalize-space()='Account Created!'])[1]")
	private WebElement successMsg;
	
	@FindBy(xpath = "(//a[normalize-space()='Continue'])[1]")
	private WebElement continueBtn;
	
	public boolean isAccountCreated() {
		return successMsg.isDisplayed();
	}
	public void clickContinueButton() {
		continueBtn.click();
	}
	public void setFirstName(String fName) {
		firstName.clear();
		firstName.sendKeys(fName);
	}
	
	public void setLastName(String lName) {
		lastName.clear();
		lastName.sendKeys(lName);
	}
	
	public void setCompany(String comp) {
		company.clear();
		company.sendKeys(comp);
	}
	
	public void setAddress1(String add1) {
		address1.clear();
		address1.sendKeys(add1);
	}
	
	public void setAddress2(String add2) {
		address2.clear();
		address2.sendKeys(add2);
	}
	
	public void setCountry(String cnt) {
		country.click();
		country.sendKeys(cnt.toLowerCase());
	}
	
	public void setState(String st) {
		state.clear();
		state.sendKeys(st);
	}
	
	public void setCity(String ct) {
		city.clear();
		city.sendKeys(ct);
	}
	
	public void setZipCode(String zpCode) {
		zipCode.clear();
		zipCode.sendKeys(zpCode);
	}
	
	public void setMobileNumber(String number) {
		mobileNumber.clear();
		mobileNumber.sendKeys(number);
	}
	
	public void clickCreatAccountButton() {
		creatAccoutnBtn.click();
	}
	
	public void setDay(int d) {
		day.click();
		day.sendKeys("" + d + "");
	}
	
	public void setMonth(String m) {
		month.click();
		month.sendKeys(m.toLowerCase());
	}
	
	public void setYear(int y) {
		year.click();
		year.sendKeys("" + y + "");
	}
	
	public void setDateOfBirth(int d, String m, int y) {
		setDay(d);
		setMonth(m);
		setYear(y);
	}
	
	public void setPassword(String pass) {
		password.clear();
		password.sendKeys(pass);
	}
	
	public void clickMrsButton() {
		womanBtn.click();
	}
	
	public void clickNewSletterButton() {
		newsletterbtn.click();
	}
	public void clickReciveSpecialOffersButton() {
		reciveOffersBtn.click();
	}
	
	public void clickMrButton() {
		manBtn.click();
	}
	
	public void scrollDown() {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0, 500)");
	}
}
