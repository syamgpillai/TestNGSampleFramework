package com.freecrm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	@FindBy(xpath="//div[contains(@class,'ui header item mb5 light-black')]")
	WebElement contactsLabel;
	
	//initializing the page objects
		public ContactsPage() {
			PageFactory.initElements(driver, this);
		}
		
		
		//methods or actions
		
		public boolean verifyContactsLabel() {
			return contactsLabel.isDisplayed();			
		}
		
		public String verifyContactsLabelText() {
			return contactsLabel.getText();
		}
		
		
		
			
			
}
