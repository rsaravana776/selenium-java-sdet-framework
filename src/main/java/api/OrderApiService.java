package api;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class OrderApiService {

    private final String baseUrl;

    public OrderApiService(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String createOrder(
            String accessToken,
            String productId,
            int quantity) {

        String requestBody = """
                {
                    "productId": "%s",
                    "quantity": %d
                }
                """.formatted(productId, quantity);

        return given()
                .baseUri(baseUrl)
                .header(
                        "Authorization",
                        "Bearer " + accessToken
                )
                .contentType(ContentType.JSON)
                .body(requestBody)

                .when()
                .post("/orders")

                .then()
                .statusCode(201)
                .extract()
                .jsonPath()
                .getString("orderId");
    }

    public String getOrderStatus(
            String accessToken,
            String orderId) {

        return given()
                .baseUri(baseUrl)
                .header(
                        "Authorization",
                        "Bearer " + accessToken
                )

                .when()
                .get("/orders/" + orderId)

                .then()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getString("status");
    }

    public void deleteOrder(
            String accessToken,
            String orderId) {

        given()
                .baseUri(baseUrl)
                .header(
                        "Authorization",
                        "Bearer " + accessToken
                )

                .when()
                .delete("/orders/" + orderId)

                .then()
                .statusCode(204);
    }
}