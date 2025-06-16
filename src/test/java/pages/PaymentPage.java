package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tools.BasePage;

public class PaymentPage extends BasePage {
	
	public PaymentPage(WebDriver driver) {
		super(driver);
		removeAd(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "name_on_card")
		private WebElement nameOnCard;
	
	@FindBy(name = "card_number")
		private WebElement cardNumber;
	
	@FindBy(name = "cvc")
		private WebElement cvc;
	
	@FindBy(name = "expiry_month")
		private WebElement monthOfExpire;
	
	@FindBy(name = "expiry_year")
		private WebElement yearOfExpire;
	
	@FindBy(id = "submit")
		private WebElement payAndConfirmBtn;
	
	@FindBy(xpath = "//b[normalize-space()='Order Placed!']")
		private WebElement successMsg;
	
	@FindBy(xpath = "//a[normalize-space()='Download Invoice']")
		private WebElement downloadInvoiceButton;
	
	@FindBy(xpath = "//a[normalize-space()='Delete Account']")
		private WebElement deleteAccount;
	
	@FindBy(xpath = "//b[normalize-space()='Account Deleted!']")
		private WebElement deletedMsg;
    
	@FindBy(xpath = "//a[normalize-space()='Continue']")
		private WebElement continueAfterDeleteBtn;
	@FindBy(xpath = "//a[normalize-space()='Continue']")
		private WebElement continueAfterOrder;
	
	public HomePage clickContinueAfterOrder() {
		waitAndClick(continueAfterOrder);
		return new HomePage(driver);
	}
	public void clickDownloadInvoice() {
        waitAndClick(downloadInvoiceButton);
    }
	
	public PaymentPage setPaymentDetails(String name, String number, String CVC, String month, String year) {
        nameOnCard.sendKeys(name);
        cardNumber.sendKeys(number);
        cvc.sendKeys(CVC);
        monthOfExpire.sendKeys(month);
        yearOfExpire.sendKeys(year);
        return this;
    }
	
	public HomePage clickContinueAfterDeleteButton() {
		continueAfterDeleteBtn.click();
		return new HomePage(driver);
	}
	public boolean isAccountedDeleted() {
		return deletedMsg.isDisplayed();
	}
	public PaymentPage clickDeleteAccount() {
		deleteAccount.click();
		return this;
	}
	public boolean isOrderConfirmed() {
		return successMsg.isDisplayed();
	}
	
	public PaymentPage setNameOnCard(String name) {
		nameOnCard.clear();
		nameOnCard.sendKeys(name);
		return this;
	}
	public PaymentPage setCardNumber(String number) {
		cardNumber.clear();
		cardNumber.sendKeys(number);
		return this;
	}
	public PaymentPage setCardCVC(String CVC) {
		cvc.clear();
		cvc.sendKeys(CVC);
		return this;
	}
	public PaymentPage setCardMonthOfExpire(String month) {
		monthOfExpire.clear();
		monthOfExpire.sendKeys(month);
		return this;
	}
	public PaymentPage setCardYearOfExpire(String year) {
		yearOfExpire.clear();
		yearOfExpire.sendKeys(year);
		return this;
	}
	public PaymentPage clickPayAndConfirmButton() {
		payAndConfirmBtn.click();
		return this;
	}
}
