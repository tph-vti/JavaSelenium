package pages;

import core.BasePage;
import locator.TestCasesPageLocator;
import org.openqa.selenium.By;

public class TestCasesPage extends BasePage {

    public boolean verifyTestCasesTitleVisible() {

        logger.info("Verify 'TEST CASES' title is displayed");
        verifyElementVisible(TestCasesPageLocator.lblTestCasesHeader, "Test Cases");
        return true;
    }

    public void verifyTestCasesPage() {
        logger.info("Verify user is navigated to Test Cases page");

        verifyElementVisible(
                TestCasesPageLocator.lblTestCasesHeader,
                "Test Cases title is NOT visible"
        );

    }
}
