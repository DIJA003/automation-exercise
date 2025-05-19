package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import tools.BaseTest;

public class testCase_10 extends BaseTest {
		

	@Test()
		public void validEmailInHomePage() {
			HomePage home = new HomePage(driver);
			
			Assert.assertTrue(home.isHomePageDisplayed());
			
			home.scrollToBottom();
			
			Assert.assertTrue(home.isSubscriptionDisplayed());
			
			home.enterEmail("anything@gmail.com");
			home.clickSubscripButton();
			
			Assert.assertTrue(home.isSuccessMessageDisplayed());	
		}
	@Test()
		public void invalidEmailInHomePage () {
			HomePage home = new HomePage(driver);
			
			Assert.assertTrue(home.isHomePageDisplayed());
			
			home.scrollToBottom();
			
			Assert.assertTrue(home.isSubscriptionDisplayed());
			
			home.enterEmail("Invaild-email");
			home.clickSubscripButton();
			
			Assert.assertFalse(home.isSuccessMessageDisplayed(),"Subscription shouldn't be successful with invalid email");	
		}
 
}
