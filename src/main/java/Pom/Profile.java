package Pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Profile {
	AndroidDriver driver;

	public Profile(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Account']")
	WebElement accountTab;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Edit Profile']")
	WebElement editProfileButton;

	@AndroidFindBy(xpath = "(//android.view.ViewGroup[@clickable='true'])[1]")
	WebElement backArrow;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Full Name']/following::android.widget.EditText[1]")
	WebElement fullNameBox;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Email Address']/following::android.widget.EditText[1]")
	WebElement emailBox;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Save Changes']")
	WebElement saveChangesButton;

	private void type(WebElement box, String text) {
		box.clear();
		if (!text.isEmpty()) {
			box.sendKeys(text);
		}
		try {
			driver.hideKeyboard();
		} catch (Exception e) {
		}
	}

	public void tapAccountTab() {
		accountTab.click();
	}

	public void tapTab(String name) {
		driver.findElement(By.xpath("(//android.widget.TextView[@text='" + name + "'])[last()]")).click();
	}

	public boolean isTextShown(String text) {
		List<WebElement> list = driver
				.findElements(By.xpath("//android.widget.TextView[contains(@text,\"" + text + "\")]"));
		return !list.isEmpty();
	}

	public void scrollTo(String text) {
		driver.findElement(
				AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView("
						+ "new UiSelector().textContains(\"" + text + "\"))"));
	}

	public void tapEditProfile() {
		editProfileButton.click();
	}

	public void tapBack() {
		backArrow.click();
	}

	public void enterFullName(String text) {
		type(fullNameBox, text);
	}

	public void enterEmail(String text) {
		type(emailBox, text);
	}

	public String getFullName() {
		return fullNameBox.getText();
	}

	public String getEmail() {
		return emailBox.getText();
	}

	public void tapSave() {
		saveChangesButton.click();
	}

	private WebElement switchOf(String label) {
		return driver.findElement(
				By.xpath("//android.widget.TextView[@text='" + label + "']/following::android.widget.Switch[1]"));
	}

	public void tapSwitch(String label) {
		switchOf(label).click();
	}

	public boolean isSwitchOn(String label) {
		return switchOf(label).getAttribute("checked").equals("true");
	}

	public int getCardCount(String label) {
		String text = driver.findElement(By
				.xpath("(//android.widget.TextView[@text='" + label + "']/preceding::android.widget.TextView)[last()]"))
				.getText();
		return Integer.parseInt(text.replaceAll("[^0-9]", ""));
	}
}
