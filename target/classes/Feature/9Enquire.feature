Feature: User should verify the Enquiries and Vendor Responses

  Background:
    Given User should launch the application
    And User login with email "monikaparimalam@gmail.com" and password "Monika@19"
    Then User should be on the Home screen
    When User tap the Enquiry tab in the bottom bar

  @positive
  Scenario: Verify the My Enquiries and Quotes page is displayed
    Then User should see the My Enquiries and Quotes page

  @positive
  Scenario Outline: Verify the enquiries count matches the filter count
    When User tap the "<filter>" enquiry filter
    Then The enquiries list count should match the filter count

    Examples:
      | filter   |
      | All      |
      | Assigned |
      | New      |

  @positive
  Scenario: Verify the Timeline View steps are displayed
    When User tap the Timeline View tab
    Then User should see the timeline steps

  @positive
  Scenario: Verify Vendor Responses shows the Message and Call buttons
    When User tap the Vendor Responses tab
    Then User should see the Message and Call buttons

  @positive
  Scenario: Verify the Message button opens the Messaging screen
    When User tap the Vendor Responses tab
    And User tap the Message button
    Then User should see the Messaging screen

  @positive
  Scenario: Verify the Call button opens the phone dialer
    When User tap the Vendor Responses tab
    And User tap the Call button
    Then The phone dialer should open

  @negative
  Scenario: Verify the Submitted filter shows no enquiries
    When User tap the "Submitted" enquiry filter
    Then The enquiries list count should be 0

  @negative
  Scenario: Verify the vendor phone number is not a dummy number
    When User tap the Vendor Responses tab
    And User tap the Call button
    Then The dialer should not show the dummy number "1234567890"
