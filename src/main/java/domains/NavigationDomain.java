package domains;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import pageObjects.PageNavigateObjects;
import utilities.WebDriverConfig;

public class NavigationDomain {
	WebDriver driver;
	
	public NavigationDomain(WebDriverConfig driver){
		this.driver=driver.initialize_webdriver();
	}
	public PageNavigateObjects initialize_Navigation_Objects(){
		
		return PageFactory.initElements(driver, PageNavigateObjects.class);
		
	}
	
}
