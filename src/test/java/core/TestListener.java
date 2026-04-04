package core;

import common.ScreenshotHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * TestListener provides automatic test lifecycle logging and screenshot capture on failure.
 * Implements TestNG ITestListener to hook into test events without modifying test code.
 *
 * Usage: Add @Listeners(TestListener.class) to BaseTest
 */
public class TestListener implements ITestListener {

    private static final Logger logger = LogManager.getLogger("automationExercise");

    @Override
    public void onTestStart(ITestResult result) {
        logger.info("▶ TEST STARTED: {} [{}]",
                result.getMethod().getMethodName(),
                result.getMethod().getDescription());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        long duration = result.getEndMillis() - result.getStartMillis();
        logger.info("✅ TEST PASSED: {} ({}ms)",
                result.getMethod().getMethodName(), duration);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        long duration = result.getEndMillis() - result.getStartMillis();
        logger.error("❌ TEST FAILED: {} ({}ms)",
                result.getMethod().getMethodName(), duration);
        logger.error("Failure reason: {}", result.getThrowable().getMessage());

        // Auto screenshot on failure
        String screenshotPath = ScreenshotHelper.captureScreenshot(
                result.getMethod().getMethodName());
        if (screenshotPath != null) {
            logger.info("Failure screenshot saved at: {}", screenshotPath);
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.warn("⏭ TEST SKIPPED: {} - Reason: {}",
                result.getMethod().getMethodName(),
                result.getThrowable() != null ? result.getThrowable().getMessage() : "Unknown");
    }
}
