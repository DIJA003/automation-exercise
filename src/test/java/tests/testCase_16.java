package tests;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.CartPage;
import pages.CheckOutPage;
import pages.HomePage;
import pages.LoginAndRigsterPage;
import pages.PaymentPage;
import pages.SignUpPage;
import tools.BaseTest;

public class testCase_16 extends BaseTest{
	
	Faker faker = new Faker();
	
	public HomePage creatAcc(String name, String email, String password) throws AWTException, InterruptedException {
		HomePage home = new HomePage(driver);

		LoginAndRigsterPage register = home.clickSignUpLogIn();
		
		register.registerNameAndEmail(name, email);
		
		SignUpPage signUp = register.clickSignUp();
		
		signUp.fillAccountDetails(password, "15", "July", "1985", faker.name().firstName(), faker.name().lastName(), "Widgets Inc.", "456 Automation Dr", "Suite 101", "India", "California", "San Francisco", "94105", "9876543210");
		home = signUp.clickContinueButton();
	  	return home.clickLogoutBtn();
	}

	@Test(priority = 1)
		public void everythingValid() throws InterruptedException, AWTException {
	    	String name = faker.name().username();
	    	String email = faker.internet().emailAddress();
	    	String password = "password123";
			
	    	HomePage home = creatAcc(name,email,password);

			Assert.assertTrue(home.isHomePageDisplayed(),"Home page not shown");
			
			LoginAndRigsterPage login = home.clickSignUpLogIn();
			
			login.loginByEmailAndPassword(email, password);
			home = login.clickLogin();
			
			Assert.assertTrue(home.isLoggedIn(),"Not logged in");
			
			home.scrollPage(500)
				.addFirstProduct()
				.continueShopping();
			
			CartPage cart = home.clickCartPageButton();
			
			
			Assert.assertTrue(cart.isCartPageDisplayed(),"Cart page not shown");
			
			CheckOutPage checkOut = cart.clickProceedToCheckout();
			
			Assert.assertTrue(checkOut.isAddressDetailsDisplayed(),"Address details not showen");
			Assert.assertTrue(checkOut.isReviewOrderDisplayed(),"Order not showen");

	        checkOut.typeComment("Leave at door");
	        PaymentPage pay = checkOut.clickPlaceOrder();
	        
	        pay.setPaymentDetails("Test User", "4100000000000000", "123", "12", "2030")
	           .clickPayAndConfirmButton();
	        
	        Assert.assertTrue(pay.isOrderConfirmed(),"Order is not confirmed");
			
	        pay.clickDeleteAccount();
	        
	        Assert.assertTrue(pay.isAccountedDeleted(),"Account is not deleted");
	        
	        home = pay.clickContinueAfterDeleteButton();
		}
	@Test(priority = 2)
	public void testInvalidPaymentDetails() throws InterruptedException, AWTException {
		String name = faker.name().username();
    	String email = faker.internet().emailAddress();
    	String password = "password123";
    	
		HomePage home = creatAcc(name,email,password);
		
		LoginAndRigsterPage login = home.clickSignUpLogIn();
		
		login.loginByEmailAndPassword(email, password);
		home = login.clickLogin();
		
		home.addFirstProduct()
			.continueShopping();
		
		CartPage cart = home.clickCartPageButton();
		
		CheckOutPage checkOut = cart.clickProceedToCheckout();

        checkOut.typeComment("Leave at door");
        PaymentPage pay = checkOut.clickPlaceOrder();
        
        pay.setPaymentDetails("Test User", "4100000000000000", "", "12", "2030")
        .clickPayAndConfirmButton();
        
        String currUrl = driver.getCurrentUrl();
	    Assert.assertFalse(!currUrl.contains("/payment"));

	    pay.clickDeleteAccount()
	       .clickContinueAfterDeleteButton();
	}
 
}
