package pages;

import core.BasePage;
import locator.ContactUsLocator;

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
        logger.info("Enter Name: abcxyz");
        enterText(ContactUsLocator.txtName, name);
    }
    public void enterEmail(String email){
        logger.info("Enter Email abc@gmail.com");
        enterText(ContactUsLocator.txtEmail, email);
    }
    public void enterSubject(String subject){
        logger.info("Enter Subject");
        enterText(ContactUsLocator.txtSubject, subject);
    }
    public void enterMessage(String message){
        logger.info("Enter Message");
        enterText(ContactUsLocator.txtMessage, message);
    }
}
