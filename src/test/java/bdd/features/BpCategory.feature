Feature: Blood Pressure Category Calculation
  As a user
  I want to enter my blood pressure values
  So that the system can show me the correct BP category

  Scenario: Calculate Low Blood Pressure Category
    Given I open the BP Home Page
    When I enter systolic value "70"
    And I enter diastolic value "60"
    And I click the Submit button
    Then I should see the BP category as "Low Blood Pressure"

    Scenario: Calculate Ideal Blood Pressure Category
    Given I open the BP Home Page
    When I enter systolic value "115"
    And I enter diastolic value "75"
    And I click the Submit button
    Then I should see the BP category as "Ideal Blood Pressure"


    Scenario: Calculate Ideal Pre-High Pressure Category
    Given I open the BP Home Page
    When I enter systolic value "130"
    And I enter diastolic value "80"
    And I click the Submit button
    Then I should see the BP category as "Pre-High Blood Pressure"


    Scenario: Calculate High Blood Pressure Category
    Given I open the BP Home Page
    When I enter systolic value "140"
    And I enter diastolic value "80"
    And I click the Submit button
    Then I should see the BP category as "High Blood Pressure"

