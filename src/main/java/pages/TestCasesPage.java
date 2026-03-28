package pages;

import core.BasePage;
import locator.TestCasesPageLocator;
import org.openqa.selenium.By;

public class TestCasesPage extends BasePage {
    public void clickTestCasesButton() {
        logger.info("Click 'Test Cases' button");
        click(TestCasesPageLocator.btnTestCases);
    }

    public boolean verifyTestCasesTitleVisible() {
        logger.info("Verify 'TEST CASES' title is displayed");
        verifyElementVisible(TestCasesPageLocator.lblTestCasesHeader, "Account Created!");
        return true;
    }

    public void verifyTestCasesPage() {

    }
}
