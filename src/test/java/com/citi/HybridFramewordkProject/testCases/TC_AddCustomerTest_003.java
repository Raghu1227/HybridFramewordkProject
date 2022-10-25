package com.citi.HybridFramewordkProject.testCases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.citi.HybridFramewordkProject.pageObjects.AddcustomerPage;
import com.citi.HybridFramewordkProject.pageObjects.LoginPage;



public class TC_AddCustomerTest_003 extends BaseClass
{
	
	@Test
	public void addNewCustomer() throws IOException, InterruptedException
	{
		driver.get(baseURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("User name is provided");
		
		lp.setPassword(password);
		logger.info("password is provided");
		
		lp.clickloginBtn();
				
		logger.info("providing customer details....");
		
		AddcustomerPage addcust=new AddcustomerPage(driver);
		
		Thread.sleep(2000);
		addcust.clickOnCustomersMenu();
		Thread.sleep(2000);
		addcust.clickOnCustomersMenuItem();
		Thread.sleep(2000);		
		addcust.clickOnAddnew();
				
		String email=randomestring()+"@gmail.com";
		
		logger.info("Providing email");
		addcust.setEmail(email);
		
		logger.info("Providing password");
		addcust.setPassword("test123");
		
		logger.info("Providing Customer roles");
		Thread.sleep(2000);	
		addcust.setCustomerRoles("Guest");
		//addcust.setCustomerRoles("Administrators");
		Thread.sleep(2000);	
		logger.info("Selecting vendor");
		addcust.setManagerOfVendor("Vendor 2");
		
		logger.info("Selecting gender");
		addcust.setGender("Male");
		
		logger.info("Providing first name and last name");
		addcust.setFirstName("Pavan");
		addcust.setLastName("Kumar");
		
		logger.info("Providing dob");
		addcust.setDob("7/05/1985"); // Format: D/MM/YYY
		
		logger.info("Providing company name and admin content");
		addcust.setCompanyName("busyQA");
		addcust.setAdminContent("This is for testing.........");
	
		logger.info("clicking on save");
		addcust.clickOnSave();
		
		logger.info("validation started....");
		
		String msg=driver.findElement(By.tagName("body")).getText();
		//String msg=driver.findElement(By.xpath("/html/body/div[3]/div[3]/div[1]")).getText();
		
		
		if(msg.contains("The new customer has been added successfully"))
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
		}
		else
		{
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}
	
	}
	
	

}
