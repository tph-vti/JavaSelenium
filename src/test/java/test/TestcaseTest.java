package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import core.BaseTest;
import pages.CommonPage;
import pages.HomePage;
import pages.TestcasePage;
import static core.Constants.*;

public class TestcaseTest extends BaseTest {
    @Test(description = "TC7: Verify Test Cases page")
    public void testVerifyTestCasesPage() {
        CommonPage commonPage = new CommonPage();
        TestcasePage testcasePage = new TestcasePage();
        HomePage homePage = new HomePage();
        String expectedTitle;
        String actualTitle;

        logger.info("3. Verify that home page is visible successfully");
        expectedTitle = HOME_TITLE;
        actualTitle = homePage.getHomeTitle();
        Assert.assertEquals(actualTitle, expectedTitle);

        logger.info("4. Click on 'Test Cases' button");
        commonPage.clickMenu("Test Cases");

        logger.info("5. Verify user is navigated to test cases page successfully");
        expectedTitle = TEST_CASE_TITLE;
        actualTitle = testcasePage.getTestCaseTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }
}
