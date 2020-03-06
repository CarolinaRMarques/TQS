Feature: Trying to find something

  Scenario: Finding some cheese
    Given I am on the Google search page
    When I search for "Queijo!"
    Then the page title should start with "Queijoxxxxxxxxxxx"