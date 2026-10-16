package api;

import io.restassured.response.Response;
import models.Order;

import static io.restassured.RestAssured.given;

public class OrderAPI extends BaseAPI {

    public OrderAPI(String baseUrl) {
        super(baseUrl);
    }

    public Response createOrder(
            String accessToken,
            Order order) {

        return given()
                .spec(authenticatedRequest(accessToken))
                .body(order)
                .when()
                .post("/orders");
    }

    public Response getOrder(
            String accessToken,
            String orderId) {

        return given()
                .spec(authenticatedRequest(accessToken))
                .when()
                .get("/orders/" + orderId);
    }

    public Response deleteOrder(
            String accessToken,
            String orderId) {

        return given()
                .spec(authenticatedRequest(accessToken))
                .when()
                .delete("/orders/" + orderId);
    }
}