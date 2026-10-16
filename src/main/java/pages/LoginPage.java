
package pages;

import base.BasePage;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private final By username =
            By.id("user-name");

    private final By password =
            By.id("password");

    private final By loginButton =
            By.id("login-button");

    private final By homePage =
            By.id("inventory_container");

    public void enterUsername(String usernameValue) {
        enterText(username, usernameValue);
    }

    public void enterPassword(String passwordValue) {
        enterText(password, passwordValue);
    }

    public void clickLogin() {
        click(loginButton);
    }

    public void login(String usernameValue, String passwordValue) {
        enterUsername(usernameValue);
        enterPassword(passwordValue);
        clickLogin();
    }

    public boolean isHomePageDisplayed() {
        return isDisplayed(homePage);
    }
}
