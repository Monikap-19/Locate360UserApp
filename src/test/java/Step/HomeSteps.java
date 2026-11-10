package Step;

import org.junit.Assert;

import Base.Baseclass;
import Pom.Home;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomeSteps extends Baseclass {
	Home page;

    Home page() {
        if (page == null) {
            page = new Home(driver);
        }
        return page;
    }

  
 
    @And("User tap the home item {string}")
    public void user_tap_the_home_item(String text) {
        page().tapText(text);
    }

  
    @And("User scroll home to {string}")
    public void user_scroll_home_to(String text) {
        page().scrollTo(text);
    }

  
    @And("Home page should show {string}")
    public void home_page_should_show(String text) {
        Assert.assertTrue( text + " is not displayed",page().isTextShown(text));
    }

 
    @And("Home page should not show {string}")
    public void home_page_should_not_show(String text) {
        Assert.assertFalse( text + " is displayed",page().isTextShown(text));
    }

  
    @When("User tap the location selector")
    public void user_tap_the_location_selector() {
        page().tapLocationSelector();
    }

    @And("User select the city {string}")
    public void user_select_the_city(String city) {
        page().selectCity(city);
    }

    @And("User close the location sheet")
    public void user_close_the_location_sheet() {
        page().closeLocationSheet();
    }

  
    @When("User tap the home bell icon")
    public void user_tap_the_home_bell_icon() {
        page().tapBell();
    }

    @And("User close the home notifications popup")
    public void user_close_the_home_notifications_popup() {
        page().closeNotifications();
    }

  
    @When("User tap the home search bar")
    public void user_tap_the_home_search_bar() {
        page().tapSearchBar();
    }

    @And("User type {string} in the home search popup")
    public void user_type_in_the_home_search_popup(String text) {
        page().typeInSearch(text);
    }

   
    @When("User press Enter in the home search")
    public void user_press_enter_in_the_home_search() {
        page().pressEnter();
    }

    @And("User close the home search popup")
    public void user_close_the_home_search_popup() {
        page().closeSearchPopup();
    }

   
    @When("User tap the home logout icon")
    public void user_tap_the_home_logout_icon() {
        page().tapLogout();
    }

   
    @And("User enter the departure city {string}")
    public void user_enter_the_departure_city(String text) {
        page().enterFrom(text);
    }

    @And("User enter the destination city {string}")
    public void user_enter_the_destination_city(String text) {
        page().enterTo(text);
    }

    @And("User tap the travel Search button")
    public void user_tap_the_travel_search_button() {
        page().tapTravelSearch();
    }

   
    @And("User enter the bill mobile number {string}")
    public void user_enter_the_bill_mobile_number(String text) {
        page().enterBillMobile(text);
    }

    @And("User choose the bill amount {string}")
    public void user_choose_the_bill_amount(String amount) {
        page().chooseAmount(amount);
    }

    @Then("The pay button should show the amount {string}")
    public void the_pay_button_should_show_the_amount(String amount) {
        Assert.assertTrue( "Pay button does not show " + amount,page().isPayButtonShowing(amount));
    }

    @And("User tap the Pay Now button")
    public void user_tap_the_pay_now_button() {
        page().tapPayNow();
    }
}


