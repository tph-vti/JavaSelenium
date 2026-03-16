package pages;

import core.BasePage;
import locator.CreatedLocator;

public class CreatedPage extends BasePage {
    public void verifyAccountCreatedVisible() {
        isElementDisplayed(CreatedLocator.ACCOUNT_CREATED_MESSAGE);
    }

    public void clickContinueButton() {
        clickButtonJS(CreatedLocator.CONTINUE_BUTTON);
        handleVignette();
        if (driver.getCurrentUrl().contains("account_created") && isElementDisplayed(CreatedLocator.CONTINUE_BUTTON)) {
            logger.info("Vignette ad intercepted Continue button, retrying...");
            clickButtonJS(CreatedLocator.CONTINUE_BUTTON);
            handleVignette();
        }
    }
}
