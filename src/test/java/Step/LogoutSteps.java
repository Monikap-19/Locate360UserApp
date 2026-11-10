package Step;

import org.junit.Assert;

import Base.Baseclass;
import Pom.Login;
import Pom.Logout;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogoutSteps extends Baseclass {
	Logout homePage;

    @And("User login with email {string} and password {string}")
    public void user_login_with_email_and_password(String email, String password) {
        Login loginPage = new Login(driver);
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.tapSignIn();
        homePage = new Logout(driver);
    }

    @Then("User should be on the Home screen")
    public void user_should_be_on_the_home_screen() {
        Assert.assertTrue( "Home screen not displayed",homePage.isHomeDisplayed());
    }

    @When("User tap the logout icon")
    public void user_tap_the_logout_icon() {
        homePage.tapLogoutIcon();
    }

    @Then("User should see the logout confirmation popup")
    public void user_should_see_the_logout_confirmation_popup() {
        Assert.assertTrue( "Logout popup not displayed",homePage.isPopupDisplayed());
    }

    @And("User tap the Yes, Logout button")
    public void user_tap_the_yes_logout_button() {
        homePage.tapYesLogout();
    }

    @And("User tap the Cancel button")
    public void user_tap_the_cancel_button() {
        homePage.tapCancel();
    }

    @Then("User should be navigated to the Sign In screen")
    public void user_should_be_navigated_to_the_sign_in_screen() {
        Assert.assertTrue( "Sign In screen not displayed after logout",homePage.isSignInDisplayed());
    }
}
 
