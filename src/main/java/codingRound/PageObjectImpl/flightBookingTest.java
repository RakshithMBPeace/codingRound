package codingRound.PageObjectImpl;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import codingRound.pageObjects.flightBooking;
import codingRound.testBase.testBase;

public class flightBookingTest {
	
	@Test
	public void getFlightSchedules() throws InterruptedException {
		testBase test = new testBase();
		test.setDriverPath();
		test.getUrl();
		test.maximizeWindow();
		flightBooking flight = PageFactory.initElements(test.driver, flightBooking.class);
		flight.getFlightDetails("Bangalore", "Delhi");
		test.driver.quit();
	}

}
