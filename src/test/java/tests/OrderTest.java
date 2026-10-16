
package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductPage;

public class OrderTest extends BaseTest {

    @Test
    public void createOrderAndValidateOrder() {

        // 1. Login
        LoginPage loginPage = new LoginPage();
        loginPage.login("standard_user", "secret_sauce");

        // 2. Verify products page
        ProductPage productPage = new ProductPage();

        Assert.assertTrue(
                productPage.isProductDisplayed(),
                "Products page was not displayed"
        );

        // 3. Add product to cart
        productPage.addProductToCart();
        productPage.openCart();

        // 4. Validate cart
        CartPage cartPage = new CartPage();

        Assert.assertTrue(
                cartPage.isCartDisplayed(),
                "Cart was not displayed"
        );

        cartPage.clickCheckout();

        // 5. Enter checkout information
        CheckoutPage checkoutPage = new CheckoutPage();

        checkoutPage.enterCheckoutInformation(
                "Saravanan",
                "Rajendran",
                "641001"
        );

        checkoutPage.finishOrder();

        // 6. Validate order confirmation
        Assert.assertTrue(
                checkoutPage.isOrderConfirmationDisplayed(),
                "Order confirmation was not displayed"
        );

        System.out.println(
                "Order created and confirmation validated successfully."
        );
    }
}
