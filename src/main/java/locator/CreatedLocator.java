package locator;

import org.openqa.selenium.By;

public class CreatedLocator {
    public static final By ACCOUNT_CREATED_MESSAGE = By.xpath("//h2[contains(@class, 'title text-center')]//b");
    public static final By CONTINUE_BUTTON = By.xpath("//a[@data-qa='continue-button']");
}
