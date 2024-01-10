Feature: Validate hrm credentials

 
  Scenario: login to hrm application with valid test data
    Given using hrm url in any browser
    When user type valid Username and Password
    And click on login button
    Then verify the error message
      | 
