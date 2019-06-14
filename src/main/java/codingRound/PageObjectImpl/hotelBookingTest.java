package codingRound.PageObjectImpl;


import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;


import codingRound.pageObjects.hotelBooking;
import codingRound.testBase.testBase;

public class hotelBookingTest {
	@Parameters({"url", "locality"})
	@Test
	public void searchHotel(String url, String locality) throws InterruptedException {
		testBase t =  new testBase();
		t.setDriverPath();
		t.getUrl(url);
		t.maximizeWindow();
		hotelBooking hotel = PageFactory.initElements(t.driver, hotelBooking.class);
		hotel.searchHotelByLocality(locality);
		t.driver.quit();
	}
}
