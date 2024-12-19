#Feature describes the functionality of the application
Feature: Salesforce - Edit a Account

#Scenario describes the behaviour of the testcase
Scenario: Editing a Salesforce account

#Given represents the precondition
Given Launch the new browser and Load the Url

#When represents the test condition
When Click the App Launcher Icon next to setup

#And represents the combination of multiple steps
And Click View All and Select Accounts from App launcher
And Search the account using unique account name
And Click the dropdown icon and select Edit
And Set Type to Technology Partner
And Set Industry to HealthCare
And Enter the Billing address to 'Chennai'
And Enter the Shipping address to 'Namakkal'
And Set Customer Priority to Low
And Set SLA to Silver
And Set Active to NO
And Enter a Unique Phone number "9568423789"
And Set Upsell Opportunity to NO

#Then represents the expected result
Then Click Save and verify the phone number