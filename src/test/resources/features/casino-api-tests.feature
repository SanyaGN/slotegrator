Feature: API tests for casino site

  Background:
    Given I generate token request body
    Given I populate ACCESS_TOKEN
    Given I generate create player request body
    Given I send POST create player request
    Given I generate client token request body
    Given I populate CLIENT_ACCESS_TOKEN

  Scenario: Get current player data after its creation
    When  I send GET player request by ID
    Then  I validate get player response

  Scenario: Get different player data with current client token
    When  I send GET player request by different ID
    Then  I should get "Object not found:" error message
