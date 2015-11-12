Feature: OrangeHRM Login

  Background: Load login page
    #Below is datatable and it works fine
    # Given I am in OrangeHRM login page
    # | url | http://enterprise.demo.orangehrmlive.com |
    #Below is another way of declaring data(using comma) to pass a List<String> to step Definitions
    #Note the use of regis in @Given in step definition to implement below method
    #comment 1
    #Given I am in OrangeHRM login page:url,http://enterprise.demo.orangehrmlive.com
    Given I am in OrangeHRM login page

  @adminLogin @smokeTest
  Scenario: Admin login with valid credential
    #Never use colon (:) after Given, When, And and Then keywords
    #Given I am in OrangeHRM login page
    #|url|http://enterprise.demo.orangehrmlive.com|
    When I entered valid username and password
    And I clicked on Login button
    Then Login is successful
    
    Scenario: Login with valid credential
    When I entered correct username and password
    And I clicked on Login button
    Then Login is successful
    
    @logout
    Scenario: Logout test
    And I am logged with valid account
    When I clicked on the logout link
    Then I should be successfully logged out

  Scenario Outline: Login test for invalid credentials
    When I entered username as <username> and password as <password>
    And I clicked on the Login button
    Then Login failed

    Examples: 
      | username | password |
      | jay      | chlo33d  |
      | kikei    | pufirk   |
      | cnlle09  | lkksiek  |
