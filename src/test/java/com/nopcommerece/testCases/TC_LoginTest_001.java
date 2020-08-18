package com.nopcommerece.testCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopcommerece.pageObjects.LoginPage;
import com.nopcommerece.testBase.BaseClass;

public class TC_LoginTest_001 extends BaseClass{

	
	//public WebDriver driver;
	
	
	
	@Test
	public void loginTest() throws IOException
	{
		logger.info("************** Starting TC_LoginTest_001 *************** ");
		driver.get(configPropObj.getProperty("baseURL"));
		
		LoginPage lp=new LoginPage(driver);
		
		logger.info("************** Providing Login Details   *************** ");
		lp.setUserName(configPropObj.getProperty("useremail"));
		lp.setPassword(configPropObj.getProperty("password"));
		lp.clickLogin();
		
		String exp_title="Dashboard / nopCommerce administration";
		String act_title=driver.getTitle();
		if(exp_title.equals(act_title))
		{
			logger.info("**************  Login Test Passed    *************** ");
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("************** Login Test Failed   *************** ");
			captureScreen(driver,"loginTest");  //Call this method on failure
			Assert.assertTrue(false);
		}
		
		logger.info("************** Login Test Finished   *************** ");
	}
}
