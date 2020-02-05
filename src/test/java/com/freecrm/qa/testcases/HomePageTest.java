package com.freecrm.qa.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.freecrm.qa.base.TestBase;
import com.freecrm.qa.pages.ContactsPage;
import com.freecrm.qa.pages.HomePage;
import com.freecrm.qa.pages.LoginPage;

public class HomePageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	
	public HomePageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		contactsPage = new ContactsPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
//	@Test(priority=1)
//	public void verifyPageTitleDisplayTest() {
//		String homePageTitle = homePage.verifyHomePageTitle();
//		System.out.println(homePageTitle);
//		Assert.assertEquals(homePageTitle, "Cogmento CRM");
//	}
	
	@Test(priority=2)
	public void verifyUserNameTextDisplayTest() {
		String usernamedisplay = homePage.verifyUserNameText();
		System.out.println(usernamedisplay);
		Assert.assertEquals(usernamedisplay, "Syam Kumar");
	}
	
	@Test(priority=3)
	public void verifyUserNameDisplayTest() {
		Assert.assertTrue(homePage.verifyUserName());
		System.out.println(homePage.verifyUserName());
		
	}
	
	
	@Test(priority=4)
	public void contactsLinkClickTest() {
		contactsPage = homePage.clickOnContactsLink();
	}
	
	
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	

}
