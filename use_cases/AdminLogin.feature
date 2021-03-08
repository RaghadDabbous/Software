Feature: Admin login

Background: The System has a repository of Admins with their information (Email - password)
    Given these accounts are contained in the system
      | m@gmail.com      | 123        |
      | r@gmail.com      | 14222      | 

Scenario: login with error password
	Given I am on the login page
	When I fill in "m@gmail.com" and "1111"
	And I call  Login Func
	Then I should see Error message
 

 Scenario: login with valid credentials
	Given I am on the login page
	When I fill in "r@gmail.com" and "14222"
	And I call  Login Func
	Then I should see Login successful
	
	
	
 
 
 
 
 
   
 
 