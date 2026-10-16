package stepdefinitions;

import driver.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class ApplicationSteps {

    @Given("user opens the application")
    public void userOpensTheApplication() {

        // Browser is already started by Hooks
        System.out.println("Application opened: " + DriverManager.getDriver().getCurrentUrl()
        );
    }

    @Then("page title should be {string}")
    public void pageTitleShouldBe(String expectedTitle) {

        String actualTitle = DriverManager.getDriver().getTitle();

        Assert.assertEquals(actualTitle, expectedTitle, "Page title does not match");
    }
}