package Pom;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class forgotpassword {
	 AndroidDriver driver;

	    public forgotpassword(AndroidDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	    }

	
	    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Forgot Password?']")
	    WebElement forgotPasswordLink;

	    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Welcome Back')]")
	    List<WebElement> signInTitle;

	  
	    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Enter your registered email')]")
	    List<WebElement> forgotPasswordText;

	    @AndroidFindBy(xpath = "//android.widget.EditText")
	    WebElement emailField;

	    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Continue']")
	    WebElement continueButton;

	    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Back']")
	    WebElement backButton;

	 
	    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Verification Code']")
	    List<WebElement> verificationTitle;

	    @AndroidFindBy(xpath = "//android.widget.EditText")
	    List<WebElement> otpBoxes;

	    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Verify']")
	    WebElement verifyButton;

	    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Registration email not found']")
	    List<WebElement> emailNotFoundError;

	
	    public void tapForgotPasswordLink() {
	        forgotPasswordLink.click();
	    }

	    public boolean isForgotPasswordScreenShown() {
	        return !forgotPasswordText.isEmpty();
	    }

	    public void enterEmail(String email) {
	        emailField.clear();
	        emailField.sendKeys(email);
	    }

	    public void tapContinue() {
	        continueButton.click();
	    }

	    public void tapBack() {
	        backButton.click();
	    }

	    public boolean isSignInScreenShown() {
	        return !signInTitle.isEmpty();
	    }

	    public boolean isVerificationScreenShown() {
	        return !verificationTitle.isEmpty();
	    }

	    public boolean areOtpBoxesShown() {
	        return !otpBoxes.isEmpty();
	    }

	    public void tapVerify() {
	        verifyButton.click();
	    }

	    public boolean isEmailNotFoundShown() {
	        return !emailNotFoundError.isEmpty();
	    }
	}

