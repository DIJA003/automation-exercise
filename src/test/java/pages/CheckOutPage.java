package pages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tools.BasePage;

public class CheckOutPage extends BasePage{

	
	public CheckOutPage(WebDriver driver) {
		super(driver);
		removeAd(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//u[normalize-space()='Register / Login']")
		private WebElement signUpAndLoginBtn;
	
	@FindBy(css = "ul#address_delivery li")
		private List<WebElement> deliveryAddressLines;
	
	@FindBy(css = "ul#address_invoice li")
		private List<WebElement> billingAddressLines;

	@FindBy(name = "message")
		private WebElement comment;
	
	@FindBy(xpath = "//a[normalize-space()='Place Order']")
		private WebElement placeOrderBtn;
	
	@FindBy(xpath = "//h2[normalize-space()='Address Details']")
		private WebElement addressDetails;
	
	@FindBy(xpath = "//h2[normalize-space()='Review Your Order']")
		private WebElement reviewOrder;
	
		public LoginAndRigsterPage clickSignUpLogIn() {
			waitAndClick(signUpAndLoginBtn);
		return new LoginAndRigsterPage(driver);
		}
		public boolean isAddressDetailsDisplayed() {
			return addressDetails.isDisplayed();
		}
		public boolean isReviewOrderDisplayed() {
			return reviewOrder.isDisplayed();
		}
		public PaymentPage clickPlaceOrder() {
			placeOrderBtn.click();
			return new PaymentPage(driver);
		}
		public void typeComment(String comm) {
			comment.clear();
			comment.sendKeys(comm);
		}
		public List<String> getDeliveryAddressDetails() {
	        waitForAllElements(deliveryAddressLines);
	        return deliveryAddressLines.stream()
	                                   .map(WebElement::getText)
	                                   .collect(Collectors.toList());
	    }

	    public List<String> getBillingAddressDetails() {
	        waitForAllElements(billingAddressLines);
	        return billingAddressLines.stream()
	                                  .map(WebElement::getText)
	                                  .collect(Collectors.toList());
	    }
	    public CheckOutPage scrollPage(int pixles) {
		    scrollDownBy(pixles);
	    	return this;
		    
		}
}
