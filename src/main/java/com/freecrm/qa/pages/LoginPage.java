package com.freecrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//pagefactory
	@FindBy(name="email")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
	WebElement loginbutton;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement signup;
	
	
	//initializing the page objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	//methods or actions
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	
	public boolean validateSignupLinkPresence() {
		return signup.isDisplayed();
	}
	
	
	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginbutton.click();
		
		
		return new HomePage();
	}
	
	
}

