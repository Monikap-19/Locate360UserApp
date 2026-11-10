package Pom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Notification {
	  AndroidDriver driver;
	    WebDriverWait wait;

	    public Notification(AndroidDriver driver) {
	        this.driver = driver;
	        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	    }

	  
	    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@clickable='true'])[4]")
	    WebElement bellIcon;

	   
	    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Notifications']")
	    WebElement notificationsTitle;

	    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'New')]")
	    WebElement newCountText;

	  
	    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Notifications']/following::android.view.ViewGroup[@clickable='true'][1]")
	    WebElement closeIcon;

	    @AndroidFindBy(xpath = "//android.widget.TextView[@text='View All Notifications']")
	    WebElement viewAllButton;

	  
	    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@clickable='true'])[1]")
	    WebElement backArrow;

	    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Total Notifications']")
	    WebElement totalLabel;

	  
	    @AndroidFindBy(xpath = "(//android.widget.TextView[@text='Unread'])[1]")
	    WebElement unreadLabel;

	    @AndroidFindBy(xpath = "//android.widget.TextView[@text='High Priority']")
	    WebElement highPriorityLabel;

	    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'unread notifications')]")
	    WebElement headerUnreadText;

	  
	    @AndroidFindBy(xpath = "(//android.widget.TextView[@text='Unread'])[1]/preceding-sibling::android.widget.TextView[1]")
	    WebElement unreadCountNumber;

	    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Mark read']")
	    List<WebElement> markReadButtons;

	    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Delete']")
	    List<WebElement> deleteButtons;

	  
	    public void tapBell() {
	        wait.until(ExpectedConditions.elementToBeClickable(bellIcon)).click();
	    }

	    public boolean isPopupDisplayed() {
	        return wait.until(ExpectedConditions.visibilityOf(notificationsTitle)).isDisplayed()
	                && viewAllButton.isDisplayed();
	    }

	    public boolean isNewCountDisplayed() {
	        return wait.until(ExpectedConditions.visibilityOf(newCountText)).isDisplayed();
	    }

	    public void tapClose() {
	        wait.until(ExpectedConditions.elementToBeClickable(closeIcon)).click();
	    }

	    public void tapViewAll() {
	        wait.until(ExpectedConditions.elementToBeClickable(viewAllButton)).click();
	    }

	    public boolean isNotificationsPageDisplayed() {
	        wait.until(ExpectedConditions.visibilityOf(totalLabel));
	        return notificationsTitle.isDisplayed();
	    }

	    public boolean areCountsDisplayed() {
	        return totalLabel.isDisplayed() && unreadLabel.isDisplayed() && highPriorityLabel.isDisplayed();
	    }

	    public void tapBack() {
	        wait.until(ExpectedConditions.elementToBeClickable(backArrow)).click();
	    }

	  
	    public void tapFilter(String name) {
	        By chip = By.xpath("(//android.widget.TextView[@text='" + name + "'])[last()]");
	        wait.until(ExpectedConditions.elementToBeClickable(chip)).click();
	    }

	    public boolean isNotificationDisplayed(String title) {
	        return !driver.findElements(By.xpath("//android.widget.TextView[@text='" + title + "']")).isEmpty();
	    }

	    public int markReadCount() {
	        return markReadButtons.size();
	    }

	    public int deleteCount() {
	        return deleteButtons.size();
	    }

	    public void tapFirstMarkRead() {
	        wait.until(ExpectedConditions.visibilityOfAllElements(markReadButtons));
	        markReadButtons.get(0).click();
	    }

	    public void tapFirstDelete() {
	        wait.until(ExpectedConditions.visibilityOfAllElements(deleteButtons));
	        deleteButtons.get(0).click();
	    }

	    public int headerUnreadNumber() {
	        String text = wait.until(ExpectedConditions.visibilityOf(headerUnreadText)).getText();
	        return Integer.parseInt(text.replaceAll("[^0-9]", ""));
	    }

	    public int unreadCardNumber() {
	        return Integer.parseInt(unreadCountNumber.getText().trim());
	    }
	}


