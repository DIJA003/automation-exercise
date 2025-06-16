package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginAndRigsterPage;
import tools.BaseTest;

public class testCase_5 extends BaseTest {
  @Test
  public void positive_RegisterUserWithExistingEmail() {
		HomePage home = new HomePage(driver);
		  
		Assert.assertTrue(home.isHomePageDisplayed(),"Home page is not displayed");
		
		LoginAndRigsterPage register = home.clickSignUpLogIn();

		Assert.assertTrue(register.isSignupTitleDisplayed());
		
		register.registerNameAndEmail("user", "anything99@gmail.com");
		register.clickSignUp();
		Assert.assertTrue(register.isEmailExist(),"Email does not exist");
  }
}
