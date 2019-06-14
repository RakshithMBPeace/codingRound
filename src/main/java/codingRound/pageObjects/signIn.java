package codingRound.pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class signIn {
	WebDriver driver;
	public signIn(WebDriver driver) {
		this.driver=driver;
	}
	@FindBy(linkText="Your trips")
	private WebElement Trips;
	
	@FindBy(id="SignIn")
	private WebElement signIn;
	
	@FindBy(xpath="//*[@id='modal_window']")
	private WebElement modal;
	
	@FindBy(xpath="//*[@id='signInButton']")
	private WebElement signInButton;
	
	@FindBy(xpath="//*[@id='errors1']/span")
	private WebElement Errors;
	
	public void clickOnYourTrips() {
		Trips.click();
	}
	
	public void clickSignInAndSwitchToFrame() {
		signIn.click();
		driver.switchTo().frame(modal);
	}
	
	public void clickOnSiginInButtonOnBootStrapWindow() {
		signInButton.click();
		String errors1 = Errors.getText();
		String errorText = "There were errors in your submission";
		Assert.assertEquals(errors1, errorText);
		
	}
	
	public void clickOnSiginInButtonAndValidateError() {
		clickOnYourTrips();
		clickSignInAndSwitchToFrame();
		clickOnSiginInButtonOnBootStrapWindow();
	}
	

}
