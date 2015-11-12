package stepDefinitions;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	WebDriverWait wait;
	LoginPage LoginPageObject;
	DashboardPage dashboardPage;
	Login loginSteps;
	PageNavigateObjects navigate;
	AddEmployeePage addEmployeePage;
	EmployeeDetailsPage employeeDetailsPage;
	EmployeeListPage employeeListPage;

	String newEmployeeFullName;
	String expectedlastName;
	String expectedid;
	String actualLastName;
	String validUsername="";
	String validPassword="";
	String newEmployeeFirstName="";
	Properties properties;

	public AddEmployee(Login loginSteps, WebDriverConfig driver,
			PageNavigateObjects navigate, Properties properties,
			EmployeeDetailsPage employeeDetailsPage,
			AddEmployeePage addEmployeePage,
			EmployeeListPage employeeListPage,
			DashboardPage dashboardPage
			) {

		this.loginSteps = loginSteps;
		this.driver = driver.initialize_webdriver();
		this.navigate = navigate;
		this.properties=properties;
		this.employeeDetailsPage = employeeDetailsPage;
		this.employeeListPage=employeeListPage;
		this.addEmployeePage=addEmployeePage;
		this.dashboardPage=dashboardPage;
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
		System.out.println("I just clicked PIM");
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
		this.expectedlastName=lastName;

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
		Thread.sleep(10000);
	}
	
	//{{Steps for creating user login account while adding new employee
	
@Given("^I entered employee information as below$")
public void i_entered_employee_information_as_below(List<String> names) throws Throwable {
	newEmployeeFirstName=names.get(0);
	addEmployeePage.getFirstNameField().sendKeys(names.get(0));
	addEmployeePage.getMiddleNameField().sendKeys(names.get(1));
	addEmployeePage.getLastNameField().sendKeys(names.get(2));
}

@Given("^I clicked the create login details checkbox$")
public void i_clicked_the_create_login_details_checkbox() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
  addEmployeePage.getCreateLoginDetailCheckbox().click();
}

@Given("^I entered following login details$")
public void i_entered_following_login_details(List<String> loginData) throws Throwable {
	validUsername=loginData.get(0).trim();
	validPassword=loginData.get(1).trim();
	addEmployeePage.getUsernametxtBox().sendKeys(validUsername);
	addEmployeePage.getPasswordtxtBox().sendKeys(validPassword);
	addEmployeePage.getConfirmPasswordtxtBox().sendKeys(validPassword);

   }

@Then("^Employee login account created successfully$")
public void employee_login_account_created_successfully() throws Throwable {
    wait=new WebDriverWait(driver, 10);
	//first logout and log back in with the ids just created
	loginSteps.i_clicked_on_the_logout_link();
	
	
	// logging back in
	
	loginSteps.i_am_in_OrangeHRM_login_page();
    loginSteps.i_entered_correct_username_and_password(validUsername, validPassword);
    loginSteps.i_clicked_on_Login_button();
    
    wait.until(ExpectedConditions.elementToBeClickable(dashboardPage.getWelcomeUsernameLink()));
    
    //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    Assert.assertTrue(dashboardPage.getWelcomeUsernameLink().getText().contains(newEmployeeFirstName));
	driver.close();
}

//}}


	@Then("^Employee added successfully$")
	public void employee_added_successfully() throws Throwable {
		actualLastName="";
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		/*
		System.out.println(employeeDetailsPage.getProfilePictureName().getText());
		System.out.println(newEmployeeFullName.trim());
		Assert.assertTrue(employeeDetailsPage.getProfilePictureName().getText().equals(newEmployeeFullName.trim()));
		*/
		
		expectedid=employeeDetailsPage.employeeId.getAttribute("value");
		System.out.println("Employee Id="+expectedid);
	
		//driver.navigate().to("http://enterprise.demo.orangehrmlive.com/pim/viewEmployeeList");
		navigate.getNavigate2PIMPage().click();
		//System.out.println("I just clicked on PIM again to verify employee added");
		System.out.println("navigating to PIM page");
		
		employeeListPage.getSearchIdBox().sendKeys(expectedid);
		System.out.println("id entered in search box");
		
		employeeListPage.getSearchButton().click();
		System.out.println("search button clicked");
		
	System.out.println("entering to last name assertion test");
	System.out.println("actual last name= "+actualLastName);
	actualLastName=employeeListPage.getSearchedLastName().getText().trim();
	System.out.println("actual last name= "+actualLastName);
	
	Assert.assertEquals(expectedlastName.trim(),actualLastName);
		driver.close();
	}

}