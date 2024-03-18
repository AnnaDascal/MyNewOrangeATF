@API
Feature: User API Tests

Background:
Given I have API Key
#And Create a user

@ValidCredentials
Scenario: Create a user with credentials
When I send a POST request to create a user with unique email
Then the response status code should be 200

@ValidCredentials
Scenario: Delete newly created user
When I send a DELETE request to delete the created user
Then the delete response status code should be 200
And the delete response message should indicate user deletion success

  @NegativeTests @test1
  Scenario: Attempt to create a user with a repeated email
    When I send a POST request to create a user
    And the response status code should be 200
    And  repeat request
    Then the response status code should be 400
    And the response message should indicate email already used

#  @NegativeTests
#  Scenario: Attempt to delete a user with an invalid ID
#    When I send DELETE requests to delete a user twice
#    Then the response status code should be 400