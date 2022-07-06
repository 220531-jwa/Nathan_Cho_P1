Feature: Manager Single Request View Works

Scenario:
	Given Admin is logged on
	And Refresh is pressed
	And Admin has selected ticket21
	When status is changed to answered
	And status update is pressed
	Then new status can be seen
	And the admin sets the status back to open
	
