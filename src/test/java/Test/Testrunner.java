package Test;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
	    features = "src/test/resource/Feature",
	    glue = {"Step", "hook"},
	    tags = "@positive or @negative",
	    plugin = {
	        "pretty",
	        "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
	        "html:test-output/cucumber-report.html"
	    },
	    monochrome = false
	)
	public class Testrunner{
	
}
