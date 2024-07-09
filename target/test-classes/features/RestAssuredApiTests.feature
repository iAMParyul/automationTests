Feature: HerokuApp APi tests

  @pun @ci
  Scenario: Create token service validation
    When I request for new token
    Then I got 200 as a response
    And I got the token in the response


  @pun
  Scenario: Get booking ids
    When I like to get booking ids
    Then I got 200 as a response
    And I got details from the response

  @pun
  Scenario: Get details of booking using id "331"
    When I want to get details of booking id "32"
    Then I got 200 as a response
    And I got details from the response

  @pun
  Scenario: Get details of booking using firstname and lastname
    When I want to get Id of booking using first name "Josh" and lastname "Allen"
    Then I got 200 as a response
    And I got details from the response

  @pun
  Scenario: Create a new booking data
    When I want to get Id of booking using first name "Josh" and lastname "Allen"
    Then I got 200 as a response
    And I got details from the response