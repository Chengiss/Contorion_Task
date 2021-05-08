@wip
Feature: Login Function

  #first login method
  @login
  Scenario: Login after navigating to login page
    Given the user is on the homepage
    And user navigates to "login page"
    When user enters credentials and clicks Jetzt anmelden
    Then user should succesfully login

  #second login method
  @anotherTag
  Scenario: Login from the homepage
    Given the user is on the homepage
    When the user hovers on "anmelden"
    And user enters credentials and clicks Jetzt anmelden
    Then user should succesfully login

