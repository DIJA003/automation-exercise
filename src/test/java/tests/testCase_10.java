package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.HomePage;
import tools.BaseTest;

public class testCase_10 extends BaseTest {
		

	@Test()
		public void validEmailInHomePage() {
			Faker faker = new Faker();
			String email = faker.internet().emailAddress();
			
			HomePage home = new HomePage(driver);
			
			Assert.assertTrue(home.isHomePageDisplayed());
			
			home.toBottomPage();
			
			Assert.assertTrue(home.isSubscriptionDisplayed());
			
			home.enterEmail(email)
				.clickSubscripButton();
			
			Assert.assertTrue(home.isSuccessMessageDisplayed());	
		}
	@Test()
		public void invalidEmailInHomePage () {
			HomePage home = new HomePage(driver);
			
			Assert.assertTrue(home.isHomePageDisplayed());
			
			home.toBottomPage();
			
			Assert.assertTrue(home.isSubscriptionDisplayed());
			
			home.enterEmail("Invaild-email")
				.clickSubscripButton();
			
			Assert.assertFalse(home.isSuccessMessageDisplayed(),"Subscription shouldn't be successful with invalid email");	
		}
 
}
