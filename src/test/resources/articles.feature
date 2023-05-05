Feature: Articles page test

  Background:
    Given the home page is opened
    And the Articles button is clicked

  Scenario: We get to the articles page
    Then the articles page is opened

  Scenario: Login button is working on the articles page
    When the Login button is clicked
    Then the login page is opened

  Scenario: The user can see the searchbar
    Then the searchbar is visible

  Scenario: Search for hungarian EPAM articles
    Given the More filters button is clicked
    And the searchbar is clicked
    When "Epam" is typed in searchbar
    And the Language button is clicked
    And Hungarian is selected
    Then 21 card is visible

  Scenario: Search for russian articles by 05/11/2023
    Given the More filters button is clicked
    When the Language button is clicked
    And Russian is selected
    And the Date till button is clicked
    And 05/11/2023 is selected
    Then 205 card is visible

  Scenario: Search for articles by Timea Kovacs
    Given the More filters button is clicked
    When the Author button is clicked
    And "Timea Kovacs" is typed in
    Then "Női karrierút az EPAM-nál, gyerekkel - három anya története" card is visible
    And 40 cards is visible