package tests;

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

public class testCase_24 extends BaseTest {
  @Test
  public void downloadInvoiceTest() {
	  Faker faker = new Faker();
      
	  HomePage home = new HomePage(driver);
      
	  Assert.assertTrue(home.isHomePageDisplayed(), "Home page not visible.");

      home.addFirstProduct().clickContinueShoppingBtn();
      
      CartPage cart = home.clickCartPageButton();
      
      Assert.assertTrue(cart.isCartPageDisplayed(), "Cart page not displayed.");
      
      CheckOutPage checkoutPage = cart.clickProceedToCheckout();
      
      LoginAndRigsterPage register = checkoutPage.clickSignUpLogIn();
      
      
      SignUpPage signUp = register.registerNameAndEmail(faker.name().username(), faker.internet().emailAddress()).clickSignUp();
      
      signUp.fillAccountDetails("password123", "15", "July", "1985", faker.name().firstName(), faker.name().lastName(), "Widgets Inc.", "456 Automation Dr", "Suite 101", "India", "California", "San Francisco", "94105", "9876543210");
      
      Assert.assertTrue(signUp.isAccountCreated(), "'ACCOUNT CREATED!' is not visible.");
      
      home = signUp.clickContinueButton();
      
      Assert.assertTrue(home.isLoggedIn(), "'Logged in as' is not visible.");
      
      cart = home.clickCartPageButton();
      
      checkoutPage = cart.clickProceedToCheckout();
      
      Assert.assertTrue(checkoutPage.isAddressDetailsDisplayed(), "Address details not visible.");
      
      checkoutPage.typeComment("ay7aga");
      
      PaymentPage paymentPage = checkoutPage.clickPlaceOrder();
      
      paymentPage.setPaymentDetails("Test User", "4100000000000000", "123", "12", "2030")
                 .clickPayAndConfirmButton();
                 
      Assert.assertTrue(paymentPage.isOrderConfirmed(), "Order success message was not displayed.");
      
      paymentPage.clickDownloadInvoice();
      
      home = paymentPage.clickContinueAfterOrder();
      
      home.clickDeleteAccount();
      
      Assert.assertTrue(home.isAccountedDeleted(), "'ACCOUNT DELETED!' is not visible.");
      
      home.clickContinueAfterDeleteButton();
      
  }
}
