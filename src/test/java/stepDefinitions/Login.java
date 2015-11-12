package stepDefinitions;


import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import utilities.PropertiesConfig;
import utilities.WebDriverConfig;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



public class Login{
	WebDriver driver;
	Properties properties;
	LoginPage loginPage;
	DashboardPage dashboardPage;
	
	public Login(WebDriverConfig driverConfig, 
			PropertiesConfig propertiesConfig, 
			LoginPage loginPage,
			DashboardPage dashboardPage) throws IOException{
		this.driver=driverConfig.initialize_webdriver();
		this.properties=propertiesConfig.loadPropertiesFile();
		this.loginPage=loginPage;
		this.dashboardPage=dashboardPage;
	}
	
	//Login with valid account
	@When("^I entered correct username and password$")
	public void i_entered_correct_username_and_password(String username, String password) throws Throwable {
		loginPage.getUsernameField().sendKeys(username);
		loginPage.getPasswordField().sendKeys(password);
	}
	
	//{{logout steps
	
	@Given("^I am logged with valid account$")
	public void i_am_logged_with_valid_account() throws Throwable {
		i_entered_valid_username_and_password();
		i_clicked_on_Login_button();
	}

	@When("^I clicked on the logout link$")
	public void i_clicked_on_the_logout_link() throws Throwable {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='welcome']")).click();
		driver.findElement(By.xpath(".//*[@id='welcome-menu']/ul/li[2]/a")).click();
	}

	@Then("^I should be successfully logged out$")
	public void i_should_be_successfully_logged_out() throws Throwable {
	   Assert.assertEquals(properties.getProperty("afterLogoutUrl"), driver.getCurrentUrl());
	}
	
	//}}
	
	
	//{{ Admin Login test with valid credential
	
	//@Given("^I am in OrangeHRM login page:(.*)")--To use with comment 1 in login feature
	@Given("^I am in OrangeHRM login page$")
	public void i_am_in_OrangeHRM_login_page() throws IOException{
	
	//@Given("^I am in OrangeHRM login page$")
	//public void i_am_in_OrangeHRM_login_page(List<String> homeUrl) throws Throwable {
		driver.get(properties.getProperty("url"));
		//System.out.println(homeUrl.get(1));
	   
	}

	@When("^I entered valid username and password$")
	public void i_entered_valid_username_and_password() throws IOException{
		
		
		loginPage.getUsernameField().sendKeys(properties.getProperty("userName"));
		loginPage.getPasswordField().sendKeys(properties.getProperty("passWord"));
	   
		// Write code here that turns the phrase above into concrete actions
	   // throw new PendingException();
	}

	@And("^I clicked on Login button$")
	public void i_clicked_on_Login_button() throws Throwable {
		loginPage.getLoginButton().click();
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	@Then("^Login is successful$")
	public void login_is_successful() throws Throwable {
		
		//assertThat(dashboardObject.getWelcomeUsernameLink().getText(), containsString("username"));
	    //Assert.assertThat(dashboardObject.getWelcomeUsernameLink().getText(), anyOf(username));
		
		Assert.assertTrue(dashboardPage.getWelcomeUsernameLink().getText().contains(properties.getProperty("userName")));
		
		driver.close();
		// Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}
	
	//}}

	//{{ Login Test with invalid credentials
	
	@When("^I entered username as?(.*) and password as?(.*)$")
	public void i_entered_username_and_password(String invalidUsername, String invalidPassword) throws Throwable {
		
		loginPage.getUsernameField().sendKeys(invalidUsername);
		loginPage.getPasswordField().sendKeys(invalidPassword);
		// Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}
	
	@And("^I clicked on the Login button$")
	public void i_clicked_on_Login_Button() throws Throwable {
		loginPage.getLoginButton().click();
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
