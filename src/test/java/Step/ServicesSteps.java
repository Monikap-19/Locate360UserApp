package Step;

import org.junit.Assert;

import Base.Baseclass;
import Pom.Services;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ServicesSteps extends Baseclass {
	Services page;

	Services page() {
		if (page == null) {
			page = new Services(driver);
		}
		return page;
	}

	@When("User go to the Services page")
	public void user_go_to_the_services_page() {
		page().tapServicesTab();
	}

	@When("User search for {string} in the services")
	public void user_search_for_in_the_services(String text) {
		page().search(text);
	}

	@When("User tap Reset in the services")
	public void user_tap_reset_in_the_services() {
		page().tapReset();
	}

	@When("User open the services category list")
	public void user_open_the_services_category_list() {
		page().openCategoryList();
	}

	@When("User choose the services category {string}")
	public void user_choose_the_services_category(String name) {
		page().chooseCategory(name);
	}

	@When("User switch to the {string} view")
	public void user_switch_to_the_view(String name) {
		page().switchView(name);
	}

	@When("User tap Call Now of the first service")
	public void user_tap_call_now_of_the_first_service() {
		page().tapFirstCallNow();
	}

	@When("User tap Details of the first service")
	public void user_tap_details_of_the_first_service() {
		page().tapFirstDetails();
	}

	@When("User tap Send Enquiry")
	public void user_tap_send_enquiry() {
		page().tapSendEnquiry();
	}

	@When("User tap My Enquiry")
	public void user_tap_my_enquiry() {
		page().tapMyEnquiry();
	}

	@When("User tap Chat")
	public void user_tap_chat() {
		page().tapChat();
	}

	@When("User tap Directions")
	public void user_tap_directions() {
		page().tapDirections();
	}

	@When("User tap Book Now")
	public void user_tap_book_now() {
		page().tapBookNow();
	}

	@When("User close the Send Enquiry form")
	public void user_close_the_send_enquiry_form() {
		page().closeEnquiry();
	}

	@When("User enter enquiry name {string}")
	public void user_enter_enquiry_name(String text) {
		page().enterName(text);
	}

	@When("User enter enquiry mobile {string}")
	public void user_enter_enquiry_mobile(String text) {
		page().enterMobile(text);
	}

	@When("User enter enquiry email {string}")
	public void user_enter_enquiry_email(String text) {
		page().enterEmail(text);
	}

	@When("User enter enquiry title {string}")
	public void user_enter_enquiry_title(String text) {
		page().enterTitle(text);
	}

	@When("User enter enquiry budget {string}")
	public void user_enter_enquiry_budget(String text) {
		page().enterBudget(text);
	}

	@When("User enter enquiry urgency {string}")
	public void user_enter_enquiry_urgency(String text) {
		page().enterUrgency(text);
	}

	@When("User enter enquiry location {string}")
	public void user_enter_enquiry_location(String text) {
		page().enterLocation(text);
	}

	@When("User enter enquiry description {string}")
	public void user_enter_enquiry_description(String text) {
		page().enterDescription(text);
	}

	@When("User tap Next in the enquiry")
	public void user_tap_next_in_the_enquiry() {
		page().tapNext();
	}

	@When("User tap Back in the enquiry")
	public void user_tap_back_in_the_enquiry() {
		page().tapBack();
	}

	@When("User tap Submit in the enquiry")
	public void user_tap_submit() {
		page().tapSubmit();
	}

	@Given("User go to the enquiry form step {int}")
	public void user_go_to_the_enquiry_form_step(int step) {
		page().tapFirstDetails();
		page().tapSendEnquiry();
		page().enterName("Monika");
		page().enterMobile("9876543210");
		page().enterEmail("monikaparimalam@gmail.com");
		page().tapNext();
		if (step >= 3) {
			page().enterTitle("Mobile repair");
			page().enterBudget("5000");
			page().enterUrgency("High");
			page().tapNext();
		}
		if (step >= 4) {
			page().enterLocation("Chennai");
			page().tapNext();
		}
	}

	@When("User scroll down to {string}")
	public void user_scroll_down_to(String text) {
		page().scrollTo(text);
	}

	@When("User tap Write a review")
	public void user_tap_write_a_review() {
		page().tapWriteReview();
	}

	@When("User enter the review {string}")
	public void user_enter_the_review(String text) {
		page().enterReview(text);
	}

	@When("User rate {int} stars")
	public void user_rate_stars(int stars) {
		page().rate(stars);
	}

	@When("User tap Cancel review")
	public void user_tap_cancel_review() {
		page().tapCancelReview();
	}

	@When("User tap the similar business {string}")
	public void user_tap_the_similar_business(String name) {
		page().tapSimilarBusiness(name);
	}

	@Then("Screen should show {string}")
	public void screen_should_show(String text) {
		Assert.assertTrue(text + " is not displayed", page().isTextShown(text));
	}

	@Then("Screen should not show {string}")
	public void screen_should_not_show(String text) {
		Assert.assertFalse(text + " is displayed", page().isTextShown(text));
	}
}
