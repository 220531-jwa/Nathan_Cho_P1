Feature: Home Page Works

	Background:
	Given I am on the Home page
	
	Scenario: View Requests Works
		When I press on View Requests
		Then I am on the View Requests page
	
	Scenario: Submit New Request Works
		When I press on Submit a new Request
		Then I am on the Submit New Request page
	
	Scenario: Log out Works
		When I press on Log Out
		Then I am on the Home page