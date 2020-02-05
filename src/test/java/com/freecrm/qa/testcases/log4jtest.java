package com.freecrm.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.freecrm.qa.util.TestUtil;

public class log4jtest {
	
	//log4j is for capturing info/activities at the time of program execution
	//types of log
		//info
		//warn
		//error
		//fatal
	//how to generate log, we use apache log4j api
	//how it works? - it reads log 4j configuration from log4j properties file
	//log4j file need to be created inside resources source folder
	
	WebDriver driver;
	

	@BeforeMethod
	public void setup() {
		
		System.setProperty("webdriver.chrome.driver", "/Applications/SyamWorkingFolder/SeleniumSetupJarFiles/chromedriver");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	
		driver.get("https://ui.freecrm.com/");
		
	}
	
	@Test
	public void freeCrmSignupLinkTest() {
		boolean signup = driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]")).isDisplayed();
		System.out.println(signup);
		Assert.assertTrue(signup);
	}
	
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
		
		
		
		

}
