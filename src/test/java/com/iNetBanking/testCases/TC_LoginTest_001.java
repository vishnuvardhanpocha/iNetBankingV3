package com.iNetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.iNetBanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void loginTest() throws IOException{
		
		LoginPage lp=new LoginPage(driver);
		
		lp.setUserName(username);
		logger.info("Entered the username");
		
		lp.setPassword(password);
		logger.info("Entered the password");
		
		lp.clickSubmit();		
		logger.info("Clicked on login button");
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Login Test passed");
			captureScreen(driver,"loginPass");
		}
		else
		{
			captureScreen(driver,"loginTest");
			logger.info("Login Test Failed");
			Assert.assertTrue(false);			
		}
		
		
	}
}
