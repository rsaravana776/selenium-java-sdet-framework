package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URI;

public class DriverFactory {

    public static WebDriver createDriver(
            String browser,
            String executionMode,
            String gridUrl) {

        if (browser == null || browser.isBlank()) {
            throw new IllegalArgumentException(
                    "Browser cannot be null or empty"
            );
        }

        if (executionMode == null || executionMode.isBlank()) {
            executionMode = "local";
        }

        switch (browser.toLowerCase()) {

            case "chrome":
                return createChrome(
                        executionMode,
                        gridUrl
                );

            case "firefox":
                return createFirefox(
                        executionMode,
                        gridUrl
                );

            case "edge":
                return createEdge(
                        executionMode,
                        gridUrl
                );

            default:
                throw new IllegalArgumentException(
                        "Unsupported browser: " + browser
                );
        }
    }


    private static WebDriver createChrome(
            String executionMode,
            String gridUrl) {

        ChromeOptions options =
                new ChromeOptions();

        if (executionMode.equalsIgnoreCase("grid")) {

            return createRemoteDriver(
                    gridUrl,
                    options
            );
        }

        return new ChromeDriver(options);
    }


    private static WebDriver createFirefox(
            String executionMode,
            String gridUrl) {

        FirefoxOptions options =
                new FirefoxOptions();

        if (executionMode.equalsIgnoreCase("grid")) {

            return createRemoteDriver(
                    gridUrl,
                    options
            );
        }

        return new FirefoxDriver(options);
    }


    private static WebDriver createEdge(
            String executionMode,
            String gridUrl) {

        EdgeOptions options =
                new EdgeOptions();

        if (executionMode.equalsIgnoreCase("grid")) {

            return createRemoteDriver(
                    gridUrl,
                    options
            );
        }

        return new EdgeDriver(options);
    }


    private static WebDriver createRemoteDriver(
            String gridUrl,
            Object options) {

        try {

            return new RemoteWebDriver(
                    URI.create(gridUrl).toURL(),
                    (org.openqa.selenium.Capabilities) options
            );

        } catch (Exception e) {

            throw new RuntimeException(
                    "Unable to create RemoteWebDriver",
                    e
            );
        }
    }
}