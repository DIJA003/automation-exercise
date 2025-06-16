package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import tools.BasePage;

public class SignUpPage extends BasePage {
	
	public SignUpPage(WebDriver driver) {
		super(driver);
		removeAd(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "id_gender1")
    	private WebElement manBtn;
    
    @FindBy(id = "id_gender2")
    	private WebElement womanBtn;
    
    @FindBy(id = "password")
    	private WebElement password;
    
    @FindBy(id = "days")
    	private WebElement day;
    
    @FindBy(id = "months")
    	private WebElement month;
    
    @FindBy(id = "years")
    	private WebElement year;
    
    @FindBy(id = "newsletter")
    	private WebElement newsletterbtn;
    
    @FindBy(id = "optin")
    	private WebElement receiveOffersBtn;
    
    @FindBy(id = "first_name")
    	private WebElement firstName;
    
    @FindBy(id = "last_name")
    	private WebElement lastName;
    
    @FindBy(id = "company")
    	private WebElement company;
    
    @FindBy(id = "address1")
    	private WebElement address1;
    
    @FindBy(id = "address2")
    	private WebElement address2;
    
    @FindBy(id = "country")
    	private WebElement country;
    
    @FindBy(id = "state")
    	private WebElement state;
    
    @FindBy(id = "city")
    	private WebElement city;
    
    @FindBy(id = "zipcode")
    	private WebElement zipCode;
    
    @FindBy(id = "mobile_number")
    	private WebElement mobileNumber;
    
    @FindBy(xpath = "//button[normalize-space()='Create Account']")
    	private WebElement creatAccountBtn;
    
    @FindBy(xpath = "//b[normalize-space()='Account Created!']")
    	private WebElement successMsg;
    
    @FindBy(xpath = "//a[normalize-space()='Continue']")
    	private WebElement continueBtn;
	
    public boolean isAccountCreated() {
        waitForVisibilty(successMsg);
        return successMsg.isDisplayed();
    }
    public HomePage clickContinueButton() {
        waitAndClick(continueBtn);
        return new HomePage(driver);
    }
    
    public SignUpPage setFirstName(String fName) {
        firstName.sendKeys(fName);
        return this;
    }
    
    public SignUpPage setLastName(String lName) {
        lastName.sendKeys(lName);
        return this;
    }
    
    public SignUpPage setCompany(String comp) {
        company.sendKeys(comp);
        return this;
    }
    
    public SignUpPage setAddress1(String add1) {
        address1.sendKeys(add1);
        return this;
    }
    
    public SignUpPage setAddress2(String add2) {
        address2.sendKeys(add2);
        return this;
    }

    public SignUpPage setCountry(String countryName) {
        new Select(country).selectByVisibleText(countryName);
        return this;
    }
    
    public SignUpPage setState(String st) {
        state.sendKeys(st);
        return this;
    }
    
    public SignUpPage setCity(String ct) {
        city.sendKeys(ct);
        return this;
    }
    
    public SignUpPage setZipCode(String zpCode) {
        zipCode.sendKeys(zpCode);
        return this;
    }
    
    public SignUpPage setMobileNumber(String number) {
        mobileNumber.sendKeys(number);
        return this;
    }
    
    public SignUpPage clickCreateAccountButton() {
        scrollIntoView(creatAccountBtn);
        waitAndClick(creatAccountBtn);
        return this;
    }

    public SignUpPage setDateOfBirth(String day2, String monthText, String year2) {
        new Select(day).selectByValue(String.valueOf(day2));
        new Select(month).selectByVisibleText(monthText);
        new Select(year).selectByValue(String.valueOf(year2));
        return this;
    }
    
    public SignUpPage setPassword(String pass) {
        password.sendKeys(pass);
        return this;
    }
    
    public SignUpPage clickMrsButton() {
        waitAndClick(womanBtn);
        return this;
    }
    
    public SignUpPage clickNewsletterButton() {
        waitAndClick(newsletterbtn);
        return this;
    }

    public SignUpPage clickReciveSpecialOffersButton() {
        waitAndClick(receiveOffersBtn);
        return this;
    }
    
    public SignUpPage clickMrButton() {
        waitAndClick(manBtn);
        return this;
    }
    
    public SignUpPage scrollPage(int pixles) {
	    scrollDownBy(pixles);
	    return this;
	}
    
    public SignUpPage fillAccountDetails(
            String password, String day, String month, String year, 
            String firstName, String lastName, String company, 
            String address1, String address2, String country, 
            String state, String city, String zipcode, String mobileNumber
        ) {
    		setPassword(password);
    		setDateOfBirth(day, month, year);
			scrollDownBy(500);
    		setFirstName(firstName);
        	setLastName(lastName);
            setCompany(company);
            setAddress1(address1);
            setAddress2(address2);
            scrollDownBy(500);
            setCountry(country);
            setState(state);
            setCity(city);
            setZipCode(zipcode);
            setMobileNumber(mobileNumber);
            clickCreateAccountButton();
            return this;
        }
}
