@UI @test1
Feature: Login to orangeHRM Application


  Background:
    Given User is on orangeHRM login page "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"

  @ValidCredentials
  Scenario: Login with valid credentials

    When User enters username as "Admin" and password as "admin123"
    Then User should be able to login successfully and new page open

  @InvalidCredentials
  Scenario Outline: Login with invalid credentials

    When User enters username as "<username>" and password as "<password>"
    Then User should be able to see error message "<errorMessage>"

    Examples:
      | username | password  | errorMessage        |
      | Admin    | admin12$$ | Invalid credentials |
      | admin$$  | admin123  | Invalid credentials |
      | abc123   | xyz$$     | Invalid credentials |

  @MissingUsername
  Scenario: Login with blank username

    When User enters username as " " and password as "admin123"
    Then User should be able to see a message "Required" below Username