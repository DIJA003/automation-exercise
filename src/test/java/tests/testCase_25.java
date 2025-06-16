package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import tools.BaseTest;

public class testCase_25 extends BaseTest {
  @Test
  public void arrowUpTest() {
	  HomePage home = new HomePage(driver);
	  
	  Assert.assertTrue(home.isHomePageDisplayed(),"Home Page in not Displayed");
	  
	  home.toBottomPage();
	  
	  Assert.assertTrue(home.isSubscriptionDisplayed(),"Subscription is not visible");
	  
	  home.clickScrollUpArrow();
	  
	  Assert.assertTrue(home.isMainHeaderDisplayed());
	  
  }
}
