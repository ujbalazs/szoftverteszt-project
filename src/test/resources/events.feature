Feature: Events page test

  Background:
    Given the home page is opened
    And the Events button is clicked

  Scenario: We get to the events page
    Then the events page is opened

  Scenario: Login button is working on the events page
    When the Login button is clicked
    Then the login page is opened

  Scenario: The searchbar in the header is opened when we click on it
    When the search icon is clicked
    Then the searchbar in the header is visible

  Scenario Outline: the searchbar is working
    Given the searchbar is clicked
    When "<search-term>" is typed in searchbar
    Then "<name>" card is visible
    Examples:
      | search-term | name                                                              |
      | epam        | Clean Up Day with EPAM Slovakia 2023 - Bratislava                 |
      | test        | International Software TestingQualification Board as Organization |

  Scenario: Hungarian and English events are selected
    Given the More filters button is clicked
    And the Language button is clicked
    When Hungarian is selected
    And English is selected
    Then 60 card is visible

  Scenario: End date is selected
    Given the More filters button is clicked
    And the Date till button is clicked
    When 05/11/2023 is selected
    Then 32 card is visible

  Scenario: Past events in Hungary
    Given the Location button is clicked
    And Hungary is selected
    When the Past events button is clicked
    Then 94 card is visible

  Scenario Outline: Specific past event in Hungary
    Given the Location button is clicked
    And Hungary is selected
    When the Past events button is clicked
    Then "<event-name>" card is visible
    Examples:
      | event-name                                       |
      | Idea Pool - TA Tool Evaluation - Robot Framework |
      | BA Department Meeting 2023 Spring                |
      | A gentle introduction to type classes in Scala   |
      | IT Night 2023 Spring - offline in HU offices     |

  Scenario: Specific upcoming event in Hungary
    Given the Location button is clicked
    And Hungary is selected
    When the Upcoming events button is clicked
    Then "Coolest Project 2023 tavasz" card is visible