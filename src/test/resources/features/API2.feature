Feature: User API Tests 2

  Background:
    Given I have API Key

  @NegativeTests
  Scenario: Attempt to create a user with a repeated email
    When I send a POST request to create a user
    And the response status code should be 200
    And  repeat request
    Then the response status code should be 400
    And the response message should indicate email already used

#  @NegativeTests
#  Scenario: Attempt to delete a user with an invalid ID
#    When I send a POST request to create a user
#    And I send DELETE requests to delete a user twice
#    Then the response status code should be 400