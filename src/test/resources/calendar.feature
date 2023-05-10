Feature: Calendar page test

  Background:
    Given the home page is opened
    And the Calendar button is clicked

  Scenario: We get to the calendar page
    Then the calendar page is opened

  Scenario: Login button is working on the calendar page
    When the Login button is clicked
    Then the login page is opened

  Scenario: The user can see the page title
    Then "EVENTS CALENDAR" is shown

  Scenario: The user can see the calendar
    Then the calendar is shown

  Scenario: In month mode, the user can see the days of the month
    When the Month button is clicked
    Then the days of the month are visible

  Scenario: In week mode, the user can see the days of the week with the hours
    When the Week button is clicked
    Then the days of the week are visible
    And the hours of the day are visible

  Scenario: In day mode, the user can see the hours of the day
    When the Day button is clicked
    Then the hours of the day are visible in day mode

  Scenario: In list mode, the user can see the days of the month with the event list
    When the List button is clicked
    Then the days of the month are visible in list
    And the event list is visible

  Scenario Outline: When the user clicks an event in the calendar with any format,
  a sidemenu pops up with the title
    When the "<format>" button is clicked
    And "<event-name>" is clicked
    Then the "<event-name>" is in the sidemenu
    Examples:
      | format    | event-name                                   |
      | Month     | B-track Education Stream                     |
      | Day       | Wroclaw board games                          |
      | Week      | .NET Talks #8                                |
      | List      | Wroclaw board games                          |