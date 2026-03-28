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
        TestCasesPage testCasesPage = new TestCasesPage();
        BasePage.openSite();
        testCasesPage.click(TestCasesPageLocator.btnTestCases);
        testCasesPage.verifyTestCasesTitleVisible();
    }
}