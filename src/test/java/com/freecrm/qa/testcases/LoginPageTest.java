package com.freecrm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.freecrm.qa.base.TestBase;
import com.freecrm.qa.pages.HomePage;
import com.freecrm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest(){
		super();
	
	}
	
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
	}
	
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		AssertJUnit.assertEquals(title, "Cogmento CRM");
	}
	
	
	@Test(priority=2)
	public void signupLinkVisibleTest() {
		boolean signuplink = loginPage.validateSignupLinkPresence();
		AssertJUnit.assertTrue(signuplink);
	}
	
	@Test(priority=3)
	public void loginTest(){
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	
	
	@AfterMethod
	public void tearDown() {
	driver.quit();
	}
	
}
