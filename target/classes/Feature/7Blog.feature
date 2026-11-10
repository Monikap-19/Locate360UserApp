Feature: User should verify the Blog (Local City Guides) functionality

  Background:
    Given User should launch the application
    And User login with email "monikaparimalam@gmail.com" and password "Monika@19"
    Then User should be on the Home screen
    When User click the menu icon
    And User click the Blog option in the menu

  # ---------- POSITIVE ----------
  @positive
  Scenario: Verify the Local City Guides page is displayed
    Then User should see the Local City Guides page

  @positive
  Scenario: Verify the guide details are displayed
    Then User should see the guide title, likes and comments

  @positive
  Scenario: Verify the existing comments are displayed
    Then User should see the comments from "Alex Rivera" and "Priya Sharma"

  @positive
  Scenario: Verify Related Local Guides are displayed
    When User scroll to Related Local Guides
    Then User should see the related guides

  @positive
  Scenario: Verify back arrow returns to the Home screen
    When User tap the back arrow on the Blog page
    Then User should be on the Home screen

  @positive @datachange
  Scenario: Verify user can like the guide
    When User tap the Likes
    Then The likes count should increase by 1

  @positive @datachange
  Scenario: Verify user can post a comment
    When User post a new comment
    Then The new comment should be displayed
    And The comments count should increase by 1

  # ---------- NEGATIVE ----------
  @negative
  Scenario: Verify Post with an empty comment
    When User tap the Post button
    Then The comments count should not change

  @negative
  Scenario: Verify Post with only spaces
    When User type " " in the comment box
    And User tap the Post button
    Then The comments count should not change


