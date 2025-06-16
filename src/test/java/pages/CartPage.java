package pages;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import tools.BasePage;

public class CartPage extends BasePage {
	
	public CartPage(WebDriver driver) {
		super(driver);
		removeAd(driver);
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//u[normalize-space()='Register / Login']")
		private WebElement registerLoginBtn;
	
	@FindBy(xpath = "(//li[@class='active'])[1]")
		private WebElement cartPageBody;
	
	@FindBy(xpath = "//h2[normalize-space()='Subscription']")
		private WebElement subscribtionHead;
	
	@FindBy(xpath = "//input[@id='susbscribe_email']")
		private WebElement emailInput;
	
	@FindBy(xpath = "//i[@class='fa fa-arrow-circle-o-right']")
		private WebElement subscriptBtn;

	@FindBy(xpath = "(//a[normalize-space()='Proceed To Checkout'])[1]")
		private WebElement proceedToCheckout;

	@FindBy(xpath = "//a[normalize-space()='Signup / Login']")
		private WebElement loginRegisterBtn;
	
	@FindBy(css = "td.cart_description h4 a")
		private List<WebElement> cartProductNames;
	

	private By cartRows = By.xpath("//tr[starts-with(@id, 'product-')]");

	public List<String> getProductNamesInCart() {
	    waitForAllElements(cartProductNames);
	    return cartProductNames.stream()
	                           .map(WebElement::getText)
	                           .collect(Collectors.toList());
	}
	
	public boolean isCartPageDisplayed() {
		return cartPageBody.isDisplayed();
	}
    
	public LoginAndRigsterPage clickRigsterLoginButton() {
		waitAndClick(registerLoginBtn);
		return new LoginAndRigsterPage(driver);
	}
	public LoginAndRigsterPage clickLoginRigsterButton() {
		waitAndClick(loginRegisterBtn);
		return new LoginAndRigsterPage(driver);
	}

	public CheckOutPage clickProceedToCheckout() {
		waitAndClick(proceedToCheckout);
		return new CheckOutPage(driver);
	}

	public boolean isSubscriptionDisplayed() {
		return subscribtionHead.isDisplayed();
	}
	
	public CartPage enterEmail(String email) {
		emailInput.sendKeys(email);
		return this;
	}
	
	public CartPage clickSubscribeButton() {
		subscriptBtn.click();
		return this;
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
		return driver.findElements(cartRows).size();
	}

	public String getProductPrice(int index) {
		By pLocate = By.xpath("(//td[@class='cart_price'])[" + index + "]");
		return waitForElement(pLocate).getText().trim();
	}

	public String getQuantityOfProduct(int index) {
		By qLocate = By.xpath("(//td[@class='cart_quantity']/button)[" + index + "]");
		return waitForElement(qLocate).getText().trim();
	}

	public String getTotalPriceOfProduct(int index) {
		By tLocate = By.xpath("(//td[@class='cart_total'])[" + index + "]");
		return waitForElement(tLocate).getText().trim();
	}

	public String getProductName(int index) {
		By nLocate = By.xpath("(//td[@class='cart_description'])[" + index + "]");
		return waitForElement(nLocate).getText().trim();
	}

	public CartPage clickRemoveProduct(int index) {
		By rLocate = By.xpath("(//a[@class='cart_quantity_delete'])[" + index + "]");
		WebElement elementToRemove = waitForElement(rLocate);
		elementToRemove.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.stalenessOf(elementToRemove));
		return this;
	}

	public CartPage toPageBottom() {
		scrollToBottom();	
		return this;
	}

	public CartPage scrollPage(int pixles) {
		scrollDownBy(pixles);
		return this;
	}
}
