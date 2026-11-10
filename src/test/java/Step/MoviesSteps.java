package Step;

import org.junit.Assert;

import Base.Baseclass;
import Pom.Movies;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MoviesSteps extends Baseclass {
	static final String RUPEE = "\u20B9";

	Movies page;

	Movies page() {
		if (page == null) {
			page = new Movies(driver);
		}
		return page;
	}

	@When("User tap the Movies tab in the bottom bar")
	public void user_tap_the_movies_tab() {
		page().tapMoviesTab();
	}

	@And("User tap the movie {string}")
	public void user_tap_the_movie(String name) {
		page().tapMovie();
	}

	@Then("User should see the Cinema Tickets page")
	public void user_should_see_the_cinema_tickets_page() {
		Assert.assertTrue( "Cinema Tickets page not displayed",page().isCinemaPageShown());
	}

	
	@And("User should see the text {string}")
	public void user_should_see_the_text(String text) {
		Assert.assertTrue( text + " not displayed",page().isTextShown(text));
	}

	@When("User select the date {string}")
	public void user_select_the_date(String day) {
		page().selectDate(day);
	}

	@And("User select the showtime {string}")
	public void user_select_the_showtime(String time) {
		page().selectShowtime(time);
	}

	@And("User tap Continue to Seat Selection")
	public void user_tap_continue_to_seat_selection() {
		page().tapContinueToSeats();
	}

	

	@When("User select the seat {string}")
	public void user_select_the_seat(String seat) {
		page().selectSeat(seat);
	}

	@Then("The selected seats should be {string}")
	public void the_selected_seats_should_be(String seats) {
		Assert.assertTrue( "Selected seats are not " + seats,page().isTextShown("Seats: (" + seats + ")"));
	}

	@Then("The seat price should be {string}")
	public void the_seat_price_should_be(String price) {
		Assert.assertTrue( "Seat price is not " + price,page().isTextShown(RUPEE + price));
	}

	@Then("The seat {string} should not be selected")
	public void the_seat_should_not_be_selected(String seat) {
		Assert.assertFalse( "Booked seat " + seat + " was selected",page().isTextContaining("Seats: (" + seat));
	}

	@When("User tap Add Snacks")
	public void user_tap_add_snacks() {
		page().tapAddSnacks();
	}

	@When("User tap Back")
	public void user_tap_back() {
		page().tapBack();
	}

	@When("User add the snack {string}")
	public void user_add_the_snack(String name) {
		page().addSnack(name);
	}

	@Then("The total amount should be {string}")
	public void the_total_amount_should_be(String amount) {
		Assert.assertTrue( "Total amount is not " + amount,page().isTextShown(RUPEE + amount));
	}

	@And("User tap Continue to Payment")
	public void user_tap_continue_to_payment() {
		page().tapContinueToPayment();
	}

	@And("User select the payment method {string}")
	public void user_select_the_payment_method(String name) {
		page().selectPayment(name);
	}

	@When("User enter the promo code {string}")
	public void user_enter_the_promo_code(String code) {
		page().enterPromo(code);
	}


	@When("User tap Apply")
	public void user_tap_apply() {
		page().tapApply();
	}

	@Then("The total payable should be {string}")
	public void the_total_payable_should_be(String amount) {
		Assert.assertTrue( "Total payable is not " + amount,page().isTextShown(RUPEE + amount));
	}

	@And("User tap Confirm and Pay")
	public void user_tap_confirm_and_pay() {
		page().tapConfirmAndPay();
	}

	@Then("User should see the ticket page")
	public void user_should_see_the_ticket_page() {
		Assert.assertTrue( "Ticket page not displayed",page().isTicketShown());
	}

	@When("User tap Save Ticket to Dashboard")
	public void user_tap_save_ticket_to_dashboard() {
		page().tapSaveTicket();
	}

	@Then("User should see the movie page")
	public void user_should_see_the_movie_page() {
		Assert.assertTrue( "Movie page not displayed",page().isMoviePageShown());
	}

	@Given("User go to the seat selection page")
	public void user_go_to_the_seat_selection_page() {
		page().selectDate("10");
		page().selectShowtime("04:30 PM");
		page().tapContinueToSeats();
	}

	@Given("User go to the snacks page")
	public void user_go_to_the_snacks_page() {
		user_go_to_the_seat_selection_page();
		page().selectSeat("E4");
		page().selectSeat("F3");
		page().tapAddSnacks();
	}

	@Given("User go to the payment page")
	public void user_go_to_the_payment_page() {
		user_go_to_the_snacks_page();
		page().addSnack("Popcorn (Medium)");
		page().addSnack("Coke (Large)");
		page().tapContinueToPayment();
	}
}
