package stepdefinitions;

import context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class LoginSteps {

    private final TestContext context;
    private final LoginPage loginPage;

    public LoginSteps(TestContext context) {

        this.context = context;
        this.loginPage = context.getLoginPage();
    }

    @Given("user is on the login page")
    public void userIsOnTheLoginPage() {
        // Browser is already opened by CucumberHooks
    }

    @When("user enters username {string}")
    public void userEntersUsername(String username) {
        loginPage.enterUsername(username);
    }

    @When("user enters password {string}")
    public void userEntersPassword(String password) {
        loginPage.enterPassword(password);
    }

    @When("user clicks login")
    public void userClicksLogin() {
        loginPage.clickLogin();
    }
}