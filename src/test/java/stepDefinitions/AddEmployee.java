package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import pageObjects.AddEmployeePage;
import pageObjects.DashboardPage;
import pageObjects.EmployeeDetailsPage;
import pageObjects.EmployeeListPage;
import pageObjects.LoginPage;
import pageObjects.PageNavigateObjects;
import utilities.Helper;
import utilities.WebDriverConfig;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddEmployee {

	WebDriver driver;
	LoginPage LoginPageObject;
	DashboardPage dashboardPage;
	Login loginSteps;
	PageNavigateObjects navigate;
	AddEmployeePage addEmployeePage;
	EmployeeDetailsPage employeeDetailsPage;
	
	EmployeeListPage employeeListPage;

	String newEmployeeFullName;
	String lastName;
	String id;

	public AddEmployee(Login loginSteps, WebDriverConfig driver,
			PageNavigateObjects navigate,
			EmployeeDetailsPage employeeDetailsPage,
			AddEmployeePage addEmployeePage,
			EmployeeListPage employeeListPage) {

		this.loginSteps = loginSteps;
		this.driver = driver.initialize_webdriver();
		this.navigate = navigate;
	
		this.employeeDetailsPage = employeeDetailsPage;
		
		this.addEmployeePage=addEmployeePage;
		this.employeeListPage=employeeListPage;
	}

	@Given("^I am logged as Admin$")
	public void i_am_logged_as_Admin() throws Throwable {

		loginSteps.i_am_in_OrangeHRM_login_page();
		loginSteps.i_entered_valid_username_and_password();
		loginSteps.i_clicked_on_Login_button();
	}

	@When("^I clicked on the PIM menu$")
	public void i_clicked_on_the_PIM_menu() throws Throwable {
		navigate.getNavigate2PIMPage().click();
	}

	@And("^I clicked on the add employee sub-menu$")
	public void i_clicked_on_the_add_employee_sub_menu() throws Throwable {
		navigate.getNavigate2AddEmployeePage().click();
	
	}

	@Then("^Add Employee page is successfully displayed$")
	public void add_Employee_page_is_successfully_displayed() throws Throwable {
		//
		
		Assert.assertTrue(addEmployeePage.getPageHeading().getText()
				.equals("Add Employee"));
	}

	@Given("^I entered First Name as?(.*), Middle Name as?(.*) and Last Name as?(.*)$")
	public void i_entered_Employee_full_Names(String firstName,
			String middleName, String lastName) throws Throwable {
		this.lastName=lastName;

		addEmployeePage.getFirstNameField().sendKeys(firstName);
		addEmployeePage.getMiddleNameField().sendKeys(middleName);
		addEmployeePage.getLastNameField().sendKeys(lastName);
		
		if(middleName.trim().equalsIgnoreCase("")||middleName==null){
			this.newEmployeeFullName=firstName.trim()+" "+lastName.trim();
		}else{
		this.newEmployeeFullName = firstName.trim() + " " + middleName.trim() + " " + lastName.trim();
		}
	}

	@And("^I chose the location$")
	public void i_chose_the_location() throws Throwable {
		Select select = new Select(addEmployeePage.getLocationDropdown());
		select.selectByIndex(Helper.getrandomIndex(1,select.getOptions().size()-1));
	}

	@When("^I clicked the save button$")
	public void i_clicked_the_save_button() throws Throwable {
		
		
		addEmployeePage.getAddEmployeeSaveButton().click();
	}

	@Then("^Employee added successfully$")
	public void employee_added_successfully() throws Throwable {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		/*
		System.out.println(employeeDetailsPage.getProfilePictureName().getText());
		System.out.println(newEmployeeFullName.trim());
		Assert.assertTrue(employeeDetailsPage.getProfilePictureName().getText().equals(newEmployeeFullName.trim()));
		*/
		
		id=employeeDetailsPage.employeeId.getAttribute("value");
		System.out.println("Employee Id="+id);
		
		this.i_clicked_on_the_PIM_menu();
	
		employeeListPage.getSearchIdBox().sendKeys(id);
		employeeListPage.getSearchButton().click();
		Thread.sleep(4000);
		Assert.assertTrue(employeeListPage.verifyEmployeeAdded(id, lastName));
		driver.close();
	}

}