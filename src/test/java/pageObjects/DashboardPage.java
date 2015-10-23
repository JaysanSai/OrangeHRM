package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WebDriverConfig;

public class DashboardPage {
	
	WebDriver driver;
	
	public DashboardPage(WebDriverConfig driverConfig){
		this.driver=driverConfig.initialize_webdriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath=".//*[@id='welcome']")
	WebElement welcomeUsernameLink;

	public WebElement getWelcomeUsernameLink() {
		return welcomeUsernameLink;
	}

	
	
	
	
}
