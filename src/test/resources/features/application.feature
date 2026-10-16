
Feature: Application launch

  @smoke
  Scenario: Verify application title
    Given user opens the application
    Then page title should be "Swag Labs"


  @regression
  Scenario: Another application check

    Given user opens the application
    Then page title should be "Swag Labs"


