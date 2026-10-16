package tests;

import api.ApiAuthService;
import api.OrderApiService;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.OrderPage;
import utils.ConfigReader;

public class ApiUiOrderTest extends BaseTest {

    @Test
    public void createOrderUsingApiAndValidateInUI() {

        String apiBaseUrl =
                ConfigReader.get("api.baseUrl");

        ApiAuthService authService =
                new ApiAuthService(apiBaseUrl);

        OrderApiService orderApi =
                new OrderApiService(apiBaseUrl);

        String accessToken = null;
        String orderId = null;

        try {

            // =========================================
            // 1. API LOGIN
            // =========================================

            accessToken =
                    authService.getAccessToken(
                            "Saro",
                            "1234"
                    );

            System.out.println(
                    "Access Token received"
            );


            // =========================================
            // 2. CREATE ORDER USING API
            // =========================================

            orderId =
                    orderApi.createOrder(
                            accessToken,
                            "P1001",
                            2
                    );

            System.out.println(
                    "Created Order ID: " + orderId
            );


            // =========================================
            // 3. OPEN ORDER HISTORY IN UI
            // =========================================

            OrderPage orderPage =
                    new OrderPage();

            orderPage.openOrderHistory();


            // =========================================
            // 4. SEARCH ORDER ID
            // =========================================

            orderPage.searchOrder(orderId);


            // =========================================
            // 5. VALIDATE ORDER
            // =========================================

            Assert.assertTrue(
                    orderPage.isOrderDisplayed(orderId),
                    "Order was not displayed in UI"
            );

        } finally {

            // =========================================
            // 6. API CLEANUP
            // =========================================

            if (accessToken != null && orderId != null) {

                orderApi.deleteOrder(
                        accessToken,
                        orderId
                );

                System.out.println(
                        "Order cleanup completed: "
                                + orderId
                );
            }
        }
    }
}