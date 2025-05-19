package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckOutPage {
	WebDriver driver;
	WebDriverWait wait;
	
	public CheckOutPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "/html[1]/body[1]/section[1]/div[1]/div[3]/div[1]/div[1]/ul[1]/li[2]")
	    private WebElement deliveryName;
	
	@FindBy(xpath = "/html[1]/body[1]/section[1]/div[1]/div[3]/div[1]/div[1]/ul[1]/li[3]")
		private WebElement deliveryCompany;

	@FindBy(xpath = "/html[1]/body[1]/section[1]/div[1]/div[3]/div[1]/div[1]/ul[1]/li[4]")
	    private WebElement deliveryAddress1;

	@FindBy(xpath = "/html[1]/body[1]/section[1]/div[1]/div[3]/div[1]/div[1]/ul[1]/li[5]")
	    private WebElement deliveryAddress2;

	@FindBy(xpath = "/html[1]/body[1]/section[1]/div[1]/div[3]/div[1]/div[1]/ul[1]/li[6]")
	    private WebElement deliveryPostcode;

	@FindBy(xpath = "/html[1]/body[1]/section[1]/div[1]/div[3]/div[1]/div[1]/ul[1]/li[7]")
	    private WebElement deliveryCountry;

	@FindBy(xpath = "/html[1]/body[1]/section[1]/div[1]/div[3]/div[1]/div[1]/ul[1]/li[8]")
	    private WebElement deliveryPhone;
	
	@FindBy(xpath = "/html[1]/body[1]/section[1]/div[1]/div[3]/div[1]/div[2]/ul[1]/li[3]")
		private WebElement billingCompany;

	@FindBy(xpath = "/html[1]/body[1]/section[1]/div[1]/div[3]/div[1]/div[2]/ul[1]/li[2]")
	    private WebElement billingName;

	@FindBy(xpath = "/html[1]/body[1]/section[1]/div[1]/div[3]/div[1]/div[2]/ul[1]/li[4]")
	    private WebElement billingAddress1;

	@FindBy(xpath = "/html[1]/body[1]/section[1]/div[1]/div[3]/div[1]/div[2]/ul[1]/li[5]")
	    private WebElement billingAddress2;

	@FindBy(xpath = "/html[1]/body[1]/section[1]/div[1]/div[3]/div[1]/div[2]/ul[1]/li[6]")
	    private WebElement billingPostcode;

	@FindBy(xpath = "/html[1]/body[1]/section[1]/div[1]/div[3]/div[1]/div[2]/ul[1]/li[7]")
	    private WebElement billingCountry;

	@FindBy(xpath = "/html[1]/body[1]/section[1]/div[1]/div[3]/div[1]/div[2]/ul[1]/li[8]")
	    private WebElement billingPhone;

	@FindBy(xpath = "(//textarea[@name='message'])[1]")
		private WebElement comment;
	
	@FindBy(xpath = "(//a[normalize-space()='Place Order'])[1]")
		private WebElement placeOrderBtn;
	
	@FindBy(xpath = "(//h2[normalize-space()='Address Details'])[1]")
		private WebElement addressDetails;
	
	@FindBy(xpath = "(//h2[normalize-space()='Review Your Order'])[1]")
		private WebElement reviewOrder;
	
		public boolean isAddressDetailsDisplayed() {
			return addressDetails.isDisplayed();
		}
		public boolean isReviewOrderDisplayed() {
			return reviewOrder.isDisplayed();
		}
		public void clickPlaceOrder() {
			placeOrderBtn.click();
		}
		public void typeComment(String comm) {
			comment.clear();
			comment.sendKeys(comm);
		}
	    public String getDeliveryName() {
	        return wait.until(ExpectedConditions.visibilityOf(deliveryName)).getText().trim();
	    }
	    
	    public String getDeliveryCompany() {
	        return wait.until(ExpectedConditions.visibilityOf(deliveryCompany)).getText().trim();
	    }

	    public String getDeliveryAddress1() {
	        return wait.until(ExpectedConditions.visibilityOf(deliveryAddress1)).getText().trim();
	    }

	    public String getDeliveryAddress2() {
	        return wait.until(ExpectedConditions.visibilityOf(deliveryAddress2)).getText().trim();
	    }
	    
	    public String getDeliveryPostcode() {
	        return wait.until(ExpectedConditions.visibilityOf(deliveryPostcode)).getText().trim();
	    }
	    
	    public String getDeliveryCountry() {
	        return wait.until(ExpectedConditions.visibilityOf(deliveryCountry)).getText().trim();
	    }
	    
	    public String getDeliveryPhone() {
	        return wait.until(ExpectedConditions.visibilityOf(deliveryPhone)).getText().trim();
	    }


	    public String getBillingName() {
	        return wait.until(ExpectedConditions.visibilityOf(billingName)).getText().trim();
	    }

	    public String getBillingAddress1() {
	        return wait.until(ExpectedConditions.visibilityOf(billingAddress1)).getText().trim();
	    }
	    
	    public String getBillingAddress2() {
	        return wait.until(ExpectedConditions.visibilityOf(billingAddress2)).getText().trim();
	    }
	    
	    public String getBillingPostcode() {
	        return wait.until(ExpectedConditions.visibilityOf(billingPostcode)).getText().trim();
	    }
	    
	    public String getBillingCountry() {
	        return wait.until(ExpectedConditions.visibilityOf(billingCountry)).getText().trim();
	    }
	    
	    public String getBillingPhone() {
	        return wait.until(ExpectedConditions.visibilityOf(billingPhone)).getText().trim();
	    }
	    
	    public String getBillingCompany() {
	        return wait.until(ExpectedConditions.visibilityOf(billingCompany)).getText().trim();
	    }
	    public void scrollDown() {
		    JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("window.scrollBy(0, 500)");
		}
}
