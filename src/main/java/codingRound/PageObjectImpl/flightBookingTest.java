package codingRound.PageObjectImpl;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import codingRound.pageObjects.flightBooking;
import codingRound.testBase.testBase;

public class flightBookingTest {
	
	@Parameters({"origin", "destPlace", "url"})
	@Test
	public void getFlightSchedules(String origin, String destPlace, String url) throws InterruptedException {
		testBase test = new testBase();
		test.setDriverPath();
		test.getUrl(url);
		test.maximizeWindow();
		flightBooking flight = PageFactory.initElements(test.driver, flightBooking.class);
		flight.getFlightDetails( origin,  destPlace);
		System.out.println();
		test.driver.quit();
	}

}
