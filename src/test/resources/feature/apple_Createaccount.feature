Feature: Apple vacation credential

  @tag1
  Scenario: Apple_vc-createaccount
    Given using apv url in any browser
    When user type invalid data1
    And click on createaccount button
    Then verify the error message1

  @tag2
  Scenario: Apple SIHN_IN  to account
    Given using apv url in any browser1
    When user gave invalid data
    And verify the error message2

  @tag3
  Scenario: Apple SIHN_IN  to account
    Given using apv url in any browser1
    When user gave valid data

  @tag4
  Scenario: Apple to booking a Hotelroom
    Given using apv url in any browser2
    When user gave valid data1
   Then click on search button

  @tag5
  Scenario: Apple booking aflight only
    Given using applev url in  browser
    And user gave valid informatoin
    Then click on search button

  @tag6
  Scenario: Apple booking hotel+flight
    Given using applev url in  browser
    And user gave valid informatoin1
    Then  click on search button
