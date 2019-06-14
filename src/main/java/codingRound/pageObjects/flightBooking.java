package codingRound.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import codingRound.waitHelper.waitHelper;


public class flightBooking {
	
	WebDriver driver;
	public waitHelper wt;
	public flightBooking(WebDriver driver) {
		this.driver = driver;
		  wt=new waitHelper(driver);
	}
	
	@FindBy(id="OneWay")
	private WebElement oneWay;
	
	@FindBy(id="FromTag")
	private WebElement originPlace;
	
	@FindBy(xpath="//*[@id=\"ui-id-1\"]/li")
	private List<WebElement> originOptionsDropDown;
	
	@FindBy(id="ToTag")
	private WebElement destinationPlace;
	
	@FindBy(xpath="//*[@id=\"ui-id-2\"]/li")
	private List<WebElement> destinationOptionsDropDown;
	
	@FindBy(id="DepartDate")
	private WebElement calander;
	
	@FindBy(xpath="//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[3]/td[7]/a")
	private List<WebElement> sample;
	
	@FindBy(xpath="//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr/td/a")
	private WebElement calendarData;
	
	@FindBy(id="SearchBtn")
	private WebElement searchButton;
	
	@FindBy(className="searchSummary")
	private WebElement searchSummary;
	
	public void journeyType() {
		oneWay.click();
	}
	
	public void enterOriginPlace(String startPlace) throws InterruptedException {
		originPlace.click();
		originPlace.sendKeys(startPlace);
		Thread.sleep(5000);
		List<WebElement> originOptions = originOptionsDropDown;
		originOptions.get(0).click();
		
	}
	
	public void enterDestinationPlace(String destPlace) throws InterruptedException {
		destinationPlace.click();
		destinationPlace.sendKeys(destPlace);
		Thread.sleep(5000);
		List<WebElement> originOptions = destinationOptionsDropDown;
		originOptions.get(0).click();
		
	}
	
	public void enterDateInCalendar() {
		calander.sendKeys("19/06/2019");
		
	}
	
	public void clickSearch() {
		searchButton.click();
	}
	
	public boolean searchSummaryIsDisplayed() {
		wt.waitForElement(this.driver, this.searchSummary, 20);
		boolean status = searchSummary.isDisplayed();
		return true;
	}
	
	public void getFlightDetails(String startPlace, String destPlace) throws InterruptedException {
		journeyType();
		enterOriginPlace(startPlace);
		enterDestinationPlace(destPlace);
		enterDateInCalendar();
		clickSearch();
		boolean status = searchSummaryIsDisplayed();
		Assert.assertTrue(status);
	}

	

}
