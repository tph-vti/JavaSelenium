package core;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import utils.Helper;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class BasePage extends Helper {
    protected WebDriver webDriver;
    private String crrWindow;

    public void openSite() {
        logger.info("Navigating to URL: {}", TestSettings.BASE_URL);
        DriverManager.getDriver().get(TestSettings.BASE_URL);
        logger.info("Navigation to URL: {} completed", TestSettings.BASE_URL);
    }

    public void openSite(String url) {
        logger.info("Navigating to URL: {}", url);
        DriverManager.getDriver().get(url);
        logger.info("Navigation to URL: {} completed", url);
    }

    private WebElement findElement(By selector) {
        return getWait(TestSettings.WAIT_ELEMENT).until(ExpectedConditions.visibilityOfElementLocated(selector));
    }

    public WebDriverWait getWait(long waitTime) {
        return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(waitTime));
    }

    protected void waitForElementInvisible(By selector) {
        getWait(TestSettings.WAIT_ELEMENT).until(ExpectedConditions.invisibilityOfElementLocated(selector));
    }

    private WebElement waitForElementClickable(By selector) {
        return getWait(TestSettings.WAIT_ELEMENT).until(ExpectedConditions.elementToBeClickable(selector));
    }

    protected void enterText(By selector, String text) {
        logger.info("Entering text {}", text);
        findElement(selector).sendKeys(text);
    }

    protected String getElementAttribute(By selector, String attributeName) {
        logger.info("Getting attribute {} from element {}", attributeName, selector);
        return findElement(selector).getDomAttribute(attributeName);
    }

   protected String getElementValue(By selector) {
       logger.info("Getting value from element {}", selector);
       WebElement element = findElement(selector);
       return element.getText().isEmpty() ? element.getDomProperty("value") : element.getText();
   }

    protected void clickButton(By selector) {
        logger.info("Clicking button {}", selector);
        waitForElementClickable(selector).click();
    }

    protected String getElementText(By selector) {
        String text = findElement(selector).getText();
        logger.info("Retrieved text '{}' from element {}", text, selector);
        return text;
    }

    protected void verifyTrue(boolean condition, String message) {
        logger.info("Verifying condition is true");
        assertTrue(condition, message);
    }

    protected void verifyFalse(boolean condition, String message) {
        logger.info("Verifying condition is false");
        assertFalse(condition, message);
    }

    protected void verifyEquals(Object expected, Object actual, String message) {
        logger.info("Verifying equality of expected and actual values");
        assertEquals(expected, actual, message);
    }

    protected void verifyElementVisible(By selector, String errorMessage) {
        logger.info("Verifying visibility of element {}", selector);
        try {
            getWait(0).until(ExpectedConditions.visibilityOfElementLocated(selector));
            logger.info("Element {} is visible", selector);
        } catch (Exception e) {
            logger.error("Element {} is not visible: {}", selector, errorMessage);
            throw new AssertionError(errorMessage);
        }
    }

    protected void hoverElement(By selector) {
        logger.info("Hovering over element {}", selector);
        WebElement element = findElement(selector);
        // Init action object
        Actions actions = new Actions(DriverManager.getDriver());

        // Perform hover action
        actions.moveToElement(element).perform();
    }

    protected void dragAndDrop(By sourceEleBy, By targetEleBy) {
        logger.info("Dragging element from {} to {}", sourceEleBy, targetEleBy);
        WebElement sourceElement = findElement(sourceEleBy);
        WebElement targetElement = findElement(targetEleBy);

        // Init action object
        Actions actions = new Actions(DriverManager.getDriver());

        // Perform drag and drop action
        actions.dragAndDrop(sourceElement, targetElement).perform();
    }

    protected Alert switchToAlert() {
        logger.info("Switching to alert");
        return DriverManager.getDriver().switchTo().alert();
    }

    protected void acceptAlertAction(Alert alert) {
        logger.info("Accepting alert");
        alert.accept();
    }
    protected void dismissAlertAction(Alert alert) {
        logger.info("Dismissing alert");
        alert.dismiss();
    }

    protected WebDriver swithToNewWindow(){
        logger.info("Switching to new window");
        this.crrWindow = DriverManager.getDriver().getWindowHandle();
        logger.info("Current window: {}", this.crrWindow);
        for (String windowHandle : DriverManager.getDriver().getWindowHandles()) {
            if (!windowHandle.equals(this.crrWindow)) {
                DriverManager.getDriver().switchTo().window(windowHandle);
                logger.info("Switched to new window: {}", windowHandle);
                DriverManager.getDriver();
                return null;
            }
        }
        logger.warn("No new window found to switch to");
        return DriverManager.getDriver();
    }

    public void verifyTitle(String expectedTitle) {
        logger.info("Verifying page title is: {}", expectedTitle);
        String actualTitle = DriverManager.getDriver().getTitle();
        verifyEquals(expectedTitle, actualTitle, String.format("Expected title '%s' but found '%s'", expectedTitle, actualTitle));
    }

    public void switchBackToOriginalWindow() {
        logger.info("Switching back to original window: {}", this.crrWindow);
        Set<String> arrString = DriverManager.getDriver().getWindowHandles();
        for (String windowHandle : arrString) {
            if (!windowHandle.equals(this.crrWindow)) {
                DriverManager.getDriver().switchTo().window(windowHandle);
                logger.info("Switched to new window: {}", windowHandle);
                DriverManager.getDriver().close();
            }
        }
        DriverManager.getDriver().switchTo().window(this.crrWindow);
    }
}

