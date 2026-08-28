package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;

import pages.LoginPage;
import utils.ExtentReportManager;
//import utils.ExtentReportManager;
import utils.log;

public class LoginTest extends BaseTest {

	@Test
	public void testValidLogin() {

		log.info("Starting login test...");
		test = ExtentReportManager.createTest("Login Test");
		
		test.info("Navigating to URL..");
		LoginPage loginPage = new LoginPage(driver);// 3

		log.info("Adding Credentials...");
		test.info("Adding Credentials..");
		loginPage.enterUsername("admin@yourstore.com");
		loginPage.enterPassword("admin");
		test.info("Clicking on Login Button..");
		loginPage.clickLogin();
		System.out.println("Title of the Page is: " + driver.getTitle());
		// driver.getTitle();
		log.info("Verifying Page Title...");
		test.info("Verifying page title:");
		Assert.assertEquals(driver.getTitle(), "Just a moment...");
		test.pass("Login Successfull");
	
	}
	
	@Test
	public void testingWithInValidCredentilas() {

		log.info("Starting login test...");
		test = ExtentReportManager.createTest("Login Test with invalid Credentilas");
		
		test.info("Navigating to URL..");
		LoginPage loginPage = new LoginPage(driver);// 3

		log.info("Adding Credentials...");
		test.info("Adding Credentials..");
		loginPage.enterUsername("admin1234@yourstore.com");
		loginPage.enterPassword("admin1234");
		test.info("Clicking on Login Button..");
		loginPage.clickLogin();
		System.out.println("Title of the Page is: " + driver.getTitle());
		// driver.getTitle();
		log.info("Verifying Page Title...");
		test.info("Verifying page title:");
		Assert.assertEquals(driver.getTitle(), "Just a moment...123");
		test.pass("Login Successfull");
	
	}

}
