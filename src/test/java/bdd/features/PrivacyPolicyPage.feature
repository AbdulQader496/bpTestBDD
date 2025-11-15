Feature: Home Page Navigation
  As a user
  I want to navigate to the Privacy Policy page
  So that I can view the website's privacy information

Scenario: Navigate from Home Page to Privacy Policy page
  Given I open the BP Home Page
  When I click on the Privacy Policy link
  Then I should be redirected to the Privacy Policy page titled "Privacy Policy"
