package Pom;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Logout {
	AndroidDriver driver;
	WebDriverWait wait;

	public Logout(AndroidDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//*[contains(@text,'Search services')]")
	WebElement searchBar;

	@AndroidFindBy(xpath = "(//android.view.ViewGroup[@clickable='true'])[3]")
	WebElement logoutIcon;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Are you sure you want to logout?']")
	WebElement logoutTitle;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Cancel']")
	WebElement cancelButton;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Yes, Logout']")
	WebElement yesLogoutButton;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Welcome Back')]")
	WebElement signInTitle;

	public boolean isHomeDisplayed() {
		return wait.until(ExpectedConditions.visibilityOf(searchBar)).isDisplayed();
	}

	public void tapLogoutIcon() {
		wait.until(ExpectedConditions.elementToBeClickable(logoutIcon)).click();
	}

	public boolean isPopupDisplayed() {
		return wait.until(ExpectedConditions.visibilityOf(logoutTitle)).isDisplayed();
	}

	public void tapCancel() {
		wait.until(ExpectedConditions.elementToBeClickable(cancelButton)).click();
	}

	public void tapYesLogout() {
		wait.until(ExpectedConditions.elementToBeClickable(yesLogoutButton)).click();
	}

	public boolean isSignInDisplayed() {
		return wait.until(ExpectedConditions.visibilityOf(signInTitle)).isDisplayed();
	}
}
