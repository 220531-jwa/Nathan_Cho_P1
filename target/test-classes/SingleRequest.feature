Feature: Single Request Page Works

Scenario: Going back to all requests
	Given the User is on the Single Request Page
	When the User goes to View All Requests
	Then the User is on View All Requests Page
	
Scenario: Going back home
	Given the User is on the Single Request Page
	When the User goes to Return to Home
	Then the User is back at the Home Page
	
Scenario: Submiting New Request
	Given the User is on the Single Request Page
	When the User goes to Submit a New Request
	Then I am on the Submit New Request page
	
Scenario: Edit Request button
	Given the User is on the Single Request Page
	When the User presses edit request
	Then the edit table is visible
	
Scenario:  Submitting Edits
	Given the User is on the Single Request Page
	When the User presses edit request
	And the user fills in the edits and submits
	Then the new request edits will show
	