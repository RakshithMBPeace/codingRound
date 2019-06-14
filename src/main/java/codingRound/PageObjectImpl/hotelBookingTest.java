package codingRound.PageObjectImpl;


import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import codingRound.pageObjects.hotelBooking;
import codingRound.testBase.testBase;

public class hotelBookingTest {

	@Test
	public void searchHotel() throws InterruptedException {
		testBase t =  new testBase();
		t.setDriverPath();
		t.getUrl();
		t.maximizeWindow();
		hotelBooking hotel = PageFactory.initElements(t.driver, hotelBooking.class);
		hotel.searchHotelByLocality("Indiranagara, Bengaluru");
		t.driver.quit();
	}
}
