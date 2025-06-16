package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.HomePage;
import pages.LoginAndRigsterPage;
import pages.ProductPage;
import tools.BaseTest;

public class testCase_20 extends BaseTest{
  @Test
  public void searchAndVerify() {
	  HomePage home = new HomePage(driver);
      ProductPage product = home.clickProductPageButton();
      Assert.assertTrue(product.isAllProductsPageVisible());
      
      String item = "Top";
      
      product.searchForProduct(item);
      
      Assert.assertTrue(product.isSearchedProductsVisible());
      
      product.waitForSearchResultsToLoad(); 
      
      int expectedProductCount = product.getDisplayedProductNames().size();
            
      Assert.assertTrue(expectedProductCount > 0, "No products were found for the search term.");

      product.addAllDisplayedProductsToCart();
      
      CartPage cart = product.clickCartPageButton(); 
      
      Assert.assertEquals(cart.getProductsCount(), expectedProductCount, "Incorrect product count in cart before login.");
      
      LoginAndRigsterPage login = cart.clickLoginRigsterButton();
      
      home = login.loginByEmailAndPassword("anything3@email.com", "0").clickLogin();
      cart = home.clickCartPageButton();	  		

      Assert.assertEquals(cart.getProductsCount(), expectedProductCount, "Incorrect product count in cart AFTER login.");
	  
	  
  }
}
