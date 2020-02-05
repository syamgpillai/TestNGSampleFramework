package com.freecrm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.qa.base.TestBase;

public class NewContactsPage extends TestBase{
	
	//pageFactory
	
	@FindBy(xpath="//input[@name='first_name']")
	WebElement firstname;
	
	@FindBy(xpath="//input[@name='last_name']")
	WebElement lastname;
	
	@FindBy(xpath="//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/form/div[13]/div[2]/div/div/label")
	WebElement donotcalloption;
	
	@FindBy(xpath="//*[@id=\"dashboard-toolbar\"]/div[2]/div/button[2]")
	WebElement savebutton;
	
	
	//initializing the page objects
	public NewContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	//actions
	
	public void createNewContact(String ftName, String ltName) {
		firstname.sendKeys(ftName);
		lastname.sendKeys(ltName);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", donotcalloption);
//		Thread.sleep(500); 
		donotcalloption.click();
		savebutton.click();

	}
		
			
	
	
	
	
	

}
