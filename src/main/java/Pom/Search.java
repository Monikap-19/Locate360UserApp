package Pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Search {
	AndroidDriver driver;

    public Search(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

  
    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@text,'Enter Search')]")
    List<WebElement> searchField;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Recent Searches']")
    List<WebElement> recentSearches;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Trending Searches']")
    List<WebElement> trendingTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='OYO Rooms']")
    List<WebElement> oyoRooms;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Resorts near me']")
    List<WebElement> resortsNearMe;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Best Restaurants']")
    List<WebElement> bestRestaurants;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Spa near me']")
    List<WebElement> spaNearMe;

   
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'No results') or contains(@text,'No result') or contains(@text,'not found')]")
    List<WebElement> noResultsMessage;

  
    public boolean isSearchFieldDisplayed() {
        return !searchField.isEmpty() && searchField.get(0).isDisplayed();
    }

    public boolean isRecentSearchesDisplayed() {
        return !recentSearches.isEmpty();
    }

    public boolean areTrendingItemsDisplayed() {
        return !trendingTitle.isEmpty() && !oyoRooms.isEmpty() && !resortsNearMe.isEmpty()
                && !bestRestaurants.isEmpty() && !spaNearMe.isEmpty();
    }

    public void enterKeyword(String text) {
        searchField.get(0).sendKeys(text);
    }

    public void pressSearchKey() {
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    public void tapTrending(String name) {
        driver.findElement(By.xpath("//android.widget.TextView[@text='" + name + "']")).click();
    }

   
    public boolean isKeywordTextDisplayed(String keyword) {
        String lower = keyword.toLowerCase();
        String xpath = "//android.widget.TextView[contains(translate(@text,"
                + "'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'" + lower + "')]";
        return !driver.findElements(By.xpath(xpath)).isEmpty();
    }

    public boolean isNoResultsDisplayed() {
        return !noResultsMessage.isEmpty();
    }
}