Feature: opportunity functionality
Scenario: Create opportunity and verify the opportunity
    Given  Admin has logged in and on the home page
    When  admin creates organization 
    When admin creates capaign
    When admin creates opportunity
    Then  Verify the created Opportunity
