package base;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage() {

        this.driver = DriverManager.getDriver();

        this.wait =
                new WebDriverWait(
                        driver,
                        Duration.ofSeconds(15)
                );
    }

    // =========================
    // Click
    // =========================

    protected void click(By locator) {

        wait.until(
                ExpectedConditions.elementToBeClickable(locator)
        ).click();
    }

    // =========================
    // JavaScript Click
    // =========================

    protected void jsClick(By locator) {

        WebElement element =
                wait.until(
                        ExpectedConditions.presenceOfElementLocated(locator)
                );

        ((JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].click();",
                        element
                );
    }

    // =========================
    // Type
    // =========================

    protected void type(By locator, String text) {

        WebElement element =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(locator)
                );

        element.clear();
        element.sendKeys(text);
    }

    // =========================
    // Enter Text
    // Compatibility method
    // =========================

    protected void enterText(By locator, String text) {

        WebElement element =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(locator)
                );

        element.clear();
        element.sendKeys(text);
    }

    // =========================
    // Get Text
    // =========================

    protected String getText(By locator) {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        ).getText();
    }

    // =========================
    // Check Displayed
    // =========================

    protected boolean isDisplayed(By locator) {

        try {

            return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(locator)
            ).isDisplayed();

        } catch (TimeoutException | NoSuchElementException e) {

            return false;
        }
    }

    // =========================
    // Wait for URL
    // =========================

    protected boolean waitForUrl(String url) {

        return wait.until(
                ExpectedConditions.urlContains(url)
        );
    }

    // =========================
    // Wait for Title
    // =========================

    protected boolean waitForTitle(String title) {

        return wait.until(
                ExpectedConditions.titleContains(title)
        );
    }

    // =========================
    // Scroll to Element
    // =========================

    protected void scrollToElement(By locator) {

        WebElement element =
                wait.until(
                        ExpectedConditions.presenceOfElementLocated(locator)
                );

        ((JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].scrollIntoView({block:'center'});",
                        element
                );
    }

    // =========================
    // Refresh Page
    // =========================

    protected void refreshPage() {

        driver.navigate().refresh();
    }

    // =========================
    // Current URL
    // =========================

    protected String getCurrentUrl() {

        return driver.getCurrentUrl();
    }

    // =========================
    // Page Title
    // =========================

    protected String getPageTitle() {

        return driver.getTitle();
    }
}