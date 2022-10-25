package com.citi.HybridFramewordkProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException
    {
       
    	
    	ChromeOptions co=new ChromeOptions();
    	co.setHeadless(false);
    	
    	WebDriver driver=WebDriverManager.chromedriver().capabilities(co).create();
    	
    	driver.get("http://demo.nopcommerce.com/");
    	
    	Thread.sleep(2000);
		System.out.println(driver.getTitle());
    	
    }
}
