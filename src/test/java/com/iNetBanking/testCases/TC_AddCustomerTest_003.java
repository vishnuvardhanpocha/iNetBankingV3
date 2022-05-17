package com.iNetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.iNetBanking.pageObjects.AddCustomerPage;
import com.iNetBanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass
{

	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("User name is provided");
		lp.setPassword(password);
		logger.info("Passsword is provided");
		lp.clickSubmit();
		
		Thread.sleep(1000);
		
		AddCustomerPage addcust=new AddCustomerPage(driver);
		
		addcust.clickAddNewCustomer();
		
		logger.info("providing customer details....");
		
		
		addcust.custName("Vishnu");
		addcust.custgender("male");
		addcust.custdob("01","01","1920");
		Thread.sleep(5000);
		addcust.custaddress("IRELAND");
		addcust.custcity("CORK");
		addcust.custstate("CORK");
		addcust.custpinno("123456");
		addcust.custtelephoneno("0123456789");
		
		String email=randomestring()+"@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("abcdef");
		addcust.custsubmit();
		
		Thread.sleep(3000);
		
		logger.info("validation started....");
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
			captureScreen(driver,"addNewCustomerPass");
			
		}
		else
		{
			logger.info("test case failed....");
			captureScreen(driver,"addNewCustomerFail");
			Assert.assertTrue(false);
		}
			
	}
	
	
}