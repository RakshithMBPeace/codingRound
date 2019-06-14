package codingRound.waitHelper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class waitHelper {
	private WebDriver driver;
	public waitHelper(WebDriver driver) {
		this.driver=driver;
	}
	public void waitForElement(WebDriver driver, WebElement element, long timeUnitInSeconds) {
			   WebDriverWait wait = new WebDriverWait(driver, timeUnitInSeconds);
			   wait.until(ExpectedConditions.visibilityOf(element));
		   }
	}


