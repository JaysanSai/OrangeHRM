package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WebDriverConfig;

public class EmployeeDetailsPage {
	
	WebDriver driver;
	
	public EmployeeDetailsPage(WebDriverConfig driverConfig){
		this.driver=driverConfig.initialize_webdriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath=".//*[@id='profile-pic']/h1")
	WebElement profilePictureName;
	
	@FindBy(xpath=".//*[@id='personal_txtEmployeeId']")
	public WebElement employeeId;
	

	public WebElement getProfilePictureName() {
		return profilePictureName;
	}
	
	
	
}
