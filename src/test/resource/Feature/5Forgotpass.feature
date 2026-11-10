Feature: User should verify the Forgot Password functionality

  Background:
    Given User should launch the application
    When User tap the Forgot Password link

  # ---------- POSITIVE ----------
  @positive
  Scenario: Verify the Forgot Password screen is displayed
    Then User should see the Forgot Password screen

  @positive
  Scenario: Verify user gets the Verification Code screen with a registered email
    When User enter the email "monikap.kiaq@gmail.com" on the Forgot Password screen
    And User tap the Continue button
    Then User should see the Verification Code screen
    And User should see the 6 OTP boxes
    And User should not see the error "Registration email not found"

  @positive
  Scenario: Verify Back button returns to the Sign In screen
    When User tap the Back button
    Then User should see the Sign In screen

  # ---------- NEGATIVE ----------
  @negative
  Scenario: Verify error for an unregistered email
    When User enter the email "admin@gmail.com" on the Forgot Password screen
    And User tap the Continue button
    Then User should see the error "Registration email not found"

  @negative
  Scenario: Verify Continue with an empty email
    When User tap the Continue button
    Then User should still see the Forgot Password screen

  @negative
  Scenario Outline: Verify Continue with an invalid email format
    When User enter the email "<email>" on the Forgot Password screen
    And User tap the Continue button
    Then User should still see the Forgot Password screen

    Examples:
      | email            |
      | monikaparimalam  |
      | monikaparimalam@ |
      | @gmail.com       |
      | abc@@gmail.com   |

  @negative
  Scenario: Verify Verify button with an empty OTP
    When User enter the email "monikaparimalam@gmail.com" on the Forgot Password screen
    And User tap the Continue button
    And User tap the Verify button
    Then User should still see the Verification Code screen
