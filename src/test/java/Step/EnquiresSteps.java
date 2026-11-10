package Step;

import org.junit.Assert;

import Base.Baseclass;
import Pom.Enqires;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EnquiresSteps extends Baseclass {
	static final String APP_PACKAGE = "com.rakshanm.UserApp";

	Enqires page;
	int expectedCount;

	Enqires page() {
		if (page == null) {
			page = new Enqires(driver);
		}
		return page;
	}

	@When("User tap the Enquiry tab in the bottom bar")
	public void user_tap_the_enquiry_tab() {
		page().tapEnquiryTab();
	}

	@Then("User should see the My Enquiries and Quotes page")
	public void user_should_see_the_enquiries_page() {
		Assert.assertTrue("My Enquiries & Quotes page not displayed", page().isEnquiryPageShown());
	}

	@When("User tap the {string} enquiry filter")
	public void user_tap_the_enquiry_filter(String name) {
		expectedCount = page().filterCount(name);
		page().tapFilter(name);
	}

	@Then("The enquiries list count should match the filter count")
	public void the_enquiries_list_count_should_match() {
		Assert.assertEquals("Enquiries count does not match the filter count", page().listCount(), expectedCount);
	}

	@Then("The enquiries list count should be {int}")
	public void the_enquiries_list_count_should_be(int count) {
		Assert.assertEquals("Enquiries count is not ", page().listCount(), count);
	}

	@When("User tap the Timeline View tab")
	public void user_tap_the_timeline_view_tab() {
		page().tapTimelineTab();
	}

	@Then("User should see the timeline steps")
	public void user_should_see_the_timeline_steps() {
		String[] steps = { "Enquiry Submitted", "Under Review", "Verified", "Vendor Assigned", "Quotes Received",
				"Service Hired", "Completed" };
		for (String step : steps) {
			Assert.assertTrue(step + " not displayed in the timeline", page().isTextShown(step));
		}
	}

	@When("User tap the Vendor Responses tab")
	public void user_tap_the_vendor_responses_tab() {
		page().tapVendorTab();
	}

	@Then("User should see the Message and Call buttons")
	public void user_should_see_the_message_and_call_buttons() {
		Assert.assertTrue("Message or Call button not displayed", page().areMessageAndCallShown());
	}

	@And("User tap the Message button")
	public void user_tap_the_message_button() {
		page().tapMessage();
	}

	@Then("User should see the Messaging screen")
	public void user_should_see_the_messaging_screen() {
		Assert.assertTrue("Messaging screen not displayed", page().isMessagingShown());
	}

	@And("User tap the Call button")
	public void user_tap_the_call_button() {
		page().tapCall();
	}

	@Then("The phone dialer should open")
	public void the_phone_dialer_should_open() {
		Assert.assertNotEquals(page().currentPackage(), APP_PACKAGE, "Phone dialer did not open");
	}

	@Then("The dialer should not show the dummy number {string}")
	public void the_dialer_should_not_show_the_dummy_number(String dummy) {
		Assert.assertFalse("Dialer shows the dummy number ", page().screenText().contains(dummy));
	}
}
