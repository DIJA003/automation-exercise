package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
	WebDriver driver;
	
	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath = "(//a[@class='btn btn-default add-to-cart'])[1]")
		private WebElement addFirstProductBtn;

	@FindBy(xpath = "//button[contains(@class, 'close-modal')]")
		private WebElement continueShop;
	
	@FindBy(xpath = "(//a[@class='btn btn-default add-to-cart'])[3]")
		private WebElement addSecondProduct;
	
	@FindBy(xpath = "//u[normalize-space()='View Cart']")
		private WebElement viewCart;
	
	@FindBy(xpath = "(//a[contains(text(),'View Product')])[1]")
		private WebElement viewProduct;
	
	@FindBy(xpath = "(//div[@class='product-information'])[1]")
	 	private	WebElement productInfromation;
	
	@FindBy(xpath = "(//input[@id='quantity'])[1]")
		private	WebElement productQuantity;
	
	@FindBy(xpath = "//button[normalize-space()='Add to cart']")
		private	WebElement addToCart;
	
	public void clickAddToCart() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(addToCart));
	    wait.until(ExpectedConditions.elementToBeClickable(addToCart)).click();
	}
	
	public void setQuantity(int value) {
		productQuantity.clear();
		productQuantity.sendKeys("" + value + "");
	}
	
	public void addFirstProduct() {
		addFirstProductBtn.click();
	}
	
	public void continueShopping() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(continueShop)).click();
		
	}
	public boolean isProductDetailsExist() {
		return productInfromation.isDisplayed();
	}
	
	public void clickViewProdct() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(viewProduct));
	    wait.until(ExpectedConditions.elementToBeClickable(viewProduct)).click();
	}
	
	public void addSecondProduct() {
		addSecondProduct.click();
	}
	
	public void clickViewCart() {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		    wait.until(ExpectedConditions.visibilityOf(viewCart));
		    wait.until(ExpectedConditions.elementToBeClickable(viewCart)).click();
	}
	
	public void scrollDown() {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0, 500)");
	}
	
	public void removeAds() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("document.querySelectorAll('.adsbygoogle, .adsbygoogle-noablate').forEach(el => el.style.display = 'none');");
	}
}
