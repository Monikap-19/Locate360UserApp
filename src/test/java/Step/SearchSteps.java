package Step;

import org.junit.Assert;

import Base.Baseclass;
import Pom.Search;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchSteps extends Baseclass
{

	Search page() {
        return new Search(driver);
    }

    @Then("User should see the search field")
    public void user_should_see_the_search_field() {
        Assert.assertTrue( "Search page / search field not displayed",page().isSearchFieldDisplayed());
    }

    @Then("User should see the trending search items")
    public void user_should_see_the_trending_search_items() {
        Assert.assertTrue( "Trending searches not displayed",page().areTrendingItemsDisplayed());
    }

    @Then("User should see the Recent Searches section")
    public void user_should_see_the_recent_searches_section() {
        Assert.assertTrue( "Recent Searches not displayed",page().isRecentSearchesDisplayed());
    }

    @When("User enter {string} in the search box")
    public void user_enter_in_the_search_box(String text) {
        page().enterKeyword(text);
    }

    @When("User press the search key")
    public void user_press_the_search_key() {
        page().pressSearchKey();
    }

    @When("User tap the trending search {string}")
    public void user_tap_the_trending_search(String name) {
        page().tapTrending(name);
    }

    @Then("User should see suggestions for {string}")
    public void user_should_see_suggestions_for(String keyword) {
        Assert.assertTrue( "No suggestions displayed for " + keyword,page().isKeywordTextDisplayed(keyword));
    }

    @Then("User should see search results for {string}")
    public void user_should_see_search_results_for(String keyword) {
        Assert.assertTrue( "No search results displayed for " + keyword,page().isKeywordTextDisplayed(keyword));
    }

    @Then("User should see the no results message")
    public void user_should_see_the_no_results_message() {
        Assert.assertTrue( "No results message not displayed",page().isNoResultsDisplayed());
    }
}