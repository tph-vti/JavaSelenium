package test;

import core.BaseTest;
import org.testng.annotations.Test;
import pages.ContactPages;
import pages.HomePages;
import data.TestData;

public class ContactPagesTest extends BaseTest {

    @Test
    public void TC06_ContactUsForm() {

        HomePages homePage = new HomePages();
        ContactPages contactPage = new ContactPages();

        logger.info("STEP 1: Open Home Page");
        homePage.openSite();

        logger.info("STEP 2: Click 'Contact Us' menu");
        homePage.clickMenu("Contact us");

        logger.info("STEP 3: Verify 'GET IN TOUCH' is visible");
        contactPage.verifyGetInTouchVisible();

        logger.info("STEP 4: Enter name, email, subject and message");
        contactPage.fillContactForm(TestData.contactData);

        logger.info("STEP 5: Upload file");
        contactPage.uploadFile("C:\\Users\\ADMIN\\OneDrive\\Desktop\\test.txt");

        logger.info("STEP 6: Click 'Submit' button");
        contactPage.clickSubmit();

        contactPage.acceptAlert();

        logger.info("STEP 7: Click 'Home' button");
        contactPage.clickHomeButton();

        logger.info("STEP 8: Verify user is navigated to Home page");
        homePage.verifyHomePage();
    }
}