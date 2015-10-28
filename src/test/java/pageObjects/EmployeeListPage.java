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
	
	
	// .//*[@id='resultTable']/tbody/tr[1]/td[4] first row from all employees list
	@FindBy(xpath=".//*[@id='resultTable']/tbody/tr/td[4]")// first  row from filtered employee list after search
	WebElement searchedLastName;
	

	public WebElement getSearchIdBox() {
		return searchIdBox;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}

	public WebElement getSearchedLastName(){
		return searchedLastName;
	}
}
