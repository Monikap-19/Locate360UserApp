package Pom;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CreateAccount {
	  AndroidDriver driver;

	    public CreateAccount(AndroidDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	    }

	 
	    @AndroidFindBy(xpath = "(//android.widget.TextView[@text='Create Account'])[1]")
	    WebElement createAccountTab;

	    @AndroidFindBy(xpath = "(//android.widget.TextView[@text='Sign In'])[1]")
	    WebElement signInTab;

	  
	    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Join Locate 360']")
	    List<WebElement> joinTitle;

	
	    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Enter User Name']")
	    WebElement userNameField;

	    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Enter email']")
	    WebElement emailField;

	    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Enter password']")
	    WebElement passwordField;

	    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Enter mobile']")
	    WebElement mobileField;

	  
	    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"I agree to the Terms of Service and Privacy Policy.\"]/android.view.ViewGroup")
	    WebElement termsCheckbox;

	    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Create Account\"]")
	    WebElement createAccountButton;

	    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Sign In Instead']")
	    WebElement signInInsteadButton;

	
	    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Welcome Back')]")
	    List<WebElement> signInTitle;

	  
	    public void tapCreateAccountTab() {
	        createAccountTab.click();
	    }

	    public void tapSignInTab() {
	        signInTab.click();
	    }

	    public boolean isCreateAccountScreenShown() {
	        return !joinTitle.isEmpty();
	    }

	    public void enterUserName(String text) {
	        userNameField.sendKeys(text);
	    }

	    public void enterEmail(String text) {
	        emailField.sendKeys(text);
	    }

	    public void enterPassword(String text) {
	        passwordField.sendKeys(text);
	    }

	    public void enterMobile(String text) {
	        mobileField.sendKeys(text);
	        hideKeyboardSafely();
	    }

	    public void tickTerms() {
	        termsCheckbox.click();
	    }

	    public void tapCreateAccount() {
	        hideKeyboardSafely();
	        createAccountButton.click();
	    }

	    public void tapSignInInstead() {
	        hideKeyboardSafely();
	        signInInsteadButton.click();
	    }

	    public boolean isSignInScreenShown() {
	        return !signInTitle.isEmpty();
	    }

	    private void hideKeyboardSafely() {
	        try {
	            driver.hideKeyboard();
	        } catch (Exception e) {
	            
	        }
	    }
	}

