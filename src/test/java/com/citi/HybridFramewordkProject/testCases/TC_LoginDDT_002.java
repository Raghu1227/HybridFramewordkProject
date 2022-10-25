package com.citi.HybridFramewordkProject.testCases;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.XLSBUnsupportedException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.citi.HybridFramewordkProject.pageObjects.LoginPage;
import com.citi.HybridFramewordkProject.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass {

	@Test(dataProvider="LoginData")
	public void loginTest(String user,String pwd) throws InterruptedException, IOException {
		
		driver.get(baseURL);
		logger.info("URL is opened.....");
		Thread.sleep(1000);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(user);
		Thread.sleep(2000);
		lp.setPassword(pwd);
		lp.clickloginBtn();
		Thread.sleep(2000);
		logger.info("clicked on Login btn");
		System.out.println(driver.getTitle());
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
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException {
		
		String path= System.getProperty("user.dir")+"//src//test//java//com//citi//HybridFramewordkProject//testData//LoginData.xlsx";
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int calcount=XLUtils.getCellCount(path, "Sheet1", 1);
		
	   String logindata[][]=new String[rownum][calcount];
	   
	   for(int i=1;i<=rownum;i++) {
		   for(int j=0;j<calcount;j++) {
			   logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
		   }
	   }
	return logindata;
		
		
	}
	
}
