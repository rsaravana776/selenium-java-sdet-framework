package apiTests;

import api.LoginAPI;
import base.BaseTest;
import io.restassured.response.Response;
import models.LoginRequest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginAPITest extends BaseTest {

    @Test
    public void verifyLoginAPI() {

        LoginAPI loginAPI =
                new LoginAPI("https://your-api-url.com");

        LoginRequest request =
                new LoginRequest(
                        "testuser",
                        "password"
                );

        Response response =
                loginAPI.login(request);

        Assert.assertEquals(
                response.statusCode(),
                200,
                "Login API failed"
        );

        Assert.assertNotNull(
                response.jsonPath().getString("accessToken"),
                "Access token is missing"
        );
    }
}