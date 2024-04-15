#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: Login functionality
  
  Background:
		Given Open landing page

  Scenario Outline: Verify the valid login
    Given Enter the username <name> and password <password>
    When Click on the login button
    Then User should be able to Login


    Examples: 
      | name                    | password   |
      | testdemo@mailinator.com | Asdfasdf12 |

      
    Scenario Outline: Verify the invalid login
	    Given Enter the invalid username <name> and password <password>
	    When Click on the sign button
	    Then <error> message is visible


    Examples: 
      | name                    | password    | error                          |
      | testdemo@mailinator.com | Asdfasdf123 | Incorrect email or password.   |