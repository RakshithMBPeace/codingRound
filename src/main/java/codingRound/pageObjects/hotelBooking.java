package codingRound.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import codingRound.waitHelper.waitHelper;

public class hotelBooking {
	
	WebDriver driver;
	public waitHelper wt;
	
	public hotelBooking(WebDriver driver) {
		this.driver=driver;
		 wt = new waitHelper(driver);
	}

    @FindBy(linkText = "Hotels")
    private WebElement hotelLink;

    @FindBy(id = "Tags")
    private WebElement localityTextBox;

    @FindBy(id = "SearchHotelsButton")
    private WebElement searchButton;

    @FindBy(id = "travellersOnhome")
    private WebElement travellerSelection;
    
    public void clickOnHotel() {
    	hotelLink.click();
    }
    
    public boolean verifyLocalitySearchBoxIsDisplayed() {
    	boolean status = localityTextBox.isDisplayed();
		return status;
    	
    }

    public void enterLocality(String locality) {
    	this.localityTextBox.click();
    	localityTextBox.sendKeys(locality);
    }
    
    public void travellersDrpDown() {
        new Select(travellerSelection).selectByVisibleText("1 room, 2 adults");
    }
    public void clickOnSearch(){
    	searchButton.click();
    }
    
    public void searchHotelByLocality(String locality) throws InterruptedException {
    	clickOnHotel();
   wt.waitForElement(driver, localityTextBox, 30);
  	boolean status = verifyLocalitySearchBoxIsDisplayed();
    System.out.println(status);
    	enterLocality(locality);
    	travellersDrpDown();
    	clickOnSearch();
    	    	
    }

	
}
