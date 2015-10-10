package stepDefinitions;


import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;




import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Login {
	WebDriver driver=new FirefoxDriver();
	LoginPage LoginPageObject;
	DashboardPage dashboardObject;
	String username;
	
	
	//{{ Admin Login test with valid credential
	
	@Given("^I am in OrangeHRM login page:(.*)")
	public void i_am_in_OrangeHRM_login_page(List<String> homeUrl) throws Throwable {
	
	//@Given("^I am in OrangeHRM login page$")
	//public void i_am_in_OrangeHRM_login_page(List<String> homeUrl) throws Throwable {
		driver.get(homeUrl.get(1));
		//System.out.println(homeUrl.get(1));
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
	   // throw new PendingException();
	}

	@When("^I entered admin username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
	public void i_entered_admin_username_as_and_password_as(String username, String password) throws Throwable {
		this.username=username;
		LoginPageObject=PageFactory.initElements(driver, LoginPage.class);
	  
	    LoginPageObject.getUsernameField().sendKeys(username);
	    LoginPageObject.getPasswordField().sendKeys(password);
	   
		// Write code here that turns the phrase above into concrete actions
	   // throw new PendingException();
	}

	@And("^I clicked on Login button$")
	public void i_clicked_on_Login_button() throws Throwable {
		 LoginPageObject.getLoginButton().click();
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	@Then("^Login is successful$")
	public void login_is_successful() throws Throwable {
		dashboardObject=PageFactory.initElements(driver, DashboardPage.class);
		//assertThat(dashboardObject.getWelcomeUsernameLink().getText(), containsString("username"));
	    //Assert.assertThat(dashboardObject.getWelcomeUsernameLink().getText(), anyOf(username));
		Assert.assertTrue(dashboardObject.getWelcomeUsernameLink().getText().contains(username));
		
		driver.close();
		// Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}
	
	//}}

	//{{ Login Test with invalid credentials
	
	@When("^I entered username as?(.*) and password as? (.*)$")
	public void i_entered_username_and_password(String invalidUsername, String invalidPassword) throws Throwable {
		LoginPageObject=PageFactory.initElements(driver, LoginPage.class);
		LoginPageObject.getUsernameField().sendKeys(invalidUsername);
	    LoginPageObject.getPasswordField().sendKeys(invalidPassword);
		// Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}
	
	@And("^I clicked on Login Button$")
	public void i_clicked_on_Login_Button() throws Throwable {
		 LoginPageObject.getLoginButton().click();
	    // Write code here that turns the phrase above into concrete actions
	   // throw new PendingException();
	}

	@Then("^Login failed$")
	public void login_failed() throws Throwable {
		Assert.assertTrue(driver.getCurrentUrl().contains("retryLogin"));
		driver.close();
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}


	
	//}}
}
