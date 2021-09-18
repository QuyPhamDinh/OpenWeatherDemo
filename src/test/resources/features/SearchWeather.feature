@Search
Feature: Home Page

  Scenario: Search Weather

    Given the defined browser opens up
    And the fruit is Banana
    When entering searched text as "Ha Noi"
    Then there is 1 suggestion
    When clicking that suggestion
    Then detail weather of the location shown
    Then verify all
