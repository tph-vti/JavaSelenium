package pages;

import core.BasePage;
import locator.TestcaseLocator;

public class TestcasePages extends BasePage {

    public TestcasePages() {
        super();
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
    }
}