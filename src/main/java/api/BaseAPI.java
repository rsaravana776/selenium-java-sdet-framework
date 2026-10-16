package api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class BaseAPI {

    protected final String baseUrl;
    protected final RequestSpecification requestSpec;

    public BaseAPI(String baseUrl) {

        if (baseUrl == null || baseUrl.isBlank()) {
            throw new IllegalArgumentException(
                    "Base URL cannot be null or empty"
            );
        }

        this.baseUrl = baseUrl;

        this.requestSpec =
                new RequestSpecBuilder()
                        .setBaseUri(baseUrl)
                        .setContentType(ContentType.JSON)
                        .setAccept(ContentType.JSON)
                        .build();
    }

    protected RequestSpecification request() {
        return requestSpec;
    }

    protected RequestSpecification authenticatedRequest(
            String accessToken) {

        return new RequestSpecBuilder()
                .addRequestSpecification(requestSpec)
                .addHeader(
                        "Authorization",
                        "Bearer " + accessToken
                )
                .build();
    }
}