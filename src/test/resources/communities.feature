Feature: Communities page test

  Background:
    Given the home page is opened
    And the Communities button is clicked

  Scenario: We get to the communities page
    Then the communities page is opened

  Scenario: Login button is working on the communities page
    When the Login button is clicked
    Then the login page is opened

  Scenario: The user can see the searchbar
    Then the searchbar is visible

  Scenario Outline: the searchbar is working
    Given the searchbar is clicked
    When "<search>" is typed in searchbar
    Then "<name>" card is visible
    Examples:
      | search     | name                      |
      | epam       | EPAM Conference Community |
      | react      | React Native Belarus      |
      | test       | Global Testing Community  |
      | artificial | Artificial intelligence   |

  Scenario Outline: Filter communities by location
    Given the Location button is clicked
    And searchbar is empty
    When just "<location>" is selected
    Then <count> card is visible
    Examples:
      | location | count |
      | Hungary  | 13    |
      | Japan    | 1     |
      | Poland   | 22    |
      | Ukraine  | 53    |
      | Vietnam  | 2     |

  Scenario: only online communities are visible
    Given the More filters button is clicked
    When Online button is clicked
    Then 523 card is visible

  Scenario: Hungarian and English communities are selected
    Given the More filters button is clicked
    And the Language button is clicked
    When Hungarian is selected
    And English is selected
    Then 386 card is visible
