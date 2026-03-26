package locator;

import org.openqa.selenium.By;

public class ContactLocator {

    public static By txtGetInTouch = By.xpath("//h2[text()='Get In Touch']");

    public static By txtName = By.xpath("//input[@name='name']");

    public static By txtEmail = By.xpath("//input[@name='email']");

    public static By txtSubject = By.xpath("//input[@name='subject']");

    public static By txtMessage = By.xpath("//textarea[@name='message']");

    public static By btnUploadFile = By.xpath("//input[@name='upload_file']");

    public static By btnSubmit = By.xpath("//input[@name='submit']");

    public static By txtSuccessMessage =
            By.xpath("//div[contains(@class,'alert-success')]");

    public static By btnHome = By.xpath("//a[contains(text(),'Home')]");
}
