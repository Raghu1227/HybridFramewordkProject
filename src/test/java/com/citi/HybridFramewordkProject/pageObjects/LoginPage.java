package com.citi.HybridFramewordkProject.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver ldriver;
	
	//l --> Locadriver
	//r--> remote driver
	public LoginPage(WebDriver rdriver){
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id="Email")
	WebElement txtemail;
	
	@FindBy(id="Password")
	WebElement txtpassword;
	
	@FindBy(xpath="//button[normalize-space()='Log in']")
	WebElement clkLoginBtn;
	
	@FindBy(linkText="Logout")
	WebElement clkLogoutlnk;
	
	public void setUserName(String uname) {
		txtemail.clear();
		txtemail.sendKeys(uname);
	}
	public void setPassword(String password) {
		txtpassword.clear();
		txtpassword.sendKeys(password);
	}
	public void clickloginBtn() {
		clkLoginBtn.click();
	}
	public void clicklogoutBtn() {
		clkLogoutlnk.click();
	}
	

}
