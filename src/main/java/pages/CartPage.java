
package pages;

import base.BasePage;
import org.openqa.selenium.By;

public class CartPage extends BasePage {

    private final By cartProduct =
            By.className("cart_item");

    private final By checkoutButton =
            By.id("checkout");

    public boolean isCartDisplayed() {
        return isDisplayed(cartProduct);
    }

    public void clickCheckout() {
        click(checkoutButton);
    }
}
