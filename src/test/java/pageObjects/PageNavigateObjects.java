package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageNavigateObjects {

	
	public WebElement getNavigate2PIMPage() {
		return navigate2PIMPage;
	}

	public WebElement getNavigate2AddEmployeePage() {
		return navigate2AddEmployeePage;
	}



	@FindBy(xpath=".//*[@id='menu_pim_viewPimModule']")
	WebElement navigate2PIMPage;
	
	@FindBy(xpath=".//*[@id='menu_pim_addEmployee']")
	WebElement navigate2AddEmployeePage;
	
	
}
