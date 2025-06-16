package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import tools.BaseTest;

public class testCase_26 extends BaseTest{
  @Test
  public void scrollWithOutArrowHelpTest() {
	  HomePage home = new HomePage(driver);
	  
	  Assert.assertTrue(home.isHomePageDisplayed(),"Home page is not displayed");
	  
	  home.toBottomPage();
	  
	  Assert.assertTrue(home.isSubscriptionDisplayed(),"Subscription is not displayed");
	  
	  home.scrollToTop();
	  
	  Assert.assertTrue(home.isMainHeaderDisplayed(),"Full-Fledged practice website for Automation Engineers header is not displayed");
  }
}
