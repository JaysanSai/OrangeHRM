package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	
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
