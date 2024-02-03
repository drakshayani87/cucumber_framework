

 

 Scenario Outline: login to hrm application with invalid valid test data
    Given using hrm url in any browser
    When user type <Username> and <Password>
    And click on login button
    Then verify the error message

    Examples: 
      |Username      | Password |
      |drakshayani   |    hasdgsajsad |
      | Admin        |    admin123 |
