package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageNavigateObjects {

	
	@FindBy(xpath=".//*[@id='menu_pim_viewPimModule']")
	WebElement navigate2PIMPage;
	
	@FindBy(xpath=".//*[@id='menu_pim_addEmployee']")
	WebElement navigate2AddEmployeePage;
	
	
}
