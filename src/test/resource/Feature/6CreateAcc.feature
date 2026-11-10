Feature: User should verify the Create Account functionality

  Background:
    Given User should launch the application
    When User tap the Create Account tab
    Then User should see the Create Account screen

  # ---------- POSITIVE ----------
  @positive
  Scenario: Verify user can create an account with valid details
    When User enter the User Name "Monika"
    And User enter a new unique email
    And User enter the signup password "Monika@19"
    And User enter the mobile "9876543210"
    And User tick the Terms of Service checkbox
    And User tap the Create Account button
    Then User should leave the Create Account screen

  @positive
  Scenario: Verify Sign In Instead opens the Sign In screen
    When User tap the Sign In Instead button
    Then User should see the Sign In screen

  @positive
  Scenario: Verify Sign In tab opens the Sign In screen
    When User tap the Sign In tab
    Then User should see the Sign In screen

  # ---------- NEGATIVE ----------
  @negative
  Scenario: Verify Create Account with all fields empty
    When User tap the Create Account button
    Then User should still see the Create Account screen

  @negative
  Scenario: Verify Create Account without accepting the Terms of Service
    When User enter the User Name "Monika"
    And User enter a new unique email
    And User enter the signup password "Monika@19"
    And User enter the mobile "9876543210"
    And User tap the Create Account button
    Then User should still see the Create Account screen

  @negative
  Scenario: Verify Create Account with an empty User Name
    When User enter a new unique email
    And User enter the signup password "Monika@19"
    And User enter the mobile "9876543210"
    And User tick the Terms of Service checkbox
    And User tap the Create Account button
    Then User should still see the Create Account screen

  @negative
  Scenario: Verify Create Account with an already registered email
    When User enter the User Name "Monika"
    And User enter the signup email "monikaparimalam@gmail.com"
    And User enter the signup password "Monika@19"
    And User enter the mobile "9876543210"
    And User tick the Terms of Service checkbox
    And User tap the Create Account button
    Then User should still see the Create Account screen

  @negative
  Scenario Outline: Verify Create Account with an invalid email format
    When User enter the User Name "Monika"
    And User enter the signup email "<email>"
    And User enter the signup password "Monika@19"
    And User enter the mobile "9876543210"
    And User tick the Terms of Service checkbox
    And User tap the Create Account button
    Then User should still see the Create Account screen

    Examples:
      | email            |
      | monikaparimalam  |
      | monikaparimalam@ |
      | @gmail.com       |
      | abc@@gmail.com   |

  @negative
  Scenario Outline: Verify Create Account with an invalid mobile number
    When User enter the User Name "Monika"
    And User enter a new unique email
    And User enter the signup password "Monika@19"
    And User enter the mobile "<mobile>"
    And User tick the Terms of Service checkbox
    And User tap the Create Account button
    Then User should still see the Create Account screen

    Examples:
      | mobile     |
      | 12345      |
      | abcdefghij |
      | @#$%^&*()! |

  @negative
  Scenario: Verify Create Account with a weak password
    When User enter the User Name "Monika"
    And User enter a new unique email
    And User enter the signup password "123"
    And User enter the mobile "9876543210"
    And User tick the Terms of Service checkbox
    And User tap the Create Account button
    Then User should still see the Create Account screen
