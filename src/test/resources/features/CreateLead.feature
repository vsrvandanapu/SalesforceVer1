Feature: Create Lead in Salesforce
  As a Salesforce user
  I want to be able to create a new lead
  So that I can track potential customers
  Scenario: User creates a new lead
  Given Registered user logged in to Salesforce
  When user navigate to the leads creation page
  And user fill in to below fields
  |firstName				|VV           			      |
  |lastName					|Raghava							    |
  |companyName			|CIS									  	|
  |email						|akrishna@gmail.com			  |
  |leadStatus				|Working - Contacted		  |
  And I click the save button
  Then the lead should be created successfully