Feature: User should verify the Login functionality

  Background:
    Given User should launch the application

  @positive
  Scenario: Verify login with valid email and password
    When User enter the Email Address "monikap.kiaq@gmail.com"
    And User enter the password "Monika@19"
    And User tap the Sign In button
    Then User should be navigated to the dashboard

  @negative
  Scenario: Verify login with valid email and wrong password
    When User enter the Email Address "monikap.kiaq@gmail.com"
    And User enter the password "Wrong@123"
    And User tap the Sign In button
    Then User should see login failure and stay on the Sign In screen

  @negative
  Scenario: Verify login with empty email and password
    When User tap the Sign In button
    Then User should see login failure and stay on the Sign In screen

  @negative
  Scenario: Verify login with email only and empty password
    When User enter the Email Address "monikap.kiaq@gmail.com"
    And User tap the Sign In button
    Then User should see login failure and stay on the Sign In screen

  @negative
  Scenario: Verify login with password only and empty email
    When User enter the password "Monika@19"
    And User tap the Sign In button
    Then User should see login failure and stay on the Sign In screen

  @negative
  Scenario Outline: Verify login with invalid email formats
    When User enter the Email Address "<email>"
    And User enter the password "Monika@19"
    And User tap the Sign In button
    Then User should see login failure and stay on the Sign In screen

    Examples:
      | email                    |
      | monikap.kiaq             |
      | monikap.kiaq@            |
      | @gmail.com               |
      | monikap.  kiaq@gmail.com |
      | monikap.kiaq@@gmail.com  |

  # ---------- POSITIVE ----------
  @positive
  Scenario: Verify the Sign in with Google button is displayed on the Sign In page
    Then Google page should show "Welcome Back"
    And Google page should show "Or continue with"
    And Google page should show "Sign in with Google"

  @negative
  Scenario: Verify the Unauthorized error is displayed after choosing a Google account
    When User tap Sign in with Google
    And User choose the first Google account
    Then User should see the Unauthorized error
