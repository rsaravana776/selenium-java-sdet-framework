package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public WaitUtils(WebDriver driver) {
        this.driver = driver;

        int timeout = ConfigReader.getInt("timeout");

        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeout)
        );
    }

    public WebElement waitForVisible(By locator) {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForClickable(By locator) {

        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public boolean waitForInvisible(By locator) {

        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public void waitForTitle(String title) {

        wait.until(ExpectedConditions.titleContains(title));
    }
}