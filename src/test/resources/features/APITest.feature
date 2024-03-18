#@API
#Feature: Create new user
#
#
#  Background:
#    Given User is on orangeHRM login page "https://dummyapi.io/data/v1/user/create"
#
#  @ValidCredentials @test1
#  Scenario: Create new user valid credentials
#
#    When Create user with valid data FirstName LastName EMail
#    Then Check that new user was created
#
#  @InvalidCredentials
#  Scenario: Create new user with invalid credentials
#
#    When User enters username as "<firstname>" and password as "<lastname>" "<email>"
#    Then User should be able to see error message "<errorMessage>" "<whattheproblem>"
##  {
##  "firstName": "", OR "1515151",
##  "lastName": "Tester",
##  "email": "queupreitreicreume-2333@yopmail.com"
##  }
#    Examples:
#      | firstname      | 1515151                             | Admin                                                                   |
#      | lastname       | Tester                              | 15135                                                                   |
#      | email          | queupreitreicreume-2333@yopmail.com | Email@mai.mail                                                          |
#      | errorMessage   | BODY_NOT_VALID                      | BODY_NOT_VALID                                                          |
#      | whattheproblem | Path `firstName` is required.       | "Path `lastName` (`4`) is shorter than the minimum allowed length (2)." |
##  {
##  "error": "BODY_NOT_VALID",
##  "data": {
##  "firstName": "Path `firstName` is required."
##  }}
#
##
##    Examples:
##      | username | lastname  | email          | errorMessage   |whattheproblem
##      | Admin    | admin12$$ | mail@mail.mail |BODY_NOT_VALID  |Path `firstName` is required.
##      | admin$$  | admin123  | mail@mail.mail |BODY_NOT_VALID  |Path `lastName` (`4`) is shorter than the minimum allowed length (2).
##      | abc123   | xyz$$     | mail@mail.mail |BODY_NOT_VALID  |----
#
#  @MissingUsername
#  Scenario: Login with blank username
#
#    When User enters username as " " and password as "admin123"
#    Then User should be able to see a message "Required" below Username
#
##  User Full
##  Full user data returned by id.
##  {
##  id: string(autogenerated)
##  title: string("mr", "ms", "mrs", "miss", "dr", "")
##  firstName: string(length: 2-50)
##  lastName: string(length: 2-50)
##  gender: string("male", "female", "other", "")
##  email: string(email)
##  dateOfBirth: string(ISO Date - value: 1/1/1900 - now)
##  registerDate: string(autogenerated)
##  phone: string(phone number - any format)
##  picture: string(url)
##  location: object(Location)
##  }