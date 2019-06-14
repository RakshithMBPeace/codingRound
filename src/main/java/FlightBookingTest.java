import com.sun.javafx.PlatformUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class FlightBookingTest {

	public WebDriver driver;


    @Test
    public void testThatResultsAppearForAOneWayJourney() {
    	ChromeOptions options = new ChromeOptions();
    	options.addArguments("--disable-notifications");
        setDriverPath();
         driver = new ChromeDriver(options);
        driver.get("https://www.cleartrip.com/");
        driver.manage().window().maximize();
        waitFor(20000);
       
        driver.findElement(By.id("OneWay")).click();
        driver.findElement(By.id("FromTag")).click();

        driver.findElement(By.id("FromTag")).sendKeys("Bangalore");

        //wait for the auto complete options to appear for the origin

        waitFor(5000);
       // driver.findElement(By.id("FromTag")).sendKeys(Keys.ENTER);

        List<WebElement> originOptions = driver.findElements(By.xpath("//*[@id=\"ui-id-1\"]/li"));
        System.out.println(originOptions.size());
        originOptions.get(0).click();
        waitFor(2000);
        driver.findElement(By.id("ToTag")).click();
        driver.findElement(By.id("ToTag")).sendKeys("Delhi");
        //wait for the auto complete options to appear for the destination

        waitFor(5000);
        //select the first item from the destination auto complete list
        List<WebElement> destinationOptions = driver.findElements(By.xpath("//*[@id=\"ui-id-2\"]/li"));
        destinationOptions.get(0).click();

        driver.findElement(By.xpath("//i[@class='icon ir datePicker']")).click();
        driver.findElement(By.xpath("//table[@class='calendar']/tbody/td[@data-year='2019' and @data-month='5']/a[@text()='17")).click();;
       
        
        //driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr/td/a")).click();

        //all fields filled in. Now click on search
        //driver.findElement(By.id("SearchBtn")).click();

       // waitFor(5000);
        //verify that result appears for the provided journey search
      //  Assert.assertTrue(isElementPresent(By.className("searchSummary")));

        //close the browser
       // driver.quit();

    }


    private void waitFor(int durationInMilliSeconds) {
        try {
            Thread.sleep(durationInMilliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }


    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
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
