#Feature describes the functionality of the application
Feature: Edit Account - LeafTaps

#Scenario describes the behaviour of the testcase
Scenario Outline: Editing a account in leaftaps application

#When represents the test condition
When Crmsfa Link should be clicked

#And represents the combination of multiple steps
And Account Tab should be clicked
And Click the Find Accounts tab
And Enter the account Id as <ID>
And Click the Find accounts button
And Click the edit button
And Click the save button

#Then represents the expected result
Then Check the edited name of the account 

Examples:
|ID|
|'11845'|
|'11846'|

