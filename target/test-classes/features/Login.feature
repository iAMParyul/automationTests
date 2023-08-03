Feature: Login to Demo cart

  @Login
  Scenario: Demo cart login
    Given We are at login Page of Demo cart app
    When User enters the username : "Demo"
    And enters the password : "demo"
    And click on login button
    #Then user able to login