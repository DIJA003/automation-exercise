package tests;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;
import tools.AdRemove;
import tools.BaseTest;

public class testCase_13 extends BaseTest {

	@Test()
		public void addingValueGreaterThanZero() throws InterruptedException, AWTException {
			HomePage home = new HomePage(driver);
			ProductPage product = new ProductPage(driver);
			CartPage cart = new CartPage(driver);
			
			Assert.assertTrue(home.isHomePageDisplayed());
			
			home.clickProductPageButton();
			
			AdRemove.removeAd(driver);

			product.scrollDown();
			product.clickViewProdct();
			
			AdRemove.removeAd(driver);

			Assert.assertTrue(product.isProductDetailsExist());
			
			product.setQuantity(4);
			product.clickAddToCart();
			product.clickViewCart();
			
			AdRemove.removeAd(driver);
			
			Assert.assertEquals(cart.getQuantityOfProduct(1),"4", "Mismatch");
			
		}
	@Test()
		public void addingValueLessThanZero() throws AWTException, InterruptedException {
			HomePage home = new HomePage(driver);
			ProductPage product = new ProductPage(driver);
			CartPage cart = new CartPage(driver);
			
			home.clickProductPageButton();
			
			AdRemove.removeAd(driver);

		    product.scrollDown();
		    product.clickViewProdct();
		    
		    AdRemove.removeAd(driver);
			
		    product.setQuantity(-1);
			product.clickAddToCart();
			product.clickViewCart();

		    try {
		    	Assert.assertFalse(cart.isProductDisplayed(1), "Bug: Product with quantity -1 should not be in cart");
		    } catch(Exception ex) {
		    	Assert.assertTrue(true);
		    }
		}
 
}
