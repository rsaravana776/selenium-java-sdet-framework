
package context;

import pages.LoginPage;
import pages.ProductPage;
import pages.CartPage;
import pages.CheckoutPage;

public class TestContext {

    private final LoginPage loginPage;
    private final ProductPage productPage;
    private final CartPage cartPage;
    private final CheckoutPage checkoutPage;

    public TestContext() {
        this.loginPage = new LoginPage();
        this.productPage = new ProductPage();
        this.cartPage = new CartPage();
        this.checkoutPage = new CheckoutPage();
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }

    public ProductPage getProductPage() {
        return productPage;
    }

    public CartPage getCartPage() {
        return cartPage;
    }

    public CheckoutPage getCheckoutPage() {
        return checkoutPage;
    }
}
