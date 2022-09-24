Feature: API tests for casino site

  Scenario: Search something
    Given I generate token request body
    Then  I populate ACCESS_TOKEN