package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.HomePage;
import tools.BaseTest;

public class testCase_11 extends BaseTest {

	@Test(priority = 1)
		public void validEmailInCartPage() {
			HomePage home = new HomePage(driver);
			CartPage cart = new CartPage(driver);
			
			Assert.assertTrue(home.isHomePageDisplayed());
			
			home.clickCartPageButton();
			cart.scrollToBottom();
			
			Assert.assertTrue(cart.isSubscriptionDisplayed());
			
			cart.enterEmail("anything@gmail.com");
			cart.clickSubscripButton();
			
			Assert.assertTrue(cart.isSuccessMessageDisplayed());	
		}
	@Test(priority = 2)
		public void invalidEmailInCartPage () {
			HomePage home = new HomePage(driver);		
			CartPage cart = new CartPage(driver);
			
			Assert.assertTrue(home.isHomePageDisplayed());
			
			home.clickCartPageButton();
			cart.scrollToBottom();
			
			Assert.assertTrue(cart.isSubscriptionDisplayed());
			
			cart.enterEmail("Invalid-Email");
			cart.clickSubscripButton();

			Assert.assertFalse(cart.isSuccessMessageDisplayed(), "Subscription should not be successful with invalid email.");
		}
 
}
