@shopping_cart @remove_items
Feature: Remove items from the shopping cart
  In order to manage the shopping cart list of items
  As a customer
  I want to be able to remove items

  Background:
    Given Chris is logged in with valid credentials
    And he has added the following items to his shopping cart:
      | Sauce Labs Bolt T-Shirt  |
      | Sauce Labs Fleece Jacket |

  Rule: The customer can remove items

    Example: The customer can remove items via catalog
      When Chris removes the following item via catalog
        | Sauce Labs Bolt T-Shirt |
      Then the shopping cart count should be 1
      And the item should be removed from the shopping cart

    Example: The customer can remove items via shopping cart
      When Chris removes the following item via shopping cart
        | Sauce Labs Fleece Jacket |
      Then the shopping cart count should be 1
      And the item should be removed from the shopping cart