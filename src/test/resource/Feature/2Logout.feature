Feature: User should verify the Logout functionality

  Background:
    Given User should launch the application
    And User login with email "monikap.kiaq@gmail.com" and password "Monika@19"
    Then User should be on the Home screen

  @positive
  Scenario: Verify the logout confirmation popup is displayed
    When User tap the logout icon
    Then User should see the logout confirmation popup

  @positive
  Scenario: Verify user can logout by tapping Yes, Logout
    When User tap the logout icon
    And User tap the Yes, Logout button
    Then User should be navigated to the Sign In screen

  @negative
  Scenario: Verify user stays on Home screen when Cancel is tapped
    When User tap the logout icon
    And User tap the Cancel button
    Then User should be on the Home screen

