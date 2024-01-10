Feature: Validate hrm credentials


  Scenario: login to hrm application with invalid test data
    Given using hrm url in any browser
    When user type invalid Username and Password
    And click on login button
    Then verify the error message 
