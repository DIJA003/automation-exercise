package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductPage;
import tools.BaseTest;

public class testCase_18 extends BaseTest{
  @Test
  public void viewCatagoryProductTest() {
	  HomePage home = new HomePage(driver);
	  ProductPage product = home.clickProductPageButton(); 
	  
	  Assert.assertTrue(product.isCategorySidebarVisible());
	  
	  product.clickWomenCategory().clickWomenDressSubCategory();
	  
	  String expectedWomenCategoryText = "WOMEN - DRESS PRODUCTS";
      String actualWomenCategoryText = product.getPageTitleText();
      
      Assert.assertEquals(actualWomenCategoryText, expectedWomenCategoryText);
      
      product.clickMenCategory()
      		 .clickMenTshirtsSubCategory();
      
      String expectedMenCategoryText = "MEN - TSHIRTS PRODUCTS";
      String actualMenCategoryText = product.getPageTitleText();
      
      Assert.assertEquals(actualMenCategoryText, expectedMenCategoryText);
  }
}
