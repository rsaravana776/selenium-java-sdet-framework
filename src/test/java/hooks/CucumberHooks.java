
package hooks;

import driver.DriverFactory;
import driver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CucumberHooks {

    @Before
    public void setUp() {

        String env = System.getProperty("env", "qa");
        String browser = System.getProperty("browser", "chrome");

        // Load configuration before reading properties
        ConfigReader.load("config-" + env + ".properties");

        String executionMode = ConfigReader.get("execution.mode");
        String gridUrl = ConfigReader.get("grid.url");

        // Initialize WebDriver
        WebDriver driver = DriverFactory.createDriver(
                browser,
                executionMode,
                gridUrl
        );

        DriverManager.setDriver(driver);

        // Open the application
        DriverManager.getDriver().get(ConfigReader.get("url"));
    }

    @After
    public void tearDown(Scenario scenario) {

        WebDriver driver = DriverManager.getDriver();

        try {
            if (driver != null && scenario.isFailed()) {

                byte[] screenshot =
                        ((TakesScreenshot) driver)
                                .getScreenshotAs(OutputType.BYTES);

                // Attach screenshot to the Cucumber report
                scenario.attach(
                        screenshot,
                        "image/png",
                        scenario.getName()
                );

                // Save screenshot locally
                Path screenshotDirectory =
                        Paths.get("screenshots");

                Files.createDirectories(screenshotDirectory);

                String safeScenarioName = scenario.getName()
                        .replaceAll("[^a-zA-Z0-9._-]", "_");

                Path screenshotPath = screenshotDirectory.resolve(
                        safeScenarioName + "_"
                                + System.currentTimeMillis()
                                + ".png"
                );

                Files.write(screenshotPath, screenshot);

                System.out.println(
                        "Failure screenshot saved to: "
                                + screenshotPath.toAbsolutePath()
                );
            }

        } catch (IOException | RuntimeException e) {
            System.err.println(
                    "Could not save failure screenshot: "
                            + e.getMessage()
            );

        } finally {
            // Always close the browser
            DriverManager.quitDriver();
        }
    }
}
