package tests;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.HomePage;
import pages.LoginAndRigsterPage;
import pages.SignUpPage;
import tools.BaseTest;

public class testCase_2 extends BaseTest{
	
	Faker faker = new Faker();
	
	public HomePage creatAcc(String name, String email, String password) throws AWTException, InterruptedException {
		HomePage home = new HomePage(driver);

		LoginAndRigsterPage register = home.clickSignUpLogIn();
		
		register.registerNameAndEmail(name, email);
		
		SignUpPage signUp = register.clickSignUp();
		
		signUp.fillAccountDetails(password, "15", "July", "1985", faker.name().firstName(), faker.name().lastName(), "Widgets Inc.", "456 Automation Dr", "Suite 101", "India", "California", "San Francisco", "94105", "9876543210");
		home = signUp.clickContinueButton();
	  	return home.clickLogoutBtn();
	}
  @Test
  public void positive_LoginTest() throws AWTException, InterruptedException {
	  	String name = faker.name().username();
  		String email = faker.internet().emailAddress();
  		String password = "password123";
	  	HomePage home = creatAcc(name,email,password);
	  
		Assert.assertTrue(home.isHomePageDisplayed(),"Home page is not displayed");
		
		LoginAndRigsterPage login = home.clickSignUpLogIn();
		Assert.assertTrue(login.isLoginTitleDisplayed());
		
		login.loginByEmailAndPassword(email, password);
		home = login.clickLogin();
		
		Assert.assertTrue(home.isLoggedIn(),"Loggin failed");
		
		home.clickDeleteAccount();
		
		Assert.assertTrue(home.isAccountedDeleted(),"Account wasn't created");
		
		home.clickContinueAfterDeleteButton();
  }
}
