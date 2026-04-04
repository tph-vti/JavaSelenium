package locator;

import org.openqa.selenium.By;

public class ContactLocator {

    // GET IN TOUCH
    public static final By GET_IN_TOUCH_TITLE = By.xpath("//h2[normalize-space()='Get In Touch']");
    // NAME
    public static final By NAME_INPUT = By.cssSelector("[data-qa='name']");
    // EMAIL
    public static final By EMAIL_INPUT = By.cssSelector("[data-qa='email']");
    // SUBJECT
    public static final By SUBJECT_INPUT = By.cssSelector("[data-qa='subject']");
    // MESSAGE
    public static final By MESSAGE_INPUT = By.id("message");
    // SUBMIT
    public static final By SUBMIT_BUTTON = By.cssSelector("[data-qa='submit-button']");
    // SUCCESS MESSAGE
    public static final By SUCCESS_MESSAGE = By.cssSelector(".status.alert.alert-success");
    // UPLOAD FILE
    public static final By UPLOAD_FILE_INPUT = By.cssSelector("input[type='file']");
    // HOME BUTTON
    public static final By HOME_BUTTON = By.cssSelector("a.btn.btn-success");
}
