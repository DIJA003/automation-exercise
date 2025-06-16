package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductPage;
import tools.BaseTest;

public class testCase_19 extends BaseTest {
  @Test
  public void viewAndCartBrandProduct() {
	  HomePage home = new HomePage(driver);
	  
	  ProductPage product = home.clickProductPageButton();
	  
	  Assert.assertTrue(product.isBrandSidebarVisible());
	  
	  product.clickPoloBrand();
	  
	  String expectedPoloTitle = "BRAND - POLO PRODUCTS";
      
	  Assert.assertEquals(product.getPageTitleText(), expectedPoloTitle, "Not on Polo brand page.");
      
      Assert.assertTrue(product.waitForSearchResultsToLoad().getDisplayedProductNames().size() > 0, "No Polo products are displayed.");
      
      product.clickHMBrand();
      
      String expectedHMTitle = "BRAND - H&M PRODUCTS";
      
      Assert.assertEquals(product.getPageTitleText(), expectedHMTitle, "Not on H&M brand page.");
      
      Assert.assertTrue(product.waitForSearchResultsToLoad().getDisplayedProductNames().size() > 0, "No H&M products are displayed.");
  }
}
