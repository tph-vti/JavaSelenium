package pages;

import core.BasePage;
import locator.DeleteLocator;

public class DeletePage extends BasePage {
    public void verifyAccountDeletedVisible() {
        isElementDisplayed(DeleteLocator.ACCOUNT_DELETED_MESSAGE);
    }

    public void clickContinueButton() {
        clickButtonJS(DeleteLocator.CONTINUE_BUTTON);
        handleVignette();
        if (driver.getCurrentUrl().contains("delete_account") && isElementDisplayed(DeleteLocator.CONTINUE_BUTTON)) {
            logger.info("Vignette ad intercepted Continue button, retrying...");
            clickButtonJS(DeleteLocator.CONTINUE_BUTTON);
            handleVignette();
        }
    }
}
