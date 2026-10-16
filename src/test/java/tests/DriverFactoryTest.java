package tests;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;

public class DriverFactoryTest {

    public static void main(String[] args) {

        String browser = "chrome";
        String executionMode = "local";
        String gridUrl = "http://localhost:4444";

        WebDriver driver =
                DriverFactory.createDriver(
                        browser,
                        executionMode,
                        gridUrl
                );

        try {

            driver.get("https://www.google.com");

            System.out.println(
                    "Title: " + driver.getTitle()
            );

        } finally {

            driver.quit();
        }
    }
}