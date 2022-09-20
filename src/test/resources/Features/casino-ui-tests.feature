Feature: UI tests for casino site

  Scenario: Search existing player by name on Casino players page
    Given I open casino login page
    When  I login with valid credentials
    Then  Casino main page is loaded
    And   I click on link Users on side menu
    And   I click on link Players to open players page
    Then  Players page is loaded
    When  I add valid parameter in search by name field
    Then  I verify that Player search result is not empty

  Scenario: Search NOT existing player by random name on Casino players page
    Given I open casino login page
    When  I login with valid credentials
    Then  Casino main page is loaded
    And   I click on link Users on side menu
    And   I click on link Players to open players page
    Then  Players page is loaded
    When  I set random parameter in search by name field
    Then  I verify that Player search result is empty