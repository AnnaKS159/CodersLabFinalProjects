@Exercise2
Feature: Doing shopping in mystore page

  Scenario: Adding product and whole path to pay for it.

    Given I login in my-store-testlab.coderslab.pl
    When I click in SignIn Button to login
    When I login in my-store-testlab.coderslab.pl with email:chppksekkuapvmncsw@ptv.com and password: plmokn
    When I go back to main page
    When I search the product: Hummingbird Printed Sweater
    When  I choose my product from results
    When I choose the size: M and quantity which is equal 5 of product and I add to cart
    When I am proceed to checkout
    And I make doublecheck in my order and click proceed to checkout.
    When I Confirm address
    When I choose pick up method as PrestaShop "pick up in store"
    When I choose payment method: Pay by Check
    Then I make screen shot as confirmation of my order

#    Examples:
#      | name OF Product             |size|quantity|
#      | Hummingbird Printed Sweater |M|5|