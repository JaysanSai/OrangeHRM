package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WebDriverConfig;

public class EmployeeListPage {
	WebDriver driver;

	public EmployeeListPage(WebDriverConfig driverConfig) {
		this.driver = driverConfig.initialize_webdriver();
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = ".//*[@id='searchBtn']")
	WebElement searchButton;



	@FindBy(xpath = ".//*[@id='empsearch_id']")
	WebElement searchIdBox;
/*
	public boolean verifyEmployeeAdded(String id, String lastName) {
	
		
		if(driver.findElement(By.xpath(".//*[@id='resultTable']/tbody/tr/td[2]")).getText().trim().equals(id.trim())&&
				driver.findElement(By.xpath(".//*[@id='resultTable']/tbody/tr/td[4]")).getText().trim().equals(lastName.trim()))
		{
			return true;
		}
		

		return false;
	}
	*/

	public WebElement getSearchIdBox() {
		return searchIdBox;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}


}
