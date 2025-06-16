package pages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tools.BasePage;

public class ProductPage extends BasePage {
	
	public ProductPage(WebDriver driver) {
		super(driver);
		removeAd(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[normalize-space()='Cart']//i[@class='fa fa-shopping-cart']")
		private WebElement cartPageBtn;
	
	@FindBy(xpath = "//h2[normalize-space()='Brands']")
		private WebElement brandHeader;
	
	@FindBy(xpath = "//h2[normalize-space()='Category']")
		private WebElement categoryHeader;

    @FindBy(xpath = "//a[@href='#Women']")
    	private WebElement womenCategoryLink;

    @FindBy(xpath = "//div[@id='Women']//a[normalize-space()='Dress']")
    	private WebElement womenDressSubCategoryLink;
    
    @FindBy(xpath = "//a[@href='#Men']")
    	private WebElement menCategoryLink;

    @FindBy(xpath = "//div[@id='Men']//a[normalize-space()='Tshirts']")
    	private WebElement menTshirtsSubCategoryLink;
    
    @FindBy(xpath = "//h2[@class='title text-center']")
    	private WebElement pageTitle;
	
    @FindBy(xpath = "//h2[normalize-space()='Searched Products']")
		private WebElement searchedProductsHeader;
	
	@FindBy(id = "search_product")
		private WebElement searchField;
	
	@FindBy(id = "submit_search")
		private WebElement searchBtn;
	
	@FindBy(xpath = "(//a[@class='btn btn-default add-to-cart'])[1]")
		private WebElement addFirstProductBtn;

	@FindBy(xpath = "//button[contains(@class, 'close-modal')]")
		private WebElement continueShop;
	
	@FindBy(xpath = "(//a[@class='btn btn-default add-to-cart'])[3]")
		private WebElement addSecondProduct;
	
	@FindBy(xpath = "//u[normalize-space()='View Cart']")
		private WebElement viewCart;
	
	@FindBy(xpath = "(//input[@id='quantity'])[1]")
		private	WebElement productQuantity;
	
	@FindBy(xpath = "//button[normalize-space()='Add to cart']")
		private	WebElement addToCart;
	
    @FindBy(xpath = "//h2[normalize-space()='All Products']")
    	private WebElement allProductsHeader; 

    @FindBy(xpath = "(//a[contains(text(),'View Product')])[1]")
    	private WebElement viewFirstProductLink; 

    @FindBy(css = ".product-information h2")
    	private WebElement productName;

    @FindBy(xpath = "//p[contains(text(),'Category')]")
    	private WebElement productCategory;

    @FindBy(css = ".product-information span span")
    	private WebElement productPrice;
    
    @FindBy(xpath = "//b[contains(text(),'Availability:')]")
    	private WebElement productAvailability;

    @FindBy(xpath = "//b[contains(text(),'Condition:')]")
    	private WebElement productCondition;

    @FindBy(xpath = "//b[contains(text(),'Brand:')]")
    	private WebElement productBrand;
   
    @FindBy(xpath = "/html[1]/body[1]/section[2]/div[1]/div[1]/div[2]/div[1]") 
    	private List<WebElement> allSearchedProducts;
 
    @FindBy(css = ".features_items")
    	private WebElement searchedProductsContainer;

    @FindBy(xpath = "//div[@class='brands_products']//a[@href='/brand_products/Polo']")
    	private WebElement poloBrandLink;

    @FindBy(xpath = "//div[@class='brands_products']//a[@href='/brand_products/H&M']")
    	private WebElement hmBrandLink;

    @FindBy(css = ".features_items .product-image-wrapper")
    	private List<WebElement> allDisplayedProducts; 
    
    @FindBy(css = ".features_items .productinfo p")
    	private List<WebElement> displayedProductNames;
    
    @FindBy(xpath = "//a[normalize-space()='Write Your Review']")
    	private WebElement writeYourReviewHeader;

    @FindBy(id = "name")
    	private WebElement reviewNameField;

    @FindBy(id = "email")
    	private WebElement reviewEmailField;

    @FindBy(id = "review")
    	private WebElement reviewTextField;

    @FindBy(id = "button-review")
    	private WebElement reviewSubmitButton;

    @FindBy(xpath = "//div[@class='alert-success alert']/span")
    	private WebElement reviewSuccessMessage;
    
    public boolean isWriteYourReviewVisible() {
        waitForVisibilty(writeYourReviewHeader);
        return writeYourReviewHeader.isDisplayed();
    }

    public ProductPage submitReview(String name, String email, String review) {
        reviewNameField.sendKeys(name);
        reviewEmailField.sendKeys(email);
        reviewTextField.sendKeys(review);
        waitAndClick(reviewSubmitButton);
        return this;
    }

    public boolean isReviewSuccessMessageDisplayed() {
        waitForVisibilty(reviewSuccessMessage);
        return reviewSuccessMessage.isDisplayed();
    }
    
    public CartPage clickCartPageButton() {
    	scrollIntoView(cartPageBtn);
		waitAndClick(cartPageBtn);
		return new CartPage(driver);
	}
    
    public boolean isBrandSidebarVisible() {
        scrollIntoView(brandHeader); 
        waitForVisibilty(brandHeader);
        return brandHeader.isDisplayed(); 
    }

    public ProductPage clickPoloBrand() {
        waitAndClick(poloBrandLink);
        return this;
    }

    public ProductPage clickHMBrand() {
        waitAndClick(hmBrandLink);
        return this;
    }

    public List<String> getDisplayedProductNames() {
        waitForAllElements(displayedProductNames);
        return displayedProductNames.stream()
                                    .map(WebElement::getText)
                                    .collect(Collectors.toList());
    }

    public ProductPage addAllDisplayedProductsToCart() {
        for (WebElement product : allDisplayedProducts) {
            scrollIntoView(product);
            WebElement cartButton = product.findElement(By.xpath(".//a[contains(@class, 'add-to-cart')]"));
            waitAndClick(cartButton);
            continueShopping();
        }
        return this;
    }
    
    public ProductPage waitForSearchResultsToLoad() {
        waitForVisibilty(searchedProductsContainer);
        return this;
    }
    
    public boolean areAllProductsRelatedToSearch(String searchTerm) {
    	String searchTermToCompare = searchTerm.trim().toLowerCase();
        for (WebElement element : displayedProductNames) {
        	scrollIntoView(element);
            String productNameOnPage = element.getText().trim().toLowerCase();
            if (!productNameOnPage.contains(searchTermToCompare)) {
                System.out.println("    Product Name: '" + element.getText() + "'");
                System.out.println("    Does NOT contain search term: '" + searchTerm + "'");
                return false;
            }
        }
        return true;
    }
    public ProductPage searchForProduct(String str) {
    	waitForVisibilty(searchField);
        searchField.sendKeys(str);
        waitAndClick(searchBtn);
    	return this;
    }
    
    public boolean isSearchedProductsVisible() { 
        return searchedProductsHeader.isDisplayed();
    }
    public boolean isAllProductsPageVisible() { 
        return allProductsHeader.isDisplayed();
    }

    public ProductPage clickViewFirstProduct() {
        waitAndClick(viewFirstProductLink);
        return this;
    }

    public boolean areProductDetailsVisible() {
        waitForVisibilty(productName);
        return productName.isDisplayed() &&
               productCategory.isDisplayed() &&
               productPrice.isDisplayed() &&
               productAvailability.isDisplayed() &&
               productCondition.isDisplayed() &&
               productBrand.isDisplayed();
    }
    
    public boolean isCategorySidebarVisible() {
        waitForVisibilty(categoryHeader);
        return categoryHeader.isDisplayed();
    }
    

    public ProductPage clickWomenCategory() {
        waitAndClick(womenCategoryLink);
        return this;
    }
    
    public ProductPage clickWomenDressSubCategory() {
        waitAndClick(womenDressSubCategoryLink);
        return this;
    }
    
    public ProductPage clickMenCategory() {
        waitAndClick(menCategoryLink);
        return this;
    }
    
    public ProductPage clickMenTshirtsSubCategory() {
        waitAndClick(menTshirtsSubCategoryLink);
        return this;
    }
    
    public String getPageTitleText() {
        waitForVisibilty(pageTitle);
        return pageTitle.getText().trim();
    }
	public ProductPage clickAddToCart() {
		waitForVisibilty(addToCart);
		waitAndClick(addToCart);
		return this;
	}
	
	public ProductPage setQuantity(int value) {
		productQuantity.clear();
		productQuantity.sendKeys("" + value + "");
		return this;
	}
	
	public ProductPage addFirstProduct() {
		addFirstProductBtn.click();
		return this;
	}
	
	public ProductPage continueShopping() {
		clickContinueShoppingBtn();
		return this;
	}
	
	public ProductPage addSecondProduct() {
		addSecondProduct.click();
		return this;
	}
	
	public CartPage clickViewCart() {
		waitForVisibilty(viewCart);
		waitAndClick(viewCart);
		return new CartPage(driver);
	}
	
	public ProductPage scrollPage(int pixels) {
	    scrollDownBy(pixels);
	    return this;
	}
	public ProductPage scrollDown() {
		scrollToBottom();
		return this;
	}
}
