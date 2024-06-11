@tag
Feature: Tab Title

  Scenario: Verify the title of the web page tab
    Given I am on the login page
    Then the title of the web page tab should be "4YOU - Se connecter"

  Scenario Outline: Verify the title of the web page tab after login
    Given I am on the login page
    When I enter username "<username>" and password "<password>"
    Then the title of the web page tab should be "4YOU - Start your day"

    Examples:
      | username | password |
      | MARWEN   | HR       |
