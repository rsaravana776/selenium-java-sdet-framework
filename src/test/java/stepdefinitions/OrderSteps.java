
package stepdefinitions;

import context.TestContext;
import driver.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.CartPage;
import pages.CheckoutPage;
import pages.ProductPage;

public class OrderSteps {

    private final ProductPage productsPage;
    private final CartPage cartPage;
    private final CheckoutPage checkoutPage;

    public OrderSteps(TestContext context) {
        this.productsPage = context.getProductPage();
        this.cartPage = context.getCartPage();
        this.checkoutPage = context.getCheckoutPage();
    }

    @And("user adds a product to the cart")
    public void userAddsAProductToTheCart() {
        productsPage.addProductToCart();
    }

    @And("user opens the shopping cart")
    public void userOpensTheShoppingCart() {
        productsPage.openCart();
    }

    @And("user proceeds to checkout")
    public void userProceedsToCheckout() {
        cartPage.clickCheckout();

        System.out.println("Current URL: "
                + DriverManager.getDriver().getCurrentUrl());

        System.out.println("Current title: "
                + DriverManager.getDriver().getTitle());
    }

    @And("user enters checkout information {string} {string} {string}")
    public void userEntersCheckoutInformation(
            String firstName,
            String lastName,
            String postalCode) {

        checkoutPage.enterCheckoutInformation(
                firstName,
                lastName,
                postalCode
        );
    }

    @And("user completes the order")
    public void userCompletesTheOrder() {
        checkoutPage.finishOrder();
    }

    @Then("order confirmation should be displayed")
    public void orderConfirmationShouldBeDisplayed() {
        Assert.assertTrue(
                checkoutPage.isOrderConfirmationDisplayed(),
                "Order confirmation was not displayed"
        );
    }
}
