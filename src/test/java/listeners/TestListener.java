package listeners;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import reporting.ExtentReportManager;
import utils.ScreenshotUtils;

public class TestListener implements ITestListener {

    private static final ThreadLocal<ExtentTest> test =
            new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {

        ExtentTest extentTest = ExtentReportManager
                        .getInstance()
                        .createTest(result.getName());

        test.set(extentTest);

        test.get().log(Status.INFO, "Test started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        test.get().pass("Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.get().fail(result.getThrowable());

        WebDriver driver = DriverManager.getDriver();

        if (driver != null) {

            String screenshotPath = ScreenshotUtils.takeScreenshot(driver, result.getName());

            try {

                test.get().addScreenCaptureFromPath(screenshotPath);

            } catch (Exception e) {

                test.get().warning("Unable to attach screenshot: " + e.getMessage());
            }
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        test.get().skip("Test skipped");
    }

    @Override
    public void onFinish(ITestContext context) {

        ExtentReportManager.getInstance().flush();

        test.remove();
    }
}