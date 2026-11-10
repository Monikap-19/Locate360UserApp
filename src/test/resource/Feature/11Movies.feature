Feature: User should verify the Movie ticket booking

  Background:
    Given User should launch the application
    And User login with email "monikap.kiaq@gmail.com" and password "Monika@19"
    Then User should be on the Home screen
    When User tap the Movies tab in the bottom bar
    And User tap the movie "Jailer 2"

  # ---------- POSITIVE ----------
  @positive
  Scenario: Verify the Cinema Tickets time page is displayed
    Then User should see the Cinema Tickets page
    And User should see the text "PVR Cinema Downtown"
    And User should see the text "INOX Megaplex"

  @positive @datachange
  Scenario: Verify user can book a ticket from date to dashboard
    When User select the date "10"
    And User select the showtime "04:30 PM"
    And User tap Continue to Seat Selection
    And User select the seat "E4"
    And User select the seat "F3"
    Then The selected seats should be "E4, F3"
    When User tap Add Snacks
    And User add the snack "Popcorn (Medium)"
    And User add the snack "Coke (Large)"
    And User tap Continue to Payment
    And User select the payment method "UPI Instant"
    And User tap Confirm and Pay
    Then User should see the ticket page
    When User tap Save Ticket to Dashboard
    Then User should see the movie page

  @positive
  Scenario: Verify the seat price is displayed for the selected seats
    Given User go to the seat selection page
    When User select the seat "E4"
    And User select the seat "F3"
    Then The seat price should be "400 (2 Seats)"

  @positive
  Scenario: Verify Back on the seat page returns to the time page
    Given User go to the seat selection page
    When User tap Back
    Then User should see the text "Select Theater & Showtime"

  @positive
  Scenario: Verify the booking summary on the snacks page
    Given User go to the snacks page
    Then User should see the text "INOX Megaplex"
    And User should see the text "NOV 10 @ 04:30 PM"
    And User should see the text "E4, F3"
    And The total amount should be "430.00"

  @positive
  Scenario: Verify the snack quantity increases when Add is tapped
    Given User go to the snacks page
    When User add the snack "Popcorn (Medium)"
    Then User should see the text "Quantity: 1"

  @positive
  Scenario: Verify the total payable on the payment page
    Given User go to the payment page
    Then User should see the text "Secure Checkout"
    And The total payable should be "830.00"

  # ---------- NEGATIVE ----------
  @negative
  Scenario: Verify Continue without selecting a showtime
    When User tap Continue to Seat Selection
    Then User should see the text "Select Theater & Showtime"

  @negative
  Scenario: Verify Add Snacks without selecting a seat
    Given User go to the seat selection page
    When User tap Add Snacks
    Then User should see the text "SCREEN THIS WAY"

  @negative
  Scenario: Verify a booked seat cannot be selected
    Given User go to the seat selection page
    When User select the seat "C3"
    Then The seat "C3" should not be selected

  @negative
  Scenario: Verify an invalid promo code does not change the total
    Given User go to the payment page
    When User enter the promo code "INVALID123"
    And User tap Apply
    Then The total payable should be "830.00"

  @negative
  Scenario: Verify Apply with an empty promo code does not change the total
    Given User go to the payment page
    When User tap Apply
    Then The total payable should be "830.00"