
//**** This class is about capturing screenshot and attach same to Extent report****


package com.freecrm.qa.testcases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.freecrm.qa.util.TestUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReportScreenshot {

	public WebDriver driver;
	public ExtentReports extent;
	public ExtentTest extentTest;
	
	
	
	@BeforeTest
	//This method is to mention all parameters to be displayed in the extent html report
	public void ExtentTest() {
		extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/ExtentReport.html", true);
		extent.addSystemInfo("Host Name", "Syam Mac");
		extent.addSystemInfo("User Name", "Syam" );
		extent.addSystemInfo("Enviornment", "Staging" );
		
	}
	
	@AfterTest
	//to flush and close the generated reports
	public void endReport() {
		extent.flush();
		extent.close();
	}
	
	//to generate screenshots
	public static String getScreenShot(WebDriver driver, String screenshotName) throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		//After execution you could see a folder "FailedTestsScreenshots" under src folder
		String destination = System.getProperty("user.dir" )+ "/FailedTestsScreenshots/" + screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source,  finalDestination);
		return destination;
	}
	
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
	public void freeCrmTitleTest() {
		extentTest = extent.startTest("freeCrmTitleTest");
		String sitetitle = driver.getTitle();
		System.out.println(sitetitle);
		Assert.assertEquals(sitetitle, "Cogmento CRMs");
	}
	
	@Test
	public void freeCrmSignupLinkTest() {
		boolean signup = driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]")).isDisplayed();
		System.out.println(signup);
		Assert.assertTrue(signup);
	}
	
	
	
	@AfterMethod
	//all fail and pass count will be stored in "itestresult" object
	public void teardown(ITestResult result) throws IOException {
		
		if(result.getStatus()==ITestResult.FAILURE) {
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS " + result.getName());// to add name in extent report
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS " + result.getThrowable()); //to add error/exception in extent report
			
			String screenshotPath = ExtentReportScreenshot.getScreenShot(driver, result.getName()); // 
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath)); //to add screenshot in extent report
			
		}
		else if(result.getStatus()==ITestResult.SKIP) {
			extentTest.log(LogStatus.SKIP, "TEST CASE SKIPPED IS "+ result.getName());
		}
		else if (result.getStatus()==ITestResult.SUCCESS) {
			extentTest.log(LogStatus.PASS, "TEST CASE PASSED IS " + result.getName());
		}
		
		extent.endTest(extentTest); //for ending the current test and prepare to create html report
		driver.quit();
	}
	
	
}
