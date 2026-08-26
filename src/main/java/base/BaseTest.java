package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import jdk.internal.org.jline.utils.Log;
import utils.log;

public class BaseTest {
	
	protected WebDriver driver;//1
	
	@BeforeMethod
	public void setUp() {
		
		log.info("Staring Webdriver...");
		driver = new ChromeDriver();//2
		driver.manage().window().maximize();
		log.info("Navigating to URL...");
		driver.get("https://admin-demo.nopcommerce.com/login");
		
	}
	
	@AfterMethod
	public void teardown() {
		if(driver!=null) {
			log.info("Closing browser...");
			//driver.quit();
		}
		
	}

}
