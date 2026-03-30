package core;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.ITestResult;

import pages.*;
import utils.Helper;

import java.lang.reflect.Method;
import java.net.MalformedURLException;

public class BaseTest extends Helper {
    protected DriverManager driverManager;

    protected HomePages homePage;
    protected ContactPages contactPage;
    protected LoginPages loginPages;
    protected ProductPages productPages;
    protected RegisterPages registerPages;
    protected TestcasePages testcasePages;


    @BeforeMethod
    public void setup(Method method) throws MalformedURLException {
        logger.info("========================================");
        logger.info("Starting test: {}", method.getName());
        logger.info("Test class: {}", method.getDeclaringClass().getName());
        logger.info("Environment: {}", TestSettings.TEST_ENV);
        logger.info("Browser: {}", TestSettings.BROWSER_TYPE);
        logger.info("========================================");

        try {
            driverManager = new DriverManager();
            logger.info("WebDriver initialized successfully");

            // 🔥 THÊM ĐOẠN NÀY
            WebDriver driver = driverManager.getDriver();

            homePage = new HomePages();
            loginPages = new LoginPages();
            registerPages = new RegisterPages();
            contactPage = new ContactPages();
            productPages = new ProductPages();
            testcasePages = new TestcasePages();

            logger.info("All pages initialized");

        } catch (Exception e) {
            logger.error("Failed to initialize WebDriver", e);
            throw e;
        }
    }



    @AfterMethod
    public void teardown(ITestResult result) {
        try {
            if (driverManager != null) {
                driverManager.quit();
                logger.info("WebDriver quit successfully");
            }
        } catch (Exception e) {
            logger.error("Error during test teardown", e);
        }

        logger.info("Test completed: {}", result.getMethod().getMethodName());
        logger.info("Status: {}", getStatus(result.getStatus()));
        logger.info("========================================\n");
    }

    private String getStatus(int status) {
        switch (status) {
            case ITestResult.SUCCESS:
                return "PASSED";
            case ITestResult.FAILURE:
                return "FAILED";
            case ITestResult.SKIP:
                return "SKIPPED";
            default:
                return "UNKNOWN";
        }
    }


}