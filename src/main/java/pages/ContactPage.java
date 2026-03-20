package pages;

import core.BasePage;
import locator.ContactLocator;
import static common.Constants.*;

public class ContactPage extends BasePage {
    public ContactPage() {
        super();
        openSite(AUTOMATION_EXERCISE_BASE_URL);
        removeAds();
    }

    public String getGetInTouchTitle() {
        logger.info("Getting 'Get In Touch' title");
        return getElementText(ContactLocator.GET_IN_TOUCH_TITLE);
    }

    public void enterContactForm(String name, String email, String subject, String message) {
        logger.info("Entering contact form");
        if (name != null && !name.isEmpty()) {
            enterText(ContactLocator.NAME_INPUT, name);
        }
        if (email != null && !email.isEmpty()) {
            enterText(ContactLocator.EMAIL_INPUT, email);
        }
        if (subject != null && !subject.isEmpty()) {
            enterText(ContactLocator.SUBJECT_INPUT, subject);
        }
        if (message != null && !message.isEmpty()) {
            enterText(ContactLocator.MESSAGE_INPUT, message);
        }
    }

    public void clickSubmitButton() {
        logger.info("Clicking submit button");
        clickButtonJS(ContactLocator.SUBMIT_BUTTON);
    }

    public void clickOkButton() {
        logger.info("Clicking OK button");
        acceptAlertIfPresent();
    }

    public void clickHomeButton() {
        logger.info("Clicking home button");
        clickButtonJS(ContactLocator.HOME_BUTTON);
    }

    public String getSuccessMessage() {
        logger.info("Getting success message");
        return getElementText(ContactLocator.SUCCESS_MESSAGE);
    }

    public void uploadFile(String filePath) {
        logger.info("Uploading file: {}", filePath);
        if (filePath != null && !filePath.isEmpty()) {
            uploadFile(ContactLocator.UPLOAD_FILE_INPUT, filePath);
        }
    }

}
