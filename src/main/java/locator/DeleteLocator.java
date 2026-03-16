package locator;

import org.openqa.selenium.By;

public class DeleteLocator {
    public static final By ACCOUNT_DELETED_MESSAGE = By.xpath("//h2[contains(@class, 'title text-center')]//b");
    public static final By CONTINUE_BUTTON = By.xpath("//a[contains(@data-qa, 'continue-button')]");
}
