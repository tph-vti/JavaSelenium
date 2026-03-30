package core;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.Helper;

import java.lang.reflect.Method;
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
     * @throws MalformedURLException if hub URL is malformed
     */
    @BeforeMethod
    public void setup(Method method) throws MalformedURLException {
        logger.info("========================================");
        logger.info("Starting test: {}", method.getName());
        logger.info("Test class: {}", method.getDeclaringClass());
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
     */
    @AfterMethod
    public void teardown(Method method) {
        try {
            if (driverManager != null) {
                driverManager.quit();
                logger.info("WebDriver quit successfully");
            }
        } catch (Exception e) {
            logger.error("Error during test teardown", e);
        }

        logger.info("Test completed: {}", method.getName());
        logger.info("========================================\n");
    }
}
