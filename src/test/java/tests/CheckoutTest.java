
package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;
import pages.CartPage;
import pages.CheckoutPage;

public class CheckoutTest extends BaseTest {

    @Test
    public void verifyCheckout() {

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
                "Cart was not displayed"
        );

        cartPage.clickCheckout();

        CheckoutPage checkoutPage = new CheckoutPage();

        checkoutPage.enterCheckoutInformation(
                "Saravanan",
                "Rajendran",
                "641001"
        );

        checkoutPage.finishOrder();

        Assert.assertTrue(
                checkoutPage.isOrderConfirmationDisplayed(),
                "Order was not confirmed"
        );

        System.out.println("Checkout completed successfully.");
    }
}
