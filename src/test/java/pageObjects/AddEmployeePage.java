package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WebDriverConfig;

public class AddEmployeePage {
	WebDriver driver;
	
	public AddEmployeePage(WebDriverConfig driverConfig){
		this.driver=driverConfig.initialize_webdriver();
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath=".//*[@id='location']")
	WebElement locationDropdown;
	
	public WebElement getLocationDropdown() {
		return locationDropdown;
	}

	@FindBy(xpath=".//*[@id='content']/div/div[1]/h1")
	WebElement pageHeading;
	
	@FindBy(xpath=".//*[@id='firstName']")
	WebElement firstNameField;
	
	@FindBy(xpath=".//*[@id='middleName']")
	WebElement middleNameField;
	
	@FindBy(xpath=".//*[@id='lastName']")
	WebElement lastNameField;
	
	@FindBy(xpath=".//*[@id='employeeId']")
	WebElement employeeIdField;
	
	@FindBy(xpath=".//*[@id='photofile']")
	WebElement addPhotoButton;
	
	@FindBy(xpath=".//*[@id='btnSave']")
	WebElement addEmployeeSaveButton;
	
	@FindBy(xpath=".//*[@id='chkLogin']")
	WebElement createLoginDetailCheckbox;
	
	@FindBy(xpath=".//*[@id='user_name']")
	WebElement usernametxtBox;
			
	@FindBy(xpath=".//*[@id='user_password']")
	WebElement passwordtxtBox;
					
	@FindBy(xpath=".//*[@id='re_password']")
	WebElement confirmPasswordtxtBox;
	
	
	public WebElement getPageHeading() {
		return pageHeading;
	}

	public WebElement getCreateLoginDetailCheckbox() {
		return createLoginDetailCheckbox;
	}

	public WebElement getUsernametxtBox() {
		return usernametxtBox;
	}

	public WebElement getPasswordtxtBox() {
		return passwordtxtBox;
	}

	public WebElement getConfirmPasswordtxtBox() {
		return confirmPasswordtxtBox;
	}



	public WebElement getFirstNameField() {
		return firstNameField;
	}

	public WebElement getMiddleNameField() {
		return middleNameField;
	}

	public WebElement getLastNameField() {
		return lastNameField;
	}

	public WebElement getEmployeeIdField() {
		return employeeIdField;
	}

	public WebElement getAddPhotoButton() {
		return addPhotoButton;
	}

	public WebElement getAddEmployeeSaveButton() {
		return addEmployeeSaveButton;
	}
	
	
}
