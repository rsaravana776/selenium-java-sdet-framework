package api;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ProductAPI extends BaseAPI {

    public ProductAPI(String baseUrl) {
        super(baseUrl);
    }

    public Response getAllProducts() {

        return given()
                .spec(request())
                .when()
                .get("/products");
    }

    public Response getProductById(int productId) {

        return given()
                .spec(request())
                .when()
                .get("/products/" + productId);
    }

    public Response createProduct(Object productRequest) {

        return given()
                .spec(request())
                .body(productRequest)
                .when()
                .post("/products");
    }

    public Response deleteProduct(int productId) {

        return given()
                .spec(request())
                .when()
                .delete("/products/" + productId);
    }
}