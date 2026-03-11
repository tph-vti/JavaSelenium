package core;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import utils.Helper;

import java.net.MalformedURLException;

/**
 * BaseTest provides common setup and teardown for all test classes.
 * Uses @BeforeEach/@AfterEach for test-level driver lifecycle (better test isolation).
 */
public class BaseTest extends Helper {
    protected DriverManager driverManager;

    /**
     * Setup executed before each test method.
     * Initializes WebDriver instance for the test.
     *
     * @param testInfo JUnit 5 test metadata
     * @throws MalformedURLException if hub URL is malformed
     */
    @BeforeEach
    public void setup(TestInfo testInfo) throws MalformedURLException {
        logger.info("========================================");
        logger.info("Starting test: {}", testInfo.getDisplayName());
        logger.info("Test class: {}", testInfo.getTestClass().orElse(null));
        logger.info("Environment: {}", TestSettings.TEST_ENV);
        logger.info("Browser: {}", TestSettings.BROWSER_TYPE);
        logger.info("========================================");

        try {
            driverManager = new DriverManager();
            logger.info("WebDriver initialized successfully");
        } catch (Exception e) {
            logger.error("Failed to initialize WebDriver", e);
            throw e;
        }
    }

    /**
     * Teardown executed after each test method.
     * Quits WebDriver and logs test completion.
     *
     * @param testInfo JUnit 5 test metadata
     */
    @AfterEach
    public void teardown(TestInfo testInfo) {
        try {
            if (driverManager != null) {
                driverManager.quit();
                logger.info("WebDriver quit successfully");
            }
        } catch (Exception e) {
            logger.error("Error during test teardown", e);
        }

        logger.info("Test completed: {}", testInfo.getDisplayName());
        logger.info("========================================\n");
    }
}
