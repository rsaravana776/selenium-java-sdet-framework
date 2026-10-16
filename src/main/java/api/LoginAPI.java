package api;

import io.restassured.response.Response;
import models.LoginRequest;

import static io.restassured.RestAssured.given;

public class LoginAPI extends BaseAPI {

    public LoginAPI(String baseUrl) {
        super(baseUrl);
    }

    public Response login(LoginRequest requestBody) {

        return given()
                .spec(request())
                .body(requestBody)
                .when()
                .post("/login");
    }
}