package ve3.test;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestWithReport {
    public static void main(String[] args) {
        // Setup Extent Report
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("test-output/ExtentReport.html");
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        ExtentTest test = extent.createTest("Homepage Load Test", "Verify VE3 homepage loads");

        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://ve3.global");

            String title = driver.getTitle();
            if (title.toLowerCase().contains("ve3")) {
                test.pass("Homepage loaded successfully");
            } else {
                test.fail("Homepage title did not match").addScreenCaptureFromPath(ScreenshotUtil.captureScreenshot(driver, "homepage_fail"));
            }

        } catch (Exception e) {
            test.fail("Exception: " + e.getMessage());
        } finally {
            driver.quit();
            extent.flush(); // Write everything to the report
        }
    }
}
