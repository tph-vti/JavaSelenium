//package guru;
//import core.BaseTest;
//import org.junit.jupiter.api.Tag;
//import org.junit.jupiter.api.Test;
//
//import pages.guru.DragDropPage;
//import pages.guru.GuruToolTipsPage;
//import pages.guru.LoginPage;
//
//public class GutuTest extends BaseTest {
//
//    @Test
//    @Tag("guru")
//    public void guruTc01() {
//        /**
//         * Test case sample 01
//         */
//        LoginPage loginPage = new LoginPage();
//        logger.info("Test case sample 01");
//
//        logger.info("Step 1: Go to Guru99 Demo Site");
//        loginPage.openSite();
//
//        logger.info("Step 2: Input blank into User Id text box");
//        loginPage.enterEmailID("");
//        loginPage.submitEmailID();
//
//        logger.info("Step 3: Verify that the Login page show text as 'Email ID must not be blank'");
//        loginPage.verifyLoginErrorMessage("Email ID must not be blank");
//    }
//
//    @Test
//    @Tag("guru")
//    public void guruTc02() {
//        /**
//         * Test case sample 02
//         * Tooltips
//         */
//        logger.info("Pre-condition: Go to Guru99 Tooltips Demo Site");
//        GuruToolTipsPage guruToolTipsPage = new GuruToolTipsPage();
//
//        logger.info("1. Hover to 'Download now' button");
//        guruToolTipsPage.hoverToDownloadNowButton();
//
//        logger.info("VP: Verify tooltip text is displayed");
//        guruToolTipsPage.verifyTooltipTextIsDisplayed();
//    }
//
//    @Test
//    @Tag("guru")
//    public void guruTc03() {
//        /**
//         * Test case sample 03
//         * Drag and Drop
//         */
//        logger.info("Test case sample 03 - Drag and Drop");
//        DragDropPage dragDropPage = new DragDropPage();
//
//        logger.info("1. Perform drag and drop action");
//        dragDropPage.dragDropAmountToCardType("5000", "DEBIT SIDE");
//
//        logger.info("VP: Verify amount '5000' is displayed in 'Debit Card' section");
//        dragDropPage.verifyAmountInCardType("5000", "DEBIT SIDE");
//    }
//}
