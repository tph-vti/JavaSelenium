package pages;

import core.BasePage;
import locator.HeaderLocators;

public class HeaderPage extends BasePage {

    public HeaderPage() {
        super();
    }

    public void clickHome() {
        logger.info("Clicking Home link");
        clickButton(HeaderLocators.HOME_LINK);
    }

    public void clickProducts() {
        logger.info("Clicking Products link");
        clickButton(HeaderLocators.PRODUCTS_LINK);
    }

    public void clickCart() {
        logger.info("Clicking Cart link");
        clickButton(HeaderLocators.CART_LINK);
    }

    public void clickSignupLogin() {
        logger.info("Clicking Signup / Login link");
        clickButton(HeaderLocators.SIGNUP_LOGIN_LINK);
    }

    public void clickTestCases() {
        logger.info("Clicking Test Cases link");
        clickButton(HeaderLocators.TEST_CASES_LINK);
    }

    public void clickApiTesting() {
        logger.info("Clicking API Testing link");
        clickButton(HeaderLocators.API_TESTING_LINK);
    }

    public void clickVideoTutorials() {
        logger.info("Clicking Video Tutorials link");
        clickButton(HeaderLocators.VIDEO_TUTORIALS_LINK);
    }

    public void clickContactUs() {
        logger.info("Clicking Contact us link");
        clickButton(HeaderLocators.CONTACT_US_LINK);
    }

    public void clickDeleteAccount() {
        logger.info("Clicking Delete Account link");
        clickButton(HeaderLocators.DELETE_ACCOUNT_LINK);
    }
}
