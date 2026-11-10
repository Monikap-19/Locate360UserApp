package Step;

import org.junit.Assert;

import Base.Baseclass;
import Pom.Login;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends Baseclass{
	 Login loginPage;

	    @Given("User should launch the application")
	    public void user_should_launch_the_application() {
	        loginPage = new Login(driver);
	        viewWait();
	        Assert.assertTrue( "Login screen not displayed",loginPage.isLoginScreenDisplayed());
	    }

	    @When("User enter the Email Address {string}")
	    public void user_enter_the_email_address(String email) {
	        loginPage.enterEmail(email);
	    }

	    @When("User enter the password {string}")
	    public void user_enter_the_password(String password) {
	        loginPage.enterPassword(password);
	    }

	    @When("User tap the Sign In button")
	    public void user_tap_the_sign_in_button() {
	        loginPage.tapSignIn();
	    }

	    @Then("User should be navigated to the dashboard")
	    public void user_should_be_navigated_to_the_dashboard() {
	    	viewWait();
	        Assert.assertTrue( "Still on login screen after valid login",loginPage.isLoginScreenGone());
	    }

	    @Then("User should see login failure and stay on the Sign In screen")
	    public void user_should_see_login_failure() {
	        Assert.assertTrue( "Login screen not displayed after invalid login",loginPage.isStillOnLoginScreen());
	    
	
	    }
	}



