Feature: User should verify the Notifications functionality

  Background:
    Given User should launch the application
    And User login with email "monikap.kiaq@gmail.com" and password "Monika@19"
    Then User should be on the Home screen

  @positive
  Scenario: Verify the notifications popup is displayed when the bell icon is tapped
    When User tap the notification bell icon
    Then User should see the Notifications popup

  @positive
  Scenario: Verify the Notifications popup is closed using the close icon
    When User tap the notification bell icon
    And User tap the close icon on the Notifications popup
    Then User should be on the Home screen

  @positive
  Scenario: Verify View All Notifications opens the Notifications page
    When User tap the notification bell icon
    And User tap the View All Notifications button
    Then User should see the Notifications page
    And User should see Total Notifications, Unread and High Priority counts

  @positive
  Scenario: Verify the Unread filter shows unread notifications
    When User tap the notification bell icon
    And User tap the View All Notifications button
    And User tap the "Unread" filter
    Then User should see the notification "Account Verified"

  @positive @datachange
  Scenario: Verify user can delete a notification
    When User tap the notification bell icon
    And User tap the View All Notifications button
    And User tap Delete on the first notification
    Then The number of Delete buttons should decrease by 1

  @negative
  Scenario: Verify user returns to Home screen using the back arrow on Notifications page
    When User tap the notification bell icon
    And User tap the View All Notifications button
    And User tap the back arrow on the Notifications page
    Then User should be on the Home screen

  @negative
  Scenario: Verify the Leads filter does not show unrelated notifications
    When User tap the notification bell icon
    And User tap the View All Notifications button
    And User tap the "Leads" filter
    Then User should not see the notification "Account Verified"
