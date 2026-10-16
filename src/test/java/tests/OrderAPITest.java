package apiTests;

import api.LoginAPI;
import api.OrderAPI;
import base.BaseTest;
import io.restassured.response.Response;
import models.LoginRequest;
import models.Order;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OrderAPITest extends BaseTest {

    @Test
    public void verifyCreateAndGetOrder() {

        String baseUrl =
                "https://your-api-url.com";

        // Login
        LoginAPI loginAPI =
                new LoginAPI(baseUrl);

        Response loginResponse =
                loginAPI.login(
                        new LoginRequest(
                                "testuser",
                                "password"
                        )
                );

        Assert.assertEquals(
                loginResponse.statusCode(),
                200
        );

        String accessToken =
                loginResponse
                        .jsonPath()
                        .getString("accessToken");

        Assert.assertNotNull(accessToken);

        // Create order
        OrderAPI orderAPI =
                new OrderAPI(baseUrl);

        Order order =
                new Order(
                        null,
                        101,
                        2,
                        1999.99
                );

        Response createResponse =
                orderAPI.createOrder(
                        accessToken,
                        order
                );

        Assert.assertEquals(
                createResponse.statusCode(),
                201,
                "Create order failed"
        );

        String orderId =
                createResponse
                        .jsonPath()
                        .getString("id");

        Assert.assertNotNull(
                orderId,
                "Order ID is missing"
        );

        // Get order
        Response getResponse =
                orderAPI.getOrder(
                        accessToken,
                        orderId
                );

        Assert.assertEquals(
                getResponse.statusCode(),
                200,
                "Get order failed"
        );

        Assert.assertEquals(
                getResponse
                        .jsonPath()
                        .getString("id"),
                orderId
        );

        // Cleanup
        Response deleteResponse =
                orderAPI.deleteOrder(
                        accessToken,
                        orderId
                );

        Assert.assertTrue(
                deleteResponse.statusCode() == 200 ||
                        deleteResponse.statusCode() == 204,
                "Order cleanup failed"
        );
    }
}
