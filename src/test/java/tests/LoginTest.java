package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;

import pages.LoginPage;
import utils.log;

public class LoginTest extends BaseTest {

	@Test
	public void testValidLogin() {

		log.info("Starting login test...");
		LoginPage loginPage = new LoginPage(driver);// 3

		log.info("Adding Credentials...");
		loginPage.enterUsername("admin@yourstore.com");
		loginPage.enterPassword("admin");
		loginPage.clickLogin();
		System.out.println("Title of the Page is: " + driver.getTitle());
		// driver.getTitle();
		log.info("verifing title of the page...");
		Assert.assertEquals(driver.getTitle(), "Just a moment...");
	}

}
