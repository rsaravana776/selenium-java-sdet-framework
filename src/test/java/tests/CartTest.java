
package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;
import pages.CartPage;

public class CartTest extends BaseTest {

    @Test
    public void verifyCart() {

        LoginPage loginPage = new LoginPage();

        loginPage.login("standard_user", "secret_sauce");

        ProductPage productPage = new ProductPage();

        Assert.assertTrue(
                productPage.isProductDisplayed(),
                "Products page was not displayed"
        );

        productPage.addProductToCart();
        productPage.openCart();

        CartPage cartPage = new CartPage();

        Assert.assertTrue(
                cartPage.isCartDisplayed(),
                "Cart was not displayed or the product is missing"
        );

        System.out.println("Cart verification passed successfully.");
    }
}
