#Feature describes the functionality of the application
Feature: SalesForce Account Creation

#Scenario describes the behaviour of the testcase
Scenario: Verify Account is created

#Given represents the precondition 
Given Launch the browser and load the URL

#When represents the test condition
When Enter the username as dilip@testleaf.com

#And represents the combination of multiple steps
And Enter the password as leaf@2024
And Click on Login button
And Click on toggle menu button from the  left corner
And Click View All button and Click Sales from App Launcher
And Click on Accounts tab
And Click on New button
When Enter your name as account name
And Select Ownership as Public
And Click Save button

#Then represents the expected result
Then Verify the account name