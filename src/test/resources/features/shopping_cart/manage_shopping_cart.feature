@shopping_cart
Feature: Manage the shopping cart
  In order to choose the items which I want to buy
  As a customer
  I want to be able to manage the shopping cart by adding and removing items

  Rule: The chosen items should be added to the shopping cart

    @add_items
    Example: The customer chooses items via catalog overview
      Given Chris is logged in with valid credentials
      When he chooses the following items:
        | Sauce Labs Bolt T-Shirt  |
        | Sauce Labs Fleece Jacket |
      Then the shopping cart count should be 2
      And the items should be listed in the shopping cart

  Rule: The customer can remove items from the shopping cart

    Background:
      Given Chris is logged in with valid credentials
      And he has chosen the following items:
        | Sauce Labs Bolt T-Shirt  |
        | Sauce Labs Fleece Jacket |

    @remove_items
    Example: The customer removes items via catalog overview
      When Chris removes the following item via catalog overview
        | Sauce Labs Bolt T-Shirt |
      Then the shopping cart count should be 1
      And the item should be removed from the shopping cart

    @remove_items
    Example: The customer removes items via shopping cart
      When Chris removes the following item via shopping cart
        | Sauce Labs Fleece Jacket |
      Then the shopping cart count should be 1
      And the item should be removed from the shopping cart