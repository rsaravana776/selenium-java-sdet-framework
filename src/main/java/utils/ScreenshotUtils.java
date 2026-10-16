package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class ScreenshotUtils {

    private ScreenshotUtils() {
    }

    public static String takeScreenshot(WebDriver driver, String testName) {

        try {

            String safeTestName = testName.replaceAll("[^a-zA-Z0-9-_]", "_");

            String fileName = safeTestName + "_thread-"
                            + Thread.currentThread().getId() + "_"
                            + System.currentTimeMillis() + ".png";

            Path directory = Paths.get("reports", "screenshots");

            Files.createDirectories(directory);

            Path target = directory.resolve(fileName);

            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

            Files.write(target, screenshot);

            return target.toString();

        } catch (IOException e) {

            throw new RuntimeException("Failed to save screenshot", e);
        }
    }
}