package core;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.ITestResult;
import java.lang.reflect.Method;
import common.DataGenerator;
import pages.RegisterPage;

import java.net.MalformedURLException;

public class BaseTest extends DataGenerator {
    protected DriverManager driverManager;

    /**
     * Pre-condition: Registers a new user, returns to home, and returns their credentials.
     * Leaves the browser on the home page as a logged-in user.
     * @return String array [username, email, password]
     */
    protected String[] registerAndGetCredentials() {
        RegisterPage registerPage = new RegisterPage();
        
        String username = getRandomUserName();
        String email = getRandomEmail();
        String password = getRandomPassword();
        
        java.time.LocalDate randomDate = getRandomBirthDate();
        String day = getDayFromDate(randomDate);
        String month = getMonthFromDate(randomDate);
        String year = getYearFromDate(randomDate);

        registerPage.register("Mr.", username, email, password, day, month, year, 
            getRandomFirstName(), getRandomLastName(), getRandomCompanyName(), 
            getRandomAddress(), getRandomAddress(), getRandomCountry(), 
            getRandomState(), getRandomCity(), getRandomZipCode(), getRandomPhoneNumber());
            
        // The register() method now includes clickContinueButton(), so we are back on home page.
        
        return new String[]{username, email, password};
    }

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
