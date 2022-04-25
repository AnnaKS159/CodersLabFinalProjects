@Exercise1
Feature: Login in to mystore page and create the address.

  Scenario Outline: Add new address into the logged user.
    Given I am login in my-store-testlab.coderslab.pl
    When I click in SignIn Button
    When I am login in my-store-testlab.coderslab.pl with email:chppksekkuapvmncsw@ptv.com and password: plmokn
    When I click in Addresses button.
    When I choose the option to create new address.
    When I create new address with alias:<Alias>, address:<address>, city:<City>, zip code:<Zip Code>, phone number:<Phone Number>
    When I save the data
    Then I see the address with alias:<Alias>, address:<address>, city:<City>, zip code:<Zip Code>, phone number:<Phone Number>
    And I delete my inserted data with alias <Alias>

    #    spróbuj dodać tutaj więcej przypadków, tak żeby Twój test  sprawdził np adres
      #  co znaczy wiecej przypadkow
    Examples:
      | Alias          | address         | City   | Zip Code | Phone Number |
      | Home Address   | Kocmyrzowska 5  | Warsaw | 00-356   | 0221251256   |
      | Harry Potter's | Private Drive 4 | London | 11-123   | 0221234567   |