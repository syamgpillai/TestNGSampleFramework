package com.freecrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.qa.base.TestBase;

public class HomePage extends TestBase{
	

	
	//pagefactory
	
	@FindBy(xpath="//title[contains(text(),'Cogmento CRM')]")
	WebElement pagetitle;
	
	@FindBy(xpath="//span[contains(text(),'Syam Kumar')]")
	WebElement usernamelabel;
	
	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	WebElement contactslink;

	@FindBy(xpath="//span[contains(text(),'Deals')]")
	WebElement dealslink;
	
	@FindBy(xpath="//span[contains(text(),'Tasks')]")
	WebElement taskslink;
	
	@FindBy(xpath="//a[@href='/contacts/new']")
	WebElement newcontactlink;
	
	//initialization
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	//methods or actions
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public String verifyUserNameText() {
		return usernamelabel.getText();
	
	}

	public boolean verifyUserName() {
		return usernamelabel.isDisplayed();
	}
	
	public ContactsPage clickOnContactsLink() {
		contactslink.click();
		return new ContactsPage();
		
	}
	
	public DealsPage clickOnDealslink() {
		dealslink.click();
		return new DealsPage();
	}
	
	public NewContactsPage clickOnNewContactlink() {
		newcontactlink.click();
		return new NewContactsPage();
	}
	
	
	

}
