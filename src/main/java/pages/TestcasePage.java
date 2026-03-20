package pages;

import core.BasePage;
import locator.TestcaseLocator;
import static common.Constants.*;

public class TestcasePage extends BasePage {
    public TestcasePage() {
        super();
        openSite(AUTOMATION_EXERCISE_BASE_URL);
        removeAds();
    }

    public String getTestCaseTitle() {
        logger.info("Getting 'Test Cases' title");
        if(isElementDisplayed(TestcaseLocator.TEST_CASE_TITLE)) {
            return getElementText(TestcaseLocator.TEST_CASE_TITLE);
        }
        return "";
    }
}
