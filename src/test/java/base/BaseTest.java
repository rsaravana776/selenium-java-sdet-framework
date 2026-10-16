package base;

import driver.DriverFactory;
import driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import utils.ConfigReader;

public class BaseTest {

    @BeforeSuite(alwaysRun = true)
    public void loadConfiguration() {

        String env =
                System.getProperty("env", "qa");

        ConfigReader.load(
                "config-" + env + ".properties"
        );
    }

    @BeforeMethod(alwaysRun = true)
    @Parameters("browser")
    public void setUp(
            @Optional("chrome") String browser) {

        String executionMode =
                ConfigReader.get("execution.mode");

        String gridUrl =
                ConfigReader.get("grid.url");

        WebDriver driver =
                DriverFactory.createDriver(
                        browser,
                        executionMode,
                        gridUrl
                );

        DriverManager.setDriver(driver);

        DriverManager.getDriver().get(
                ConfigReader.get("url")
        );
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {

        DriverManager.quitDriver();
    }

    protected WebDriver getDriver() {
        return DriverManager.getDriver();
    }
}