package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.TestCasesPage;
import tools.BaseTest;

public class testCase_7 extends BaseTest{
  @Test
  public void verifyTestCasesPage() {
	  HomePage home = new HomePage(driver);
	  
	  Assert.assertTrue(home.isHomePageDisplayed(),"Home page is not displayed");
	  
	  TestCasesPage tcp = home.clickTestCasesBtn();
	  
	  Assert.assertTrue(tcp.isTestCasePageDisplayed());
  }
}
