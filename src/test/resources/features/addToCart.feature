Feature: Adding products to cart

  Scenario: Adding a backpack and bike light to the shopping cart
    Given A user logs into the website as a regular user
    When They add the "backpack" to their cart
    And They add the "bike light" to their cart
    Then Their cart shows "2" items added
