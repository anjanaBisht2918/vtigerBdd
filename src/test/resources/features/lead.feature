Feature: create a Lead 

Scenario: create a lead and verify the lead 
	Given  user should be logged in and navigate to the Home page
	When  user creates a lead 
	Then  user verify the lead informaion
	And   close the browser
	