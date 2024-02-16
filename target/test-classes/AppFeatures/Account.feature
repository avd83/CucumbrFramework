Feature: Account Page Feature

Background:
Given User has already logged in to application
|username|password|
|avd@gmail.com|rahulshettyacademy|

@accounts
Scenario: Accounts page title
Given User is on Accounts page
When User gets the title of the page
Then Page title should be "Rahul Shetty Academy - Login page"

@accounts
Scenario: Accounts section count
Given User is on Accounts page
Then User gets accounts section
|ORDER HISTORY AND DETAILS|
|MY CREDIT SLIPS|
|MY ADDRESSES|
|MY PERSONAL INFORMATION|
|MY WISHLISTS|
|Home|
And Accounts section count should be 6