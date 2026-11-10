Feature: User should verify the Explore Top Tourist Places functionality

  Background:
    Given User should launch the application
    And User login with email "monikaparimalam@gmail.com" and password "Monika@19"
    Then User should be on the Home screen
    When User click the menu icon
    And User click the Explore option in the menu

  # ---------- POSITIVE ----------
  @positive
  Scenario: Verify the Explore page is displayed
    Then User should see the Explore Top Tourist Places page

  @positive
  Scenario: Verify the places are displayed
    Then User should see the place "Silver beach"
    And User should see the place "Marina"
    And User should see the places found count

  @positive
  Scenario: Verify the category filters are displayed
    Then User should see the category filters

  @positive
  Scenario: Verify search shows only the matching place
    When User search the place "Marina"
    Then User should see the place "Marina"
    And User should not see the place "Silver beach"

  @positive
  Scenario: Verify Get Route opens the Directions page
    When User tap Get Route on the first place
    Then User should see the Directions page for "Silver beach"

  @positive
  Scenario: Verify the route options are displayed on the Directions page
    When User tap Get Route on the first place
    Then User should see Drive, Ride and Walk options
    And User should see the Start button

  @positive
  Scenario: Verify the turn-by-turn navigation is displayed
    When User tap Get Route on the first place
    And User scroll to Turn-by-turn navigation
    Then User should see the turn-by-turn steps

  @positive
  Scenario: Verify Back to place returns to the Explore page
    When User tap Get Route on the first place
    And User tap Back to the place
    Then User should see the Explore Top Tourist Places page

  @positive
  Scenario: Verify Back returns to the Home screen
    When User tap Back on the Explore page
    Then User should be on the Home screen

  # ---------- NEGATIVE ----------
  @negative
  Scenario: Verify search with an unknown place
    When User search the place "zzzzxxxx"
    Then User should not see the place "Silver beach"
    And User should not see the place "Marina"

  @negative
  Scenario: Verify search with special characters
    When User search the place "@#$%^&*"
    Then User should not see the place "Silver beach"
    And User should not see the place "Marina"

  @negative
  Scenario: Verify the Historical filter does not show Nature places
    When User tap the "Historical" filter
    Then User should not see the place "Silver beach"
    And User should not see the place "Marina"

  @negative
  Scenario: Verify All Places filter shows all places again
    When User tap the "Historical" filter
    And User tap the "All Places" filter
    Then User should see the place "Silver beach"
    And User should see the place "Marina"
