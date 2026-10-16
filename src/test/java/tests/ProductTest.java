package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;

public class ProductTest extends BaseTest {

    @Test
    public void verifyProductAndAddToCart() {

        LoginPage loginPage = new LoginPage();

        loginPage.enterUsername("testuser");
        loginPage.enterPassword("password");
        loginPage.clickLogin();

        HomePage homePage = new HomePage();
        homePage.openProducts();

        ProductPage productPage = new ProductPage();

        Assert.assertTrue(
                productPage.isProductDisplayed(),
                "Product page was not displayed"
        );

        String productName = productPage.getProductName();

        Assert.assertFalse(
                productName.isBlank(),
                "Product name is empty"
        );

        productPage.addProductToCart();

        System.out.println(
                "Product added to cart: " + productName
        );
    }
}