package locator;

import org.openqa.selenium.By;

public class ContactLocator {

    // GET IN TOUCH
    public static final By GET_IN_TOUCH_TITLE = By.xpath("//h2[normalize-space()='Get In Touch']");
    // NAME
    public static final By NAME_INPUT = By.xpath("//input[@placeholder='Name']");
    // EMAIL
    public static final By EMAIL_INPUT = By.xpath("//input[@placeholder='Email']");
    // SUBJECT
    public static final By SUBJECT_INPUT = By.xpath("//input[@placeholder='Subject']");
    // MESSAGE
    public static final By MESSAGE_INPUT = By.xpath("//textarea[@id='message']");
    // SUBMIT
    public static final By SUBMIT_BUTTON = By.xpath("//input[@type='submit']");
    // SUCCESS MESSAGE
    public static final By SUCCESS_MESSAGE = By.xpath("//div[@class='status alert alert-success']");
    // UPLOAD FILE
    public static final By UPLOAD_FILE_INPUT = By.xpath("//input[@type='file']");
    // DOWNLOAD
    public static final By DOWNLOAD_LINK = By.xpath("//a[normalize-space()='Download']");
    // OK BUTTON
    public static final By OK_BUTTON = By.xpath("//button[normalize-space()='OK']");
    // HOME BUTTON
    public static final By HOME_BUTTON = By.xpath("//a[@class='btn btn-success']"); 
}
