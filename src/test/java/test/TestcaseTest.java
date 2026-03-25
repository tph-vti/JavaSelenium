package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import core.BaseTest;
import static core.Constants.*;

public class TestcaseTest extends BaseTest {
    @Test(description = "TC7: Verify Test Cases page")
    public void testVerifyTestCasesPage() {

        logger.info("3. Verify that home page is visible successfully");
        expectedResult = HOME_TITLE;
        actualResult = homePage.getHomeTitle();
        Assert.assertEquals(actualResult, expectedResult);

        logger.info("4. Click on 'Test Cases' button");
        commonPage.clickMenu("Test Cases");

        logger.info("5. Verify user is navigated to test cases page successfully");
        expectedResult = TEST_CASE_TITLE;
        actualResult = testcasePage.getTestCaseTitle();
        Assert.assertEquals(actualResult, expectedResult);
    }
}
