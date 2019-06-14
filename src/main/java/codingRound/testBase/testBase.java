package codingRound.testBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sun.javafx.PlatformUtil;

public class testBase {
public 	ChromeOptions options;

	public WebDriver driver;
	public static String url;
	   public void setDriverPath() {
	        if (PlatformUtil.isMac()) {
	            System.setProperty("webdriver.chrome.driver", "chromedriver");
	        }
	        if (PlatformUtil.isWindows()) {
	            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//src//main//java//drivers//chromedriver.exe");
	            options = new ChromeOptions();
	            options.addArguments("--disable-notifications");
	            driver = new ChromeDriver(options);
	        }
	        if (PlatformUtil.isLinux()) {
	            System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
	        }
	    }
	   
	   public void getUrl(String url) {
		   driver.get(url);
	   }
	   
	   public void maximizeWindow() {
		   driver.manage().window().maximize();
	   }
	 
	   public static void main(String[] args) {
		   testBase test = new testBase();
		   test.setDriverPath();
		   test.getUrl(url);
		   test.maximizeWindow();
	   }
}
