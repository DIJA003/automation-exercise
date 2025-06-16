package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginAndRigsterPage;
import tools.BaseTest;

public class testCase_4 extends BaseTest {
  @Test
  public void positive_LogoutTest() {
	  HomePage home = new HomePage(driver);
	  
		Assert.assertTrue(home.isHomePageDisplayed(),"Home page is not displayed");
		
		LoginAndRigsterPage login = home.clickSignUpLogIn();
		Assert.assertTrue(login.isLoginTitleDisplayed());
		
		login.loginByEmailAndPassword("perma@gmail.com","u1" );
		home = login.clickLogin();
		
		Assert.assertTrue(home.isLoggedIn(),"Loggin failed");
		
		home.clickLogoutBtn();
		
		Assert.assertTrue(!home.isLoggedIn(),"logging out failed failed");
  }
}
