package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage {

	@FindBy(xpath=".//*[@id='welcome']")
	WebElement welcomeUsernameLink;

	public WebElement getWelcomeUsernameLink() {
		return welcomeUsernameLink;
	}

	
	
	
	
}
