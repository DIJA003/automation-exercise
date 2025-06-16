package tests;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;
import tools.BaseTest;

public class testCase_13 extends BaseTest {

	@Test()
		public void addingValueGreaterThanZero() throws InterruptedException, AWTException {
			HomePage home = new HomePage(driver);
			
			Assert.assertTrue(home.isHomePageDisplayed());
			
			ProductPage product = home.clickProductPageButton()
									  .scrollPage(500)
									  .clickViewFirstProduct();
			
			Assert.assertTrue(product.areProductDetailsVisible());
			
			product.setQuantity(4)
				   .clickAddToCart();
			
			CartPage cart = product.clickViewCart();
			
			Assert.assertEquals(cart.getQuantityOfProduct(1),"4", "Mismatch");
			
		}
	@Test()
		public void addingValueLessThanZero() throws AWTException, InterruptedException {
			HomePage home = new HomePage(driver);
			
			ProductPage product = home.clickProductPageButton();

		    product.scrollPage(500)
		    	   .clickViewFirstProduct()
		    	   .setQuantity(-1)
		    	   .clickAddToCart();
		    
		    CartPage cart = product.clickViewCart();
		    Assert.assertEquals(cart.getProductsCount(), 0, "Product with negative quantity should not be added to cart.");
		}
 
}
