Feature: Finance Manager Home Page Works

Scenario: Refresh Displays Requests
		Given Admin is logged on
		When Refresh is pressed
		Then Request Table is populated
		
Scenario: Employee Lookup Redirects Correctly
		Given Admin is logged on
		When Employee Lookup is pressed
		Then Admin is on Employee Lookup page
		
Scenario: To Main Page Works Correctly
		Given Admin is logged on
		When To Main Page is pressed
		Then Admin is on main page
		
Scenario: ID Redirect to Single Req Page Works
		Given Admin is logged on
		When Refresh is pressed
		And First ID is clicked
		Then Admin is on Request Management page