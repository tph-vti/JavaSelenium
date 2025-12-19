package pages.automation_demo;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import core.BasePage;
import static utils.Constants.AUTOMATION_DEMO_ALERTS_URL;

class AlertPageSelector {
    public static final By btnAlertWithOK = By.id("OKTab");
    public static final By btnAlertWithOKCancel = By.id("CancelTab");
    public static final By txtMessageCancelTab = By.xpath("//div[@id='CancelTab']/p");
    public static final By tabAlertWithOKCancel = By.xpath("//a[@href='#CancelTab']");
    public static final By tabAlertWithTextbox = By.xpath("//a[@href='#Textbox']");
//    NEW TAB WINDOW SELECTOR

    public static final By btnNewTabWindow = By.xpath("//div[@id='Tabbed']/a");
}

public class AlertPage extends BasePage {

    public AlertPage() {
        super();
        openSite(AUTOMATION_DEMO_ALERTS_URL);
    }

    public void acceptAlert() {
        logger.info("Accepting alert");
        Alert alert = switchToAlert();
        acceptAlertAction(alert);
    }

    public void dismissAlert() {
        logger.info("Dismissing alert");
        Alert alert = switchToAlert();
        dismissAlertAction(alert);
    }

    public void clickAlertWithOKButton() {
        logger.info("Clicking 'Alert with OK' button");
        clickButton(AlertPageSelector.btnAlertWithOK);
    }

    public void clickAlertWithOKCancelButton() {
        logger.info("Clicking 'Alert with OK & Cancel' button");
        clickButton(AlertPageSelector.btnAlertWithOKCancel);
    }

    public void verifyAlertDismissedMessage(String expectedMessage) {
        logger.info("Verifying alert dismissed message contains: {}", expectedMessage);

        String crrMsg = getElementText(AlertPageSelector.txtMessageCancelTab);
        verifyEquals(expectedMessage, crrMsg, String.format("The message %s displays intead of %s", crrMsg, expectedMessage));
    }

    public void selectAlertTab(String tabName) {
        logger.info("Selecting alert tab: {}", tabName);
        if (tabName.equals("Alert with OK & Cancel")) {
            clickButton(AlertPageSelector.tabAlertWithOKCancel);
        } else if (tabName.equals("Alert with Textbox")) {
            clickButton(AlertPageSelector.tabAlertWithTextbox);
        }
    }

    // NEW WINDOW METHODS
    public void clickNewTabWindowButton() {
        logger.info("Clicking 'New Tab / Window' button");
        clickButton(AlertPageSelector.btnNewTabWindow);
        swithToNewWindow();
    }

}