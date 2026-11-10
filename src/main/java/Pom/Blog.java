package Pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Blog {
	AndroidDriver driver;

    public Blog(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Geolocation Platform']/following::android.widget.TextView[@text='Blog'][1]")
    WebElement blogOption;

    
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Local City Guides']")
    List<WebElement> pageTitle;

  
    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@clickable='true'])[1]")
    WebElement backArrow;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Rooftop Dining')]")
    List<WebElement> guideTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Likes')]")
    WebElement likesText;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Comments')]")
    WebElement commentsText;

   
    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Share your thoughts...']")
    WebElement commentBox;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Post']")
    WebElement postButton;

   
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Related Local Guides']")
    List<WebElement> relatedTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='5 Essential Plumbing Safety Tips']")
    List<WebElement> relatedGuide1;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Ultimate City Transit & GPS Guide']")
    List<WebElement> relatedGuide2;

  
    public void clickBlogOption() {
        blogOption.click();
    }

    public boolean isBlogPageShown() {
        return !pageTitle.isEmpty();
    }

    public boolean areGuideDetailsShown() {
        return !guideTitle.isEmpty() && likesText.isDisplayed() && commentsText.isDisplayed();
    }

    public boolean isTextShown(String text) {
        return !driver.findElements(By.xpath("//android.widget.TextView[@text='" + text + "']")).isEmpty();
    }

    public void tapBack() {
        backArrow.click();
    }

 
    public int getLikes() {
        return Integer.parseInt(likesText.getText().replaceAll("[^0-9]", ""));
    }

  
    public int getComments() {
        return Integer.parseInt(commentsText.getText().replaceAll("[^0-9]", ""));
    }

    public void tapLikes() {
        likesText.click();
    }

    public void typeComment(String text) {
        commentBox.sendKeys(text);
        try {
            driver.hideKeyboard();
        } catch (Exception e) {
           
        }
    }

    public void tapPost() {
        postButton.click();
    }

    public void scrollToRelated() {
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView("
                        + "new UiSelector().text(\"Related Local Guides\"))"));
    }

    public boolean areRelatedGuidesShown() {
        return !relatedTitle.isEmpty() && !relatedGuide1.isEmpty() && !relatedGuide2.isEmpty();
    }
}

