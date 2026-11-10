package Base;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Baseclass {
	public static AndroidDriver driver;
	public static WebDriverWait wait;

	public static AndroidDriver BrowserLaunch() throws MalformedURLException {
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("Android");
		options.setAutomationName("UiAutomator2");
		options.setDeviceName("Pixel_4_API_36");
		options.setUdid("emulator-5554");
		options.setApp("C:\\apk\\UserApp.apk");
		options.setAppPackage("com.rakshanm.UserApp");
		options.setAppActivity("com.rakshanm.UserApp.MainActivity");
		options.setAutoGrantPermissions(true);
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		System.out.println("UserApp launch successfully!!!");
		return driver;
	}

	public static void closeApp() {
		if (driver != null) {
			driver.quit();
			
		}
	}

	public static boolean isDisplayed(WebElement e) {
		try {
			return e.isDisplayed();
		} catch (Exception e1) {
			return false;
		}
	}

	public void click(WebElement e) {
		wait.until(ExpectedConditions.elementToBeClickable(e));
		e.click();

	}

	public static void sendKeys(WebElement e, String t) {
		wait.until(ExpectedConditions.visibilityOf(e)).clear();
		e.sendKeys(t);
	}

	public static String getText(WebElement e) {
		return wait.until(ExpectedConditions.visibilityOf(e)).getText();
	}

	public static void viewWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	public void Scrolldown() {
		driver.executeScript("mobile:swipeGesture",
				Map.of("left", 100, "top", 100, "width", 200, "height", 600, "direction", "down", "percent", 0.75));
	}

	public void Scrollup() {
		driver.executeScript("mobile.swipeGesture",
				Map.of("left", 100, "top", 100, "width", 200, "height", 600, "direction", "up", "percent", 0.75));
	}

	public void scrollToElementByText(String text) {

		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"

				+ ".scrollIntoView(new UiSelector().text(\"" + text + "\"))"));
	}

	public static void jsclick(WebElement e) {
		wait.until(ExpectedConditions.elementToBeClickable(e));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", e);
	}

	public static void Alertaccept() {
		driver.switchTo().alert().accept();
	}

	public void clickunder(WebElement e) {
		WebElement filter = wait.until(ExpectedConditions.elementToBeClickable(e));
		filter.click();
	}
	public void waitForVisibility(WebElement element) {
		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(element));
	}
	public static void search(WebElement e) {
		e.sendKeys(Keys.ENTER);
	}
}


