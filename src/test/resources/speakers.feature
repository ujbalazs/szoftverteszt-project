Feature: Speakers page test

  Background:
    Given the home page is opened
    And the Speakers button is clicked

  Scenario: We get to the speakers page
    Then the speakers page is opened

  Scenario: Login button is working on the speakers page
    When the Login button is clicked
    Then the login page is opened

  Scenario: The user can see the searchbar
    Then the searchbar is visible

  Scenario Outline: Search for speakers
    Given the searchbar is clicked
    When "<search-name>" is typed in searchbar
    Then "<card-user-name>" card is visible
    And <count> card is visible
    Examples:
      | search-name       | card-user-name        | count |
      | Balazs Cservenak  | Balazs Cservenak      | 1     |
      | Zoltan            | Zoltan Gal            | 9     |