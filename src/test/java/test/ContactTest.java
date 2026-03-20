package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import core.BaseTest;
import pages.CommonPage;
import pages.ContactPage;
import pages.HomePage;

import static core.Constants.*;

public class ContactTest extends BaseTest {

    @Test(description = "TC6: Contact Us Form")
    public void testContactUsForm() {
        ContactPage contactPage = new ContactPage();
        CommonPage commonPage = new CommonPage();
        HomePage homePage = new HomePage();
        

        String name = getRandomUserName();
        String email = getRandomEmail();
        String subject = getRandomSubject();
        String message = getRandomMessage();

        logger.info("4. Click on'Contact Us' button");
        commonPage.clickContactUs();

        logger.info("5. Verify 'GET IN TOUCH' is visible");
        String expectedTitle = GET_IN_TOUCH_TITLE;
        String actualTitle = contactPage.getGetInTouchTitle();
        Assert.assertEquals(actualTitle, expectedTitle);

        logger.info("6. Enter name, email, subject and message");
        contactPage.enterContactForm(name, email, subject, message);

        logger.info("7. Upload file");
        contactPage.uploadFile(FILE_PATH);

        logger.info("8. Click 'Submit' button");
        contactPage.clickSubmitButton();

        logger.info("9. Click 'OK' button");
        contactPage.clickOkButton();

        logger.info("10. Verify success message 'Success! Your details have been submitted successfully.' is visible");
        expectedTitle = SUCCESS_MESSAGE;
        actualTitle = contactPage.getSuccessMessage();
        Assert.assertEquals(actualTitle, expectedTitle);

        logger.info("11.1 Click 'Home' button");
        contactPage.clickHomeButton();

        logger.info("11.2 Verify that landed to home page successfully");
        expectedTitle = HOME_TITLE;
        actualTitle = homePage.getHomeTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }
}
