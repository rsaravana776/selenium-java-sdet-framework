package tests;

import base.BaseTest;
import data.TestDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test(
            dataProvider = "jsonLoginData",
            dataProviderClass = TestDataProvider.class
    )
    public void loginUsingJsonData(
            String username,
            String password) {

        LoginPage loginPage =
                new LoginPage();

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();

        Assert.assertTrue(
                loginPage.isHomePageDisplayed(),
                "Login failed for user: " + username
        );
    }
}