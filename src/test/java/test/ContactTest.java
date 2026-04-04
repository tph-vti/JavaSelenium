package test;

import core.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static core.Constants.*;

public class ContactTest extends BaseTest {

    @Test(description = "TC6: Contact Us Form")
    public void testContactUsForm() {        

        String name = getRandomUserName();
        String email = getRandomEmail();
        String subject = getRandomSubject();
        String message = getRandomMessage();

        logStep("3. Verify that home page is visible successfully");
        commonPage.clickHomeButton();
        expectedResult = HOME_PAGE_LINK;
        actualResult = commonPage.getCurrentUrl();
        Assert.assertEquals(actualResult, expectedResult);

        logStep("4. Click on'Contact Us' button");
        commonPage.clickContactUs();

        logStep("5. Verify 'GET IN TOUCH' is visible");
        String expectedTitle = GET_IN_TOUCH_TITLE;
        String actualTitle = contactPage.getGetInTouchTitle();
        Assert.assertEquals(actualTitle, expectedTitle);

        logStep("6. Enter name, email, subject and message");
        contactPage.enterContactForm(name, email, subject, message);

        logStep("7. Upload file");
        String fileName = System.getProperty("user.dir") + FILE_PATH;
        contactPage.uploadFile(fileName);

        logStep("8. Click 'Submit' button");
        contactPage.clickSubmitButton();

        logStep("9. Click 'OK' button");
        contactPage.clickOkButton();

        logStep("10. Verify success message 'Success! Your details have been submitted successfully.' is visible");
        expectedTitle = SUCCESS_CONTACT_MESSAGE;
        actualTitle = contactPage.getSuccessMessage();
        Assert.assertEquals(actualTitle, expectedTitle);

        logStep("11.1 Click 'Home' button");
        contactPage.clickHomeButton();

        logStep("11.2 Verify that landed to home page successfully");
        expectedTitle = HOME_PAGE_LINK;
        actualTitle = commonPage.getCurrentUrl();
        Assert.assertEquals(actualTitle, expectedTitle);
    }
}
