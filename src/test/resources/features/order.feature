
Feature: Place an order

  @smoke
  Scenario: Successfully complete a product order
    Given user is on the login page
    When user enters username "standard_user"
    And user enters password "secret_sauce"
    And user clicks login
    And user adds a product to the cart
    And user opens the shopping cart
    And user proceeds to checkout
    And user enters checkout information "Saravanan" "Rajendran" "641001"
    And user completes the order
    Then order confirmation should be displayed
