@UI
Feature: Reset password in orangeHRM Application

  Background:
    Given User is on orangeHRM login page "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    And Click on the Forgot Password button

  @ValidCredentials
  Scenario: Reset Password

    When User enters username as "Admin" and click on the Reset Password button
    Then New page is open and user should have success massage "Reset Password link sent successfully"


  @MissingUsername
  Scenario: Reset Password with blank username
    When User enters username as " " and click on the Reset Password button
    Then User should have error message "Required"

  @BackOnPreviousPage
  Scenario: Reset Password back on previous page
    When User click on the Cancel button
    Then User should be on login page again