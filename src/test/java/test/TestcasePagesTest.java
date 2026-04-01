package test;

import core.BaseTest;
import org.testng.annotations.Test;
import pages.HomePages;
import pages.TestcasePages;

public class TestcasePagesTest extends BaseTest {

    @Test (description = "TC07: Verify TestCases Page")
    public void TC07_VerifyTestCasesPage() {

        logger.info("STEP 1: Launch browser and open Home Page");
        homePage.openSite();

        logger.info("STEP 2: Click on 'Test Cases' button");
        homePage.clickMenu("Test Cases");

        logger.info("STEP 3: Verify user is navigated to Test Cases page successfully");
        testcasePages.verifyTestCasesPage();
    }
}