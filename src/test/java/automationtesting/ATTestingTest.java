package automationtesting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import core.BaseTest;
import pages.automation_demo.AlertPage;
import pages.guru.LoginPage;

public class ATTestingTest extends BaseTest {
    AlertPage alertPage;

    @BeforeEach
    public void setUp() {
        // Setup code before each test
        alertPage = new AlertPage();
    }

    @Test
    @Tag("automationtesting")
    public void alertWithOK() {
        /**
         * Test case sample 01
         */
        logger.info("Step 1: Click 'Alert with OK' button to display an alert box");
        alertPage.clickAlertWithOKButton();

        logger.info("Step 2: Accept the alert box");
        alertPage.acceptAlert();
    }

    @Test
    @Tag("automationtesting")
    public void alertWithOKCancel() {
        /**
         * Test case sample 02
         */
        logger.info("Automation Testing - Alert with OK & Cancel tab");
        alertPage.selectAlertTab("Alert with OK & Cancel");

        logger.info("Step 1: Click 'Alert with OK' button to display an alert box");
        alertPage.clickAlertWithOKCancelButton();

        logger.info("Step 2: Dismiss the alert box");
        alertPage.dismissAlert();

        logger.info("Step 3: Verify the alert was dismissed successfully");
        alertPage.verifyAlertDismissedMessage("You Pressed Cancel");
    }


    @Test
    @Tag("automationtesting")
    public void testSwitchWindow01() {
        logger.info("Automation Testing - Alert with OK & Cancel tab");
        alertPage.openSite("https://demo.automationtesting.in/Windows.html");

        alertPage.clickNewTabWindowButton();
        alertPage.verifyTitle("Selenium");


        alertPage.switchBackToOriginalWindow();
        alertPage.verifyTitle("Frames & windows");
    }


}
