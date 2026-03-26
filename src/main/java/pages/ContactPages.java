package pages;

import core.BasePage;
import locator.ContactLocator;
import java.util.Map;

public class ContactPages extends BasePage {

    public ContactPages() {
        super();
    }

    public void verifyGetInTouchVisible() {
        logger.info("Verify 'GET IN TOUCH' title is visible");

        verifyElementVisible(
                ContactLocator.txtGetInTouch,
                "GET IN TOUCH is not visible"
        );
    }

    public void enterName(String name) {
        logger.info("Enter Name: {}", name);
        enterText(ContactLocator.txtName, name);
    }

    public void enterEmail(String email) {
        logger.info("Enter Email: {}", email);
        enterText(ContactLocator.txtEmail, email);
    }

    public void enterSubject(String subject) {
        logger.info("Enter Subject: {}", subject);
        enterText(ContactLocator.txtSubject, subject);
    }

    public void enterMessage(String message) {
        logger.info("Enter Message: {}", message);
        enterText(ContactLocator.txtMessage, message);
    }

    public void fillContactForm(Map<String, String> data) {

        logger.info("========== FILL CONTACT FORM ==========");

        if (data.containsKey("name") && !data.get("name").isBlank()) {
            logger.info("Enter Name: {}", data.get("name"));
            enterName(data.get("name"));
        }

        if (data.containsKey("email") && !data.get("email").isBlank()) {
            logger.info("Enter Email: {}", data.get("email"));
            enterEmail(data.get("email"));
        }

        if (data.containsKey("subject") && !data.get("subject").isBlank()) {
            logger.info("Enter Subject: {}", data.get("subject"));
            enterSubject(data.get("subject"));
        }

        if (data.containsKey("message") && !data.get("message").isBlank()) {
            logger.info("Enter Message: {}", data.get("message"));
            enterMessage(data.get("message"));
        }
    }

    public void uploadFile(String filePath) {
        logger.info("Upload file: {}", filePath);

        // Upload file bằng sendKeys
        sendKeys(ContactLocator.btnUploadFile, filePath);
    }

    public void clickSubmit() {
        logger.info("Click 'Submit' button");
        click(ContactLocator.btnSubmit);
    }

    public void acceptAlert() {
        logger.info("Accept alert popup");
        acceptAlertAction(switchToAlert());
    }

    public void clickHomeButton() {
        logger.info("Click 'Home' button");
        click(ContactLocator.btnHome);
    }


}
