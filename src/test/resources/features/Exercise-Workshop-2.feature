@Exercise2
Feature: Doing shopping in mystore page

  Scenario Outline: Adding product and whole path to pay for it.

    Given I login in my-store-testlab.coderslab.pl
    When I click in SignIn Button to login
    When I login in my-store-testlab.coderslab.pl with email:chppksekkuapvmncsw@ptv.com and password: plmokn
    When I go back to main page
    When I search the product: <name OF Product>
    When  I choose my product from results
    Then I check that product is discounted about 20%
    When I choose the size: <size> and quantity which is equal <quantity> of product and I add to cart
    When I am proceed to checkout
    And I make doublecheck in my order and click proceed to checkout.
    When I Confirm address
    When I choose pick up method as PrestaShop "pick up in store"
    When I choose payment method: Pay by Check
    Then I make screen shot as confirmation of my order
    And I go back to main user Page
    And I go to tiles with my details of my order and history of my orders.
    Then I check that My order is here

    Examples:
      | name OF Product             | size | quantity |
      | Hummingbird Printed Sweater | M    | 5        |