package pages;

import core.BasePage;
import locator.TestcaseLocator;

public class TestcasePage extends BasePage {
    public TestcasePage() {
        super();
    }

    public String getTestCaseTitle() {
        logger.info("Getting 'Test Cases' title");
        return getElementText(TestcaseLocator.TEST_CASE_TITLE);
    }
}
