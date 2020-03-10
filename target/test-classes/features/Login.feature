@sprint1 
Feature: Login
 @login
  Scenario: Valid Login
    When I enter valid username and password
    And I click on Login button
    Then I successfully logged in
  
  @regression
  Scenario: Invalid Login
    When I enter valid username and invalid password
    And I click on Login button
    Then I see error message
  @regression
  Scenario Outline: Invalid Login and message validation
    When I enter "<Username>" and "<Password>"
    And I click on Login button
    Then I see "<ErrorMessage>"
    Examples:
      | Username | Password   | ErrorMessage             |
      | Admin    | Admin123   | Invalid credentials      |
      | Admin    |            | Password cannot be empty |
      |          | Syntax@123 | Username cannot be empty |
      |          |            | Username cannot be empty |