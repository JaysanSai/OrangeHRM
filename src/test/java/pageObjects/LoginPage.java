package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WebDriverConfig;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriverConfig driverConfig){
		this.driver=driverConfig.initialize_webdriver();
		PageFactory.initElements(driver, this);
	}
	
	
	//WebElements of Login page
	
	@FindBy(xpath=".//*[@id='txtUsername']")
	WebElement usernameField;
	
	@FindBy(xpath=".//*[@id='txtPassword']")
	WebElement passwordField;
	

	@FindBy(xpath=".//*[@id='btnLogin']")
	WebElement loginButton;


	public WebElement getUsernameField() {
		return usernameField;
	}


	public WebElement getPasswordField() {
		return passwordField;
	}


	public WebElement getLoginButton() {
		return loginButton;
	}



	
	

}
