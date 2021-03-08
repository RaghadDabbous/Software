Feature: Admin logout

Scenario: Administrator logs out
Given admin should be loged in
When i call the Logout function
Then the administrator should be loged out