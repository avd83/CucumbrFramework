Feature: Login feature

@Login
Scenario: Login Page Title
Given User is on Login page
When User gets the title of the page
Then Page title should be "Rahul Shetty Academy - Login page"

@Login
Scenario: Forgot Password Link
Given User is on Login page
Then Forgot password link should be displayed

@Login
Scenario: Login With Correct Credentials
Given User is on Login page
When User eneters username "avd@gmail.com"
And User eneters password "rahulshettyacademy"
And User clicks on login button
Then User gets the title of the page 
And Page title should be "Rahul Shetty Academy - Login page"