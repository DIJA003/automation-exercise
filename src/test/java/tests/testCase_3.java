package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginAndRigsterPage;
import tools.BaseTest;

public class testCase_3 extends BaseTest {
  @Test
  public void positive_invaildLoginTest() {
	  HomePage home = new HomePage(driver);
	  
		Assert.assertTrue(home.isHomePageDisplayed(),"Home page is not displayed");
		
		LoginAndRigsterPage login = home.clickSignUpLogIn();
		Assert.assertTrue(login.isLoginTitleDisplayed());
		
		login.loginByEmailAndPassword("user", "invalid-email");
		home = login.clickLogin();
		
		Assert.assertTrue(home.isLoggedIn(),"Loggin failed");
		
		home.clickDeleteAccount();
		
		Assert.assertTrue(home.isAccountedDeleted(),"Account wasn't created");
		
		home.clickContinueAfterDeleteButton();
  }
}
