package Step;

import org.junit.Assert;

import Base.Baseclass;
import Pom.Blog;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BlogSteps extends Baseclass{
	 Blog page;
	    int likesBefore;
	    int commentsBefore;
	    String newComment;

	    Blog page() {
	        if (page == null) {
	            page = new Blog(driver);
	        }
	        return page;
	    }

	    @And("User click the Blog option in the menu")
	    public void user_click_the_blog_option_in_the_menu() {
	        page().clickBlogOption();
	    }

	    @Then("User should see the Local City Guides page")
	    public void user_should_see_the_local_city_guides_page() {
	        Assert.assertTrue( "Local City Guides page not displayed",page().isBlogPageShown());
	    }

	    @Then("User should see the guide title, likes and comments")
	    public void user_should_see_the_guide_details() {
	        Assert.assertTrue( "Guide title, likes or comments not displayed",page().areGuideDetailsShown());
	    }

	    @Then("User should see the comments from {string} and {string}")
	    public void user_should_see_the_comments_from(String first, String second) {
	        Assert.assertTrue(" comment not displayed",page().isTextShown(first));
	        Assert.assertTrue( " comment not displayed",page().isTextShown(second));
	    }

	    @When("User scroll to Related Local Guides")
	    public void user_scroll_to_related_local_guides() {
	        page().scrollToRelated();
	    }

	    @Then("User should see the related guides")
	    public void user_should_see_the_related_guides() {
	        Assert.assertTrue( "Related Local Guides not displayed",page().areRelatedGuidesShown());
	    }

	    @When("User tap the back arrow on the Blog page")
	    public void user_tap_the_back_arrow_on_the_blog_page() {
	        page().tapBack();
	    }

	    @When("User tap the Likes")
	    public void user_tap_the_likes() {
	        likesBefore = page().getLikes();
	        page().tapLikes();
	    }

	    @Then("The likes count should increase by 1")
	    public void the_likes_count_should_increase_by_1() {
	        Assert.assertEquals( "Likes count did not increase",page().getLikes(), likesBefore + 1);
	    }

	  
	    @When("User post a new comment")
	    public void user_post_a_new_comment() {
	        commentsBefore = page().getComments();
	        newComment = "Auto comment " + System.currentTimeMillis();
	        page().typeComment(newComment);
	        page().tapPost();
	    }

	    @Then("The new comment should be displayed")
	    public void the_new_comment_should_be_displayed() {
	        Assert.assertTrue( "New comment not displayed",page().isTextShown(newComment));
	    }

	    @And("The comments count should increase by 1")
	    public void the_comments_count_should_increase_by_1() {
	        Assert.assertEquals( "Comments count did not increase",page().getComments(), commentsBefore + 1);
	    }

	    @When("User type {string} in the comment box")
	    public void user_type_in_the_comment_box(String text) {
	        commentsBefore = page().getComments();
	        page().typeComment(text);
	    }

	   
	    @When("User tap the Post button")
	    public void user_tap_the_post_button() {
	        if (commentsBefore == 0) {
	            commentsBefore = page().getComments();
	        }
	        page().tapPost();
	    }

	    @Then("The comments count should not change")
	    public void the_comments_count_should_not_change() {
	        Assert.assertEquals(  "Comments count changed for an invalid comment",page().getComments(),commentsBefore);
	    }
}

