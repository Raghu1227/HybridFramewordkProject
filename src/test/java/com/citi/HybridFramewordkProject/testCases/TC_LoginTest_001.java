package com.citi.HybridFramewordkProject.testCases;

import java.io.IOException;
import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.citi.HybridFramewordkProject.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
	
		
	@Test
	public void LoginTest() throws InterruptedException, IOException {
		
		driver.get(baseURL);
		logger.info("URL is opened.....");
		Thread.sleep(1000);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		LoginPage lp=new LoginPage(driver);
		//lp.setUserName(username);
		Thread.sleep(2000);
		//lp.setPassword(password);
		lp.clickloginBtn();
		Thread.sleep(2000);
		logger.info("clicked on Login btn");
		//System.out.println(driver.getTitle());
		logger.info("click on the login page...");
		
		if(driver.getTitle().equals("Dashboard / nopCommerce administration")) {
			
			Assert.assertTrue(true);
			lp.clicklogoutBtn();
			Thread.sleep(2000);
			logger.info("Login Passed");
		}
		else {
			captureScreen(driver, "LoginTest");
			Assert.assertTrue(false);
			logger.info("Login Failed");
		}
	}
	
	
}
