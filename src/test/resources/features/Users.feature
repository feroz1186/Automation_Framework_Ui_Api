Feature: User API

@api
  Scenario: Get user details
    Given API base URL is set
    When user sends GET request to "/users/2"
    Then response status code should be 200
    And response field "data.id" should be 2