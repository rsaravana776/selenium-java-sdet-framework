package reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public final class ExtentReportManager {

    private static ExtentReports extent;

    private ExtentReportManager() {
    }

    public static synchronized ExtentReports getInstance() {

        if (extent == null) {

            ExtentSparkReporter sparkReporter = new ExtentSparkReporter("reports/extent-report.html");

            sparkReporter.config()
                    .setDocumentTitle("SDET Automation Report");

            sparkReporter.config()
                    .setReportName("Automation Execution Report");

            extent = new ExtentReports();

            extent.attachReporter(sparkReporter);

            extent.setSystemInfo("Project", "SDET Automation Framework");

            extent.setSystemInfo("Environment",
                    System.getProperty("env", "qa")
            );
        }

        return extent;
    }
}