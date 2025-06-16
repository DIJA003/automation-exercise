package tests;

import java.awt.AWTException;
import java.util.List;

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

public class testCase_15 extends BaseTest {

	@Test()
		public void test() throws InterruptedException, AWTException {
			Faker faker  = new Faker();
		
			String name = faker.name().username();
			String email = faker.internet().emailAddress();
			String password = faker.internet().password(8, 16);
			String firstName = faker.name().firstName();
	        String lastName = faker.name().lastName();
	        String company = faker.company().name();
	        String address1 = faker.address().streetAddress();
	        String address2 = faker.address().secondaryAddress();
	        String state = faker.address().state();
	        String city = faker.address().city();
	        String zipCode = faker.address().zipCode();
	        String mobileNumber = faker.phoneNumber().cellPhone();
	        
			HomePage home = new HomePage(driver);
			
			Assert.assertTrue(home.isHomePageDisplayed(),"Home page is not displayed");

			LoginAndRigsterPage register = home.clickSignUpLogIn();
			
			register.registerNameAndEmail(name, email);
			
			SignUpPage signUp = register.clickSignUp();
			
			signUp.fillAccountDetails(password, "15", "July", "1985", firstName, lastName, company, address1,address2, "India", state, city, zipCode, mobileNumber);
			
			Assert.assertTrue(signUp.isAccountCreated(),"Account wasn't created");
			
			signUp.clickContinueButton();
			
			Assert.assertTrue(home.isLoggedIn(),"Not logged in");
			
			home.addFirstProduct();
			
			CartPage cart = home.clickCartPageButton();
			CheckOutPage checkOut = cart.clickProceedToCheckout();

			List<String> deliveryDetails = checkOut.getDeliveryAddressDetails();
			List<String> billingDetails = checkOut.getBillingAddressDetails();

			Assert.assertTrue(deliveryDetails.stream().anyMatch(line -> line.contains(firstName) && line.contains(lastName)));
			Assert.assertTrue(deliveryDetails.stream().anyMatch(line -> line.equals(company)));
			Assert.assertTrue(deliveryDetails.stream().anyMatch(line -> line.equals(address1)));
			Assert.assertTrue(deliveryDetails.stream().anyMatch(line -> line.equals(address2)));
			Assert.assertTrue(deliveryDetails.stream().anyMatch(line -> line.contains(city) && line.contains(state) && line.contains(zipCode)));
			Assert.assertTrue(deliveryDetails.stream().anyMatch(line -> line.equals(mobileNumber)));

			Assert.assertTrue(billingDetails.stream().anyMatch(line -> line.contains(firstName) && line.contains(lastName)));
			Assert.assertTrue(billingDetails.stream().anyMatch(line -> line.equals(address1)));
		    
		    checkOut.scrollPage(500);
		    
			Assert.assertEquals(cart.getProductsCount(),1);
	        
	        checkOut.typeComment("Leave at door");
	        PaymentPage pay = checkOut.clickPlaceOrder();
	        
	        pay.setPaymentDetails("mustafa", "12345678909", "312", "12", "2027")
	           .clickPayAndConfirmButton();
	        
	        Assert.assertTrue(pay.isOrderConfirmed(),"Order is not confirmed");
	        
	        pay.clickDeleteAccount();
	        
	        Assert.assertTrue(pay.isAccountedDeleted(),"Account was not deleted");
	        
	        home = pay.clickContinueAfterDeleteButton();	        
			
		}
	@Test
	public void testSignupWithExistingEmail() throws InterruptedException {

		HomePage home = new HomePage(driver);
		
		home.addFirstProduct()
			.continueShopping();
		CartPage cart = home.clickCartPageButton();
		
		cart.clickProceedToCheckout();
		
		LoginAndRigsterPage register = cart.clickLoginRigsterButton();

		register.registerNameAndEmail("user", "anything2@gmail.com");
		register.clickSignUp();
		
	    Assert.assertTrue(register.isEmailExist(),"Expected error for duplicate email, but none was shown.");
	    
	}

 
}
