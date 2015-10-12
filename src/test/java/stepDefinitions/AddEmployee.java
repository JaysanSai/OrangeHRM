package stepDefinitions;

import java.util.List;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddEmployee {
	Login stepsLogin= new Login();
	
	@Given("^I am in OrangeHRM dashboard page$")
	public void i_am_in_OrangeHRM_dashboard_page(List<List<String>> data) throws Throwable {
		List<String> url=data.get(0);
		String username=data.get(1).get(1);
		String password=data.get(2).get(1);
		stepsLogin.i_am_in_OrangeHRM_login_page(url);
		stepsLogin.i_entered_admin_username_as_and_password_as(username, password);
		stepsLogin.i_clicked_on_Login_Button();
	    // Write code here that turns the phrase above into concrete actions
	   // throw new PendingException();
	}

	@When("^I clicked on the PIM menu$")
	public void i_clicked_on_the_PIM_menu() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	  //  throw new PendingException();
	}

	@And("^I clicked on the add employee sub-menu$")
	public void i_clicked_on_the_add_employee_sub_menu() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	@Then("^Add Employee page is successfully displayed$")
	public void add_Employee_page_is_successfully_displayed() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	@Given("^I entered First Name as?(.*), Middle Name as?(.*) and Last Name as?(.*)$")
	public void i_entered_Employee_full_Names(String firstName,String middleName, String lastName) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new PendingException();
	}

	@When("^I clicked the save button$")
	public void i_clicked_the_save_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new PendingException();
	}

	@Then("^Employee added successfully$")
	public void employee_added_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

}