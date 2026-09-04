package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import utils.EmailUtils;
import utils.ExtentReportManager;

//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;

//import jdk.internal.org.jline.utils.Log;
//import utils.ExtentReportMAnager;
//import utils.ExtentReportManager;
import utils.log;

public class BaseTest {
	
	protected WebDriver driver; //1
	protected static ExtentReports extent;
	protected ExtentTest test;
	
	
	@BeforeSuite
	public void setupReport() {
		extent = ExtentReportManager.getReportInstance();
		 System.out.println(
			        "Extent report will be created at: "
			        + ExtentReportManager.reportPath
			    );
	}
	
	@AfterSuite
//	public void teardownReport() {
//		extent.flush();
//		String reportPath = ExtentReportManager.reportPath;
//		EmailUtils.sendTestReport(reportPath);
//	}
	
	public void teardownReport() {

	    System.out.println("Before extent.flush()");

	    extent.flush();

	    System.out.println("After extent.flush()");

	    String reportPath = ExtentReportManager.reportPath;

	    System.out.println("Final report path: " + reportPath);

	    // EmailUtils.sendTestReport(reportPath);
	}
	
	
	@BeforeMethod
	public void setUp() {
		
		log.info("Staring Webdriver...");
		driver = new ChromeDriver();//2
		driver.manage().window().maximize();
		log.info("Navigating to URL...");
		driver.get("https://admin-demo.nopcommerce.com/login");
		
	}
	
	@AfterMethod
	public void teardown(ITestResult result) {
		if(result.getStatus() == ITestResult.FAILURE) {
			String screenshotPath = ExtentReportManager.captureScreenshot(driver, "LoginFailure");
			test.fail("test Failed...check Screenshot", 
					MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
		
		
		if(driver!=null) {
			log.info("Closing browser...");
			driver.quit();
		}
		
	}

}
