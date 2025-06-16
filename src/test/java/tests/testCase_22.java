package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;
import tools.BaseTest;

public class testCase_22 extends BaseTest {
  @Test
  public void addRecommendedItemsTest() {
	  HomePage home = new HomePage(driver);
     
	  home.toBottomPage();
      
	  Assert.assertTrue(home.isRecommendedItemsVisible(), "'RECOMMENDED ITEMS' not visible.");

      
	  ProductPage productPage = home.addRecommendedItemToCart();
      
	  CartPage cartPage = productPage.clickViewCart();
      
      Assert.assertTrue(cartPage.getProductsCount() > 0, "Product was not added to cart from recommended items.");
  }
}
