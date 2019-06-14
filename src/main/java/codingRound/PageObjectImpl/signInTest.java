package codingRound.PageObjectImpl;



import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import codingRound.testBase.testBase;

public class signInTest {
	@Parameters({"url"})
	@Test
	public void signIn(String url) {
		testBase t =  new testBase();
		t.setDriverPath();
		t.getUrl(url);
		t.maximizeWindow();
		codingRound.pageObjects.signIn sign = PageFactory.initElements(t.driver, codingRound.pageObjects.signIn.class);
		sign.clickOnSiginInButtonAndValidateError();
		t.driver.quit();
	}

}
