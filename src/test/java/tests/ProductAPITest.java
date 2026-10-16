package apiTests;

import api.ProductAPI;
import base.BaseTest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductAPITest extends BaseTest {

    @Test
    public void verifyGetProducts() {

        ProductAPI productAPI =
                new ProductAPI("https://your-api-url.com");

        Response response =
                productAPI.getAllProducts();

        Assert.assertEquals(
                response.statusCode(),
                200,
                "Get products API failed"
        );

        Assert.assertNotNull(
                response.jsonPath().getList("$"),
                "Product response is empty"
        );
    }
}