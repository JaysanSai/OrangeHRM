package domains;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import utilities.WebDriverConfig;

public class LoginDomain {
	WebDriver driver;
	
	public LoginDomain(WebDriverConfig driverConfig){
		this.driver=driverConfig.initialize_webdriver();
	}
	
	public LoginPage initialize_LoginPage_Objects(){
	
		return PageFactory.initElements(driver, LoginPage.class);
		
	}
	public DashboardPage initialize_dashboardPage(){
		return PageFactory.initElements(driver, DashboardPage.class);
	}
	
	
	


}
