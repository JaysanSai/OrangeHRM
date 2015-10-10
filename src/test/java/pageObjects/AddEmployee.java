package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddEmployee {
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
	
	
}
