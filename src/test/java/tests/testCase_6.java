package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.HomePage;
import tools.BaseTest;

public class testCase_6 extends BaseTest{
  @Test
  public void positive_ContactUsForm() {
	  HomePage home = new HomePage(driver);
	  
	  Assert.assertTrue(home.isHomePageDisplayed(),"Home Page is not displayed");
	  
	  ContactUsPage cont = home.clickContactUs();
	  
	  Assert.assertTrue(cont.isContactusPageDisplayed(),"Contact Page is not displayed");
	  
	  cont.fillNameField("user")
	  	  .fillEmailField("email@email.com")
	  	  .fillSubjectField("subject")
	  	  .fillMessageField("message")
	  	  .clickChooseFile("D:\\blank.txt")
	  	  .clickSubmitBtn()
	  	  .handleAlert();
	  
	  Assert.assertTrue(cont.isSubmitted(),"form wasn't submitted right");
	  home = cont.clickHomeBtn();
  }
}
