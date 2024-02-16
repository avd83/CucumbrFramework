Feature: Logout Page Feature

Background:
Given User has already logged in to application
|username|password|
|avd@gmail.com|rahulshettyacademy|

@Logout
Scenario: Logout page title
Given User is on Logout page
When User gets the title of the page
Then Page title should be "Rahul Shetty Academy - Login page"

@Logout
Scenario: Logout section lable display
Given User is on Logout page
Then User gets logout section lables
|Hello avd@gmail.com,|
|Welcome to Rahul Shetty Academy|
|You are successfully logged in.|

@Logout
Scenario: Logout button 
Given User is on Logout page
When User clicks on logout button and should logedout from application
Then User is on Login page
