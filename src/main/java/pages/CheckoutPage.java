
package pages;

import base.BasePage;
import org.openqa.selenium.By;

public class CheckoutPage extends BasePage {

    private final By firstName =
            By.id("first-name");

    private final By lastName =
            By.id("last-name");

    private final By postalCode =
            By.id("postal-code");

    private final By continueButton =
            By.id("continue");

    private final By finishButton =
            By.id("finish");

    private final By orderConfirmation =
            By.className("complete-header");

    public void enterCheckoutInformation(
            String firstNameValue,
            String lastNameValue,
            String postalCodeValue) {

        enterText(firstName, firstNameValue);
        enterText(lastName, lastNameValue);
        enterText(postalCode, postalCodeValue);
        click(continueButton);
    }

    public void finishOrder() {
        click(finishButton);
    }

    public boolean isOrderConfirmationDisplayed() {
        return isDisplayed(orderConfirmation);
    }
}
