package pages;

import base.BasePage;
import org.openqa.selenium.By;

public class OrderPage extends BasePage {

    private final By orderHistory =
            By.id("orderHistory");

    private final By orderSearch =
            By.id("orderSearch");

    private final By orderResult =
            By.id("orderResult");

    public void openOrderHistory() {

        click(orderHistory);
    }

    public void searchOrder(String orderId) {

        enterText(orderSearch, orderId);
    }

    public boolean isOrderDisplayed(String orderId) {

        return getText(orderResult)
                .contains(orderId);
    }
}