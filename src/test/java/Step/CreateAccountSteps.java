package Step;

import org.junit.Assert;

import Base.Baseclass;
import Pom.CreateAccount;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateAccountSteps extends Baseclass {
	CreateAccount page;

    CreateAccount page() {
        if (page == null) {
            page = new CreateAccount(driver);
        }
        return page;
    }

    @When("User tap the Create Account tab")
    public void user_tap_the_create_account_tab() {
        page().tapCreateAccountTab();
    }

    @Then("User should see the Create Account screen")
    public void user_should_see_the_create_account_screen() {
        Assert.assertTrue( "Create Account screen not displayed",page().isCreateAccountScreenShown());
    }

    @Then("User should still see the Create Account screen")
    public void user_should_still_see_the_create_account_screen() {
        Assert.assertTrue( "Create Account screen is not displayed",page().isCreateAccountScreenShown());
    }

    @Then("User should leave the Create Account screen")
    public void user_should_leave_the_create_account_screen() {
        Assert.assertFalse( "Still on the Create Account screen",page().isCreateAccountScreenShown());
    }

    @When("User enter the User Name {string}")
    public void user_enter_the_user_name(String text) {
        page().enterUserName(text);
    }

    @And("User enter the signup email {string}")
    public void user_enter_the_signup_email(String text) {
        page().enterEmail(text);
    }

   
    @And("User enter a new unique email")
    public void user_enter_a_new_unique_email() {
        page().enterEmail("auto" + System.currentTimeMillis() + "@gmail.com");
    }

    @And("User enter the signup password {string}")
    public void user_enter_the_signup_password(String text) {
        page().enterPassword(text);
    }

    @And("User enter the mobile {string}")
    public void user_enter_the_mobile(String text) {
        page().enterMobile(text);
    }

    @And("User tick the Terms of Service checkbox")
    public void user_tick_the_terms_of_service_checkbox() {
        page().tickTerms();
    }

   
    @When("User tap the Create Account button")
    public void user_tap_the_create_account_button() {
        page().tapCreateAccount();
    }

    @When("User tap the Sign In Instead button")
    public void user_tap_the_sign_in_instead_button() {
        page().tapSignInInstead();
    }

    @When("User tap the Sign In tab")
    public void user_tap_the_sign_in_tab() {
        page().tapSignInTab();
    }
}


