package tests;

import java.awt.AWTException;
import java.time.Duration;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.CartPage;
import pages.CheckOutPage;
import pages.HomePage;
import pages.LoginAndRigsterPage;
import pages.PaymentPage;
import pages.SignUpPage;
import tools.AdRemove;
import tools.BaseTest;

public class testCase_16 extends BaseTest{
	
	public void creatAcc() throws AWTException, InterruptedException {
		HomePage home = new HomePage(driver);
		LoginAndRigsterPage register = new LoginAndRigsterPage(driver);
		SignUpPage signUp = new SignUpPage(driver);
		
		AdRemove.removeAd(driver);
		
		home.clickSignUpLogIn();
		
		AdRemove.removeAd(driver);

		register.registerNameAndEmail("user", "anything99@gmail.com");
		register.clickSignUp();
		
		AdRemove.removeAd(driver);
		
		signUp.clickMrButton();
		signUp.setPassword("123456789");
		signUp.setDateOfBirth(13, "December", 2003);
		signUp.clickNewSletterButton();
		signUp.clickReciveSpecialOffersButton();
		
		signUp.scrollDown();
		signUp.setFirstName("mustafa");
		signUp.setLastName("muhammed");
		signUp.setCompany("DEPI");
		signUp.setAddress1("Taawan");
		signUp.setAddress2("Etihad st");
		signUp.setCountry("Canada");
		signUp.setState("Giza");
		
		signUp.scrollDown();
		
		signUp.setCity("KingsLanding");
		signUp.setZipCode("0000");
		signUp.setMobileNumber("12345678901");
		signUp.clickCreatAccountButton();
		
		AdRemove.removeAd(driver);
		
		signUp.clickContinueButton();
		driver.close();
		
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	  	driver.manage().window().maximize();
	  	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  	driver.get("https://automationexercise.com/");
	}

	@Test(priority = 1)
		public void everythingValid() throws InterruptedException, AWTException {
			creatAcc();
			HomePage home = new HomePage(driver);
			CartPage cart = new CartPage(driver);
			LoginAndRigsterPage login = new LoginAndRigsterPage(driver);
			CheckOutPage checkOut = new CheckOutPage(driver);
			PaymentPage pay = new PaymentPage(driver);
			
			AdRemove.removeAd(driver);

			Assert.assertTrue(home.isHomePageDisplayed(),"Home page not shown");
			
			home.clickSignUpLogIn();
			
			login.loginByEmailAndPassword("anything99@gmail.com", "123456789");
			login.clickLogin();
			
			AdRemove.removeAd(driver);
			
			Assert.assertTrue(home.isLoggedIn(),"Not logged in");
			
			home.scrollDown();
			home.addFirstProduct();
			home.continueShopping();
			home.clickCartPageButton();
			
			AdRemove.removeAd(driver);
			
			Assert.assertTrue(cart.isCartPageDisplayed(),"Cart page not shown");
			
			cart.clickProceedToCheckout();
			
			AdRemove.removeAd(driver);
			
			
			Assert.assertTrue(checkOut.isAddressDetailsDisplayed(),"Address details not showen");
			Assert.assertTrue(checkOut.isReviewOrderDisplayed(),"Order not showen");

	        checkOut.typeComment("Leave at door");
	        checkOut.clickPlaceOrder();
	        
	        AdRemove.removeAd(driver);
	        
	        pay.setNameOnCard("mohammed salah");
	        pay.setCardNumber("123456789");
	        pay.setCardCVC("123");
	        pay.setCardMonthOfExpire("12");
	        pay.setCardYearOfExpire("2170");
	        pay.clickPayAndConfirmButton();
	        
	        AdRemove.removeAd(driver);
	        
	        Assert.assertTrue(pay.isOrderConfirmed(),"Order is not confirmed");
			
	        pay.clickDeleteAccount();
	        
	        Assert.assertTrue(pay.isAccountedDeleted(),"Account is not deleted");
	        
	        pay.clickContinueAfterDeleteButton();
		}
	@Test(priority = 2)
	public void testInvalidPaymentDetails() throws InterruptedException, AWTException {
		creatAcc();
		HomePage home = new HomePage(driver);
		CartPage cart = new CartPage(driver);
		LoginAndRigsterPage login = new LoginAndRigsterPage(driver);
		CheckOutPage checkOut = new CheckOutPage(driver);
		PaymentPage pay = new PaymentPage(driver);
		
		AdRemove.removeAd(driver);
	    
	    home.clickSignUpLogIn();
	    
	    login.loginByEmailAndPassword("anything99@gmail.com", "123456789");
	    login.clickLogin();
	    
	    AdRemove.removeAd(driver);
	    
	    home.scrollDown();
	    home.addFirstProduct();
	    home.continueShopping();
	    home.clickCartPageButton();
	    
	    AdRemove.removeAd(driver);
	    
	    cart.clickProceedToCheckout();
	    
	    checkOut.clickPlaceOrder();
	    
	    AdRemove.removeAd(driver);
	    
	    pay.setNameOnCard("mohammed salah");
        pay.setCardNumber("");
        pay.setCardCVC("123");
        pay.setCardMonthOfExpire("12");
        pay.setCardYearOfExpire("2170");
        pay.clickPayAndConfirmButton(); 
	    
	    String currUrl = driver.getCurrentUrl();
	    Assert.assertTrue(currUrl.contains("/payment"));
	    
	    pay.clickDeleteAccount();
	    pay.clickContinueAfterDeleteButton();
	}
 
}
