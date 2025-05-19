package tests;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.CheckOutPage;
import pages.HomePage;
import pages.LoginAndRigsterPage;
import pages.PaymentPage;
import pages.SignUpPage;
import tools.AdRemove;
import tools.BaseTest;

public class testCase_14 extends BaseTest{

	@Test()
		public void singupWithNonExistingEmail() throws InterruptedException, AWTException {
			HomePage home = new HomePage(driver);
			CartPage cart = new CartPage(driver);
			LoginAndRigsterPage register = new LoginAndRigsterPage(driver);
			SignUpPage signUp = new SignUpPage(driver);
			CheckOutPage checkOut = new CheckOutPage(driver);
			PaymentPage pay = new PaymentPage(driver);
			
			Assert.assertTrue(home.isHomePageDisplayed(),"Home page is not displayed");
			
			AdRemove.removeAd(driver);
			
			home.scrollDown();
			home.addFirstProduct();
			home.continueShopping();
			home.clickCartPageButton();
			
			cart.clickProceedToCheckout();
			cart.clickLoginRigsterButton();
			
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
			
			
			Assert.assertTrue(signUp.isAccountCreated(),"Account wasn't created");
			
			signUp.clickContinueButton();
			
			AdRemove.removeAd(driver);
			
			Assert.assertTrue(home.isLoggedIn());
			home.clickCartPageButton();
			
			cart.clickProceedToCheckout();
			
			AdRemove.removeAd(driver);
			
		    String expectedDeliveryName = "Mr. mustafa muhammed";
		    String expectedDeliveryCompany = "DEPI";
		    String expectedDeliveryAddress1 = "Taawan";
		    String expectedDeliveryAddress2 = "Etihad st";
		    String expectedDeliveryCityStateZipCode = "KingsLanding Giza 0000";
		    String expectedDeliveryCountry = "Canada";
		    String expectedDeliveryPhone = "12345678901";

		    Assert.assertEquals(checkOut.getDeliveryName(), expectedDeliveryName);
		    Assert.assertEquals(checkOut.getDeliveryCompany(), expectedDeliveryCompany);
		    Assert.assertEquals(checkOut.getDeliveryAddress1(), expectedDeliveryAddress1);
		    Assert.assertEquals(checkOut.getDeliveryAddress2(), expectedDeliveryAddress2);
		    Assert.assertEquals(checkOut.getDeliveryPostcode(), expectedDeliveryCityStateZipCode);
		    Assert.assertEquals(checkOut.getDeliveryCountry(), expectedDeliveryCountry);
		    Assert.assertEquals(checkOut.getDeliveryPhone(), expectedDeliveryPhone);

		    Assert.assertEquals(checkOut.getBillingName(), expectedDeliveryName);
		    Assert.assertEquals(checkOut.getBillingAddress1(), expectedDeliveryAddress1);
		    Assert.assertEquals(checkOut.getBillingAddress2(), expectedDeliveryAddress2);
		    Assert.assertEquals(checkOut.getBillingPostcode(), expectedDeliveryCityStateZipCode);
		    Assert.assertEquals(checkOut.getBillingCountry(), expectedDeliveryCountry);
		    Assert.assertEquals(checkOut.getBillingPhone(), expectedDeliveryPhone);
		    
		    checkOut.scrollDown();
			Assert.assertEquals(cart.getProductsCount(),1);
	        
	        checkOut.typeComment("Leave at door");
	        checkOut.clickPlaceOrder();
	        
	        AdRemove.removeAd(driver);
	        
	        pay.setNameOnCard("mustafa");
	        pay.setCardNumber("12345678909");
	        pay.setCardCVC("312");
	        pay.setCardMonthOfExpire("12");
	        pay.setCardYearOfExpire("2027");
	        pay.clickPayAndConfirmButton();
	        
	        AdRemove.removeAd(driver);
	        
	        Assert.assertTrue(pay.isOrderConfirmed(), "Order is not confirmed");
	        
	        pay.clickDeleteAccount();
	        
	        Assert.assertTrue(pay.isAccountedDeleted(), "Account is not deleted");
	        
	        pay.clickContinueAfterDeleteButton();       
			
		}
	@Test
	public void testSignupWithExistingEmail() throws InterruptedException {
		HomePage home = new HomePage(driver);
		CartPage cart = new CartPage(driver);
		LoginAndRigsterPage register = new LoginAndRigsterPage(driver);
		
		AdRemove.removeAd(driver);
		
		home.scrollDown();
		home.addFirstProduct();
		home.continueShopping();
		home.clickCartPageButton();
		
		cart.clickProceedToCheckout();
		cart.clickLoginRigsterButton();
		
		AdRemove.removeAd(driver);

		register.registerNameAndEmail("user", "anything2@gmail.com");
		register.clickSignUp();
		
	    Assert.assertTrue(register.isEmailExist(),"Expected error for duplicate email, but none was shown.");
	}

 
}
