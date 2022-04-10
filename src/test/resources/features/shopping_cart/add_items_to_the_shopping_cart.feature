Feature: Add items to the shopping cart
  In order to purchase items
  As a customer
  I want to be able to add items to the shopping cart

  Background:
    Given Chris is logged in with valid credentials

  Rule: Items added via the catalog should be listed in the shopping cart

    @current
    Example: Chris adds items to his shopping cart
      When he adds the following items to his shopping cart:
        | Sauce Labs Bolt T-Shirt  |
        | Sauce Labs Fleece Jacket |
      Then the shopping cart count should be 2
      And the items should be listed in the shopping cart