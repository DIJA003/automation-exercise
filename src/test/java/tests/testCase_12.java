package tests;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;
import tools.BaseTest;

public class testCase_12 extends BaseTest {
	
	@Test(priority = 1)
		public void addingTwoProducts() throws InterruptedException, AWTException {
			HomePage home = new HomePage(driver);
			
			 new CartPage(driver);
			
			Assert.assertTrue(home.isHomePageDisplayed());
			
			ProductPage product = home.clickProductPageButton()
									  .addFirstProduct()
									  .continueShopping();
			
			product.addSecondProduct();
			CartPage cart = product.clickViewCart();
			
			int productCount = cart.getProductsCount();
			Assert.assertEquals(productCount, 2);
			
			for(int i = 1; i <= productCount; i++ ) {
				Assert.assertTrue(cart.isProductDisplayed(i));
				Assert.assertFalse(cart.getProductPrice(i).isEmpty());
				Assert.assertFalse(cart.getQuantityOfProduct(i).isEmpty());
				Assert.assertFalse(cart.getTotalPriceOfProduct(i).isEmpty());
			}
		}
	@Test(priority = 2)
		public void addingOnlyOneProduct() throws InterruptedException, AWTException {
			HomePage home = new HomePage(driver);
		    
		    ProductPage product = home.clickProductPageButton()
		    						  .addFirstProduct();
		    
		    CartPage cart = product.clickViewCart();
		    
		    Assert.assertFalse(cart.getProductsCount() >= 2);
		}
 
}
