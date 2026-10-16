
package pages;

import base.BasePage;
import org.openqa.selenium.By;

public class ProductPage extends BasePage {

    private final By productName =
            By.className("inventory_item_name");

    private final By addToCartButton =
            By.id("add-to-cart-sauce-labs-backpack");

    private final By cartButton =
            By.className("shopping_cart_link");

    public boolean isProductDisplayed() {
        return isDisplayed(productName);
    }

    public void addProductToCart() {
        click(addToCartButton);
    }

    public void openCart() {
        click(cartButton);
    }

    public String getProductName() {
        return getText(productName);
    }
}
