Feature: OrangeHRM Login

  Background: Load login page
    #Below is datatable and it works fine
    # Given I am in OrangeHRM login page
    # | url | http://enterprise.demo.orangehrmlive.com |
    
    #Below is another way of declaring data(using comma) to pass a List<String> to step Definitions
    #Note the use of regis in @Given in step definition to implement below method
    Given I am in OrangeHRM login page:url,http://enterprise.demo.orangehrmlive.com

  Scenario: Admin login with valid credential
    #Never use colon (:) after Given, When, And and Then keywords
    #Given I am in OrangeHRM login page
    #|url|http://enterprise.demo.orangehrmlive.com|
    When I entered admin username as "Admin" and password as "admin"
    And I clicked on Login button
    Then Login is successful

  Scenario Outline: Login test for invalid credentials
    When I entered username as <username> and password as <password>
    And I clicked on Login Button
    Then Login failed

    Examples: 
      | username | password |
      | jay      | chlo33d  |
      | kikei    | pufirk   |
      | cnlle09  | lkksiek  |
