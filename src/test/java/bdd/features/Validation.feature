Feature: Blood Pressure Input Validation
  As a user
  I want to see validation messages when entering invalid BP values
  So that I can correct my mistakes

  Scenario: Systolic and Diastolic values below allowed range
    Given I open the BP Home Page
    When I enter systolic value "69"
    And I enter diastolic value "39"
    And I click the Submit button
    Then I should see systolic validation message "Invalid Systolic Value"
    And I should see diastolic validation message "Invalid Diastolic Value"

  Scenario: Systolic and Diastolic values above allowed range
    Given I open the BP Home Page
    When I enter systolic value "191"
    And I enter diastolic value "101"
    And I click the Submit button
    Then I should see systolic validation message "Invalid Systolic Value"
    And I should see diastolic validation message "Invalid Diastolic Value"

  Scenario: Systolic is lower than Diastolic (invalid comparison)
    Given I open the BP Home Page
    When I enter systolic value "80"
    And I enter diastolic value "100"
    And I click the Submit button
    Then I should see value comparison validation "Systolic must be greater than Diastolic"
