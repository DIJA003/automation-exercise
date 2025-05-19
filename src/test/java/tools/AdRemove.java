package tools;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class AdRemove {
	
	public static void removeAd(WebDriver driver) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("document.querySelectorAll('.adsbygoogle, .adsbygoogle-noablate').forEach(el => el.style.display = 'none');");
	}

}
