package BankingTestCases;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import BankingPageObjects.Login_Page;

public class TC_LoginTest_001 extends BaseClass{

	@Test
	public void loginTest() throws IOException {
		logger.info("open Url");
		//driver.get(baseURL);
		logger.info("URL is opened");
		
		
		Login_Page lp= new Login_Page(driver);
		
		lp.setUserName(username);
		logger.info("Entered username");
		lp.setPassword(password);
		logger.info("Entered password");
		//captureScreen(driver,"loginTest");
		lp.clickSubmit();
		//captureScreen(driver,"loginTest");
		System.out.println(driver.getTitle());
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{	Assert.assertTrue(true);
		logger.info("login test passed");
		}
		else
		{	
		captureScreen(driver,"loginTest");
		Assert.assertTrue(false);
		logger.info("login test failed");
		}
		
	}
		

}
