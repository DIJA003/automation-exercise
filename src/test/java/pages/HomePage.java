package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tools.BasePage;

public class HomePage extends BasePage{
	
	public HomePage(WebDriver driver) {
		super(driver);
		removeAd(driver);
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[contains(text(),'Test Cases')]")
		private WebElement testCasesBtn;
	
	@FindBy(xpath = "//a[normalize-space()='Contact us']")
		private WebElement contactUsBtn;
	
	@FindBy(xpath = "//a[normalize-space()='Logout']")
		private WebElement logoutBtn; 
	
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
	
	@FindBy(xpath = "(//a[normalize-space()='Signup / Login'])[1]")
		private WebElement signUpAndLoginBtn;
		
	@FindBy(xpath = "(//a[normalize-space()='Delete Account'])[1]")
		private WebElement deleteAccount;
	
	@FindBy(xpath = "(//b[normalize-space()='Account Deleted!'])[1]")
		private WebElement deletedMsg;
	
	@FindBy(xpath = "(//a[normalize-space()='Continue'])[1]")
		private WebElement continueAfterDeleteBtn;
	
	@FindBy(id = "scrollUp")
		private WebElement scrollUpArrow;

	@FindBy(xpath = "//h2[normalize-space()='Full-Fledged practice website for Automation Engineers']")
		private WebElement mainHeader;

	@FindBy(xpath = "//h2[normalize-space()='recommended items']")
		private WebElement recommendedItemsHeader;
	
	@FindBy(xpath = "//div[@class='recommended_items']//a[contains(@class, 'add-to-cart')]")
		private WebElement firstRecommendedItemAddToCart;
	
	public HomePage clickScrollUpArrow() {
	    waitAndClick(scrollUpArrow);
	    return this;
	}
	public boolean isMainHeaderDisplayed() {
	    waitForVisibilty(mainHeader);
	    return mainHeader.isDisplayed();
	}
	public HomePage scrollToTop() {
	    scrollToPageTop(); 
	    return this;
	}
	public boolean isRecommendedItemsVisible() {
	    scrollIntoView(recommendedItemsHeader);
	    waitForVisibilty(recommendedItemsHeader);
	    return recommendedItemsHeader.isDisplayed();
	}
	public ProductPage addRecommendedItemToCart() {
	    waitAndClick(firstRecommendedItemAddToCart);
	    return new ProductPage(driver);
	}
	public TestCasesPage clickTestCasesBtn() {
		testCasesBtn.click();
		return new TestCasesPage(driver);
	}
	
	public ContactUsPage clickContactUs() {
		contactUsBtn.click();
		return new ContactUsPage(driver);
	}
	public HomePage clickLogoutBtn() {
		logoutBtn.click();
		return this;
	}
	public LoginAndRigsterPage clickSignUpLogIn() {
		signUpAndLoginBtn.click();
		return new LoginAndRigsterPage(driver);
	}
	public boolean isLoggedIn() {
		return logoutBtn.isDisplayed();
	}
	public HomePage continueShopping() {
		clickContinueShoppingBtn();
		return this;
	}
	
	public HomePage addFirstProduct() {
		scrollIntoView(addFirstProduct);
		waitForVisibilty(addFirstProduct);
		waitAndClick(addFirstProduct);
	    return this;
	}
	
	public boolean isHomePageDisplayed() {
		return homePageBody.isDisplayed(); 
	}
	
	public boolean isSubscriptionDisplayed() {
		return subscriptionHead.isDisplayed();
	}
	
	public HomePage enterEmail(String email) {
		emailInput.sendKeys(email);
		return this;
	}
	
	public HomePage clickSubscripButton() {
		subscriptBtn.click();
		return this;
	}
	
	public boolean isSuccessMessageDisplayed() {
		return driver.findElements(By.xpath("//*[@id='success-subscribe']")).size() > 0 
				&& driver.findElement(By.xpath("//*[@id='success-subscribe']")).isDisplayed();
	}
	
	public CartPage clickCartPageButton() {
		cartPageBtn.click();
		return new CartPage(driver);
	}
	
	public ProductPage clickProductPageButton() {
		productPageBtn.click();
		return new ProductPage(driver);
	}
	
	public HomePage toBottomPage() {
		scrollToBottom();
		return this;
	}
	
	public HomePage scrollPage(int pixles) {
	    scrollDownBy(pixles);
	    return this;
	    
	}
	public HomePage clickContinueAfterDeleteButton() {
		continueAfterDeleteBtn.click();
		return this;
	}
	public boolean isAccountedDeleted() {
		return deletedMsg.isDisplayed();
	}
	public HomePage clickDeleteAccount() {
		deleteAccount.click();
		return this;
	}
	
	
}
