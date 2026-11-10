package Pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Explore {
	AndroidDriver driver;

	public Explore(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Geolocation Platform']/following::android.widget.TextView[@text='Explore'][1]")
	WebElement exploreOption;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Explore Top Tourist Places']")
	List<WebElement> pageTitle;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Back']")
	WebElement backButton;

	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Search for places']")
	WebElement searchBox;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='All Places']")
	List<WebElement> allPlacesFilter;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Historical']")
	List<WebElement> historicalFilter;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Monument']")
	List<WebElement> monumentFilter;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Palace']")
	List<WebElement> palaceFilter;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Places Found')]")
	List<WebElement> placesFoundText;

	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='Get Route'])[1]")
	WebElement firstGetRoute;

	@AndroidFindBy(xpath = "//android.widget.TextView[starts-with(@text,'Directions to')]")
	List<WebElement> directionsTitle;

	@AndroidFindBy(xpath = "//android.widget.TextView[starts-with(@text,'Back to')]")
	WebElement backToPlace;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Drive']")
	List<WebElement> driveOption;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Ride']")
	List<WebElement> rideOption;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Walk']")
	List<WebElement> walkOption;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Start']")
	List<WebElement> startButton;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='TURN-BY-TURN NAVIGATION']")
	List<WebElement> turnByTurnTitle;

	@AndroidFindBy(xpath = "//android.widget.TextView[starts-with(@text,'Start navigation to')]")
	List<WebElement> step1;

	@AndroidFindBy(xpath = "//android.widget.TextView[starts-with(@text,'Arrive at')]")
	List<WebElement> arriveStep;

	public void clickExploreOption() {
		exploreOption.click();
	}

	public boolean isExplorePageShown() {
		return !pageTitle.isEmpty();
	}

	public boolean isTextShown(String text) {
		return !driver.findElements(By.xpath("//android.widget.TextView[@text='" + text + "']")).isEmpty();
	}

	public boolean isPlacesFoundShown() {
		return !placesFoundText.isEmpty();
	}

	public boolean areFiltersShown() {
		return !allPlacesFilter.isEmpty() && !historicalFilter.isEmpty() && !monumentFilter.isEmpty()
				&& !palaceFilter.isEmpty();
	}

	public void tapFilter(String name) {
		driver.findElement(By.xpath("//android.widget.TextView[@text='" + name + "']")).click();
	}

	public void searchPlace(String text) {
		searchBox.sendKeys(text);
		try {
			driver.hideKeyboard();
		} catch (Exception e) {

		}
	}

	public void tapBack() {
		backButton.click();
	}

	public void tapFirstGetRoute() {
		firstGetRoute.click();
	}

	public boolean isDirectionsShown(String place) {
		return !driver.findElements(By.xpath("//android.widget.TextView[@text='Directions to " + place + "']"))
				.isEmpty();
	}

	public boolean areRouteOptionsShown() {
		return !driveOption.isEmpty() && !rideOption.isEmpty() && !walkOption.isEmpty();
	}

	public boolean isStartShown() {
		return !startButton.isEmpty();
	}

	public void tapBackToPlace() {
		backToPlace.click();
	}

	public void scrollToTurnByTurn() {
		driver.findElement(
				AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView("
						+ "new UiSelector().text(\"TURN-BY-TURN NAVIGATION\"))"));
	}

	public boolean areTurnByTurnStepsShown() {
		return !turnByTurnTitle.isEmpty() && !step1.isEmpty() && !arriveStep.isEmpty();
	}
}
