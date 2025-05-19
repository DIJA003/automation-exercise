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

public class HomePage {
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//body")
	private WebElement homePageBody;
	
	@FindBy(xpath = "//a[@href='/products']")
	private WebElement productPageBtn;
	
	@FindBy(xpath = "//a[normalize-space()='Cart']//i[@class='fa fa-shopping-cart']")
	private WebElement cartPageBtn;
	
	@FindBy(xpath = "//h2[normalize-space()='Subscription']")
	private WebElement subscriptionHead;
	
	@FindBy(xpath = "//input[@id='susbscribe_email']")
	private WebElement emailInput;
	
	@FindBy(xpath = "//i[@class='fa fa-arrow-circle-o-right']")
	private WebElement subscriptBtn;
	
	@FindBy(xpath = "(//a[contains(text(),'Add to cart')])[1]")
	private WebElement addFirstProduct;
	
	@FindBy(xpath = "//button[contains(@class, 'close-modal')]")
	private WebElement continueShop;
	
	@FindBy(xpath = "/html[1]/body[1]/header[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[10]/a[1]")
	private WebElement logged;
	
	@FindBy(xpath = "(//a[normalize-space()='Signup / Login'])[1]")
		private WebElement signUpAndLogInBtn;
	
	public void clickSignUpLogIn() {
		signUpAndLogInBtn.click();
	}
	public boolean isLoggedIn() {
		return logged.isDisplayed();
	}
	public void continueShopping() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(continueShop)).click();
		
	}
	
	public void addFirstProduct() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(addFirstProduct));
	    wait.until(ExpectedConditions.elementToBeClickable(addFirstProduct)).click();
	}
	
	public boolean isHomePageDisplayed() {
		return homePageBody.isDisplayed(); 
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
	
	public void clickCartPageButton() {
		cartPageBtn.click();
	}
	
	public void clickProductPageButton() {
		productPageBtn.click();
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
