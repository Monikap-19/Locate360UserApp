Feature: User should verify the Services page, Details and Send Enquiry flow

  Background:
    Given User should launch the application
    And User login with email "monikap.kiaq@gmail.com" and password "Monika@19"
    Then User should be on the Home screen
    When User go to the Services page

  # ---------- POSITIVE : Services page ----------
  @positive
  Scenario: Verify the search bar and categories are displayed
    Then Screen should show "All Services Directory"
    And Screen should show "What are you looking for?"
    And Screen should show "Browse Categories"
    And Screen should show "All Categories"

  @positive
  Scenario: Verify search shows only the matching service
    When User search for "Hariharan" in the services
    Then Screen should show "Hariharan"
    And Screen should not show "Travel Business"

  @positive
  Scenario: Verify Reset clears the search
    When User search for "Hariharan" in the services
    And User tap Reset in the services
    Then Screen should show "Travel Business"

  @positive
  Scenario: Verify the category list is displayed and a category can be selected
    When User open the services category list
    Then Screen should show "CAT-2026-001"
    And Screen should show "CAT-2026-002"
    When User choose the services category "CAT-2026-001"
    Then Screen should show "CAT-2026-001"

  @positive
  Scenario: Verify the Grid and List views
    When User switch to the "List" view
    Then Screen should show "Hariharan"
    When User switch to the "Grid" view
    Then Screen should show "Hariharan"

  @positive
  Scenario: Verify Call Now opens the call screen
    When User tap Call Now of the first service
    Then Screen should show "Other contact options"
    And Screen should show "Primary line"

  @positive
  Scenario: Verify Details opens the service details page
    When User tap Details of the first service
    Then Screen should show "About this Business"
    And Screen should show "Send Enquiry"
    And Screen should show "My Enquiry"
    And Screen should show "Chat"
    And Screen should show "Directions"
    And Screen should show "Book Now"

  # ---------- POSITIVE : Send Enquiry steps 1 to 4 ----------
  @positive
  Scenario: Verify the Send Enquiry form opens on Step 1
    When User tap Details of the first service
    And User tap Send Enquiry
    Then Screen should show "Step 1: Contact Information"

  @positive
  Scenario: Verify user can go through all 4 steps with Next and Back
    Given User go to the enquiry form step 4
    Then Screen should show "Step 4: Additional Requirements & Description"
    When User tap Back in the enquiry
    Then Screen should show "Step 3: Location Details"
    When User tap Back in the enquiry
    Then Screen should show "Step 2: Service Requirements"
    When User tap Back in the enquiry
    Then Screen should show "Step 1: Contact Information"

  @positive @datachange
  Scenario: Verify user can submit the enquiry
    When User tap Details of the first service
    And User tap Send Enquiry
    And User enter enquiry name "Monika"
    And User enter enquiry mobile "9876543210"
    And User enter enquiry email "monikaparimalam@gmail.com"
    And User tap Next in the enquiry
    And User enter enquiry title "Mobile repair"
    And User enter enquiry budget "5000"
    And User enter enquiry urgency "High"
    And User tap Next in the enquiry
    And User enter enquiry location "Chennai"
    And User tap Next in the enquiry
    And User enter enquiry description "Screen is broken, need repair"
    And User tap Submit in the enquiry
    Then Screen should not show "Step 4: Additional Requirements & Description"

  @positive
  Scenario: Verify the Send Enquiry form is closed with the close icon
    When User tap Details of the first service
    And User tap Send Enquiry
    And User close the Send Enquiry form
    Then Screen should not show "Step 1: Contact Information"

  # ---------- POSITIVE : Details page buttons ----------
  @positive
  Scenario: Verify My Enquiry button works
    When User tap Details of the first service
    And User tap My Enquiry
    Then Screen should show "Home"

  @positive
  Scenario: Verify Call Now on the details page opens the call screen
    When User tap Details of the first service
    And User tap Call Now of the first service
    Then Screen should show "Other contact options"

  @positive
  Scenario: Verify Chat opens the messaging screen
    When User tap Details of the first service
    And User tap Chat
    Then Screen should show "Secure conversation"

  @positive
  Scenario: Verify Directions opens the directions page
    When User tap Details of the first service
    And User tap Directions
    Then Screen should show "Directions to Hariharan"
    And Screen should show "TURN-BY-TURN NAVIGATION"

  @positive
  Scenario: Verify Book Now shows the appointment form
    When User tap Details of the first service
    And User tap Book Now
    Then Screen should show "Book an Appointment"

  @positive @datachange
  Scenario: Verify user can write a review with a rating
    When User tap Details of the first service
    And User scroll down to "Customer Reviews"
    And User tap Write a review
    And User enter the review "Good service"
    And User rate 5 stars
    And User tap Submit in the enquiry
    Then Screen should not show "Write a Review"

  @positive
  Scenario: Verify a similar business can be opened
    When User tap Details of the first service
    And User scroll down to "Similar businesses near you"
    And User tap the similar business "Travel Business"
    Then Screen should show "About this Business"

  # ---------- NEGATIVE ----------
  @negative
  Scenario: Verify search with an unknown service
    When User search for "zzzzxxxx" in the services
    Then Screen should not show "Hariharan"
    And Screen should not show "Travel Business"

  @negative
  Scenario: Verify search with special characters
    When User search for "@#$%^&*" in the services
    Then Screen should not show "Hariharan"

  @negative
  Scenario: Verify the call screen does not show Phone unavailable
    When User tap Call Now of the first service
    Then Screen should not show "Phone unavailable"

  @negative
  Scenario: Verify the directions page does not show Distance unavailable
    When User tap Details of the first service
    And User tap Directions
    Then Screen should not show "Distance unavailable"

  @negative
  Scenario: Verify Step 1 Next with all fields empty
    When User tap Details of the first service
    And User tap Send Enquiry
    And User tap Next in the enquiry
    Then Screen should show "Step 1: Contact Information"

  @negative
  Scenario: Verify Step 1 Next with an invalid email
    When User tap Details of the first service
    And User tap Send Enquiry
    And User enter enquiry name "Monika"
    And User enter enquiry mobile "9876543210"
    And User enter enquiry email "monikaparimalam"
    And User tap Next in the enquiry
    Then Screen should show "Step 1: Contact Information"

  @negative
  Scenario: Verify Step 1 Next with an invalid mobile number
    When User tap Details of the first service
    And User tap Send Enquiry
    And User enter enquiry name "Monika"
    And User enter enquiry mobile "abc"
    And User enter enquiry email "monikaparimalam@gmail.com"
    And User tap Next in the enquiry
    Then Screen should show "Step 1: Contact Information"

  @negative
  Scenario: Verify Step 2 Next with all fields empty
    Given User go to the enquiry form step 2
    When User tap Next in the enquiry
    Then Screen should show "Step 2: Service Requirements"

  @negative
  Scenario: Verify Step 3 Next with an empty location
    Given User go to the enquiry form step 3
    When User tap Next in the enquiry
    Then Screen should show "Step 3: Location Details"

  @negative
  Scenario: Verify Step 4 Submit with an empty description
    Given User go to the enquiry form step 4
    When User tap Submit in the enquiry
    Then Screen should show "Step 4: Additional Requirements & Description"

  @negative
  Scenario: Verify Submit review with an empty review
    When User tap Details of the first service
    And User scroll down to "Customer Reviews"
    And User tap Write a review
    And User tap Submit in the enquiry
    Then Screen should show "Write a Review"

  @negative
  Scenario: Verify Cancel closes the review form
    When User tap Details of the first service
    And User scroll down to "Customer Reviews"
    And User tap Write a review
    And User tap Cancel review
    Then Screen should not show "Write a Review"
