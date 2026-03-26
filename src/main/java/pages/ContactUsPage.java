package pages;

import core.BasePage;
import locator.ContactUsLocator;

import java.nio.file.Paths;
import java.util.Map;

public class ContactUsPage extends BasePage {
    public ContactUsPage() {
        super();
    }
    //=====ACTIONS=====
    public boolean verifyGetInTouchHeader (){
        logger.info("Verify 'GET IN TOUCH' is visible");
        verifyElementVisible(ContactUsLocator.lblGetInTouchHeader,"Contact Us page is not visible");
        return true;
    }

    public void enterName(String name){
        logger.info("Enter Name: {}", name);
        enterText(ContactUsLocator.txtName, name);
    }
    public void enterEmail(String email){
        logger.info("Enter Email: {}", email);
        enterText(ContactUsLocator.txtEmail, email);
    }
    public void enterSubject(String subject){
        logger.info("Enter Subject: {}", subject);
        enterText(ContactUsLocator.txtSubject, subject);
    }
    public void enterMessage(String message){
        logger.info("Enter Message: {}", message);
        enterText(ContactUsLocator.txtMessage, message);
    }


    public void fillContactUsForm(Map<String, String> data) {

        logger.info("========== FILL CONTACT US FORM ==========");

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

    // ===== UPLOAD FILE =====
    private final String filePath = Paths.get("src/test/resources/files/test.txt")
            .toAbsolutePath()
            .toString();

    public void uploadFile() {
        logger.info("Upload file: {}", filePath);

        driver.findElement(ContactUsLocator.btnUploadFile)
                .sendKeys(filePath);
    }


    public void clickSubmit() {
        logger.info("Click 'Submit' button");
        click(ContactUsLocator.btnSubmit);
    }

    public void acceptAlert() {
        logger.info("Accept alert popup");
        acceptAlertAction(switchToAlert());
    }

    public void clickHomeButton() {
        logger.info("Click 'Home' button");
        click(ContactUsLocator.btnHome);
    }

    public boolean verifyHomePage() {
        logger.info("Verify user is navigated back to Home page");
        return driver.getCurrentUrl().equals("https://automationexercise.com/");
    }
}
