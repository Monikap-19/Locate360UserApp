Feature: User should verify the Search page functionality

  Background:
    Given User should launch the application
    And User login with email "monikap.kiaq@gmail.com" and password "Monika@19"
    Then User should be on the Home screen
    When User click the menu icon
    And User click the Search option in the menu

  # ---------- POSITIVE ----------
  @positive
  Scenario: Verify the Search page is displayed
    Then User should see the search field

  @positive
  Scenario: Verify Trending Searches are displayed
    Then User should see the trending search items

  @positive
  Scenario: Verify Recent Searches section is displayed
    Then User should see the Recent Searches section

  @positive
  Scenario: Verify suggestions are displayed when user types a keyword
    When User enter "Hotels" in the search box
    Then User should see suggestions for "Hotels"

  @positive
  Scenario: Verify search results are displayed for a valid keyword
    When User enter "Hotels" in the search box
    And User press the search key
    Then User should see search results for "Hotels"

  @positive
  Scenario: Verify search results are displayed when a trending search is tapped
    When User tap the trending search "OYO Rooms"
    Then User should see search results for "OYO"

  # ---------- NEGATIVE ----------
  @negative
  Scenario: Verify no results message for an unknown keyword
    When User enter "zzzzxxxx" in the search box
    And User press the search key
    Then User should see the no results message

  @negative
  Scenario: Verify search with an empty keyword
    When User press the search key
    Then User should see the search field

  @negative
  Scenario: Verify search with special characters
    When User enter "@#$%^&*" in the search box
    And User press the search key
    Then User should see the search field