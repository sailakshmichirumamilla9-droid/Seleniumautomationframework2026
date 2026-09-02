package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import base.BaseTest;

import pages.LoginPage;
import utils.ExcelUtils;
import utils.ExtentReportManager;
//import utils.ExtentReportManager;
import utils.log;

public class LoginTest extends BaseTest {

	@DataProvider(name = "LoginData")
	public Object[][] getLoginData() throws IOException {

		String filePath = System.getProperty("user.dir") + "/testdata/TestData.xlsx";
		ExcelUtils.loadExcel(filePath, "Sheet1");
		int rowCount = ExcelUtils.getRowCount();
		Object[][] data = new Object[rowCount - 1][2];

		for (int i = 1; i < rowCount; i++) {
			data[i - 1][0] = ExcelUtils.getCellData(i, 0); // Username
			data[i - 1][1] = ExcelUtils.getCellData(i, 1); // Password
		}
		ExcelUtils.closeExcel();
		return data;
	}

	@DataProvider(name = "LoginData2")
	public Object[][] getData() {
		return new Object[][] { { "user1", "pass1" }, { "user2", "pass2" }, { "user3", "pass3" } };
	}

//	@Test(dataProvider = "LoginData2")
	@Test
	@Parameters({"username","password"})
	public void testValidLogin(String username, String password) {

		log.info("Starting login test...");
		test = ExtentReportManager.createTest("Login Test - " + username);

		test.info("Navigating to URL..");
		LoginPage loginPage = new LoginPage(driver);// 3

		log.info("Adding Credentials...");
		test.info("Adding Credentials..");
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
//		loginPage.enterUsername("admin@yourstore.com");
//		loginPage.enterPassword("admin");
		test.info("Clicking on Login Button..");
		loginPage.clickLogin();
		System.out.println("Title of the Page is: " + driver.getTitle());
		// driver.getTitle();
		log.info("Verifying Page Title...");
		test.info("Verifying page title:");
		Assert.assertEquals(driver.getTitle(), "Just a moment...");
		test.pass("Login Successfull");

	}

//	@Test
//	public void testingWithInValidCredentilas() {
//
//		log.info("Starting login test...");
//		test = ExtentReportManager.createTest("Login Test with invalid Credentilas");
//		
//		test.info("Navigating to URL..");
//		LoginPage loginPage = new LoginPage(driver);// 3
//
//		log.info("Adding Credentials...");
//		test.info("Adding Credentials..");
//		loginPage.enterUsername("admin1234@yourstore.com");
//		loginPage.enterPassword("admin1234");
//		test.info("Clicking on Login Button..");
//		loginPage.clickLogin();
//		System.out.println("Title of the Page is: " + driver.getTitle());
//		// driver.getTitle();
//		log.info("Verifying Page Title...");
//		test.info("Verifying page title:");
//		Assert.assertEquals(driver.getTitle(), "Just a moment...123");
//		test.pass("Login Successfull");
//	
//	}

}
