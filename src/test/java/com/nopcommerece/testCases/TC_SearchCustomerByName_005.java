package com.nopcommerece.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopcommerece.pageObjects.AddcustomerPage;
import com.nopcommerece.pageObjects.LoginPage;
import com.nopcommerece.pageObjects.SearchCustomerPage;
import com.nopcommerece.testBase.BaseClass;

public class TC_SearchCustomerByName_005 extends BaseClass {
	
	@Test
	public void searchCustomerbyName() throws InterruptedException, IOException
	{
		logger.info("********* starting TC_SearchCustomerByName_005 *************");
		
		driver.get(configPropObj.getProperty("baseURL"));
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(configPropObj.getProperty("useremail"));
		lp.setPassword(configPropObj.getProperty("password"));
		lp.clickLogin();
		
		//Go to search page
		AddcustomerPage addcust=new AddcustomerPage(driver);
		
		addcust.clickOnCustomersMenu();
		addcust.clickOnCustomersMenuItem();
		
		//Name
		SearchCustomerPage searchcust=new SearchCustomerPage(driver);
		searchcust.setFirstName("Victoria");
		searchcust.setLastName("Terces");
		searchcust.clickSearch();
		Thread.sleep(3000);
		
		boolean status=searchcust.searchCustomerByName("Victoria Terces");
		if(status==true)
		{
			logger.info("********* Search customer by name is passed *************");
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("********* Search customer by name is failed*************");
			captureScreen(driver,"searchCustomerbyName");
			Assert.assertTrue(false);
		}
		logger.info("********* End of TC_SearchCustomerByName_005 *************");
	}

}
