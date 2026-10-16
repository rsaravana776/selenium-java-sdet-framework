package pages;

import base.BasePage;
import org.openqa.selenium.By;

public class HomePage extends BasePage {

    // Replace these locators with your application's actual locators
    private final By homePageTitle =
            By.xpath("//h1[contains(text(),'Home')]");

    private final By productsMenu =
            By.xpath("//a[contains(text(),'Products')]");

    private final By cartMenu =
            By.xpath("//a[contains(text(),'Cart')]");

    // =========================
    // Validation
    // =========================

    public boolean isHomePageDisplayed() {
        return isDisplayed(homePageTitle);
    }

    // =========================
    // Navigation
    // =========================

    public void openProducts() {
        click(productsMenu);
    }

    public void openCart() {
        click(cartMenu);
    }

    // =========================
    // Page Information
    // =========================

    public String getPageTitle() {
        return super.getPageTitle();
    }

    public String getCurrentUrl() {
        return super.getCurrentUrl();
    }
}