@Launch
@end
Feature: User Registration Validation

  Background:
    Given I'm on Opencart Registration Launch page
    And I can see the details to fill page

    @p
  Scenario:  New User Registration Validation
    When I fill following details on the registration page
    | Firstname | LastName | Email     |
    | Test      | User     | test.user |
    And click on continue button
    Then I got message of account has been created
    And I click on continue button