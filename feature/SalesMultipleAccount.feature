#Feature describes the functionality of the application
Feature: Login with Multiple Data for Salesforce Account Creation

#Scenario describes the behaviour of the testcase
Scenario Outline: Login with Multiple Data for Salesforce

#Given represents the precondition 
Given Launch a new browser and Load the URL

#When represents the test condition
When Enter credentials- username as dilip@testleaf.com

#And represents the combination of multiple steps
And Enter credentials- password as leaf@2024
And Click on the Login Button
And Click on the Toggle menu Button from the Left corner side
And Click View All Button and Click Sales Button from App Launcher
And Click on the Accounts Tab
And Click on the New Button
When Enter your name as <accName> to create account
And Selecting Ownership as Public 
And Click on Save Button

#Then represents the expected result
Then Verify the Account Name

Examples:
|accName|
|'InPa'|
|'Siva'|
|'Johnu'|
