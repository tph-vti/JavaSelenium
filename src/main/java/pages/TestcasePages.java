package pages;

import core.BasePage;
import locator.TestcaseLocator;

public class TestcasePages extends BasePage {

    public TestcasePages() {
        super();
    }

    public void verifyTestCasesPageByUrl() {
        logger.info("Verify URL contains /test_cases");

        String currentUrl = driver.getCurrentUrl();

        if (!currentUrl.contains("/test_cases")) {
            throw new AssertionError("URL is incorrect: " + currentUrl);
        }

        logger.info("Correct Test Cases URL");
    }

    public void verifyTestCasesPage() {
        logger.info("Verify user is navigated to Test Cases page");

        verifyElementVisible(
                TestcaseLocator.txtTestCasesTitle,
                "Test Cases title is NOT visible"
        );

        verifyElementVisible(
                TestcaseLocator.listTestCases,
                "Test Cases list is NOT visible"
        );

        logger.info("User is successfully navigated to Test Cases page");
    }
}