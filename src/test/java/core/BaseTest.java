package core;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.ITestResult;
import java.lang.reflect.Method;
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
import org.testng.Assert;

import java.net.MalformedURLException;

public class BaseTest extends DataGenerator {
    protected DriverManager driverManager;
    protected RegisterPage registerPage;
    protected LoginPage loginPage;
    protected CommonPage commonPage;
    protected HomePage homePage;
    protected ContactPage contactPage;
    protected ProductPage productPage;
    protected TestcasePage testcasePage;
    protected Assert Assert;
    protected Constants constants;

    // Factory
    protected User user = UserFactory.registerValidUser();

    protected String expectedResult;
    protected String actualResult;

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
            registerPage = new RegisterPage();
            loginPage = new LoginPage();
            commonPage = new CommonPage();
            homePage = new HomePage();
            contactPage = new ContactPage();
            productPage = new ProductPage();
            testcasePage = new TestcasePage();
            
            commonPage.openSite(common.Constants.AUTOMATION_EXERCISE_BASE_URL);

            logger.info("WebDriver initialized successfully");
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
        try {
            if (driverManager != null) {
                driverManager.quit();
                logger.info("WebDriver quit successfully");
            }
        } catch (Exception e) {
            logger.error("Error during test teardown", e);
        }

        logger.info("Test completed: {}", result.getName());
        logger.info("========================================\n");
    }
}
