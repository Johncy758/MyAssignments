#Feature describes the functionality of the application
Feature: Delete Account - LeafTaps

#Scenario describes the behaviour of the testcase
Scenario Outline: Deleting a account in leaftaps application

#When represents the test condition
When Crmsfa Link Should be Clicked

#And represents the combination of multiple steps
And Account Tab Should be Clicked
And Click the Find Accounts Tab
And Enter the Account Id as <ID>
And Click on Find accounts Button
And Click the deactivate button

#Then represents the expected result
Then Print the message

Examples:
|ID|
|'11643'|
|'11644'|
