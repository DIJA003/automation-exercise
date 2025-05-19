package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//li[@class='active'])[1]")
	private WebElement cartPageBody;
	
	@FindBy(xpath = "//h2[normalize-space()='Subscription']")
	private WebElement subscriptionHead;
	
	@FindBy(xpath = "//input[@id='susbscribe_email']")
	private WebElement emailInput;
	
	@FindBy(xpath = "//i[@class='fa fa-arrow-circle-o-right']")
	private WebElement subscriptBtn;
	
	@FindBy(xpath = "(//td[@class='cart_description'])[1]")
	private WebElement product1;

    @FindBy(xpath = "(//td[@class='cart_description'])[2]")
    private WebElement product2;
    
    @FindBy(xpath = "(//a[normalize-space()='Proceed To Checkout'])[1]")
    private WebElement proceedToCheckout;
    
    @FindBy(xpath = "(//u[normalize-space()='Register / Login'])[1]")
    private WebElement loginRegisterBtn;
    
    private By cartRows = By.xpath("//tr[starts-with(@id, 'product-')]");

    public boolean isCartPageDisplayed() {
    	return cartPageBody.isDisplayed();
    }
    public void clickLoginRigsterButton() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(loginRegisterBtn));
	    wait.until(ExpectedConditions.elementToBeClickable(loginRegisterBtn)).click();
    }
    
    public void clickProceedToCheckout() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckout)).click();
    }
	public boolean isSubscriptionDisplayed() {
		return subscriptionHead.isDisplayed();
	}
	
	
	public void enterEmail(String email) {
		emailInput.sendKeys(email);
	}
	
	public void clickSubscripButton() {
		subscriptBtn.click();
	}
	
	public boolean isSuccessMessageDisplayed() {
		return driver.findElements(By.xpath("//*[@id='success-subscribe']")).size() > 0 
				&& driver.findElement(By.xpath("//*[@id='success-subscribe']")).isDisplayed();
	}
	
	public boolean isProductDisplayed(int index) {
	    By productLocator = By.xpath("(//td[@class='cart_description'])[" + index + "]");
	    return driver.findElement(productLocator).isDisplayed();
	}
    
	public int getProductsCount() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(cartRows)).size();
	}
    
    public String getProductPrice(int index) {
    	By pLocate = By.xpath("(//td[@class='cart_price'])[" + index + "]");
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(pLocate)).getText().trim();
    }
    public String getQuantityOfProduct(int index) {
    	By qLocate = By.xpath("(//td[@class='cart_quantity']/button)[" + index + "]");
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(qLocate)).getText().trim();
    }
    
    public String getTotalPriceOfProduct(int index) {
    	By tLocate = By.xpath("(//td[@class='cart_total'])[" + index + "]");
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(tLocate)).getText().trim();
    }
    
    public String getProductName(int index) {
        By nLocate = By.xpath("(//td[@class='cart_description'])[" + index + "]");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(nLocate)).getText().trim();
    }
    
    public void scrollToBottom() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
    public void scrollDown() {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0, 500)");
	}
	
}
