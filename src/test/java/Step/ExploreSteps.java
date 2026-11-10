package Step;

import org.junit.Assert;

import Base.Baseclass;
import Pom.Explore;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ExploreSteps extends Baseclass {
	Explore page;

	Explore page() {
		if (page == null) {
			page = new Explore(driver);
		}
		return page;
	}

	@And("User click the Explore option in the menu")
	public void user_click_the_explore_option_in_the_menu() {
		page().clickExploreOption();
	}

	@Then("User should see the Explore Top Tourist Places page")
	public void user_should_see_the_explore_page() {
		Assert.assertTrue("Explore Top Tourist Places page not displayed", page().isExplorePageShown());
	}

	@And("User should see the place {string}")
	public void user_should_see_the_place(String name) {
		Assert.assertTrue(name + " not displayed", page().isTextShown(name));
	}

	@And("User should not see the place {string}")
	public void user_should_not_see_the_place(String name) {
		Assert.assertFalse(name + " is displayed", page().isTextShown(name));
	}

	@And("User should see the places found count")
	public void user_should_see_the_places_found_count() {
		Assert.assertTrue("Places Found count not displayed", page().isPlacesFoundShown());
	}

	@Then("User should see the category filters")
	public void user_should_see_the_category_filters() {
		Assert.assertTrue("Category filters not displayed", page().areFiltersShown());
	}

	@When("User search the place {string}")
	public void user_search_the_place(String text) {
		page().searchPlace(text);
	}

	@When("User tap the {string} filter1")
	public void user_tap_the_filter(String name) {
		page().tapFilter(name);
	}

	@When("User tap Back on the Explore page")
	public void user_tap_back_on_the_explore_page() {
		page().tapBack();
	}

	@When("User tap Get Route on the first place")
	public void user_tap_get_route_on_the_first_place() {
		page().tapFirstGetRoute();
	}

	@Then("User should see the Directions page for {string}")
	public void user_should_see_the_directions_page_for(String place) {
		Assert.assertTrue("Directions page for " + place + " not displayed", page().isDirectionsShown(place));
	}

	@Then("User should see Drive, Ride and Walk options")
	public void user_should_see_drive_ride_and_walk_options() {
		Assert.assertTrue("Drive, Ride or Walk option not displayed", page().areRouteOptionsShown());
	}

	@And("User should see the Start button")
	public void user_should_see_the_start_button() {
		Assert.assertTrue("Start button not displayed", page().isStartShown());
	}

	@And("User scroll to Turn-by-turn navigation")
	public void user_scroll_to_turn_by_turn_navigation() {
		page().scrollToTurnByTurn();
	}

	@Then("User should see the turn-by-turn steps")
	public void user_should_see_the_turn_by_turn_steps() {
		Assert.assertTrue("Turn-by-turn steps not displayed", page().areTurnByTurnStepsShown());
	}

	@And("User tap Back to the place")
	public void user_tap_back_to_the_place() {
		page().tapBackToPlace();
	}
}
