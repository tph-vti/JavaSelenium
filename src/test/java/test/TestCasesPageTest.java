package test;

import core.BasePage;
import core.BaseTest;
import core.DriverManager;
import locator.TestCasesPageLocator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import pages.TestCasesPage;
import org.testng.annotations.Test;

public class TestCasesPageTest extends BaseTest {
    DriverManager driverManager;

    @BeforeMethod
    public void setup() throws Exception {
        driverManager = new DriverManager();
    }

    @AfterMethod
    public void teardown() {
        driverManager.quit();
    }

    @Test(description = "TC07: Verify Test Cases Page")
    public void TC07_VerifyTestCasesPage() {

        HomePage homePage = new HomePage();
        TestCasesPage testCasesPage = new TestCasesPage();

        logger.info("STEP 1: Launch browser and open Home Page");
        homePage.openSite();

        logger.info("STEP 2: Click on 'Test Cases' button");
        homePage.clickMenu("Test Cases");

        logger.info("STEP 3: Verify user is navigated to Test Cases page successfully");
        testCasesPage.verifyTestCasesPage();
    }
}