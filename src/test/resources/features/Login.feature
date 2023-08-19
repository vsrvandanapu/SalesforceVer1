Feature: Verify Login Functionality
  Registered user should be able to login to access the account details

  Scenario Outline: Login with valid credentials
    Given User navigates to login page
    When user enters valid email address <username> into username filed
    And user enters valid password <password> into password filed
    And clicks on Login button
    Then user should login successfully
 Examples:
    |username											|password								|
    |srinivas@cisolutions.com			|Selenium@1							|
    |srinivas@cisolutions.com			|Selenium@1							|
    |srinivas@cisolutions.com			|Selenium@1							|

  Scenario: Login with invalid credentials
    Given User navigates to login page
    When user enters invalid email address into username filed
    And enter invalid password "Selenium1" into password filed
    And clicks on Login button
    Then user should get a proper warning message about credentials mismatch

  Scenario: Login with valid email and invalid password
    Given User navigates to login page
    When user enters valid email address "srinivas@cisolutions.com" into username filed
    And enter invalid password "Selenium1" into password filed
    And clicks on Login button
    Then user should get a proper warning message about credentials mismatch

  Scenario: Login with invalid email and valid password
     Given User navigates to login page
    When user enters invalid email address into username filed
    And user enters valid password "Selenium@1" into password filed
    And clicks on Login button
    Then user should get a proper warning message about credentials mismatch
