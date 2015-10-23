package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverConfig {
	WebDriver driver;
	
	public WebDriver initialize_webdriver(){
		
		if (driver==null){
			driver=new FirefoxDriver();
		}
		return driver;
	}
	
}
