package Pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Movies {
	AndroidDriver driver;

	public Movies(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Movies']")
	WebElement moviesTab;

	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='Jailer 2'])[1]")
	WebElement jailer2;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Cinema Tickets']")
	List<WebElement> cinemaTitle;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Continue to Seat Selection']")
	WebElement continueToSeats;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Add Snacks']")
	WebElement addSnacks;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Back']")
	WebElement backButton;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Popcorn (Medium)']/following::android.widget.TextView[@text='Add'][1]")
	WebElement addPopcornMedium;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Coke (Large)']/following::android.widget.TextView[@text='Add'][1]")
	WebElement addCokeLarge;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Continue to Payment']")
	WebElement continueToPayment;

	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Enter promo code']")
	WebElement promoBox;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Apply']")
	WebElement applyButton;

	@AndroidFindBy(xpath = "//android.widget.TextView[starts-with(@text,'Confirm & Pay')]")
	WebElement confirmAndPay;

	@AndroidFindBy(xpath = "//android.widget.TextView[starts-with(@text,'TICKET #')]")
	List<WebElement> ticketNumber;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Save Ticket to Dashboard']")
	WebElement saveTicket;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Latest Movies Now Showing']")
	List<WebElement> moviePageText;

	public void tapMoviesTab() {
		moviesTab.click();
	}

	public void tapMovie() {
		jailer2.click();
	}

	public boolean isCinemaPageShown() {
		return !cinemaTitle.isEmpty();
	}

	public boolean isTextShown(String text) {
		return !driver.findElements(By.xpath("//android.widget.TextView[@text='" + text + "']")).isEmpty();
	}

	public boolean isTextContaining(String text) {
		return !driver.findElements(By.xpath("//android.widget.TextView[contains(@text,'" + text + "')]")).isEmpty();
	}

	public void selectDate(String day) {
		driver.findElement(By.xpath("(//android.widget.TextView[@text='" + day + "'])[1]")).click();
	}

	public void selectShowtime(String time) {
		driver.findElement(By.xpath("//android.widget.TextView[@text='" + time + "']")).click();
	}

	public void tapContinueToSeats() {
		continueToSeats.click();
	}

	public void selectSeat(String seat) {
		driver.findElement(By.xpath("//android.widget.TextView[@text='" + seat + "']")).click();
	}

	public void tapAddSnacks() {
		addSnacks.click();
	}

	public void tapBack() {
		backButton.click();
	}

	public void addSnack(String name) {
		if (name.equals("Popcorn (Medium)")) {
			addPopcornMedium.click();
		} else if (name.equals("Coke (Large)")) {
			addCokeLarge.click();
		}
	}

	public void tapContinueToPayment() {
		continueToPayment.click();
	}

	public void selectPayment(String name) {
		driver.findElement(By.xpath("//android.widget.TextView[@text='" + name + "']")).click();
	}

	public void enterPromo(String code) {
		promoBox.sendKeys(code);
	}

	public void tapApply() {
		applyButton.click();
	}

	public void tapConfirmAndPay() {
		confirmAndPay.click();
	}

	public boolean isTicketShown() {
		return !ticketNumber.isEmpty();
	}

	public void tapSaveTicket() {
		saveTicket.click();
	}

	public boolean isMoviePageShown() {
		return !moviePageText.isEmpty();
	}
}
