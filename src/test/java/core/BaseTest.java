package core;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.lang.reflect.Method;
import java.net.MalformedURLException;

import common.DataGenerator;
import factory.UserFactory;
import models.User;
import pages.RegisterPage;
import pages.TestcasePage;
import pages.LoginPage;
import pages.ProductPage;
import pages.CommonPage;
import pages.ContactPage;
import pages.HomePage;

/**
 * BaseTest provides common test setup, teardown, and shared page objects.
 * Fixed: Removed 'protected Assert Assert' field that shadowed TestNG Assert class.
 * Added: @Listeners(TestListener.class) for auto screenshot on failure + lifecycle logging.
 */
@Listeners(TestListener.class)
public class BaseTest extends DataGenerator {
    protected DriverManager driverManager;
    protected RegisterPage registerPage;
    protected LoginPage loginPage;
    protected CommonPage commonPage;
    protected HomePage homePage;
    protected ContactPage contactPage;
    protected ProductPage productPage;
    protected TestcasePage testcasePage;
    protected Constants constants;

    // Factory
    protected User user = UserFactory.registerValidUser();

    protected String expectedResult;
    protected String actualResult;

    @BeforeMethod
    public void setup(Method method) throws MalformedURLException {
        long startTime = System.currentTimeMillis();
        logger.info("========================================");
        logger.info("Starting test: {}", method.getName());
        logger.info("Test class: {}", method.getDeclaringClass().getSimpleName());
        logger.info("Environment: {}", TestSettings.TEST_ENV);
        logger.info("Browser: {}", TestSettings.BROWSER_TYPE);
        logger.info("========================================");

        try {
            driverManager = new DriverManager();
            registerPage = new RegisterPage();
            loginPage = new LoginPage();
            commonPage = new CommonPage();
            homePage = new HomePage();
            contactPage = new ContactPage();
            productPage = new ProductPage();
            testcasePage = new TestcasePage();
            
            commonPage.openSite(common.Constants.AUTOMATION_EXERCISE_BASE_URL);

            long duration = System.currentTimeMillis() - startTime;
            logger.info("WebDriver initialized successfully ({}ms)", duration);
        } catch (Exception e) {
            logger.error("Failed to initialize WebDriver", e);
            throw e;
        }
    }

    public String[] registerAndGetCredentials() {
        user = UserFactory.registerValidUser();
        
        commonPage.clickSignupLogin();
        loginPage.enterRegisterNameAndEmail(user);
        loginPage.clickSignupButton();
        registerPage.fillAccountInformationForm(user);
        registerPage.fillDateOfBirth(user);
        registerPage.clickNewsletterCheckbox();
        registerPage.clickSpecialOffersCheckbox();
        registerPage.fillAddressInformation(user);
        registerPage.clickCreateAccountButton();
        commonPage.clickContinueButton();

        return new String[] { user.getName(), user.getEmail(), user.getPassword() };
    }

    @AfterMethod
    public void teardown(ITestResult result) {
        String status;
        switch (result.getStatus()) {
            case ITestResult.SUCCESS:
                status = "✅ PASS";
                break;
            case ITestResult.FAILURE:
                status = "❌ FAIL";
                break;
            case ITestResult.SKIP:
                status = "⏭ SKIP";
                break;
            default:
                status = "UNKNOWN";
        }

        try {
            if (driverManager != null) {
                driverManager.quit();
                logger.info("WebDriver quit successfully");
            }
        } catch (Exception e) {
            logger.error("Error during test teardown", e);
        }

        long duration = result.getEndMillis() - result.getStartMillis();
        logger.info("Test completed: {} | Status: {} | Duration: {}ms",
                result.getName(), status, duration);
        logger.info("========================================\n");
    }
}
