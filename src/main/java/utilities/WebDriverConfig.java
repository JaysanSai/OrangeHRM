package utilities;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class WebDriverConfig {
	WebDriver driver;
	
	public WebDriver initialize_webdriver(){
		
		if (driver==null){
			FirefoxProfile profile = new FirefoxProfile();
			driver = new FirefoxDriver(new FirefoxBinary(new File("/home/ec2-user/firefox")), profile);
			//driver=new FirefoxDriver();
		}
		return driver;
	}
	
}
