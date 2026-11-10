Feature: User should verify the Account (Profile) page and Account Settings

  Background:
    Given User should launch the application
    And User login with email "monikaparimalam@gmail.com" and password "Monika@19"
    Then User should be on the Home screen
    When User tap the Account tab in the bottom bar

  # ---------- POSITIVE : My Account ----------
  @positive
  Scenario: Verify the My Account page header is displayed
    Then Account page should show "My Account"
    And Account page should show "Welcome Back,"
    And Account page should show "Verified"
    And Account page should show "Gold Member"
    And Account page should show "Edit Profile"

  @positive
  Scenario Outline: Verify the summary cards are displayed
    Then Account page should show "<card>"

    Examples:
      | card           |
      | Total Bookings |
      | Saved Places   |
      | Enquiries      |
      | Loyalty Points |

  @positive
  Scenario Outline: Verify each tab can be opened
    When User tap the account tab "<tab>"
    Then Account page should show "<tab>"

    Examples:
      | tab          |
      | Overview     |
      | Bookings     |
      | Saved Places |
      | Enquiries    |
      | Reviews      |

  @positive
  Scenario: Verify the upcoming bookings are displayed
    Then Account page should show "Upcoming Bookings"
    And Account page should show "Raam Hotel"
    And Account page should show "CONFIRMED"
    And Account page should show "Sushi Master"
    And Account page should show "PENDING"
    And Account page should show "View All"

  @positive
  Scenario: Verify the loyalty points card is displayed
    When User scroll account to "Redeem Now"
    Then Account page should show "Loyalty Points"
    And Account page should show "Redeem Now"

  # ---------- POSITIVE : Account Settings ----------
  @positive
  Scenario: Verify Edit Profile opens Account Settings
    When User tap Edit Profile
    Then Account page should show "Account Settings"
    And Account page should show "Profile Information"
    And Account page should show "Full Name"
    And Account page should show "Email Address"
    And Account page should show "Membership Tier"
    And Account page should show "Save Changes"

  @positive
  Scenario: Verify the profile details are already filled
    When User tap Edit Profile
    Then The Full Name field should contain "Monika p"
    And Account page should show "Gold Member"

  @positive
  Scenario: Verify the notification switches are displayed with the default values
    When User tap Edit Profile
    And User scroll account to "Push Notifications"
    Then Account page should show "Email Notifications"
    And Account page should show "SMS Alerts"
    And Account page should show "Push Notifications"
    And The switch "Email Notifications" should be on
    And The switch "SMS Alerts" should be off
    And The switch "Push Notifications" should be on

  @positive @datachange
  Scenario: Verify user can turn the SMS Alerts switch on
    When User tap Edit Profile
    And User scroll account to "Push Notifications"
    And User tap the switch "SMS Alerts"
    Then The switch "SMS Alerts" should be on

  @positive
  Scenario: Verify the security status is displayed
    When User tap Edit Profile
    And User scroll account to "Your account is secure"
    Then Account page should show "Security Status"
    And Account page should show "Your account is secure"

  @positive
  Scenario: Verify the back arrow returns to My Account
    When User tap Edit Profile
    And User tap the account back arrow
    Then Account page should show "Edit Profile"

  @positive @datachange
  Scenario: Verify user can update the full name
    When User tap Edit Profile
    And User enter the full name "Monika Test"
    And User tap Save Changes
    Then Account page should show "Account Settings"

  # ---------- NEGATIVE ----------
  @negative
  Scenario: Verify Save Changes with an empty full name
    When User tap Edit Profile
    And User enter the full name ""
    And User tap Save Changes
    Then The Full Name field should not be empty

  @negative
  Scenario Outline: Verify Save Changes with an invalid full name
    When User tap Edit Profile
    And User enter the full name "<name>"
    And User tap Save Changes
    Then The Full Name field should not contain "<name>"

    Examples:
      | name    |
      | @#$%^&* |
      | 123456  |

  @negative
  Scenario Outline: Verify Save Changes with an invalid email
    When User tap Edit Profile
    And User enter the settings email "<email>"
    And User tap Save Changes
    Then The Email field should not contain "<email>"

    Examples:
      | email          |
      |                |
      | monikap        |
      | monikap@       |
      | @gmail.com     |
      | abc@@gmail.com |

  @negative
  Scenario: Verify the settings email matches the login email
    When User tap Edit Profile
    Then The Email field should contain "monikaparimalam@gmail.com"

  @negative
  Scenario: Verify the name is not changed when the user goes back without saving
    When User tap Edit Profile
    And User enter the full name "Not Saved Name"
    And User tap the account back arrow
    And User tap Edit Profile
    Then The Full Name field should contain "Monika p"

  @negative
  Scenario: Verify Total Bookings is not 0 when upcoming bookings are displayed
    Then Account page should show "Raam Hotel"
    And The Total Bookings count should not be 0

  @negative
  Scenario: Verify the security message does not say password was updated long ago for a new account
    When User tap Edit Profile
    And User scroll account to "Your account is secure"
    Then Account page should not show "Last password update was 3 months ago"
