package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.HomePage;
import tools.BaseTest;

public class testCase_17 extends BaseTest {
  @Test
  public void removeProductTest() {
	  HomePage home = new HomePage(driver);
	   
	   
	   home.addFirstProduct()
	   	   .clickContinueShoppingBtn();
	   
	   CartPage cart = home.clickCartPageButton();
	   
	   Assert.assertTrue(cart.isCartPageDisplayed());
	   
	   int number_of_products_before = cart.getProductsCount();
	   
	   cart.clickRemoveProduct(1);
	   
	   int number_of_products_after = cart.getProductsCount();
	   
	   Assert.assertTrue(number_of_products_before > number_of_products_after);
	   
  }
}
