Feature: Footer Section Verification
  As a user
  I want to see correct footer information
  So that I can trust the application's consistency and branding

  Scenario: Verify footer copyright
    Given I open the BP Home Page
    Then I should see the footer text "© 2025 - BPCalculator - Privacy"

  Scenario: Verify footer Privacy Policy link
    Given I open the BP Home Page
    Then I should see a footer link labeled "Privacy"

  Scenario: Verify footer copyright is visible in Privacy Policy page
    Given I navigate to Privacy Policy page
    Then I should see the footer text "© 2025 - BPCalculator - Privacy" in Privacy Policy page

  Scenario: Verify footer Privacy Policy link is visible in Privacy Policy page
    Given I navigate to Privacy Policy page
    Then I should see a footer link labeled "Privacy" in Privacy Policy page
