package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {
	WebDriver driver;
	
	public PaymentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//input[@name='name_on_card'])[1]")
		private WebElement nameOnCard;
	
	@FindBy(xpath = "(//input[@name='card_number'])[1]")
		private WebElement cardNumber;
	
	@FindBy(xpath = "(//input[@placeholder='ex. 311'])[1]")
		private WebElement cvc;
	
	@FindBy(xpath = "(//input[@placeholder='MM'])[1]")
		private WebElement monthOfExpire;
	
	@FindBy(xpath = "(//input[@placeholder='YYYY'])[1]")
		private WebElement yearOfExpire;
	
	@FindBy(xpath = "(//button[normalize-space()='Pay and Confirm Order'])[1]")
		private WebElement payAndConfirmBtn;
	
	@FindBy(xpath = "(//p[normalize-space()='Congratulations! Your order has been confirmed!'])[1]")
		private WebElement successMsg;
	
	@FindBy(xpath = "(//a[normalize-space()='Delete Account'])[1]")
		private WebElement deleteAccount;
	
	@FindBy(xpath = "(//b[normalize-space()='Account Deleted!'])[1]")
		private WebElement deletedMsg;
	@FindBy(xpath = "(//a[normalize-space()='Continue'])[1]")
		private WebElement continueAfterDeleteBtn;

	public void clickContinueAfterDeleteButton() {
		continueAfterDeleteBtn.click();
	}
	public boolean isAccountedDeleted() {
		return deletedMsg.isDisplayed();
	}
	public void clickDeleteAccount() {
		deleteAccount.click();
	}
	public boolean isOrderConfirmed() {
		return successMsg.isDisplayed();
	}
	
	public void setNameOnCard(String name) {
		nameOnCard.clear();
		nameOnCard.sendKeys(name);
	}
	public void setCardNumber(String number) {
		cardNumber.clear();
		cardNumber.sendKeys(number);
	}
	public void setCardCVC(String CVC) {
		cvc.clear();
		cvc.sendKeys(CVC);
	}
	public void setCardMonthOfExpire(String month) {
		monthOfExpire.clear();
		monthOfExpire.sendKeys(month);
	}
	public void setCardYearOfExpire(String year) {
		yearOfExpire.clear();
		yearOfExpire.sendKeys(year);
	}
	public void clickPayAndConfirmButton() {
		payAndConfirmBtn.click();
	}
}
