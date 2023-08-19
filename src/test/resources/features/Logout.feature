Feature: Verify Loout Functionality
  Registered user should be able to logout from the account details
 Scenario: Logout
 Given I am logged in to Salesforce
  When I click the logout button
  Then I should be redirected to the login page