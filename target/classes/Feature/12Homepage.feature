Feature: User should verify the Home page

  Background:
    Given User should launch the application
    And User login with email "monikaparimalam@gmail.com" and password "Monika@19"
    Then User should be on the Home screen

  # ---------- POSITIVE : Home page ----------
  @positive
  Scenario: Verify the Home page main elements are displayed
    Then Home page should show "Find What You Need"
    And Home page should show "Explore Directory"
    And Home page should show "How it works"
    And Home page should show "TRENDING RIGHT NOW"
    And Home page should show "Explore by Category"

  @positive
  Scenario Outline: Verify the bottom tabs are displayed
    Then Home page should show "<tab>"

    Examples:
      | tab      |
      | Home     |
      | Services |
      | Enquiry  |
      | Movies   |
      | Account  |

  @positive
  Scenario: Verify the trending chips are displayed
    Then Home page should show "Mobile repair"
    And Home page should show "Pizza delivery"
    And Home page should show "Car wash"
    And Home page should show "Dentist"
    And Home page should show "Spa packages"

  @positive
  Scenario: Verify a trending chip can be tapped
    When User tap the home item "Mobile repair"
    Then Home page should not show "TRENDING RIGHT NOW"

  # ---------- POSITIVE : Location ----------
  @positive
  Scenario: Verify the Select Your City or Area sheet is displayed
    When User tap the location selector
    Then Home page should show "Select Your City / Area"
    And Home page should show "Use GPS High Accuracy Location"
    And Home page should show "Popular Cities"
    And Home page should show "Westside Coast"
    And Home page should show "Mumbai"
    And Home page should show "New York"

  @positive
  Scenario: Verify user can select a city
    When User tap the location selector
    And User select the city "Chennai"
    Then Home page should not show "Select Your City / Area"
    And Home page should show "Chennai"

  @positive
  Scenario: Verify the location sheet is closed using the close icon
    When User tap the location selector
    And User close the location sheet
    Then Home page should not show "Select Your City / Area"
    And Home page should show "Downtown Center"

  # ---------- POSITIVE : Notifications ----------
  @positive
  Scenario: Verify the notifications popup is displayed
    When User tap the home bell icon
    Then Home page should show "View All Notifications"
    And Home page should show "Item added to saved items"

  @positive
  Scenario: Verify the notifications popup is closed using the close icon
    When User tap the home bell icon
    And User close the home notifications popup
    Then Home page should not show "View All Notifications"

  @positive
  Scenario: Verify View All Notifications opens the Notifications page
    When User tap the home bell icon
    And User tap the home item "View All Notifications"
    Then Home page should show "Total Notifications"

  # ---------- POSITIVE : Search ----------
  @positive
  Scenario: Verify the search popup is displayed
    When User tap the home search bar
    Then Home page should show "Recent Searches"
    And Home page should show "Trending Searches"
    And Home page should show "OYO Rooms"
    And Home page should show "Popular Categories"

  @positive
  Scenario: Verify user can type in the search popup
    When User tap the home search bar
    And User type "Hotels" in the home search popup
    Then Home page should show "Hotels"

  @positive
  Scenario: Verify the search popup is closed using the close icon
    When User tap the home search bar
    And User close the home search popup
    Then Home page should not show "Recent Searches"

  # ---------- POSITIVE : Logout ----------
  @positive
  Scenario: Verify the logout popup is displayed
    When User tap the home logout icon
    Then Home page should show "Are you sure you want to logout?"
    And Home page should show "Cancel"
    And Home page should show "Yes, Logout"

  @positive
  Scenario: Verify user can logout
    When User tap the home logout icon
    And User tap the home item "Yes, Logout"
    Then Home page should show "Welcome Back"

  # ---------- POSITIVE : Cards and sections ----------
  @positive
  Scenario: Verify Explore Directory opens the Services directory
    When User tap the home item "Explore Directory"
    Then Home page should show "All Services Directory"

  @positive
  Scenario: Verify the Explore by Category section is displayed
    Then Home page should show "Pavithran"
    And Home page should show "Saloon"
    And Home page should show "View all"

  @positive
  Scenario: Verify View all opens the Services directory
    When User tap the home item "View all"
    Then Home page should show "All Services Directory"

  @positive
  Scenario: Verify the Instant Services cards are displayed
    When User scroll home to "Instant Services at Your Fingertips"
    Then Home page should show "Bills & Recharge"
    And Home page should show "Travel & Stays"
    And Home page should show "Tourist Sightseeing"

  @positive
  Scenario: Verify the Featured Services section is displayed
    When User scroll home to "Featured Services"
    Then Home page should show "Featured Services"

  @positive
  Scenario: Verify the Verified Businesses are displayed
    When User scroll home to "Verified Businesses Near You"
    Then Home page should show "Spark Mobile Shop"
    And Home page should show "Kiaq Technologies"
    And Home page should show "Azure Wellness Hub"
    And Home page should show "Elite Roast & Co"
    And Home page should show "Show All Nearby Places"

  @positive
  Scenario: Verify the membership offer is displayed
    When User scroll home to "Upgrade Membership"
    Then Home page should show "Get Exclusive Deals on Locate 360"

  # ---------- POSITIVE : Stays and Travel ----------
  @positive
  Scenario: Verify Book Travel opens the Plan Your Journey page
    When User scroll home to "Book Travel"
    And User tap the home item "Book Travel"
    Then Home page should show "Plan Your Journey"
    And Home page should show "Enter departure city"
    And Home page should show "Enter destination city"

  @positive
  Scenario: Verify the travel modes are displayed
    When User scroll home to "Book Travel"
    And User tap the home item "Book Travel"
    Then Home page should show "Bus"
    And Home page should show "Train"
    And Home page should show "Flight"
    And Home page should show "Hotels"

  @positive
  Scenario: Verify user can enter the departure and destination cities
    When User scroll home to "Book Travel"
    And User tap the home item "Book Travel"
    And User enter the departure city "Chennai"
    And User enter the destination city "Mumbai"
    Then Home page should show "Chennai"
    And Home page should show "Mumbai"

  # ---------- POSITIVE : Bills and Recharge ----------
  @positive
  Scenario: Verify Pay Bills opens the Pay Mobile Bill page
    When User scroll home to "Pay Bills"
    And User tap the home item "Pay Bills"
    Then Home page should show "Pay Mobile Bill"
    And Home page should show "Select Operator / Board"
    And Home page should show "Airtel"

  @positive
  Scenario Outline: Verify the bill types are displayed and can be selected
    When User scroll home to "Pay Bills"
    And User tap the home item "Pay Bills"
    And User tap the home item "<type>"
    Then Home page should show "Pay <type> Bill"

    Examples:
      | type        |
      | Electricity |
      | DTH         |
      | Gas         |
      | Water       |

  @positive
  Scenario Outline: Verify the amount can be selected
    When User scroll home to "Pay Bills"
    And User tap the home item "Pay Bills"
    And User choose the bill amount "<amount>"
    Then The pay button should show the amount "<amount>"

    Examples:
      | amount |
      | 25     |
      | 45     |
      | 80     |
      | 120    |

  # ---------- POSITIVE : Tourist ----------
  @positive
  Scenario: Verify Explore opens the tourist places page
    When User scroll home to "Tourist Sightseeing"
    And User tap the home item "Explore"
    Then Home page should show "Explore Top Tourist Places"

  # ---------- NEGATIVE ----------
  @negative
  Scenario: Verify Cancel on the logout popup keeps the user on Home
    When User tap the home logout icon
    And User tap the home item "Cancel"
    Then Home page should not show "Are you sure you want to logout?"
    And Home page should show "Find What You Need"

  @negative
  Scenario: Verify search with an empty keyword
    When User tap the home search bar
    And User press Enter in the home search
    Then Home page should show "Recent Searches"

  @negative
  Scenario: Verify search with special characters
    When User tap the home search bar
    And User type "@#$%^&*" in the home search popup
    And User press Enter in the home search
    Then Home page should show "Recent Searches"

  @negative
  Scenario: Verify the location stays the same when no city is chosen
    When User tap the location selector
    And User close the location sheet
    Then Home page should show "Downtown Center"

  @negative
  Scenario: Verify Travel Search with empty cities stays on the page
    When User scroll home to "Book Travel"
    And User tap the home item "Book Travel"
    And User tap the travel Search button
    Then Home page should show "Plan Your Journey"

  @negative
  Scenario: Verify Travel Search with the same departure and destination
    When User scroll home to "Book Travel"
    And User tap the home item "Book Travel"
    And User enter the departure city "Chennai"
    And User enter the destination city "Chennai"
    And User tap the travel Search button
    Then Home page should show "Plan Your Journey"

  @negative
  Scenario Outline: Verify Pay with an invalid mobile number
    When User scroll home to "Pay Bills"
    And User tap the home item "Pay Bills"
    And User enter the bill mobile number "<mobile>"
    And User tap the Pay Now button
    Then Home page should show "Pay Mobile Bill"

    Examples:
      | mobile     |
      |            |
      | 123        |
      | abcdefghij |
      | @#$%^&*()! |
