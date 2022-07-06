Feature: Employee Lookup Works

Scenatio: Can look up Employee
	Given Admin is logged on
	And Admin selects employee lookup
	When id for josh is entered
	And submit is pressed
	Then requests for josh is shown
	
Scenario:
	Given Admin is logged on
	And Admin selects employee lookup
	When an invalid id is entered
	And submit is pressed
	Then invalid id error appears
	
Scenario:
	Given Admin is logged on
	And Admin selects employee lookup
	When id for josh is entered
	And submit is pressed
	And id21 is selected 
	Then Admin is on Request Management page