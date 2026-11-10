package Pom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Login {
	private final AndroidDriver driver;
	private final WebDriverWait wait;

	public Login(AndroidDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
	}

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Welcome Back')]")
	private WebElement welcomeTitle;

	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Enter email']")
	private WebElement emailField;

	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Enter password']")
	private WebElement passwordField;

	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='Sign In'])[2]")
	private WebElement signInButton;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Forgot Password?']")
	private WebElement forgotPassword;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Sign in with Google']")
	private WebElement googleButton;

	@AndroidFindBy(xpath = "(//android.widget.TextView[contains(@text,'@')])[1]")
	WebElement firstGoogleAccount;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'nauthorized')] | //android.widget.Toast[contains(@text,'nauthorized')]")
	List<WebElement> unauthorizedError;

	public boolean isLoginScreenDisplayed() {
		return wait.until(ExpectedConditions.visibilityOf(welcomeTitle)).isDisplayed();
	}

	public void enterEmail(String email) {
		wait.until(ExpectedConditions.visibilityOf(emailField)).clear();
		emailField.sendKeys(email);
	}

	public void enterPassword(String password) {
		wait.until(ExpectedConditions.visibilityOf(passwordField)).clear();
		passwordField.sendKeys(password);

	}

	public void tapSignIn() {
		wait.until(ExpectedConditions.elementToBeClickable(signInButton)).click();
	}

	public boolean isStillOnLoginScreen() {
		try {
			return welcomeTitle.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isLoginScreenGone() {
		return wait.until(ExpectedConditions.invisibilityOf(welcomeTitle));
	}

	public boolean isTextShown(String text) {
		List<WebElement> list = driver
				.findElements(By.xpath("//android.widget.TextView[contains(@text,\"" + text + "\")]"));
		return !list.isEmpty();
	}

	public void tapGoogleButton() {
		googleButton.click();
	}

	public String currentPackage() {
		return (String) driver.executeScript("mobile: getCurrentPackage");
	}

	public String screenText() {
		return driver.getPageSource();
	}

	public void tapFirstGoogleAccount() {
		firstGoogleAccount.click();
	}

	public void pressBack() {
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
	}

	public boolean isUnauthorizedShown() {
		return !unauthorizedError.isEmpty();
	}
}
