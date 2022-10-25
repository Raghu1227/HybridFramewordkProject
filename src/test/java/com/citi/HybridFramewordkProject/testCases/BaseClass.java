package com.citi.HybridFramewordkProject.testCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.citi.HybridFramewordkProject.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	ReadConfig rc=new ReadConfig();
	
	public String baseURL=rc.getApplicationURL();
	public String username=rc.getusername();
	public String password=rc.getpassword();
	
	public static WebDriver driver;
	
	public static Logger logger;
	
	@BeforeClass
	@Parameters("browser")
	public void setup(String browser) {
		
		logger=Logger.getLogger("nopCommerce");
		PropertyConfigurator.configure("log4j.properties");
		
		if(browser.equals("chrome")) {
		ChromeOptions co=new ChromeOptions();
		co.setHeadless(false);
		driver=WebDriverManager.chromedriver().capabilities(co).create();
		}
		else if (browser.equals("firefox")) {
			
			FirefoxOptions options = new FirefoxOptions();
			options.setHeadless(false);
			/*FirefoxProfile profile = new FirefoxProfile();
			FirefoxOptions options = new FirefoxOptions();
			options.setProfile(profile);*/
			options.setHeadless(false);
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-dev-shm-usage");
			driver=WebDriverManager.firefoxdriver().capabilities(options).create();
			
			/*System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//Drivers//geckodriver.exe");
			
			driver=new FirefoxDriver();*/
			
		}
		else if (browser.equals("ie")) {
			
		    InternetExplorerOptions options = new InternetExplorerOptions();
		  
		    driver=WebDriverManager.iedriver().capabilities(options).create();
			 
		}
		
	}
	
	@AfterClass
	public void tearDown() {
		
		driver.close();
		
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	
	public static String randomestring() {
		String generatedString1 = RandomStringUtils.randomAlphabetic(5);
		return (generatedString1);
	}
	
	public static String randomeNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return (generatedString2);
	}
	
	
}
