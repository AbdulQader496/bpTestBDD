Feature: Blood Pressure Category Calculation
  As a user
  I want to enter my blood pressure values
  So that the system can show me the correct BP category

  Scenario: Calculate Ideal Blood Pressure Category
    Given I open the BP Home Page
    When I enter systolic value "140"
    And I enter diastolic value "80"
    And I click the Submit button
    Then I should see the BP category as "High Blood Pressure"

