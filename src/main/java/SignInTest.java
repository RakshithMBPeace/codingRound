import com.sun.javafx.PlatformUtil;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignInTest {



    @Test
    public void shouldThrowAnErrorIfSignInDetailsAreMissing() {

        setDriverPath();
        ChromeOptions options = new ChromeOptions();

      //Add chrome switch to disable notification - "**--disable-notifications**"
      options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://www.cleartrip.com/");
        waitFor(2000);
        driver.manage().window().maximize();
      
        driver.findElement(By.linkText("Your trips")).click();
        driver.findElement(By.id("SignIn")).click();
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"modal_window\"]")));
        //driver.switchTo().defaultContent();
      //  Actions act = new Actions(driver);
       
   
      

      driver.findElement(By.xpath("//*[@id=\"signInButton\"]")).click();
       // driver.switchTo().frame("modal_window.spinnerMedium");//*[@id="signInButton"]
         
      // driver.findElement(By.xpath("//div[@id='ModalFrame']/iframe[@id='modal_window']/*[@id='signInButton']")).click();
       //  driver.findElement(By.xpath("//dd[@class='submit']")).click();

      //  driver.findElement(By.xpath("//button[@id='signInButton' and @class='primary']")).click();
     
      // frm.findElement(By.xpath(".//button[@id='signInButton']")).click();
    
     // WebElement signInButton = driver.findElement(By.xpath("//button[@text()='Sign in']"));
      //  waitForElement(signInButton, driver, 30);
       // signInButton.click();
       
       String errors1 = driver.findElement(By.xpath("//*[@id=\"errors1\"]/span")).getText();
       System.out.println(errors1);
       // Assert.assertTrue(errors1.contains("There were errors in your submission"));
      //  driver.quit();
    }

    private void waitForElement(WebElement element, WebDriver driver, int timeUnitInSeconds) {
    	WebDriverWait wt = new WebDriverWait(driver, timeUnitInSeconds);
    	wt.until(ExpectedConditions.elementToBeClickable(element));
    }
    
    private void waitFor(int durationInMilliSeconds) {
        try {
            Thread.sleep(durationInMilliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    private void setDriverPath() {
        if (PlatformUtil.isMac()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver");
        }
        if (PlatformUtil.isWindows()) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//src//main//java//drivers//chromedriver.exe");
        }
        if (PlatformUtil.isLinux()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
        }
    }
 

}
