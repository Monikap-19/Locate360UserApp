package Step;

import org.junit.Assert;

import Base.Baseclass;
import Pom.forgotpassword;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ForgotpassSteps extends Baseclass {
	 forgotpassword page;

	    forgotpassword page() {
	        if (page == null) {
	            page = new forgotpassword(driver);
	        }
	        return page;
	    }

	    @When("User tap the Forgot Password link")
	    public void user_tap_the_forgot_password_link() {
	        page().tapForgotPasswordLink();
	    }

	    @Then("User should see the Forgot Password screen")
	    public void user_should_see_the_forgot_password_screen() {
	        Assert.assertTrue( "Forgot Password screen not displayed",page().isForgotPasswordScreenShown());
	    }

	    @Then("User should still see the Forgot Password screen")
	    public void user_should_still_see_the_forgot_password_screen() {
	        Assert.assertTrue( "Forgot Password screen is not displayed",page().isForgotPasswordScreenShown());
	    }

	    @When("User enter the email {string} on the Forgot Password screen")
	    public void user_enter_the_email(String email) {
	        page().enterEmail(email);
	    }

	   
	    @When("User tap the Continue button")
	    public void user_tap_the_continue_button() {
	        page().tapContinue();
	    }

	    @When("User tap the Back button")
	    public void user_tap_the_back_button() {
	        page().tapBack();
	    }

	    @Then("User should see the Sign In screen")
	    public void user_should_see_the_sign_in_screen() {
	        Assert.assertTrue( "Sign In screen not displayed",page().isSignInScreenShown());
	    }

	    @Then("User should see the Verification Code screen")
	    public void user_should_see_the_verification_code_screen() {
	        Assert.assertTrue( "Verification Code screen not displayed",page().isVerificationScreenShown());
	    }

	    @Then("User should still see the Verification Code screen")
	    public void user_should_still_see_the_verification_code_screen() {
	        Assert.assertTrue( "Verification Code screen is not displayed",page().isVerificationScreenShown());
	    }

	    @And("User should see the 6 OTP boxes")
	    public void user_should_see_the_6_otp_boxes() {
	        Assert.assertTrue( "OTP boxes not displayed",page().areOtpBoxesShown());
	    }

	    @And("User tap the Verify button")
	    public void user_tap_the_verify_button() {
	        page().tapVerify();
	    }

	    @Then("User should see the error {string}")
	    public void user_should_see_the_error(String message) {
	        Assert.assertTrue( message + " not displayed",page().isEmailNotFoundShown());
	    }

	    @And("User should not see the error {string}")
	    public void user_should_not_see_the_error(String message) {
	        Assert.assertFalse( " is displayed for a registered email",page().isEmailNotFoundShown());
	    }
	}



