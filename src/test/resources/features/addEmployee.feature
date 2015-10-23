Feature: Add New Employee in the database
  This will automate add new employee feature of the system

  Background: Go to Add Employee page
  	Given I am logged as Admin
    When I clicked on the PIM menu
    And I clicked on the add employee sub-menu
    Then Add Employee page is successfully displayed

  #Below given statement contains duplication as url, username and password are
  #declared again on this feature file while they were already declared in login feature file
  #Question: Is there a way a scenarion written in another feature file can be called
  #this feature file in Cucumber?
  #Given I am in OrangeHRM dashboard page
  #| url      | http://enterprise.demo.orangehrmlive.com  |
  #| username | Admin                                     |
  #| password | admin                                     |
  Scenario Outline: Add New Employees
    Given I entered First Name as <First Name>, Middle Name as <Middle Name> and Last Name as <Last Name>
    And I chose the location
    When I clicked the save button
    Then Employee added successfully

    Examples: 
      | First Name | Middle Name | Last Name |
      | Jay        |             | Yes       |
      | Kiran      | Lal         | Gurung    |
     
