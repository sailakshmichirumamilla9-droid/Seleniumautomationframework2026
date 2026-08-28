package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import jdk.internal.org.jline.utils.Log;
import utils.log;

public class LoginPage {

	private WebDriver driver;

	@FindBy(id = "Email")
	WebElement usernameTextbox;
	
	@FindBy(id = "Password")
	WebElement passwordTextbox;
	
	@FindBy(xpath = "//*[@id=\"main\"]/div/section/div/div[2]/div[1]/div/form/div[3]/button")
	WebElement loginButton;
	// private By usernameTextBox = By.id("Email");
	//private By passwordTextBox = By.id("Password");
	//private By loginButton = By.xpath("//*[@id=\"main\"]/div/section/div/div[2]/div[1]/div/form/div[3]/button");

	public LoginPage(WebDriver driver) {
		this.driver = driver;// 4
		PageFactory.initElements(driver, this);
	}

	public void enterUsername(String username) {
		
		usernameTextbox.clear();
		usernameTextbox.sendKeys(username);
		//driver.findElement(usernameTextBox).clear();
		//driver.findElement(usernameTextBox).sendKeys(username);

	}

	public void enterPassword(String Password) {
		passwordTextbox.clear();
		passwordTextbox.sendKeys(Password);
		//driver.findElement(passwordTextBox).clear();
		//driver.findElement(passwordTextBox).sendKeys(Password);

	}

	public void clickLogin() {
		log.info("Clicking Login button...");
		loginButton.click();
		//driver.findElement(loginButton).click();

	}
}
