package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.CartPage;
import pages.CheckOutPage;
import pages.HomePage;
import pages.LoginAndRigsterPage;
import pages.SignUpPage;
import tools.BaseTest;

public class testCase_23 extends BaseTest {
  @Test
  public void addressDetialsTest() {
	  Faker faker = new Faker();
      
	  HomePage home = new HomePage(driver);
      
	  Assert.assertTrue(home.isHomePageDisplayed(), "Home page not visible.");

	  LoginAndRigsterPage loginPage = home.clickSignUpLogIn(); 
      
	  SignUpPage signUpPage = loginPage.registerNameAndEmail(faker.name().firstName(), faker.internet().emailAddress()).clickSignUp();
  
      String address1 = faker.address().streetAddress();

      signUpPage.fillAccountDetails("password123", "10", "May", "1990", "Test", "User", "Test Company", address1, "Test Address 2", "India", "Texas", "Dallas", "75201", "1234567890");
      
      Assert.assertTrue(signUpPage.isAccountCreated(), "'ACCOUNT CREATED!' is not visible.");
      
      home = signUpPage.clickContinueButton();
      
      Assert.assertTrue(home.isLoggedIn(), "'Logged in as' is not visible.");

      home.clickProductPageButton().addFirstProduct().continueShopping();
      
      CartPage cartPage = home.clickCartPageButton();
      
      Assert.assertTrue(cartPage.isCartPageDisplayed(), "Cart page not displayed.");

      CheckOutPage checkoutPage = cartPage.clickProceedToCheckout();
      
      Assert.assertTrue(checkoutPage.getDeliveryAddressDetails().stream().anyMatch(line -> line.contains(address1)), "Delivery address does not match registered address.");
      
      Assert.assertTrue(checkoutPage.getBillingAddressDetails().stream().anyMatch(line -> line.contains(address1)), "Billing address does not match registered address.");

      home.clickDeleteAccount();
      
      Assert.assertTrue(home.isAccountedDeleted(), "'ACCOUNT DELETED!' is not visible.");
  }
}
