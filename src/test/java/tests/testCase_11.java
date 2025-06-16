package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.CartPage;
import pages.HomePage;
import tools.BaseTest;

public class testCase_11 extends BaseTest {

	@Test(priority = 1)
		public void validEmailInCartPage() {
			Faker faker = new Faker();
			String email = faker.internet().emailAddress();
		
			HomePage home = new HomePage(driver);
			
			Assert.assertTrue(home.isHomePageDisplayed());
			
			CartPage cart = home.clickCartPageButton()
								.toPageBottom();
			
			Assert.assertTrue(cart.isSubscriptionDisplayed());
			
			cart.enterEmail(email)
				.clickSubscribeButton();
			
			Assert.assertTrue(cart.isSuccessMessageDisplayed());	
		}
	@Test(priority = 2)
		public void invalidEmailInCartPage () {
			HomePage home = new HomePage(driver);		
			
			Assert.assertTrue(home.isHomePageDisplayed());
			
			CartPage cart = home.clickCartPageButton()
								.toPageBottom();
			
			Assert.assertTrue(cart.isSubscriptionDisplayed());
			
			cart.enterEmail("invail-email")
				.clickSubscribeButton();

			Assert.assertFalse(cart.isSuccessMessageDisplayed(), "Subscription should not be successful with invalid email.");
		}
 
}
