package Pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Services {
	AndroidDriver driver;

	public Services(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Services']")
	WebElement servicesTab;

	@AndroidFindBy(xpath = "//android.widget.EditText[@text='What are you looking for?']")
	WebElement searchBox;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Reset']")
	WebElement resetButton;

	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='All Categories'])[1]")
	WebElement categoryHeader;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Grid']")
	WebElement gridTab;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='List']")
	WebElement listTab;

	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='Call Now'])[1]")
	WebElement firstCallNow;

	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='Details'])[1]")
	WebElement firstDetails;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Send Enquiry']")
	WebElement sendEnquiryButton;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='My Enquiry']")
	WebElement myEnquiryButton;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Chat']")
	WebElement chatButton;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Directions']")
	WebElement directionsButton;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Book Now']")
	WebElement bookNowButton;

	@AndroidFindBy(xpath = "//android.widget.TextView[starts-with(@text,'Send Enquiry to')]/following::android.view.ViewGroup[@clickable='true'][1]")
	WebElement enquiryClose;

	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Enter name']")
	WebElement nameBox;

	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Enter mobile']")
	WebElement mobileBox;

	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Enter Email']")
	WebElement emailBox;

	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Enter title']")
	WebElement titleBox;

	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Enter budget']")
	WebElement budgetBox;

	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Enter urgency']")
	WebElement urgencyBox;

	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Enter City or Zip code']")
	WebElement locationBox;

	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Enter description']")
	WebElement descriptionBox;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Next']")
	WebElement nextButton;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Back']")
	WebElement backButton;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Submit']")
	WebElement submitButton;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Write a review']")
	WebElement writeReviewLink;

	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Write your review...']")
	WebElement reviewBox;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Cancel']")
	WebElement reviewCancel;

	private void type(WebElement box, String text) {
		if (!text.isEmpty()) {
			box.sendKeys(text);
			try {
				driver.hideKeyboard();
			} catch (Exception e) {

			}
		}
	}

	public void tapServicesTab() {
		servicesTab.click();
	}

	public void search(String text) {
		type(searchBox, text);
	}

	public void tapReset() {
		resetButton.click();
	}

	public void openCategoryList() {
		categoryHeader.click();
	}

	public void chooseCategory(String name) {
		driver.findElement(By.xpath("//android.widget.TextView[@text='" + name + "']")).click();
	}

	public void switchView(String name) {
		if (name.equals("List")) {
			listTab.click();
		} else {
			gridTab.click();
		}
	}

	public void tapFirstCallNow() {
		firstCallNow.click();
	}

	public void tapFirstDetails() {
		firstDetails.click();
	}

	public void tapSendEnquiry() {
		sendEnquiryButton.click();
	}

	public void tapMyEnquiry() {
		myEnquiryButton.click();
	}

	public void tapChat() {
		chatButton.click();
	}

	public void tapDirections() {
		directionsButton.click();
	}

	public void tapBookNow() {
		bookNowButton.click();
	}

	public void closeEnquiry() {
		enquiryClose.click();
	}

	public void enterName(String text) {
		type(nameBox, text);
	}

	public void enterMobile(String text) {
		type(mobileBox, text);
	}

	public void enterEmail(String text) {
		type(emailBox, text);
	}

	public void enterTitle(String text) {
		type(titleBox, text);
	}

	public void enterBudget(String text) {
		type(budgetBox, text);
	}

	public void enterUrgency(String text) {
		type(urgencyBox, text);
	}

	public void enterLocation(String text) {
		type(locationBox, text);
	}

	public void enterDescription(String text) {
		type(descriptionBox, text);
	}

	public void tapNext() {
		nextButton.click();
	}

	public void tapBack() {
		backButton.click();
	}

	public void tapSubmit() {
		submitButton.click();
	}

	public void scrollTo(String text) {
		driver.findElement(
				AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView("
						+ "new UiSelector().textContains(\"" + text + "\"))"));
	}

	public void tapWriteReview() {
		writeReviewLink.click();
	}

	public void enterReview(String text) {
		type(reviewBox, text);
	}

	public void rate(int stars) {
		driver.findElement(By.xpath("(//android.widget.TextView[@text='Write a Review']"
				+ "/following::android.widget.TextView[starts-with(@text,'" + stars + "')])[1]")).click();
	}

	public void tapCancelReview() {
		reviewCancel.click();
	}

	public void tapSimilarBusiness(String name) {
		driver.findElement(By.xpath("//android.widget.TextView[@text='" + name + "']")).click();
	}

	public boolean isTextShown(String text) {
		List<WebElement> list = driver
				.findElements(By.xpath("//android.widget.TextView[contains(@text,\"" + text + "\")]"));
		return !list.isEmpty();
	}
}
