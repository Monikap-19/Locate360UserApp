package Pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Enqires {
	AndroidDriver driver;

	public Enqires(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Enquiry']")
	WebElement enquiryTab;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='My Enquiries & Quotes']")
	List<WebElement> pageTitle;

	@AndroidFindBy(xpath = "//android.widget.TextView[starts-with(@text,'Enquiries (')]")
	WebElement enquiriesCount;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Timeline View']")
	WebElement timelineTab;

	@AndroidFindBy(xpath = "//android.widget.TextView[starts-with(@text,'Vendor Responses')]")
	WebElement vendorTab;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Message']")
	List<WebElement> messageButton;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Call']")
	List<WebElement> callButton;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Secure conversation']")
	List<WebElement> secureText;

	public void tapEnquiryTab() {
		enquiryTab.click();
	}

	public boolean isEnquiryPageShown() {
		return !pageTitle.isEmpty();
	}

	private By tab(String name) {
		return By.xpath("//android.widget.TextView[starts-with(@text,'" + name + " (')]");
	}

	public int filterCount(String name) {
		String text = driver.findElement(tab(name)).getText();
		return Integer.parseInt(text.replaceAll("[^0-9]", ""));
	}

	public void tapFilter(String name) {
		driver.findElement(tab(name)).click();
	}

	public int listCount() {
		return Integer.parseInt(enquiriesCount.getText().replaceAll("[^0-9]", ""));
	}

	private void scrollTo(String text) {
		driver.findElement(
				AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView("
						+ "new UiSelector().textStartsWith(\"" + text + "\"))"));
	}

	public void tapTimelineTab() {
		scrollTo("Timeline View");
		timelineTab.click();
	}

	public boolean isTextShown(String text) {
		return !driver.findElements(By.xpath("//android.widget.TextView[@text='" + text + "']")).isEmpty();
	}

	public void tapVendorTab() {
		scrollTo("Vendor Responses");
		vendorTab.click();
	}

	public boolean areMessageAndCallShown() {
		return !messageButton.isEmpty() && !callButton.isEmpty();
	}

	public void tapMessage() {
		messageButton.get(0).click();
	}

	public void tapCall() {
		callButton.get(0).click();
	}

	public boolean isMessagingShown() {
		return !secureText.isEmpty();
	}

	public String currentPackage() {
		return (String) driver.executeScript("mobile: getCurrentPackage");
	}

	public String screenText() {
		return driver.getPageSource();
	}
}
