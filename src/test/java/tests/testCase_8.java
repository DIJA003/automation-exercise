package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductPage;
import tools.BaseTest;

public class testCase_8 extends BaseTest {
  @Test
  public void verifyProductsAndDetails() {
	  HomePage home = new HomePage(driver);
	  
	  Assert.assertTrue(home.isHomePageDisplayed(),"Home page is not displayed");
	  
	  ProductPage product = home.clickProductPageButton();
	  
	  Assert.assertTrue(product.isAllProductsPageVisible());
	  
	  product.clickViewFirstProduct();
	  
	  Assert.assertTrue(product.areProductDetailsVisible());
	  
  }
}
