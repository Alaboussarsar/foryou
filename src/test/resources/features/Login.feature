@tag
Feature: Login functionality

  Scenario Outline: User logs in successfully
    Given I am on the login page
    When I enter username "<username>" and password "<password>"
    Then I should see the welcome message if login is successful
    Examples:
      | username | password |
      | MARWEN   | HR       |

  Scenario Outline: User login fails
    Given I am on the login page
    When I enter username "<username>" and password "<password>"
    Then I should see an error message if login fails
    Examples:
      | username | password |
      | Alice    | abc123   |
      | JohnDoe  | Pass123  |


