package com.freecrm.qa.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.freecrm.qa.base.TestBase;
import com.freecrm.qa.pages.ContactsPage;
import com.freecrm.qa.pages.HomePage;
import com.freecrm.qa.pages.LoginPage;

public class ContactsPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	
	public ContactsPageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		contactsPage = new ContactsPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = homePage.clickOnContactsLink();
	}
	
	
	@Test
	public void contactsLabelDisplayTest() {
		String contactsText = contactsPage.verifyContactsLabelText(); 
		AssertJUnit.assertEquals(contactsText,"Contacts");
	}
	
	
	@AfterMethod
	public void teardown() {
	driver.quit();
	}

}
