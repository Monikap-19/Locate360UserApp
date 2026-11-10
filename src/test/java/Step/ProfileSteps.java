package Step;

import org.junit.Assert;
import Base.Baseclass;
import Pom.Profile;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProfileSteps extends Baseclass {
	Profile page;

	Profile page() {
		if (page == null) {
			page = new Profile(driver);
		}
		return page;
	}

	@When("User tap the Account tab in the bottom bar")
	public void user_tap_the_account_tab() {
		page().tapAccountTab();
	}

	@When("User tap the account tab {string}")
	public void user_tap_the_account_tab_named(String name) {
		page().tapTab(name);
	}

	@And("User tap Edit Profile")
	public void user_tap_edit_profile() {
		page().tapEditProfile();
	}

	@And("User scroll account to {string}")
	public void user_scroll_account_to(String text) {
		page().scrollTo(text);
	}

	@And("Account page should show {string}")
	public void account_page_should_show(String text) {
		Assert.assertTrue(text + " is not displayed", page().isTextShown(text));
	}

	@And("Account page should not show {string}")
	public void account_page_should_not_show(String text) {
		Assert.assertFalse(text + " is displayed", page().isTextShown(text));
	}

	@And("The Total Bookings count should not be 0")
	public void the_total_bookings_count_should_not_be_0() {
		Assert.assertNotEquals("Total Bookings is 0 but bookings are displayed", page().getCardCount("Total Bookings"),
				0);
	}

	@When("User tap the account back arrow")
	public void user_tap_the_account_back_arrow() {
		page().tapBack();
	}

	@And("User enter the full name {string}")
	public void user_enter_the_full_name(String text) {
		page().enterFullName(text);
	}

	@And("User enter the settings email {string}")
	public void user_enter_the_settings_email(String text) {
		page().enterEmail(text);
	}

	@And("User tap Save Changes")
	public void user_tap_save_changes() {
		page().tapSave();
	}

	@Then("The Full Name field should contain {string}")
	public void the_full_name_field_should_contain(String text) {
		Assert.assertEquals(page().getFullName(), text);
	}

	@Then("The Full Name field should not contain {string}")
	public void the_full_name_field_should_not_contain(String text) {
		Assert.assertNotEquals(page().getFullName(), text, "Invalid name was accepted: " + text);
	}

	@Then("The Full Name field should not be empty")
	public void the_full_name_field_should_not_be_empty() {
		Assert.assertFalse("Full Name is empty after Save Changes", page().getFullName().isEmpty());
	}

	@Then("The Email field should contain {string}")
	public void the_email_field_should_contain(String text) {
		Assert.assertEquals(page().getEmail(), text);
	}

	@Then("The Email field should not contain {string}")
	public void the_email_field_should_not_contain(String text) {
		Assert.assertNotEquals(page().getEmail(), text, "Invalid email was accepted: " + text);
	}

	@And("User tap the switch {string}")
	public void user_tap_the_switch(String label) {
		page().tapSwitch(label);
	}

	@And("The switch {string} should be on")
	public void the_switch_should_be_on(String label) {
		Assert.assertTrue(label + " is off", page().isSwitchOn(label));
	}

	@And("The switch {string} should be off")
	public void the_switch_should_be_off(String label) {
		Assert.assertFalse(label + " is on", page().isSwitchOn(label));
	}
}
