Feature: Log into Saucedemo online shop
  As a customer of Saucedemo online shop
  I want to be able to login
  So that I'm able to have access to the online shop services

  Rule: The customer must provide valid credentials to login

    Background:
      Given Chris is on the Login page

    Example: The customer provides valid credentials
      When Chris attempts to login with valid credentials
      Then the catalog should be displayed

    Scenario Template: The customer provides invalid credentials
      When Chris attempts to login with username "<username>" and password "<password>"
      Then he is not logged in
      And an error message "<message>" is displayed

      Examples:
        | username      | password       | message                                                     |
        | standard_user | wrong-password | Username and password do not match any user in this service |
        | wrong-user    | some-password  | Username and password do not match any user in this service |
        | some-username |                | Password is required                                        |
        |               | some-password  | Username is required                                        |

    Rule: Customer with locked account cannot login

    Example: Login with user whose account is locked
      Given Lora is on the Login page
      When Lora attempts to login with valid credentials
      Then she is not logged in
      And an error message "Sorry, this user has been locked out." is displayed