package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductPage;
import tools.BaseTest;

public class testCase_21 extends BaseTest {
  @Test
  public void addReviewTest() {
	  HomePage home = new HomePage(driver);
      
	  ProductPage productPage = home.clickProductPageButton();
      
	  Assert.assertTrue(productPage.isAllProductsPageVisible(), "Not on All Products page.");
      
      productPage.clickViewFirstProduct();
      
      Assert.assertTrue(productPage.isWriteYourReviewVisible(), "'Write Your Review' is not visible.");
      
      productPage.submitReview("Test User", "test@example.com", "This is a great product!");
      
      Assert.assertTrue(productPage.isReviewSuccessMessageDisplayed(), "Review success message not displayed.");
  }
}
