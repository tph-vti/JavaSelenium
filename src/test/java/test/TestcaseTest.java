package test;

import core.BaseTest;
import org.testng.annotations.Test;

public class TestcaseTest extends BaseTest {
    @Test(description = "TC7: Verify Test Cases page")
    public void testVerifyTestCasesPage() {

        logStep("3. Verify that home page is visible successfully");
        commonPage.clickHomeButton();
        expectedResult = constants.HOME_PAGE_LINK;
        actualResult = commonPage.getCurrentUrl();
        Assert.assertEquals(actualResult, expectedResult);

        logStep("4. Click on 'Test Cases' button");
        commonPage.clickMenu("Test Cases");

        logStep("5. Verify user is navigated to test cases page successfully");
        expectedResult = constants.TEST_CASE_TITLE;
        actualResult = testcasePage.getTestCaseTitle();
        Assert.assertEquals(actualResult, expectedResult);
    }
}
