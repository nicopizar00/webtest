Feature: Purchase Product

  Scenario Outline: Successfully purchase a product
    Given I am on the home page
    When I select a product
    And I add the product to the cart
    And I go to the cart
    And I place an order
    And I fill in my personal information with name "<name>", country "<country>", city "<city>", credit card "<creditCard>", month "<month>", and year "<year>"
    And I complete the purchase
    Then I should see a confirmation message

    Examples:
      | name        | country | city     | creditCard       | month | year |
      | Pepito Soto | Chile   | Santiago | 1111222233334444 | 12    | 25   |
      | John Doe    | USA     | New York | 1234567812345678 | 12    | 2025 |
      | Jane Roe    | Canada  | Toronto  | 9876543212345678 | 10    | 2024 |
      | Alice Lee   | UK      | London   | 1234987654321234 | 11    | 2026 |
      | Alice Lee   | UK      | London   | 1234987654321234 | 11    | 2026 |