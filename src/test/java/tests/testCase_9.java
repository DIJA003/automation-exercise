package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductPage;
import tools.BaseTest;

public class testCase_9 extends BaseTest {
  @Test
  public void searchProductTest() {
	  HomePage home = new HomePage(driver);
	  
	  Assert.assertTrue(home.isHomePageDisplayed(),"Home page is not displayed");
	  
	  ProductPage product = home.clickProductPageButton();
	  
	  Assert.assertTrue(product.isAllProductsPageVisible());
	  
	  String searchItem = "Top";
	  
	  product.searchForProduct(searchItem);
	  
	  Assert.assertTrue(product.isSearchedProductsVisible());
	  
	  product.waitForSearchResultsToLoad();
	  
	  Assert.assertTrue(product.areAllProductsRelatedToSearch(searchItem));
	  
  }
}
