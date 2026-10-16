package driver;

import org.openqa.selenium.WebDriver;

public class DriverManager {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    // Store driver for current thread
    public static void setDriver(WebDriver webDriver) {
        driver.set(webDriver);
    }

    // Get driver for current thread
    public static WebDriver getDriver() {
        return driver.get();
    }

    // Quit and remove driver
    public static void quitDriver() {

        WebDriver currentDriver = driver.get();

        if (currentDriver != null) {
            currentDriver.quit();
            driver.remove();
        }
    }
}