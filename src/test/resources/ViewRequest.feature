Feature: View Request Page Works

	Background: 
		Given I am logged in And I am on View Requests
		
		Scenario: Back to home takes me to Home Page
			When I press on Back to Home
			Then I am on the Home page
			
		Scenario Outline: View More Works
			When the User types "<ticketNum>" in Request ID and pressed View More
			Then I am on the Single Request Page
			
			Examples:
			| ticketNum |
			| 3 |
			| 7 |
			| 2 |
			
		Scenario: Invalid Ticket Lookup
			When the User types a random ticket number
			Then an invalid ticket error appears
			
		Scenario: No Ticket ID
			When the User types no ticket number
			Then an invalid ticket error appears
			
		
	