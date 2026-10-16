package api;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class ApiAuthService {

    private final String baseUrl;

    public ApiAuthService(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getAccessToken(String username, String password) {

        String requestBody = """
                {
                    "username": "%s",
                    "password": "%s"
                }
                """.formatted(username, password);

        return given()
                .baseUri(baseUrl)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/login")
                .then()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getString("accessToken");
    }

    public String getNewAccessToken(String refreshToken) {

        String requestBody = """
                {
                    "refreshToken": "%s"
                }
                """.formatted(refreshToken);

        return given()
                .baseUri(baseUrl)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/refresh-token")
                .then()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getString("accessToken");
    }
}