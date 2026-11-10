package Step;

import org.junit.Assert;

import Base.Baseclass;
import Pom.Notification;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NotificationSteps extends Baseclass {
	Notification page;
    int countBefore;

    @When("User tap the notification bell icon")
    public void user_tap_the_notification_bell_icon() {
    	viewWait();
        page = new Notification(driver);
        page.tapBell();
    }

    @Then("User should see the Notifications popup")
    public void user_should_see_the_notifications_popup() {
        Assert.assertTrue( "Notifications popup not displayed",page.isPopupDisplayed());
        Assert.assertTrue( "New count not displayed on popup",page.isNewCountDisplayed());
    }

    @And("User tap the close icon on the Notifications popup")
    public void user_tap_the_close_icon_on_the_notifications_popup() {
        page.tapClose();
    }

    @And("User tap the View All Notifications button")
    public void user_tap_the_view_all_notifications_button() {
    	viewWait();
        page.tapViewAll();
    }

    @Then("User should see the Notifications page")
    public void user_should_see_the_notifications_page() {
    	viewWait();
        Assert.assertTrue( "Notifications page not displayed",page.isNotificationsPageDisplayed());
    }

    @And("User should see Total Notifications, Unread and High Priority counts")
    public void user_should_see_counts() {
        Assert.assertTrue( "Count cards not displayed",page.areCountsDisplayed());
    }

    @And("User tap the {string} filter")
    public void user_tap_the_filter(String name) {
        page.tapFilter(name);
    }

    @Then("User should see the notification {string}")
    public void user_should_see_the_notification(String title) {
        Assert.assertTrue( title + " not displayed",page.isNotificationDisplayed(title));
    }

    @Then("User should not see the notification {string}")
    public void user_should_not_see_the_notification(String title) {
        Assert.assertFalse( title + " is displayed under this filter",page.isNotificationDisplayed(title));
    }

    @And("User tap Mark read on the first notification")
    public void user_tap_mark_read_on_the_first_notification() {
        countBefore = page.markReadCount();
        page.tapFirstMarkRead();
    }

    

    @And("User tap Delete on the first notification")
    public void user_tap_delete_on_the_first_notification() {
        countBefore = page.deleteCount();
        page.tapFirstDelete();
    }

    @Then("The number of Delete buttons should decrease by 1")
    public void delete_buttons_should_decrease() {
        Assert.assertEquals("Notification was not deleted",page.deleteCount(), countBefore - 1);
    }

    @And("User tap the back arrow on the Notifications page")
    public void user_tap_the_back_arrow_on_the_notifications_page() {
        page.tapBack();
    }

    
}

