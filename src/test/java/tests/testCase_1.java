package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.HomePage;
import pages.LoginAndRigsterPage;
import pages.SignUpPage;
import tools.BaseTest;

public class testCase_1 extends BaseTest {
  @Test
  public void positive_signUpTest() {  
	  	Faker faker = new Faker();
	  	
	  	String name = faker.name().username();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password(8, 16);
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String company = faker.company().name();
        String address1 = faker.address().streetAddress();
        String address2 = faker.address().secondaryAddress();
        String state = faker.address().state();
        String city = faker.address().city();
        String zipCode = faker.address().zipCode();
        String mobileNumber = faker.phoneNumber().cellPhone();
	  	
	    HomePage home = new HomePage(driver);
	  
		Assert.assertTrue(home.isHomePageDisplayed(),"Home page is not displayed");
		
		LoginAndRigsterPage register = home.clickSignUpLogIn();

		Assert.assertTrue(register.isSignupTitleDisplayed());
		
		register.registerNameAndEmail(name, email);
		
		SignUpPage signUp = register.clickSignUp();
		
		signUp.fillAccountDetails(password, "15", "July", "1985", firstName, lastName, company, address1,address2, "India", state, city, zipCode, mobileNumber);
		
		Assert.assertTrue(signUp.isAccountCreated(),"Account wasn't created");
		
		home = signUp.clickContinueButton();
		
		Assert.assertTrue(home.isLoggedIn(),"Account wasn't created");
		
		home.clickDeleteAccount();
		
		Assert.assertTrue(home.isAccountedDeleted(),"Account wasn't created");
		
		home.clickContinueAfterDeleteButton();

  }
  @Test
  public void testSignupWithExistingEmail() throws InterruptedException {

		HomePage home = new HomePage(driver);
		
		LoginAndRigsterPage register = home.clickSignUpLogIn();

		register.registerNameAndEmail("user", "anything2@gmail.com");
		register.clickSignUp();
		
	    Assert.assertTrue(register.isEmailExist(),"Expected error for duplicate email, but none was shown.");
	    
	}
}
