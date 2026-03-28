package pages;

import core.BasePage;
import locator.HomePageLocator;
import locator.LoginPageLocator;
import org.openqa.selenium.By;

import java.util.Map;

public class HomePage extends BasePage {

    public HomePage() {
        super();
    }

    public void clickMenu(String menuName){
        click(By.xpath(String.format(HomePageLocator.MENU, menuName)));
    }

    public boolean verifyMenu(String menuName){
        return findVisibleElement(
                By.xpath(String.format(HomePageLocator.MENU, menuName))
        ).isDisplayed();
    }

    public boolean verifySubscriptionTitle() {
        logger.info("Verify 'SUBSCRIPTION' title is displayed");
        verifyElementVisible(HomePageLocator.subscriptionTitle, "Subscription");
        return true;
    }


    public void enterEmail(Map<String, String> accInfo, String email) {
        logger.info("Entering email: " + email);
        enterText(HomePageLocator.txtEmail, email);
    }

    public void clickSubscribeButton() {
        logger.info("Clicking 'Subscribe' button");
        click(HomePageLocator.btnSubscribe);
    }

    public boolean verifySuccessMessage(String successMessage) {
        logger.info("Verifying success message");
        return getElementText(HomePageLocator.successMessage)
                .equals(successMessage);
    }
    public void scrollToFooter() {
        logger.info("Scrolling to footer");
        scrollToElement(HomePageLocator.scrollToFooter);
    }
}