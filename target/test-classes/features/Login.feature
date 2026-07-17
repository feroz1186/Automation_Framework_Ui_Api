Feature: Login functionality

@ui1
  Scenario: Successful login with valid credentials
    Given user navigates to login page
    When user enters username "Admin" and password "admin123"
    And user clicks login button
    Then dashboard should be displayed
    
 @ui2
 Scenario Outline: Successful login with differnt set of data
    Given user navigates to login page
    When user enters username "<username>" and password "<password>"
    And user clicks login button
    #Then dashboard should be displayed
    
Examples:
|username	|password|
|Admin		|admin123|
|admin1		|admin123|
|admin2		|admin123|

 
  Scenario: Login with multiple users - 
    Given user navigates to login page
    When user enters the following login details
      | username | password  |
      | Admin    | admin123  |
      | admin1   | admin123  |
      | admin2   | admin123  |
    And user clicks login button  
    And check the user reached proper area
    