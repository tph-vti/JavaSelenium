package common;

import core.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * ScreenshotHelper provides utility methods for capturing screenshots.
 * Used primarily by TestListener for auto-capture on test failure.
 */
public class ScreenshotHelper {

    private static final Logger logger = LogManager.getLogger("automationExercise");
    private static final String SCREENSHOT_DIR = Paths.get(
            System.getProperty("user.dir"), "target", "screenshots").toString();
    private static final DateTimeFormatter TIMESTAMP_FORMAT =
            DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");

    private ScreenshotHelper() {
        // Utility class - prevent instantiation
    }

    /**
     * Captures a screenshot and saves it to the screenshots directory.
     *
     * @param driver   the WebDriver instance
     * @param testName the name of the test (used in filename)
     * @return the absolute path to the saved screenshot, or null if failed
     */
    public static String captureScreenshot(WebDriver driver, String testName) {
        try {
            // Ensure screenshot directory exists
            Path screenshotDir = Paths.get(SCREENSHOT_DIR);
            if (!Files.exists(screenshotDir)) {
                Files.createDirectories(screenshotDir);
            }

            // Generate filename with timestamp
            String timestamp = LocalDateTime.now().format(TIMESTAMP_FORMAT);
            String fileName = String.format("%s_%s.png", testName, timestamp);
            Path screenshotPath = screenshotDir.resolve(fileName);

            // Capture screenshot
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(srcFile.toPath(), screenshotPath);

            logger.info("Screenshot saved: {}", screenshotPath);
            return screenshotPath.toString();
        } catch (Exception e) {
            logger.error("Failed to capture screenshot for test: {}", testName, e);
            return null;
        }
    }

    /**
     * Captures a screenshot using the current thread's WebDriver from DriverManager.
     *
     * @param testName the name of the test
     * @return the absolute path to the saved screenshot, or null if failed
     */
    public static String captureScreenshot(String testName) {
        try {
            WebDriver driver = DriverManager.getDriver();
            return captureScreenshot(driver, testName);
        } catch (IllegalStateException e) {
            logger.warn("Cannot capture screenshot - WebDriver not available: {}", e.getMessage());
            return null;
        }
    }
}
