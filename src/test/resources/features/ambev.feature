Feature: Opening g1.com

  Scenario: Open g1.com homepage
    Given the user is on the Globo.com homepage
    When the user navigates to the g1.com website
    Then the g1.com homepage should be displayed

