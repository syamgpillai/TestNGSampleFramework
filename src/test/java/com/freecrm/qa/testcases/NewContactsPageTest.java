package com.freecrm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.freecrm.qa.base.TestBase;
import com.freecrm.qa.pages.ContactsPage;
import com.freecrm.qa.pages.HomePage;
import com.freecrm.qa.pages.LoginPage;
import com.freecrm.qa.pages.NewContactsPage;
import com.freecrm.qa.util.TestUtil;

public class NewContactsPageTest extends TestBase{

	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	NewContactsPage newcontactspage;
	
	String sheetName = "Sheet1";
	
	public NewContactsPageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		contactsPage = new ContactsPage();
		newcontactspage = new NewContactsPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	//how to import data from excel
	@DataProvider
	public Object[][] getContactsTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(dataProvider="getContactsTestData")
	public void validateCreateNewContact(String firstName, String lastName) {
		homePage.clickOnContactsLink();
		homePage.clickOnNewContactlink();
		newcontactspage.createNewContact(firstName, lastName);
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	
	
	
}
