package tools;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
	protected WebDriver driver;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[contains(@class, 'close-modal')]")
	private WebElement continueShop;
	
	public void clickContinueShoppingBtn() {
		waitAndClick(continueShop);
		waitForInvisibility(continueShop);
	}
	protected void waitAndClick(WebElement element) {
		removeAd(driver);
		new WebDriverWait(driver, Duration.ofSeconds(10))
			.until(ExpectedConditions.elementToBeClickable(element))
			.click();
	}
	protected void waitForVisibilty(WebElement element) {
		removeAd(driver);
		scrollIntoView(element);
		new WebDriverWait(driver, Duration.ofSeconds(10))
			.until(ExpectedConditions.visibilityOf(element));
	}
	
	protected WebElement waitForElement(By locator) {
		removeAd(driver);
	    return new WebDriverWait(driver, Duration.ofSeconds(10))
	            .until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	protected void waitForAllElements(List<WebElement> elements) {
		removeAd(driver);
	    try {new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.visibilityOfAllElements(elements));
	    }
	    catch(Exception ex) {
	    	System.out.println(ex.getMessage());
	    }
	      
	}
	protected void waitForInvisibility(WebElement element) {
	    new WebDriverWait(driver, Duration.ofSeconds(10))
	        .until(ExpectedConditions.invisibilityOf(element));
	}
	protected void scrollDownBy(int pixles) {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0, " + pixles + ")");
	}
	protected void scrollToBottom() {
	    try {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	    }
	}
	protected void scrollIntoView(WebElement element) {
	    try {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].scrollIntoView(true);", element);
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	    }
	}
	
	public void removeAd(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("document.querySelectorAll('.adsbygoogle, .adsbygoogle-noablate').forEach(el => el.style.display = 'none');");
	}
	public void resilientClick(WebElement element) {
	    try {
	        waitAndClick(element);
	    } catch (ElementClickInterceptedException e) {
	        removeAd(driver);
	        waitAndClick(element);
	    }
	}
	public void resilientWaitForVisibility(WebElement element) {
	    try {
	        new WebDriverWait(driver, Duration.ofSeconds(5))
	            .until(ExpectedConditions.visibilityOf(element));
	    } catch (TimeoutException e) {
	        removeAd(driver);
	        new WebDriverWait(driver, Duration.ofSeconds(10))
	            .until(ExpectedConditions.visibilityOf(element));
	    }
	}
	protected void scrollToPageTop() {
	    try {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollTo(0, 0)");
	    } catch (Exception e) {
	        System.out.println("An exception occurred while scrolling to the page top: " + e.getMessage());
	    }
	}
}
