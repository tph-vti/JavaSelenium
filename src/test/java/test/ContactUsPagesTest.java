package test;

import core.BaseTest;
import core.DriverManager;
import data.TestData;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;

import java.util.Map;

public class ContactUsPagesTest extends BaseTest {
    @BeforeMethod
    public void setup() throws Exception {
        driverManager = new DriverManager();
    }

    @AfterMethod
    public void teardown() {
        driverManager.quit();
    }


        @Test(description = "TC06 - Contact Us Form")
        public void TC06_ContactUsForm() {

            HomePage homePage = new HomePage();
            ContactUsPage contactPage = new ContactUsPage();
            Map<String, String> data = TestData.getContactUsData();

            logger.info("STEP 1: Open Home Page");
            homePage.openSite();

            logger.info("STEP 2: Click 'Contact Us' menu");
            homePage.clickMenu("Contact us");

            logger.info("STEP 3: Verify 'GET IN TOUCH' is visible");
            Assert.assertTrue(contactPage.verifyGetInTouchHeaderVisible());

            logger.info("STEP 4: Enter name, email, subject and message");
            contactPage.fillContactUsForm(data);

            logger.info("STEP 5: Upload file");
            contactPage.uploadFile();

            logger.info("STEP 6: Click 'Submit' button");
            contactPage.clickSubmit();

            contactPage.acceptAlert();

            logger.info("STEP 7: Click 'Home' button");
            contactPage.clickHomeButton();

            logger.info("STEP 8: Verify user is navigated to Home page");
            contactPage.verifyHomePage();
        }
}
