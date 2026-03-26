package locator;

import org.openqa.selenium.By;

public class ContactUsLocator {
    public static By lblGetInTouchHeader = By.xpath("//h2[contains(text(),'Get In Touch')]");
    public static By txtName = By.xpath("//input[@data-qa='name']");
    public static By txtEmail = By.xpath("//input[@data-qa='email']");
    public static By txtSubject = By.xpath("//input[@data-qa='subject']");
    public static By txtMessage = By.id("message");
    public static By btnUploadFile = By.xpath("//input[@name='upload_file']");
    public static By btnSubmit = By.xpath("//input[@type='submit']");

    public static By successMessage = By.xpath("//div[contains(text(),'Success!')]");
}
