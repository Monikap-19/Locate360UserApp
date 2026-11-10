package Pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Home {
	AndroidDriver driver;

    public Home(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Monika p']/following::android.widget.TextView[1]")
    WebElement locationSelector;

   
    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@clickable='true'])[3]")
    WebElement logoutIcon;

    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@clickable='true'])[4]")
    WebElement bellIcon;

    @AndroidFindBy(xpath = "//*[contains(@text,'Search services')]")
    WebElement homeSearchBar;

    
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Select Your City / Area']/following::android.view.ViewGroup[@clickable='true'][1]")
    WebElement closeLocationSheet;

  
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Notifications']/following::android.view.ViewGroup[@clickable='true'][1]")
    WebElement closeNotifications;

   
    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@text,'Enter Search')]")
    WebElement searchField;

   
    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@text,'Enter Search')]/preceding::android.view.ViewGroup[@clickable='true'][1]")
    WebElement closeSearchPopup;

    
    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Enter departure city']")
    WebElement fromBox;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Enter destination city']")
    WebElement toBox;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Search']")
    WebElement travelSearchButton;

   
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Mobile Number']/following::android.widget.EditText[1]")
    WebElement billMobileBox;

    @AndroidFindBy(xpath = "//android.widget.TextView[starts-with(@text,'Pay') and contains(@text,'Now')]")
    WebElement payNowButton;

  
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

  
    public void tapText(String text) {
        driver.findElement(By.xpath("(//*[@text=\"" + text + "\"])[1]")).click();
    }

    public boolean isTextShown(String text) {
        List<WebElement> list = driver.findElements(By.xpath("//*[contains(@text,\"" + text + "\")]"));
        return !list.isEmpty();
    }

    public void scrollTo(String text) {
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView("
                        + "new UiSelector().textContains(\"" + text + "\"))"));
    }

    public void tapLocationSelector() {
        locationSelector.click();
    }

    public void selectCity(String city) {
        driver.findElement(By.xpath("(//*[@text=\"" + city + "\"])[last()]")).click();
    }

    public void closeLocationSheet() {
        closeLocationSheet.click();
    }

    public void tapBell() {
        bellIcon.click();
    }

    public void closeNotifications() {
        closeNotifications.click();
    }

    public void tapLogout() {
        logoutIcon.click();
    }

    public void tapSearchBar() {
        homeSearchBar.click();
    }

    public void typeInSearch(String text) {
        type(searchField, text);
    }

    public void pressEnter() {
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    public void closeSearchPopup() {
        closeSearchPopup.click();
    }

    public void enterFrom(String text) {
        type(fromBox, text);
    }

    public void enterTo(String text) {
        type(toBox, text);
    }

    public void tapTravelSearch() {
        travelSearchButton.click();
    }

    public void enterBillMobile(String text) {
        type(billMobileBox, text);
    }

   
    public void chooseAmount(String amount) {
        tapText("\u20B9" + amount);
    }

    public boolean isPayButtonShowing(String amount) {
        return isTextShown("Pay \u20B9" + amount + " Now");
    }

    public void tapPayNow() {
        payNowButton.click();
    }
}
