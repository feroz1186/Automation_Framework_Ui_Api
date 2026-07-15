Feature: Login functionality
@ui
  Scenario: Successful login with valid credentials
    Given user navigates to login page
    When user enters username "Admin" and password "admin123"
    And user clicks login button
    Then dashboard should be displayed