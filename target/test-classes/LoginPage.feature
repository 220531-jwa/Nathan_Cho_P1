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

Feature: Login Page Works

	Background: 
		Given I am on the Login page

  Scenario: Create Account Link Works
  	When I click on the Create Account Link
  	Then I am on the Create Account Page
  	
  Scenario: Invalid Login Works
		When the User types an invalid username and password
		Then Login Error Appears
  
  Scenario Outline: Employee Login Works
  	When the  User types in their "<username>" and "<password>" and clicks the Login Button
  	Then the User should be on the Home page
  	
  	Examples:
  	| username | password |
  	| josh     | josh     |
  	| sam      | sam      |
  	
	Scenario Outline: Admin Login Works
		When the  User types in their "<username>" and "<password>" and clicks the Login Button
		Then the User should be on the Admin page
		
		Examples:
		| username | password |
		| admin    | admin    | 

	



