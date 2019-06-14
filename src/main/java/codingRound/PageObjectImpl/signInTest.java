package codingRound.PageObjectImpl;



import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import codingRound.testBase.testBase;

public class signInTest {
	
	@Test
	public void signIn() {
		testBase t =  new testBase();
		t.setDriverPath();
		t.getUrl();
		t.maximizeWindow();
		codingRound.pageObjects.signIn sign = PageFactory.initElements(t.driver, codingRound.pageObjects.signIn.class);
		sign.clickOnSiginInButtonAndValidateError();
		t.driver.quit();
	}

}
